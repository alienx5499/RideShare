package org.example.rideshare.service;

import org.example.rideshare.dto.CreateRideRequest;
import org.example.rideshare.dto.RideResponse;
import org.example.rideshare.exception.BadRequestException;
import org.example.rideshare.exception.NotFoundException;
import org.example.rideshare.model.Ride;
import org.example.rideshare.model.User;
import org.example.rideshare.repository.RideRepository;
import org.example.rideshare.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RideService {

    @Autowired
    private RideRepository rideRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    private String getCurrentUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication != null ? authentication.getName() : null;
    }

    private boolean hasRole(String role) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication != null && authentication.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals(role));
    }

    public RideResponse createRide(CreateRideRequest request) {
        String username = getCurrentUsername();
        if (username == null) {
            throw new BadRequestException("User not authenticated");
        }

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new NotFoundException("User not found"));

        Ride ride = new Ride(user.getId(), request.getPickupLocation(), request.getDropLocation());
        ride = rideRepository.save(ride);

        return convertToResponse(ride);
    }

    public List<RideResponse> getUserRides() {
        String username = getCurrentUsername();
        if (username == null) {
            throw new BadRequestException("User not authenticated");
        }

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new NotFoundException("User not found"));

        List<Ride> rides = rideRepository.findByUserId(user.getId());
        return rides.stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    public List<RideResponse> getPendingRideRequests() {
        // Authorization is handled by @PreAuthorize in the controller
        List<Ride> rides = rideRepository.findByStatus("REQUESTED");
        return rides.stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    public RideResponse acceptRide(String rideId) {
        // Authorization is handled by @PreAuthorize in the controller
        Ride ride = rideRepository.findById(rideId)
                .orElseThrow(() -> new NotFoundException("Ride not found"));

        if (!ride.getStatus().equals("REQUESTED")) {
            throw new BadRequestException("Ride is not in REQUESTED status");
        }

        String username = getCurrentUsername();
        User driver = userRepository.findByUsername(username)
                .orElseThrow(() -> new NotFoundException("Driver not found"));

        ride.setDriverId(driver.getId());
        ride.setStatus("ACCEPTED");
        ride = rideRepository.save(ride);

        return convertToResponse(ride);
    }

    public RideResponse completeRide(String rideId) {
        Ride ride = rideRepository.findById(rideId)
                .orElseThrow(() -> new NotFoundException("Ride not found"));

        if (!ride.getStatus().equals("ACCEPTED")) {
            throw new BadRequestException("Ride must be ACCEPTED before completion");
        }

        String username = getCurrentUsername();
        User currentUser = userRepository.findByUsername(username)
                .orElseThrow(() -> new NotFoundException("User not found"));

        if (!ride.getUserId().equals(currentUser.getId()) && !ride.getDriverId().equals(currentUser.getId())) {
            throw new BadRequestException("Only the passenger or driver of this ride can complete it");
        }

        ride.setStatus("COMPLETED");
        ride = rideRepository.save(ride);

        return convertToResponse(ride);
    }

    public List<Ride> searchRides(String text) {
        Criteria criteria = new Criteria().orOperator(
                Criteria.where("pickupLocation").regex(text, "i"),
                Criteria.where("dropLocation").regex(text, "i")
        );
        Query query = new Query(criteria);
        return mongoTemplate.find(query, Ride.class);
    }

    public List<Ride> filterByDistance(double min, double max) {
        Criteria criteria = Criteria.where("distanceKm").gte(min).lte(max);
        Query query = new Query(criteria);
        return mongoTemplate.find(query, Ride.class);
    }

    public List<Ride> filterByDateRange(LocalDate start, LocalDate end) {
        Criteria criteria = Criteria.where("createdDate").gte(start).lte(end);
        Query query = new Query(criteria);
        return mongoTemplate.find(query, Ride.class);
    }

    public List<Ride> sortByFare(String order) {
        Sort.Direction direction = "asc".equalsIgnoreCase(order)
                ? Sort.Direction.ASC
                : Sort.Direction.DESC;
        Query query = new Query().with(Sort.by(direction, "fareAmount"));
        return mongoTemplate.find(query, Ride.class);
    }

    public List<Ride> getRidesForUser(String userId) {
        return rideRepository.findByUserId(userId);
    }

    public List<Ride> getRidesForUserByStatus(String userId, String status) {
        Criteria criteria = Criteria.where("userId").is(userId)
                .and("status").is(status);
        Query query = new Query(criteria);
        return mongoTemplate.find(query, Ride.class);
    }

    public List<Ride> getActiveRidesForDriver(String driverId) {
        Criteria criteria = Criteria.where("driverId").is(driverId)
                .and("status").is("ACCEPTED");
        Query query = new Query(criteria);
        return mongoTemplate.find(query, Ride.class);
    }

    public List<Ride> filterByStatusAndKeyword(String status, String search) {
        Criteria textCriteria = new Criteria().orOperator(
                Criteria.where("pickupLocation").regex(search, "i"),
                Criteria.where("dropLocation").regex(search, "i")
        );
        Criteria criteria = Criteria.where("status").is(status).andOperator(textCriteria);
        Query query = new Query(criteria);
        return mongoTemplate.find(query, Ride.class);
    }

    public List<Ride> advancedSearch(
            String search,
            String status,
            String sortField,
            String order,
            int page,
            int size
    ) {
        Criteria criteria = new Criteria();

        if (status != null && !status.isBlank()) {
            criteria = criteria.and("status").is(status);
        }

        if (search != null && !search.isBlank()) {
            Criteria textCriteria = new Criteria().orOperator(
                    Criteria.where("pickupLocation").regex(search, "i"),
                    Criteria.where("dropLocation").regex(search, "i")
            );
            criteria = criteria.andOperator(textCriteria);
        }

        Query query = new Query(criteria);

        if (sortField != null && !sortField.isBlank()) {
            Sort.Direction direction = "asc".equalsIgnoreCase(order)
                    ? Sort.Direction.ASC
                    : Sort.Direction.DESC;
            query.with(Sort.by(direction, sortField));
        }

        query.with(PageRequest.of(page, size));

        return mongoTemplate.find(query, Ride.class);
    }

    public List<Ride> getRidesOnDate(LocalDate date) {
        Criteria criteria = Criteria.where("createdDate").is(date);
        Query query = new Query(criteria);
        return mongoTemplate.find(query, Ride.class);
    }

    private RideResponse convertToResponse(Ride ride) {
        RideResponse response = new RideResponse();
        response.setId(ride.getId());
        response.setUserId(ride.getUserId());
        response.setDriverId(ride.getDriverId());
        response.setPickupLocation(ride.getPickupLocation());
        response.setDropLocation(ride.getDropLocation());
        response.setStatus(ride.getStatus());
        response.setCreatedAt(ride.getCreatedAt());
        return response;
    }
}


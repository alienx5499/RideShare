package org.example.rideshare.controller;

import org.example.rideshare.dto.CreateRideRequest;
import org.example.rideshare.dto.RideResponse;
import org.example.rideshare.model.Ride;
import org.example.rideshare.service.RideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class RideController {

    @Autowired
    private RideService rideService;

    @PostMapping("/rides")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<RideResponse> createRide(@Valid @RequestBody CreateRideRequest request) {
        RideResponse response = rideService.createRide(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/user/rides")
    public ResponseEntity<List<RideResponse>> getUserRides() {
        List<RideResponse> rides = rideService.getUserRides();
        return ResponseEntity.ok(rides);
    }

    @GetMapping("/driver/rides/requests")
    @PreAuthorize("hasAuthority('ROLE_DRIVER')")
    public ResponseEntity<List<RideResponse>> getPendingRideRequests() {
        List<RideResponse> rides = rideService.getPendingRideRequests();
        return ResponseEntity.ok(rides);
    }

    @PostMapping("/driver/rides/{rideId}/accept")
    @PreAuthorize("hasAuthority('ROLE_DRIVER')")
    public ResponseEntity<RideResponse> acceptRide(@PathVariable String rideId) {
        RideResponse response = rideService.acceptRide(rideId);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/rides/{rideId}/complete")
    public ResponseEntity<RideResponse> completeRide(@PathVariable String rideId) {
        RideResponse response = rideService.completeRide(rideId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/rides/search")
    public ResponseEntity<List<Ride>> searchRides(@RequestParam String text) {
        return ResponseEntity.ok(rideService.searchRides(text));
    }

    @GetMapping("/rides/filter-distance")
    public ResponseEntity<List<Ride>> filterByDistance(@RequestParam double min,
                                                       @RequestParam double max) {
        return ResponseEntity.ok(rideService.filterByDistance(min, max));
    }

    @GetMapping("/rides/filter-date-range")
    public ResponseEntity<List<Ride>> filterByDateRange(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end
    ) {
        return ResponseEntity.ok(rideService.filterByDateRange(start, end));
    }

    @GetMapping("/rides/sort")
    public ResponseEntity<List<Ride>> sortByFare(@RequestParam(defaultValue = "asc") String order) {
        return ResponseEntity.ok(rideService.sortByFare(order));
    }

    @GetMapping("/rides/user/{userId}")
    public ResponseEntity<List<Ride>> ridesForUser(@PathVariable String userId) {
        return ResponseEntity.ok(rideService.getRidesForUser(userId));
    }

    @GetMapping("/rides/user/{userId}/status/{status}")
    public ResponseEntity<List<Ride>> ridesForUserByStatus(@PathVariable String userId,
                                                           @PathVariable String status) {
        return ResponseEntity.ok(rideService.getRidesForUserByStatus(userId, status));
    }

    @GetMapping("/driver/{driverId}/active-rides")
    public ResponseEntity<List<Ride>> activeRidesForDriver(@PathVariable String driverId) {
        return ResponseEntity.ok(rideService.getActiveRidesForDriver(driverId));
    }

    @GetMapping("/rides/filter-status")
    public ResponseEntity<List<Ride>> filterByStatusAndKeyword(@RequestParam String status,
                                                               @RequestParam String search) {
        return ResponseEntity.ok(rideService.filterByStatusAndKeyword(status, search));
    }

    @GetMapping("/rides/advanced-search")
    public ResponseEntity<List<Ride>> advancedSearch(
            @RequestParam(required = false) String search,
            @RequestParam(required = false) String status,
            @RequestParam(defaultValue = "fareAmount") String sort,
            @RequestParam(defaultValue = "asc") String order,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return ResponseEntity.ok(
                rideService.advancedSearch(search, status, sort, order, page, size)
        );
    }

    @GetMapping("/rides/date/{date}")
    public ResponseEntity<List<Ride>> ridesOnDate(
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date
    ) {
        return ResponseEntity.ok(rideService.getRidesOnDate(date));
    }
}


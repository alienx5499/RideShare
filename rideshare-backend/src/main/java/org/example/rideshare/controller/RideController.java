package org.example.rideshare.controller;

import org.example.rideshare.dto.CreateRideRequest;
import org.example.rideshare.dto.RideResponse;
import org.example.rideshare.service.RideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
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
}


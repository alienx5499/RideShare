package org.example.rideshare.controller;

import org.bson.Document;
import org.example.rideshare.service.AnalyticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/analytics")
public class AnalyticsController {

    @Autowired
    private AnalyticsService analyticsService;

    @GetMapping("/driver/{driverId}/earnings")
    public ResponseEntity<Double> driverEarnings(@PathVariable String driverId) {
        Double total = analyticsService.totalEarnings(driverId);
        return ResponseEntity.ok(total);
    }

    @GetMapping("/rides-per-day")
    public ResponseEntity<List<Document>> ridesPerDay() {
        return ResponseEntity.ok(analyticsService.ridesPerDay());
    }

    @GetMapping("/driver/{driverId}/summary")
    public ResponseEntity<Document> driverSummary(@PathVariable String driverId) {
        return ResponseEntity.ok(analyticsService.driverSummary(driverId));
    }

    @GetMapping("/user/{userId}/spending")
    public ResponseEntity<Document> userSpending(@PathVariable String userId) {
        return ResponseEntity.ok(analyticsService.userSpending(userId));
    }

    @GetMapping("/status-summary")
    public ResponseEntity<List<Document>> statusSummary() {
        return ResponseEntity.ok(analyticsService.statusSummary());
    }
}



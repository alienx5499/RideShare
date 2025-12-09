package org.example.rideshare.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Date;

@Document(collection = "rides")
public class Ride {
    @Id
    private String id;

    // Core ride fields
    private String userId;      // Passenger user id
    private String driverId;    // Driver user id
    private String pickupLocation;
    private String dropLocation;
    private String status;      // REQUESTED, ACCEPTED, COMPLETED
    private Date createdAt;

    // Extended analytics fields (used by search / filter / analytics APIs)
    // Distance of the ride in kilometers
    private Double distanceKm;

    // Fare amount charged for the ride
    private Double fareAmount;

    // Normalized ride date (yyyy-MM-dd) used for date-based queries/aggregations
    private LocalDate createdDate;

    public Ride() {
        this.createdAt = new Date();
        this.createdDate = LocalDate.now();
    }

    public Ride(String userId, String pickupLocation, String dropLocation) {
        this.userId = userId;
        this.pickupLocation = pickupLocation;
        this.dropLocation = dropLocation;
        this.status = "REQUESTED";
        this.createdAt = new Date();
        this.createdDate = LocalDate.now();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public String getDropLocation() {
        return dropLocation;
    }

    public void setDropLocation(String dropLocation) {
        this.dropLocation = dropLocation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Double getDistanceKm() {
        return distanceKm;
    }

    public void setDistanceKm(Double distanceKm) {
        this.distanceKm = distanceKm;
    }

    public Double getFareAmount() {
        return fareAmount;
    }

    public void setFareAmount(Double fareAmount) {
        this.fareAmount = fareAmount;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }
}


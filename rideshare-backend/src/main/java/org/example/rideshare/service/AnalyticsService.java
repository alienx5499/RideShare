package org.example.rideshare.service;

import org.bson.Document;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.ConditionalOperators;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

@Service
public class AnalyticsService {

    private final MongoTemplate template;

    public AnalyticsService(MongoTemplate template) {
        this.template = template;
    }

    public Double totalEarnings(String driverId) {
        MatchOperation match = match(Criteria.where("driverId").is(driverId));
        GroupOperation group = group().sum("fareAmount").as("total");
        Aggregation agg = newAggregation(match, group);

        AggregationResults<Document> results =
                template.aggregate(agg, "rides", Document.class);

        Document result = results.getUniqueMappedResult();
        return result != null ? result.getDouble("total") : 0.0;
    }

    public List<Document> ridesPerDay() {
        GroupOperation group = group("createdDate").count().as("rideCount");
        ProjectionOperation project = project("rideCount")
                .and("_id").as("date");

        Aggregation agg = newAggregation(
                group,
                project,
                sort(Sort.Direction.ASC, "date")
        );

        return template.aggregate(agg, "rides", Document.class).getMappedResults();
    }

    public Document driverSummary(String driverId) {
        MatchOperation match = match(Criteria.where("driverId").is(driverId));

        GroupOperation group = group("driverId")
                .count().as("totalRides")
                .sum(ConditionalOperators.when(Criteria.where("status").is("COMPLETED"))
                        .then(1).otherwise(0)).as("completedRides")
                .sum(ConditionalOperators.when(Criteria.where("status").is("CANCELLED"))
                        .then(1).otherwise(0)).as("cancelledRides")
                .avg("distanceKm").as("avgDistance")
                .sum("fareAmount").as("totalFare");

        ProjectionOperation project = project("totalRides", "completedRides",
                "cancelledRides", "avgDistance", "totalFare")
                .andExclude("_id");

        Aggregation agg = newAggregation(match, group, project);

        AggregationResults<Document> results =
                template.aggregate(agg, "rides", Document.class);

        return results.getUniqueMappedResult();
    }

    public Document userSpending(String userId) {
        MatchOperation match = match(Criteria.where("userId").is(userId)
                .and("status").is("COMPLETED"));

        GroupOperation group = group("userId")
                .count().as("completedRides")
                .sum("fareAmount").as("totalSpent");

        ProjectionOperation project = project("completedRides", "totalSpent")
                .andExclude("_id");

        Aggregation agg = newAggregation(match, group, project);

        AggregationResults<Document> results =
                template.aggregate(agg, "rides", Document.class);

        return results.getUniqueMappedResult();
    }

    public List<Document> statusSummary() {
        GroupOperation group = group("status").count().as("count");
        ProjectionOperation project = project("count")
                .and("_id").as("status");

        Aggregation agg = newAggregation(group, project);

        return template.aggregate(agg, "rides", Document.class).getMappedResults();
    }
}



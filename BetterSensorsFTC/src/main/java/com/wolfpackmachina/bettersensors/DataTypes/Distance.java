package com.wolfpackmachina.bettersensors.DataTypes;

public class Distance {

    private final boolean inRange;

    private final double distanceMM;
    private final double distanceCM;
    private final double distanceMeters;
    private final double distanceInches;
    private final double distanceFeet;

    private final double avgDistanceMM;
    private final double avgDistanceCM;
    private final double avgDistanceMeters;
    private final double avgDistanceInches;
    private final double avgDistanceFeet;

    public Distance(boolean inRange, double distanceMM, double distanceCM, double distanceMeters, double distanceInches, double distanceFeet, double avgDistanceMM, double avgDistanceCM, double avgDistanceMeters, double avgDistanceInches, double avgDistanceFeet) {
        this.inRange = inRange;
        this.distanceMM = distanceMM;
        this.distanceCM = distanceCM;
        this.distanceMeters = distanceMeters;
        this.distanceInches = distanceInches;
        this.distanceFeet = distanceFeet;
        this.avgDistanceMM = avgDistanceMM;
        this.avgDistanceCM = avgDistanceCM;
        this.avgDistanceMeters = avgDistanceMeters;
        this.avgDistanceInches = avgDistanceInches;
        this.avgDistanceFeet = avgDistanceFeet;
    }

    public boolean isInRange() {
        return inRange;
    }

    public double distanceMM() {
        return distanceMM;
    }

    public double distanceCM() {
        return distanceCM;
    }

    public double distanceMeters() {
        return distanceMeters;
    }

    public double distanceInches() {
        return distanceInches;
    }

    public double distanceFeet(){
        return distanceFeet;
    }

    public double avgDistanceMM() {
        return avgDistanceMM;
    }

    public double avgDistanceCM() {
        return avgDistanceCM;
    }

    public double avgDistanceMeters() {
        return avgDistanceMeters;
    }

    public double avgDistanceInches() {
        return avgDistanceInches;
    }

    public double avgDistanceFeet() {
        return avgDistanceFeet;
    }
}

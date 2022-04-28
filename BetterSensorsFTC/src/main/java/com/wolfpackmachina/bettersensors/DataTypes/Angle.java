package com.wolfpackmachina.bettersensors.DataTypes;

public class Angle {

    private final double angle;
    private final double modAngle;
    private final double rawAngle;
    private final double rateOfChange;

    public Angle(double angle, double modAngle, double rawAngle, double rateOfChange) {
        this.angle = angle;
        this.modAngle = modAngle;
        this.rawAngle = rawAngle;
        this.rateOfChange = rateOfChange;
    }

    public double angle() {
        return angle;
    }

    public double modAngle() {
        return modAngle;
    }

    public double rawAngle() {
        return rawAngle;
    }

    public double rateOfChange() {
        return rateOfChange;
    }
}
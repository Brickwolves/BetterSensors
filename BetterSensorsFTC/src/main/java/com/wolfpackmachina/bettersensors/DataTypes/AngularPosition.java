package com.wolfpackmachina.bettersensors.DataTypes;

public class AngularPosition {

    private final Angle yaw;
    private final Angle pitch;
    private final Angle roll;

    public AngularPosition(Angle yaw, Angle pitch, Angle roll) {
        this.yaw = yaw;
        this.pitch = pitch;
        this.roll = roll;
    }

    public Angle yaw() {
        return yaw;
    }

    public Angle pitch() {
        return pitch;
    }

    public Angle roll() {
        return roll;
    }

    //since yaw is by far the most commonly requested angle, these shortcuts are provided.
    public double angle() {
        return yaw.angle();
    }

    public double modAngle() {
        return yaw.modAngle();
    }

    public double rawAngle() {
        return yaw.rawAngle();
    }

    public double rateOfChange() {
        return yaw.rateOfChange();
    }

}
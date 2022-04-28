package com.wolfpackmachina.bettersensors.SensorInterpreters;

//TODO: MAKE THIS CODE NOT HORRIBLE
/*
public class TwoWheelOdometry extends UpdatingSensorInterpreter {

    private final MotorEncoder leftEncoder;
    private final MotorEncoder rightEncoder;
    private final Gyro gyro;

    private final DifferentialDriveOdometry odometry;
    private Pose2d robotPose;

    private static double xPosMM;
    private static double yPosMM;

    public TwoWheelOdometry(MotorEncoder leftEncoder, MotorEncoder rightEncoder, Gyro gyro) {
        super(0);
        this.leftEncoder = leftEncoder;
        this.rightEncoder = rightEncoder;
        this.gyro = gyro;

        double WHEEL_DIAMETER = 0.096;
        double TICKS_PER_REV = 455.4727;
        double DISTANCE_PER_PULSE = Math.PI * WHEEL_DIAMETER / TICKS_PER_REV;

        odometry = new DifferentialDriveOdometry(new Rotation2d(Sensors.gyro.rawAngle()), new Pose2d(0, 0, new Rotation2d()));
    }

    @Override
    protected void interpretData() {
        Rotation2d gyroRotation = new Rotation2d(gyro.angle());
        robotPose = odometry.update(gyroRotation, leftEncoder.getDistance(), rightEncoder.getDistance());
        xPosMM = robotPose.getX() * 1000;
        yPosMM = robotPose.getY() * 1000;
    }

    public double getXPosMM() {
        return xPosMM;
    }

    public double getYPosMM() {
        return yPosMM;
    }

    public double getXPosCM() {
        return xPosMM / 10;
    }

    public double getYPosCM() {
        return yPosMM / 10;
    }
}
 */

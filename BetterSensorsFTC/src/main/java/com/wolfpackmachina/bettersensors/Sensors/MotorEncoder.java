package com.wolfpackmachina.bettersensors.Sensors;

import com.wolfpackmachina.bettersensors.HardwareMapProvider;
import com.wolfpackmachina.bettersensors.Sensor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.hardware.DcMotor;


public class MotorEncoder extends Sensor<Double> {

    String deviceName;
    MotorEx encoder;

    public MotorEncoder(String hardwareID, int pingFrequency){
        super(hardwareID, pingFrequency);
    }

    @Override
    protected void sensorInit(String hardwareID) {
        deviceName = HardwareMapProvider.hardwareMap.get(DcMotor.class, hardwareID).getDeviceName() + "-encoder";
        encoder = new MotorEx(HardwareMapProvider.hardwareMap, hardwareID);
        encoder.resetEncoder();
    }

    @Override
    protected Double pingSensor() {
        return encoder.getDistance();
    }

    @Override
    public boolean isConnected() {
        return true;
    }

    @Override
    public String getDeviceName() {
        return deviceName;
    }

    /**
     * Sets distance per encoder tick
     * @param distancePerPulse
     */
    protected void setDistancePerPulse(double distancePerPulse){
        encoder.setDistancePerPulse(distancePerPulse);
    }

    public double getDistance(){
        return readingCache;
    }

}

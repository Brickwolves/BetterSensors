package com.wolfpackmachina.bettersensors;

public class SensorManager {

   // private final Gyro gyro;

    private long lastTotalDelay;

    public SensorManager() {
        //this.gyro = new Gyro();
    }

    public void update(){
        //long gyroDelay = gyro.update();

        //lastTotalDelay = gyroDelay;
    }

    public long totalDelay(){
        return lastTotalDelay;
    }

}
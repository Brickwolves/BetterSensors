package com.wolfpackmachina.bettersensors.SensorInterpreters;

import static com.wolfpackmachina.bettersensors.Utils.MathUtils.withinRange;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.wolfpackmachina.bettersensors.Sensors.Gyro;

public class GyroExtensions {
    
    private final Gyro gyro;

    public GyroExtensions (Gyro gyro){
        this.gyro = gyro;
    }

    public boolean isAngleWithinMargin(double targetAngle, double margin){
        double coterminalTarget = closestTarget(targetAngle);
        return withinRange(gyro.angle(), coterminalTarget - margin, coterminalTarget + margin);
    }
    
    @RequiresApi(api = Build.VERSION_CODES.N)
    public double closestTarget(double targetAngle){
        double simpleTargetDelta = StrictMath.floorMod(Math.round(((360 - targetAngle) + gyro.angle()) * 1e6), Math.round(360.000 * 1e6)) / 1e6;
        double alternateTargetDelta = -1 * (360 - simpleTargetDelta);
        return StrictMath.abs(simpleTargetDelta) <= StrictMath.abs(alternateTargetDelta) ? gyro.angle() - simpleTargetDelta : gyro.angle() - alternateTargetDelta;
    }
    
}

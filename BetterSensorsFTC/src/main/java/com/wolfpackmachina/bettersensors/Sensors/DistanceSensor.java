package com.wolfpackmachina.bettersensors.Sensors;

import static com.wolfpackmachina.bettersensors.Utils.MathUtils.withinRange;
import static com.qualcomm.robotcore.hardware.DistanceSensor.distanceOutOfRange;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import com.wolfpackmachina.bettersensors.DataTypes.Distance;
import com.wolfpackmachina.bettersensors.Drivers.ColorSensorV3;
import com.wolfpackmachina.bettersensors.HardwareMapProvider;
import com.wolfpackmachina.bettersensors.Sensor;
import com.wolfpackmachina.bettersensors.Utils.RingBuffer;

import java.util.List;

public class DistanceSensor extends Sensor<Distance> {

    private static int DIST_AVERAGING_BUFFER_LENGTH = 40;

    com.qualcomm.robotcore.hardware.DistanceSensor distanceSensor;
    private final RingBuffer<Double> distanceBuffer = new RingBuffer<>(DIST_AVERAGING_BUFFER_LENGTH, 0.0);

    public DistanceSensor(String hardwareID, int pingFrequency){
        super(hardwareID, pingFrequency);
    }

    @Override
    protected void sensorInit(String hardwareID) {
        distanceSensor = useHardwareMap ? hardwareMap.get(com.qualcomm.robotcore.hardware.DistanceSensor.class, hardwareID) : HardwareMapProvider.hardwareMap.get(com.qualcomm.robotcore.hardware.DistanceSensor.class, hardwareID);
    }

    @Override
    protected Distance pingSensor() {
        double distanceMM = distanceSensor.getDistance(DistanceUnit.MM);
        boolean inRange = !(distanceMM == distanceOutOfRange);
        double avgDistanceMM;
        double distanceCM, distanceMeters, distanceInches, distanceFeet;
        double avgDistanceCM, avgDistanceMeters, avgDistanceInches, avgDistanceFeet;
        if(inRange){
            distanceCM = distanceMM / 10;
            distanceMeters = distanceMM / 1000;
            distanceInches = distanceMM / 25.4;
            distanceFeet = distanceInches / 12;

            distanceBuffer.getValue(distanceMM);
            List<Double> avgBuffer = distanceBuffer.getList();
            double bufferTotal = 0;
            int usefulBufferSize = 0;
            for (int i = 0; i < avgBuffer.size(); i++) {
                if(avgBuffer.get(i) > 0){
                    bufferTotal += avgBuffer.get(i);
                    usefulBufferSize ++;
                }
            }
            avgDistanceMM = bufferTotal / usefulBufferSize;

            avgDistanceCM = avgDistanceMM / 10;
            avgDistanceMeters = avgDistanceMM / 1000;
            avgDistanceInches = avgDistanceMM / 25.4;
            avgDistanceFeet = avgDistanceInches / 12;


        }else{
            distanceCM = distanceMeters = distanceInches = distanceFeet = distanceOutOfRange;
            avgDistanceMM = avgDistanceCM = avgDistanceMeters = avgDistanceInches = avgDistanceFeet = distanceOutOfRange;
        }
        return new Distance(inRange,
                distanceMM, distanceCM, distanceMeters, distanceInches, distanceFeet,
                avgDistanceMM, avgDistanceCM, avgDistanceMeters, avgDistanceInches, avgDistanceFeet);
    }

    @Override
    public boolean isConnected() {
        return !withinRange(getDistance(), 65534, 65536);
    }

    @Override
    public String getDeviceName() {
        return distanceSensor.getDeviceName();
    }

    /**
     * default method, gets distance in MM.
     * @return
     */
    public double getDistance(){
        return readingCache.distanceMM();
    }

    public double getAvgDistance(){
        return readingCache.avgDistanceMM();
    }

    public boolean isInRange(){
        return readingCache.isInRange();
    }
}

package com.wolfpackmachina.bettersensors;


import com.qualcomm.robotcore.hardware.HardwareMap;

public abstract class Sensor <T> {

    //You should add additional variables here for the sensor state, and add additional methods to get them.
    protected long prevTime;
    private int pingFrequency;
    private boolean updateSensor;
    protected T readingCache;
    protected HardwareMap hardwareMap;
    protected final boolean useHardwareMap;



    /**
     * This should be called by the Sensors class, at the beginning of init, in the Sensors init method.
     * pingFrequency is how often the sensor data should be updated, leaving this at 0 will ping the sensor every code loop.
     * @param pingFrequency
     */
    protected Sensor(String hardwareID, int pingFrequency) {
        this.pingFrequency = pingFrequency;
        updateSensor = true;
        prevTime = System.currentTimeMillis();
        sensorInit(hardwareID);
        useHardwareMap = false;
    }

    /**
     * This should be called by the Sensors class, at the beginning of init, in the Sensors init method.
     * pingFrequency is how often the sensor data should be updated, leaving this at 0 will ping the sensor every code loop.
     * @param pingFrequency
     */
    protected Sensor(String hardwareID, int pingFrequency, HardwareMap hardwareMap) {
        this.pingFrequency = pingFrequency;
        updateSensor = true;
        prevTime = System.currentTimeMillis();
        sensorInit(hardwareID);
        this.hardwareMap = hardwareMap;
        useHardwareMap = true;
    }

    /**
     * Inits with custom hardwareID but default pingFrequency (every cycle)
     * @param hardwareID
     */
    public Sensor(String hardwareID){
        this(hardwareID, 0);
    }

    /**
     * This should contain code to initialize the sensor
     */
    protected abstract void sensorInit(String hardwareID);

    /**
     * This method should have whatever code necessary to update s
     * ensor states, and SHOULD BE THE ONLY METHOD THAT PINGS A SENSOR
     */
    protected abstract T pingSensor();

    /**
     * This method should return true if the sensor is plugged in,
     * and false if it is not. It should return true if not known.
     * @return
     */
    public abstract boolean isConnected();

    public abstract String getDeviceName();

    /**
     * This method checks if deltaTime since last ping is more
     * than the desired pingFrequency, and returns the deltaTime
     * since last sensor ping.
     * @return
     */
    public final long update(){
        long currentTime = System.currentTimeMillis();
        long deltaTime = currentTime - prevTime;

        if(deltaTime >= pingFrequency && updateSensor){
            readingCache = pingSensor();
            prevTime = currentTime;
        }

        return deltaTime;
    }

    public final T getReading(){
        return readingCache;
    }

    /**
     * Get how often the sensor will ping, in milliseconds. 0 will ping every cycle.
     * @return
     */
    public int getPingFrequency() {
        return pingFrequency;
    }

    /**
     * Set how often the sensor should update, in milliseconds. Setting this to 0 will ping every cycle.
     * @param pingFrequency
     */
    public void setPingFrequency(int pingFrequency) {
        this.pingFrequency = pingFrequency;
    }

    /**
     * This will stop updating the sensor until resumeSensor is called
     */
    public void pauseSensor(){
        updateSensor = false;
    }

    /**
     * This will resume updating the sensor after pauseSensor has been used
     */
    public void resumeSensor(){
        updateSensor = true;
    }
}

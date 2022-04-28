package com.wolfpackmachina.bettersensors;

public abstract class UpdatingSensorInterpreter {

    //You should add additional variables here for the sensor state, and add additional methods to get them.
    protected long prevTime;
    private int updateFrequency;
    private boolean updateInterpreter;

    /**
     * This should be called by the Sensors class, at the beginning of init, in the Sensors init method.
     * updateFrequency is how often the interpretation should be updated, leaving this at 0 will ping the sensor every code loop.
     * @param updateFrequency
     */
    public UpdatingSensorInterpreter(int updateFrequency) {
        this.updateFrequency = updateFrequency;
        updateInterpreter = true;
        prevTime = System.currentTimeMillis();
    }

    public UpdatingSensorInterpreter(){
        this(0);
    }

    /**
     * Inits, using a Sensor to provide the pingFrequency so as to sync the two.
     * @param pingSyncProvider
     */
    public UpdatingSensorInterpreter(Sensor pingSyncProvider){
        this(pingSyncProvider.getPingFrequency());
    }


    /**
     * This method should have whatever code necessary to update interpretation, and SHOULD BE THE ONLY METHOD THAT UPDATES AN UPDATE-SENSITIVE INTERPRETER (IE PID or ODOM)
     */
    protected abstract void interpretData();

    /**
     * This method checks if deltaTime since last ping is more than the desired pingFrequency, and returns the deltaTime since last sensor ping.
     * @return
     */
    public final long update(){
        long currentTime = System.currentTimeMillis();
        long deltaTime = currentTime - prevTime;

        if(deltaTime >= updateFrequency && updateInterpreter){
            interpretData();
            prevTime = currentTime;
        }

        return deltaTime;
    }

    /**
     * Get how often the interpreter will update, in milliseconds. 0 will update every cycle.
     * @return
     */
    public int getUpdateFrequency() {
        return updateFrequency;
    }

    /**
     * Set how often the interpreter should update, in milliseconds. Setting this to 0 will update every cycle.
     * @param pingFrequency
     */
    public void setUpdateFrequency(int pingFrequency) {
        this.updateFrequency = pingFrequency;
    }

    /**
     * Sets how often the interpreter updates, by syncing it's update rate with a sensors. To truly sync the two, the interpreter must be constructed synced or at the same updateFrequency.
     * @param pingSyncProvider
     */
    public void syncUpdateFrequency(Sensor pingSyncProvider){
        updateFrequency = pingSyncProvider.getPingFrequency();
    }

    /**
     * This will stop updating the interpreter until resumeInterpreter is called
     */
    public void pauseInterpreter(){
        updateInterpreter = false;
    }

    /**
     * This will resume updating the interpreter after pauseInterpreter has been used
     */
    public void resumeInterpreter(){
        updateInterpreter = true;
    }

}

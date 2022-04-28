package com.wolfpackmachina.bettersensors.SensorInterpreters;

//TODO YEAH BE COOL IF THIS CODE WORKED TOO
/*


@Config
public class DistToPosition extends UpdatingSensorInterpreter {

    private static double ANGLE_MARGIN = 5;

    private final DistanceSensor leftDistSensor, rightDistSensor, forwardDistSensor;
    private final Gyro gyro;
    private final GyroExtensions gyroData;
    private boolean isXDataCurrent;
    private boolean isYDataCurrent;
    private double xPosMM;
    private double yPosMM;

    /**
     * Forward in this context is in the direction of the intake.
     * @param leftDistSensor
     * @param rightDistSensor
     * @param forwardDistSensor
     * @param gyroExtensions
     */


/*


    public DistToPosition(DistanceSensor leftDistSensor, DistanceSensor rightDistSensor, DistanceSensor forwardDistSensor, Gyro gyro,
                          GyroExtensions gyroExtensions)
    {
        super();
        this.leftDistSensor = leftDistSensor;
        this.rightDistSensor = rightDistSensor;
        this.forwardDistSensor = forwardDistSensor;
        this.gyroData = gyroExtensions;
        this.gyro = gyro;
    }

    @Override
    protected void interpretData() {
        isXDataCurrent = false;
        isYDataCurrent = false;

        switch (GameState.alliance) {
            case RED_ALLIANCE:
                if(gyroData.isAngleWithinMargin(0, ANGLE_MARGIN)){
                    setData(rightDistSensor, forwardDistSensor, 0);
                }else if(gyroData.isAngleWithinMargin(270, ANGLE_MARGIN)){
                    setData(forwardDistSensor, leftDistSensor, 270);
                }
                break;
            case BLUE_ALLIANCE:
                if(gyroData.isAngleWithinMargin(0, ANGLE_MARGIN)){
                    setData(leftDistSensor, forwardDistSensor, 0);
                }else if(gyroData.isAngleWithinMargin(90, ANGLE_MARGIN)){
                    setData(forwardDistSensor, rightDistSensor, 90);
                }
                break;
            case PRACTICE:
                System.out.println("P roblems     e vident     e xceeding    y -positional    o verflow    u nder     r epeated    h andling,  a nd    n ot     d istance    s ensing"); //contact peter hanna with any questions
                break;
        }
    }

    private void setData(DistanceSensor xDistSensor, DistanceSensor yDistSensor, double frontAngle){
        if(xDistSensor.isInRange()){
            setXData(xDistSensor.getAvgDistance() * cos(toRadians((gyro.angle() - frontAngle) * 3.2)));
        }
        if(yDistSensor.isInRange()){
            setYData(yDistSensor.getAvgDistance() * cos(toRadians((gyro.angle() - frontAngle) * 3.2)));
        }
    }

    private void setXData(Double dist){
        isXDataCurrent = true;
        xPosMM = dist;
    }

    private void setYData(Double dist){
        isYDataCurrent = true;
        yPosMM = dist;
    }

    public boolean isXDataCurrent() {
        return isXDataCurrent;
    }

    public boolean isYDataCurrent() {
        return isYDataCurrent;
    }

    public double getXPosMM() {
        return xPosMM;
    }

    public double getYPosMM() {
        return yPosMM;
    }
}

 */


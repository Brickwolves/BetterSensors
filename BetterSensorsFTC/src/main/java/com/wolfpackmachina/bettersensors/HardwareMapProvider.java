package com.wolfpackmachina.bettersensors;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class HardwareMapProvider {
    public static HardwareMap hardwareMap;

    public static void setMap(OpMode opMode){
        hardwareMap = opMode.hardwareMap;
    }

    public static void setMap(HardwareMap inputHardwareMap){
        hardwareMap = hardwareMap;
    }

}

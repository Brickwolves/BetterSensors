package com.wolfpackmachina.bettersensors.Utils;

import static java.lang.Math.abs;
import static java.lang.Math.floorMod;

import android.os.Build;

import androidx.annotation.RequiresApi;

public class MathUtils {

    public static double deadZone(double number, double deadZone){

        return number < deadZone && number > -deadZone ? 0 : number;

    }

    public static double sigmoid(double rawNumber, double range, double outputRange){
        return (outputRange / (1 + Math.pow(range, -rawNumber))) - outputRange / 2;
    }

    public static double degsToRads(Double theta){
        return theta * (Math.PI / 180);
    }

    public static double radsToDegs(Double theta){ return theta * (180 / Math.PI); }


    public static double degSin(double theta){ return Math.sin(degsToRads(theta)); }

    public static double degCos(double theta){ return Math.cos(degsToRads(theta)); }

    public static double degTan(double theta){ return Math.tan(degsToRads(theta)); }

    public static double degASin(double sin){ return radsToDegs(Math.asin(sin)); }

    public static double degATan(double opposite, double adjacent){ return radsToDegs(Math.atan2(opposite, adjacent)); }


    public static double mod(double value, int base){
        return (value % base + base) % base;
    }

    public static double pow(double value, double exponent) {
        if(value == 0) return 0;
        else return Math.pow(abs(value), exponent) * (value / abs(value));
    }

    //TODO Make these actually have input for accuracy like a normal function
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static double floorModDouble(double dividend, double divisor){
        return floorMod(Math.round(dividend * 1e6), Math.round(divisor * 1e6)) / 1e6;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static double floorModDouble(double dividend, int divisor){
        return floorMod(Math.round(dividend * 1e6), divisor) / 1e6;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static double floorModDouble(int dividend, double divisor){
        return floorMod(dividend, Math.round(divisor * 1e6)) / 1e6;

    }

    //calculates distance between two points
    public static double distance2D(double x1, double y1, double x2, double y2){
        return abs(Math.hypot(x2-x1, y2-y1));
    }


    public static double angleFromOrigin(double X, double Y){
        return ((270 - (Math.atan2(0 - Y, 0 - X)) * 180 / Math.PI) % 360);
    }

    public static boolean withinRange(double value, double min, double max){
        return (value >= min) && (value <= max);
    }

    public static double linearConversion(double value, double oldMin, double oldMax, double newMin, double newMax){
        double oldRange = (oldMax - oldMin);
        double newRange = (newMax - newMin);
        return (((value - oldMin) * newRange) / oldRange) + newMin;
    }

}

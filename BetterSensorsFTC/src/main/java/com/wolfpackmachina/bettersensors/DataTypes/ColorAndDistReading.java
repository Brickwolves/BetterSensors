package com.wolfpackmachina.bettersensors.DataTypes;

public class ColorAndDistReading {

    private final int alpha;
    private final int red;
    private final int green;
    private final int blue;
    private final double distance;

    public ColorAndDistReading(int alpha, int red, int green, int blue, double distance) {
        this.alpha = alpha;
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.distance = distance;
    }

    public int alpha() {
        return alpha;
    }

    public int red() {
        return red;
    }

    public int green() {
        return green;
    }

    public int blue() {
        return blue;
    }

    public double distance(){
        return distance;
    }

}

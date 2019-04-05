package com.example.spacetraders.entities;

import android.graphics.Color;

import java.util.Random;

public enum StarClass {
    O('O', 0.004f, Color.parseColor("#9BB0FF"), 30000, 99999, 6.6,  99.99),
    B('B', 0.027f, Color.parseColor("#BBCCFF"), 10000, 30000, 1.8,  6.6),
    A('A', 0.10f,  Color.parseColor("#FBF8FF"), 7500,  10000, 1.4,  1.8),
    F('F', 0.24f,  Color.parseColor("#FFFFED"), 6000,  7500,  1.15, 1.4),
    G('G', 0.35f,  Color.parseColor("#FFFF00"), 5200,  6000,  0.96, 1.15),
    K('K', 0.60f,  Color.parseColor("#FF9833"), 3700,  5200,  0.7,  0.96),
    M('M', 1.00f,  Color.parseColor("#FF0000"), 2400,  3700,  0.12, 0.7);

    private final char classification;
    private final float chance;
    private final int color;
    private final int tempLower;
    private final int tempUpper;
    private final double radiusLower;
    private final double radiusUpper;

    private final Random r = new Random();

    StarClass(char classification, float chance, int color, int tempLower,
              int tempUpper, double radiusLower, double radiusUpper) {
        this.classification = classification;
        this.chance = chance;
        this.color = color;
        this.tempLower = tempLower;
        this.tempUpper = tempUpper;
        this.radiusLower = radiusLower;
        this.radiusUpper = radiusUpper;
    }

    public static float[] getChancesAsArray() {
        StarClass[] values = StarClass.values();
        float chances[] = new float[values.length];
        for (int i = 0; i < values.length; i++) {
            chances[i] = values[i].getChance();
        }
        return chances;
    }

    public char getClassification() {
        return this.classification;
    }

    private float getChance() {
        return this.chance;
    }

    public int getColor() {
        return this.color;
    }

    public int getTempLower() {
        return tempLower;
    }

    public int getTempUpper() {
        return tempUpper;
    }

    public double getRadiusLower() {
        return radiusLower;
    }

    public double getRadiusUpper() {
        return radiusUpper;
    }
}

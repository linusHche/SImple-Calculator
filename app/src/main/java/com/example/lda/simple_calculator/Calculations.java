package com.example.linusanddave.simple_calculator;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Calculations {

    public static String addition(double a, double b) {
        NumberFormat nf = new DecimalFormat("##.###############");
        return nf.format(a+b);
    }

    public static String subtraction(double a, double b) {
        NumberFormat nf = new DecimalFormat("##.###############");
        return nf.format(a-b);
    }

    public static String multiplication(double a, double b) {
        NumberFormat nf = new DecimalFormat("##.###############");
        return nf.format(a*b);
    }

    public static String regularDivision(double a, double b) {
        NumberFormat nf = new DecimalFormat("##.###############");
        return nf.format(a/b);
    }

    public static String divisionWithRemainder(double a, double b) {
        int quot = (int) (a/b);
        int rem = (int) (a%b);
        return quot + " r " + rem;
    }

    public static double log(double a) {
        return Math.log(a);
    }

    public static double sine(double a) {
        return Math.sin(a);
    }

    public static double cos(double a) {
        return Math.cos(a);
    }

    public static double tan(double a) {
        return Math.tan(a);
    }

    public static double asin(double a) {
        return Math.asin(a);
    }

    public static double acos(double a) {
        return Math.acos(a);
    }
    public static double atan(double a) {
        return Math.atan(a);
    }



}

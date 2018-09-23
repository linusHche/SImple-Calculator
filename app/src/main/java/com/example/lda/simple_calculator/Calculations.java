package com.example.lda.simple_calculator;

public class Calculations {

    public static double addition(double a, double b) {
        return a+b;
    }

    public static double subraction(double a, double b) {
        return a-b;
    }

    public static double mutiplication(double a, double b) {
        return a*b;
    }

    public static double regDivision(double a, double b) {
        return a/b;
    }

    public static String devisionWiRemainder(double a, double b) {
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

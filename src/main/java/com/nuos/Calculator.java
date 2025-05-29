package com.nuos;

public class Calculator {
    public double calculateFormula1(double a, double b, double x) {
        // R = x^2 * (x + 1) / b - sin^2(x + a)
        return (Math.pow(x, 2) * (x + 1) / b) - Math.pow(Math.sin(x + a), 2);
    }

    public double calculateFormula2(double a, double b, double x) {
        // S = sqrt(x * b / a) + cos^2(x + b)^3
        return Math.sqrt(x * b / a) + Math.pow(Math.cos(x + b), 6);
    }
}


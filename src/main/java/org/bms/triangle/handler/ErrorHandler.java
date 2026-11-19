package org.bms.triangle.handler;

import org.bms.triangle.TriangleType;

public class ErrorHandler implements TriangleHandler {

    @Override
    public boolean canHandle(double a, double b, double c) {
        return !isValidTriangle(a, b, c);
    }

    @Override
    public TriangleType classify(double a, double b, double c) {
        return TriangleType.INVALID;
    }

    private boolean isValidTriangle(double a, double b, double c) {
        return Double.isFinite(a)
                && Double.isFinite(b)
                && Double.isFinite(c)
                && a > 0 && b > 0 && c > 0
                && a + b > c
                && a + c > b
                && b + c > a;
    }
}
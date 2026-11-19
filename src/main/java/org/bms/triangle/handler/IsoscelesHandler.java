package org.bms.triangle.handler;

import org.bms.triangle.TriangleType;

public class IsoscelesHandler implements TriangleHandler {

    @Override
    public boolean canHandle(double a, double b, double c) {
        return a == b || a == c || b == c;
    }

    @Override
    public TriangleType classify(double a, double b, double c) {
        return TriangleType.ISOSCELES;
    }
}
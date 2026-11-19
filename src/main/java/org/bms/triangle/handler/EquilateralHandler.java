package org.bms.triangle.handler;

import org.bms.triangle.TriangleType;

public class EquilateralHandler implements TriangleHandler {

    @Override
    public boolean canHandle(double a, double b, double c) {
        return a == b && b == c;
    }

    @Override
    public TriangleType classify(double a, double b, double c) {
        return TriangleType.EQUILATERAL;
    }
}

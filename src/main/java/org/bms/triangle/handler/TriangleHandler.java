package org.bms.triangle.handler;

import org.bms.triangle.TriangleType;

public interface TriangleHandler {

    boolean canHandle(double a, double b, double c);

    TriangleType classify(double a, double b, double c);
}
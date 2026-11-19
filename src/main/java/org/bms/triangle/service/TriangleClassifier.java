package org.bms.triangle.service;

import org.bms.triangle.TriangleType;
import org.bms.triangle.handler.*;

import java.util.List;

public class TriangleClassifier {
    private static final TriangleClassifier INSTANCE =
            new TriangleClassifier();

    public static TriangleClassifier getInstance() {
        return INSTANCE;
    }

    private final List<TriangleHandler> handlers;

    private TriangleClassifier() {
        this.handlers = List.of(
                new ErrorHandler(),
                new EquilateralHandler(),
                new IsoscelesHandler(),
                new ScaleneHandler()
        );
    }

    public TriangleType classify(double a, double b, double c) {
        return handlers.stream()
                .filter(handler -> handler.canHandle(a, b, c))
                .findFirst()
                .map(handler -> handler.classify(a, b, c))
                .orElseThrow(() ->
                        new IllegalArgumentException("No handler found"));
    }
}

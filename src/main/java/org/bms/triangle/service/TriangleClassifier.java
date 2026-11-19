package org.bms.triangle.service;

import org.bms.triangle.TriangleType;
import org.bms.triangle.handler.*;

import java.util.List;

public class TriangleClassifier {
    private final List<TriangleHandler> handlers;

    public TriangleClassifier(List<TriangleHandler> handlers) {
        this.handlers = List.copyOf(handlers);
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

package org.bms.triangle.service;

import org.bms.triangle.TriangleType;
import org.bms.triangle.handler.EquilateralHandler;
import org.bms.triangle.handler.ErrorHandler;
import org.bms.triangle.handler.IsoscelesHandler;
import org.bms.triangle.handler.ScaleneHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TriangleClassifierTest {

    private TriangleClassifier classifier;

    @BeforeEach
    void setUp() {
        classifier = new TriangleClassifier(List.of(
                new ErrorHandler(),
                new EquilateralHandler(),
                new IsoscelesHandler(),
                new ScaleneHandler()
        ));
    }

    @Test
    void shouldClassifyEquilateralTriangle() {
        assertEquals(TriangleType.EQUILATERAL,
                classifier.classify(5, 5, 5));
    }

    @Test
    void shouldClassifyIsoscelesTriangle() {
        assertEquals(TriangleType.ISOSCELES,
                classifier.classify(5, 5, 3));
    }

    @Test
    void shouldClassifyScaleneTriangle() {
        assertEquals(TriangleType.SCALENE,
                classifier.classify(3, 4, 5));
    }

    @Test
    void shouldReturnInvalidForInvalidTriangle() {
        assertEquals(TriangleType.INVALID,
                classifier.classify(1, 2, 3));
    }

    @Test
    void shouldThrowExceptionWhenNoHandlerCanHandleInput() {
        TriangleClassifier emptyClassifier =
                new TriangleClassifier(List.of());

        assertThrows(
                IllegalArgumentException.class,
                () -> emptyClassifier.classify(3, 4, 5)
        );
    }
}
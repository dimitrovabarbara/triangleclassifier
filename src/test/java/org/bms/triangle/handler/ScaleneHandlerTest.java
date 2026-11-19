package org.bms.triangle.handler;

import org.bms.triangle.TriangleType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScaleneHandlerTest {
    private final ScaleneHandler handler = new ScaleneHandler();

    @Test
    void shouldHandleScaleneTriangle() {
        assertTrue(handler.canHandle(3, 4, 5));
    }

    @Test
    void shouldHandleDecimalScaleneTriangle() {
        assertTrue(handler.canHandle(2.5, 3.5, 4.5));
    }

    @Test
    void shouldNotHandleEquilateralTriangle() {
        assertFalse(handler.canHandle(5, 5, 5));
    }

    @Test
    void shouldNotHandleIsoscelesTriangle() {
        assertFalse(handler.canHandle(5, 5, 3));
    }

    @Test
    void shouldReturnScalene() {
        assertEquals(
                TriangleType.SCALENE,
                handler.classify(3, 4, 5)
        );
    }
}
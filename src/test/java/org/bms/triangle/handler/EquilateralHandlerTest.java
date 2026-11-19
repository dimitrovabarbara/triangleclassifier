package org.bms.triangle.handler;

import org.bms.triangle.TriangleType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EquilateralHandlerTest {

    private final EquilateralHandler handler = new EquilateralHandler();

    @Test
    void shouldHandleEquilateralTriangle() {
        assertTrue(handler.canHandle(5, 5, 5));
    }

    @Test
    void shouldHandleDecimalEquilateralTriangle() {
        assertTrue(handler.canHandle(2.5, 2.5, 2.5));
    }

    @Test
    void shouldNotHandleIsoscelesTriangle() {
        assertFalse(handler.canHandle(5, 5, 3));
    }

    @Test
    void shouldNotHandleScaleneTriangle() {
        assertFalse(handler.canHandle(3, 4, 5));
    }

    @Test
    void shouldReturnEquilateral() {
        assertEquals(
                TriangleType.EQUILATERAL,
                handler.classify(5, 5, 5)
        );
    }
}
package org.bms.triangle.handler;

import org.bms.triangle.TriangleType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ErrorHandlerTest {
    private final ErrorHandler handler = new ErrorHandler();

    @Test
    void shouldHandleInvalidTriangle() {
        assertTrue(handler.canHandle(1, 2, 3));
    }

    @Test
    void shouldHandleTriangleWithZeroSide() {
        assertTrue(handler.canHandle(0, 4, 5));
    }

    @Test
    void shouldHandleTriangleWithNegativeSide() {
        assertTrue(handler.canHandle(-2, 4, 5));
    }

    @Test
    void shouldHandleTriangleWithInfiniteSide() {
        assertTrue(handler.canHandle(Double.POSITIVE_INFINITY, 2, 3));
    }

    @Test
    void shouldHandleTriangleWithNaN() {
        assertTrue(handler.canHandle(Double.NaN, 2, 3));
    }

    @Test
    void shouldReturnInvalid() {
        assertEquals(TriangleType.INVALID, handler.classify(1, 2, 3));
    }
}
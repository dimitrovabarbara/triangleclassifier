package org.bms.triangle.handler;

import org.bms.triangle.TriangleType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IsoscelesHandlerTest {
    private final IsoscelesHandler handler = new IsoscelesHandler();

    @Test
    void shouldHandleFirstAndSecondSidesEqual() {
        assertTrue(handler.canHandle(5, 5, 3));
    }

    @Test
    void shouldHandleFirstAndThirdSidesEqual() {
        assertTrue(handler.canHandle(5, 3, 5));
    }

    @Test
    void shouldHandleSecondAndThirdSidesEqual() {
        assertTrue(handler.canHandle(3, 5, 5));
    }


    @Test
    void shouldNotHandleScaleneTriangle() {
        assertFalse(handler.canHandle(3, 4, 5));
    }

    @Test
    void shouldReturnIsosceles() {
        assertEquals(
                TriangleType.ISOSCELES,
                handler.classify(5, 5, 3)
        );
    }
}
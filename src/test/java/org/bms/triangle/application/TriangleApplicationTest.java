package org.bms.triangle.application;

import static org.junit.jupiter.api.Assertions.*;

import org.bms.triangle.handler.EquilateralHandler;
import org.bms.triangle.handler.ErrorHandler;
import org.bms.triangle.handler.IsoscelesHandler;
import org.bms.triangle.handler.ScaleneHandler;
import org.bms.triangle.service.TriangleClassifier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

class TriangleApplicationTest {

    private ByteArrayOutputStream output;

    @BeforeEach
    void setUp() {
        output = new ByteArrayOutputStream();
    }

    @Test
    void shouldDisplayWelcomeMessage() {
        runApplicationWithInput("");
        String result = output.toString();

        assertTrue(result.contains("Triangle Classifier"));
        assertTrue(result.contains("Enter three side lengths"));
        assertTrue(result.contains("Type 'end' to exit."));
    }

    @Test
    void shouldHandleEquilateralTriangle() {
        runApplicationWithInput("5, 5, 5\nend\n");

        assertTrue(output.toString().contains("Triangle type: EQUILATERAL"));
    }

    @Test
    void shouldHandleIsoscelesTriangle() {
        runApplicationWithInput("5 5 3\nend\n");

        assertTrue(output.toString().contains("Triangle type: ISOSCELES"));
    }

    @Test
    void shouldHandleScaleneTriangle() {
        runApplicationWithInput("3, 4, 5\nend\n");

        assertTrue(output.toString().contains("Triangle type: SCALENE"));
    }

    @Test
    void shouldHandleInvalidTriangle() {
        runApplicationWithInput("1, 2, 3\nend\n");

        assertTrue(output.toString().contains("Triangle type: INVALID"));
    }

    @Test
    void shouldHandleInvalidInput() {
        runApplicationWithInput("abc, 4, 5\nend\n");

        assertTrue(output.toString().contains("Error:"));
    }

    @Test
    void shouldExitWhenEndIsEntered() {
        runApplicationWithInput("end\n");

        assertTrue(output.toString().contains("Goodbye!"));
    }

    @Test
    void shouldRecognizeEndRegardlessOfCase() {
        runApplicationWithInput("END\n");

        assertTrue(output.toString().contains("Goodbye!"));
    }

    @Test
    void shouldContinueAfterInvalidInput() {
        runApplicationWithInput("abc, 4, 5\n3, 4, 5\nend\n");

        String result = output.toString();

        assertTrue(result.contains("Error:"));
        assertTrue(result.contains("Triangle type: SCALENE"));
        assertTrue(result.contains("Goodbye!"));
    }

    private void runApplicationWithInput(String input) {
        Scanner scanner = new Scanner(input);

        TriangleApplication application = new TriangleApplication(
                new TriangleClassifier(List.of(
                        new ErrorHandler(),
                        new EquilateralHandler(),
                        new IsoscelesHandler(),
                        new ScaleneHandler()
                )),
                scanner,
                new PrintStream(output)
        );

        application.run();
    }
}
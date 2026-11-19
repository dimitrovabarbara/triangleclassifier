package org.bms.triangle.input;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleInputParserTest {

    @Test
    void shouldParseCommaSeparatedInput() {
        double[] result = TriangleInputParser.parseSides("3, 4, 5");

        assertArrayEquals(new double[]{3, 4, 5}, result);
    }

    @Test
    void shouldParseSpaceSeparatedInput() {
        double[] result = TriangleInputParser.parseSides("3 4 5");

        assertArrayEquals(new double[]{3, 4, 5}, result);
    }

    @Test
    void shouldParseMixedSeparators() {
        double[] result = TriangleInputParser.parseSides("3, 4 5");

        assertArrayEquals(new double[]{3, 4, 5}, result);
    }

    @Test
    void shouldRejectInputWithLessThanThreeSides() {
        assertThrows(
                IllegalArgumentException.class,
                () -> TriangleInputParser.parseSides("3, 4")
        );
    }

    @Test
    void shouldRejectNonNumericInput() {
        assertThrows(
                NumberFormatException.class,
                () -> TriangleInputParser.parseSides("abc, 4, 5")
        );
    }

    @Test
    void shouldRecognizeExitCommand() {
        assertTrue(TriangleInputParser.shouldExit("end"));
        assertTrue(TriangleInputParser.shouldExit("END"));
        assertTrue(TriangleInputParser.shouldExit(" End "));
    }

    @Test
    void shouldNotRecognizeNormalInputAsExitCommand() {
        assertFalse(TriangleInputParser.shouldExit("3, 4, 5"));
    }
}

package org.bms.triangle.input;

public class TriangleInputParser {

    public static double[] parseSides(String input) {

        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("Input cannot be empty.");
        }

        String[] sides = input.trim().split("[,\\s]+");

        if (sides.length != 3) {
            throw new IllegalArgumentException(
                    "Exactly three side lengths are required."
            );
        }

        return new double[]{
                Double.parseDouble(sides[0]),
                Double.parseDouble(sides[1]),
                Double.parseDouble(sides[2])
        };
    }

    public static boolean shouldExit(String input) {
        return input != null && input.trim().equalsIgnoreCase("end");
    }
}
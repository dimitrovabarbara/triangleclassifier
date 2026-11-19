package org.bms.triangle.application;

import org.bms.triangle.TriangleType;
import org.bms.triangle.input.TriangleInputParser;
import org.bms.triangle.service.TriangleClassifier;

import java.io.PrintStream;
import java.util.Scanner;

public class TriangleApplication {

    private final TriangleClassifier classifier;
    private final Scanner scanner;
    private final PrintStream output;

    public TriangleApplication(
            TriangleClassifier classifier,
            Scanner scanner,
            PrintStream output
    ) {
        this.classifier = classifier;
        this.scanner = scanner;
        this.output = output;
    }

    public void run() {
        printWelcomeMessage();

        while (true) {
            print("Enter sides: ");
            if (!scanner.hasNextLine()) {
                break;
            }

            String input = scanner.nextLine();

            if (TriangleInputParser.shouldExit(input)) {
                print("Goodbye!");
                break;
            }

            String triangleTypeResult = classify(input);
            print(triangleTypeResult + "\n");
        }
    }

    private String classify(String input) {
        try {
            double[] sides = TriangleInputParser.parseSides(input);

            TriangleType result = classifier.classify(
                    sides[0], sides[1], sides[2]
            );

            return ("Triangle type: " + result);

        } catch (IllegalArgumentException e) {
            return ("Error: " + e.getMessage());
        }
    }

    private void printWelcomeMessage() {
        print("Triangle Classifier");
        print("Enter three side lengths separated by commas or spaces.");
        print("Type 'end' to exit.");
    }

    private void print(String message) {
        output.println(message);
    }
}

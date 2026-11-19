package org.bms;

import org.bms.triangle.application.TriangleApplication;
import org.bms.triangle.handler.*;
import org.bms.triangle.service.TriangleClassifier;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<TriangleHandler> handlers = List.of(
                new ErrorHandler(),
                new EquilateralHandler(),
                new IsoscelesHandler(),
                new ScaleneHandler()
        );

        TriangleClassifier classifier = new TriangleClassifier(handlers);

        try (Scanner scanner = new Scanner(System.in)) {
            TriangleApplication application =
                    new TriangleApplication(classifier, scanner, System.out);

            application.run();
        }
    }
}
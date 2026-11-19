package org.bms;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import org.bms.triangle.application.TriangleApplication;
import org.bms.triangle.handler.*;
import org.bms.triangle.service.TriangleClassifier;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<TriangleHandler> handlers = List.of(
                new ErrorHandler(),
                new EquilateralHandler(),
                new IsoscelesHandler(),
                new ScaleneHandler()
        );

        TriangleClassifier classifier = new TriangleClassifier(handlers);
        TriangleApplication application = new TriangleApplication(classifier);

        application.run();
    }
}
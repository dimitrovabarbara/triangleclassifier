package org.bms;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import org.bms.triangle.application.TriangleApplication;
import org.bms.triangle.service.TriangleClassifier;

public class Main {

    public static void main(String[] args) {
        TriangleClassifier classifier = TriangleClassifier.getInstance();
        TriangleApplication application = new TriangleApplication(classifier);

        application.run();
    }
}
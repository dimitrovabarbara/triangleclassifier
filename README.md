# Triangle Classifier

A Java command-line application that classifies triangles based on their three side lengths.

## Triangle Types

- **Equilateral** – all three sides are equal.
- **Isosceles** – exactly two sides are equal.
- **Scalene** – all three sides are different.
- **Invalid** – the side lengths do not form a valid triangle.

## Requirements

- Java 21
- Gradle

## Run

```bash
./gradlew run
```

Enter three side lengths separated by commas or spaces. Type `end` to exit.

## Run Tests

```bash
./gradlew test
```

## Design

The application uses separate components for input parsing, classification, and triangle-type handlers. 
Dependencies are injected through constructors to keep the classification logic modular and testable.
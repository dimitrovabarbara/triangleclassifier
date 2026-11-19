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

I was debating between handlers as it is now, and just doing an if statement in the TriangleClassifier.
Probably now it is overengineered, but I image a use case where we have to calculate the area's of the triangles 
or introduce more types, such as right-angled, ocute, etc. 
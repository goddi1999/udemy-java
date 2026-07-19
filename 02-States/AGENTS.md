# AGENTS.md — 02 States

## Ueberblick
Gradle-Konsolenprojekt. Zustandsautomat eines Roboters (Enum-basiert).

## Struktur
- app/src/main/java/de/rt/fp/robot/State.java   (enum)
- app/src/main/java/de/rt/fp/robot/Robot.java
- app/src/main/java/de/rt/fp/robot/App.java

## Tech-Stack
- Java 21, Gradle, Scanner (System.in)

## Build & Run
- ./gradlew run

## Konventionen
- Package: de.rt.fp.robot
- Zufaelligkeit nur in work() ueber Math.random()
- Zustandslogik im Enum (getNext), nicht in App

## Tutor-Hinweis
Ask-Mode = Hinweise statt Loesung (siehe .github/copilot-instructions.md).

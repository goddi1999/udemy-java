# AGENTS.md — 06 FXML Calculator

## Ueberblick
JavaFX-Gradle-Projekt (MVVM). FXML-View + ViewModel-Controller + Model.

## Struktur
- app/src/main/java/de/rt/fp/calculator/App.java
- app/src/main/java/de/rt/fp/calculator/SimpleCalculatorModel.java
- app/src/main/java/de/rt/fp/calculator/SimpleCalculatorViewModel.java
- app/src/main/java/de/rt/fp/calculator/SimpleCalculatorException.java
- app/src/main/resources/fxml/SimpleCalculator.fxml

## Tech-Stack
- Java 21, Gradle, JavaFX 21 (javafx.controls, javafx.fxml)
- org.openjfx.javafxplugin 0.1.0

## Konventionen
- Package: de.rt.fp.calculator  (KEIN Platzhalter wie ihr.package)
- fx:controller + fx:id konsistent zu den Controller-Feldern
- Gradle nach build.gradle-Aenderung neu laden

## Run
- ./gradlew run

## Tutor-Hinweis
Ask-Mode = Hinweise statt Loesung (siehe .github/copilot-instructions.md).

# AGENTS.md — 07 CaesarCipher FXML

## Ueberblick
JavaFX-Gradle-Projekt (MVVM). Caesar-Chiffre mit Slider-Key und Fehleranzeige.

## Struktur
- app/src/main/java/de/rt/fp/caesar/App.java
- app/src/main/java/de/rt/fp/caesar/CaesarCipherModel.java
- app/src/main/java/de/rt/fp/caesar/CaesarCipherViewModel.java
- app/src/main/java/de/rt/fp/caesar/CaesarCipherException.java
- app/src/main/resources/fxml/CaesarCipher.fxml

## Tech-Stack
- Java 21, Gradle, JavaFX 21 (javafx.controls, javafx.fxml)
- org.openjfx.javafxplugin 0.1.0

## Konventionen
- Package: de.rt.fp.caesar
- fx:id sprechend (keySlider, inputField, messageLabel) = Controller-Felder
- Entschluesseln = cipher mit angepasstem Key (nicht zweite Logik)
- key gueltig 1..26, nur Kleinbuchstaben a-z

## Run
- ./gradlew run

## Tutor-Hinweis
Ask-Mode = Hinweise statt Loesung (siehe .github/copilot-instructions.md).

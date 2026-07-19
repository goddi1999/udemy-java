# AGENTS.md — 01 Karteikarten

## Ueberblick
Gradle-Konsolenprojekt (Modul app/). Erstellt und fragt Karteikarten ab.

## Struktur
- app/src/main/java/de/rt/fp/flashcards/Card.java
- app/src/main/java/de/rt/fp/flashcards/Game.java
- app/src/main/java/de/rt/fp/flashcards/App.java

## Tech-Stack
- Java 21, Gradle
- Konsole: EIN gemeinsamer java.util.Scanner (in App erzeugt, an setup/play uebergeben)

## Build & Run
- ./gradlew run   (build.gradle: run { standardInput = System.in })

## Konventionen
- Package: de.rt.fp.flashcards
- Englische Bezeichner, eine Klasse pro Datei
- Scanner NICHT mehrfach auf System.in oeffnen

## Tutor-Hinweis
Ask-Mode = Hinweise statt Loesung (siehe .github/copilot-instructions.md).

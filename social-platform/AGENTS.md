# AGENTS.md — Mini-Social-Media-Plattform

## Ueberblick
JavaFX-Gradle-Projekt (Modul app/). Single-User-Social-Prototyp:
EIN Post mit Likes, Bild und Kommentaren, gespeichert in einer Textdatei.
Architektur: MVVM.

## Struktur
- app/src/main/java/de/rt/fp/social/model/Post.java
- app/src/main/java/de/rt/fp/social/model/Comment.java
- app/src/main/java/de/rt/fp/social/viewmodel/FeedViewModel.java
- app/src/main/java/de/rt/fp/social/persistence/PostRepository.java   // DAO, Textdatei
- app/src/main/java/de/rt/fp/social/App.java                          // JavaFX Application
- app/src/main/resources/de/rt/fp/social/feed.fxml                    // TabPane: Feed + Comments
- app/src/test/java/de/rt/fp/social/model/...                         // Unit-Tests (Model)

## Tech-Stack
- Java 21, Gradle, JavaFX (FXML / Scene Builder)
- Tests: JUnit 5 + JaCoCo (Ziel ~80% auf Modellklassen)

## Build & Run
- ./gradlew run
- ./gradlew test jacocoTestReport
- ./gradlew jar

## Konventionen
- Package: de.rt.fp.social
- MVVM strikt: Model OHNE JavaFX-Imports, keine Geschaeftslogik im Controller
- Englische Bezeichner, eine Klasse pro Datei
- Eigene fachliche Exceptions (z. B. TextTooLongException, EmptyTextException)
- Fehler in der UI anzeigen (Statuslabel/Alert), nicht nur auf der Konsole

## Datenstruktur (bewusst einfach)
- Post haelt List<Comment>; Kommentare gehoeren zum Post (Loeschen = Kaskade)

## Tutor-Hinweis
Ask-Mode = Hinweise statt Loesung. Die Implementierung bleibt Aufgabe der Gruppe.
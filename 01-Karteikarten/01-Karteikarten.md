# 01 - Karteikarten (Flashcards)

## Ziel
Interaktive Konsolen-App: Karteikarten erstellen und danach abfragen.

## Klassen
- Card  — eine Karteikarte (Frage + Antwort)
- Game  — haelt Score und Liste aller Karten, steuert den Ablauf
- App   — main-Methode, erzeugt EINEN Scanner

## Contracts (Signaturen)
Card:
- Card(String question, String answer)
- String getQuestion()
- boolean checkAnswer(String input)   // true, wenn korrekt

Game:
- void setup(Scanner scanner)   // Karten anlegen (Schleife y/n)
- void play(Scanner scanner)    // abfragen, Score zaehlen
- int getScore()

## Build / Run
- Gradle. In build.gradle:
      run { standardInput = System.in }
- Starten: ./gradlew run

## Beispiel-Ablauf (erwartetes Transkript)
    Enter card question:
    > Capital of France?
    Enter card answer:
    > Paris
    Do you want to add a new card? (y/n)
    > n
    Capital of France?
    > Paris
    Correct!
    Your score: 1/1

## Konzepte
Klassen & Kapselung, List, Scanner-Schleife, String-Vergleich.

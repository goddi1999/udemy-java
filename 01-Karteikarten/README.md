# 01 - Karteikarten

## Ziel

Das Ziel dieser Aufgabe ist die Entwicklung einer interaktiven Karteikarten-App, die es ermöglicht, Karteikarten zu erstellen und anschließend abzufragen.

## Vorgehen

### 1. Erstellen eines Gradle-Projekts

Bitte beachten Sie die in der Vorlesung erklärten Schritte.

### 2. Hinzufügen der Scanner-Abhängigkeit

In der Datei build.gradle die benötigte Scanner-Abhängigkeit hinzufügen.

```gradle
run {
    standardInput = System.in
}
```

### 3. Implementierung der Card-Klasse

Die Klasse Card sollte folgende Funktionen enthalten:

- Speichern einer Frage und einer Antwort
- Eine Methode zur Überprüfung der Korrektheit einer Benutzereingabe
- Getter-Methoden für die Frage

### 4. Implementierung der Game-Klasse

Die Game-Klasse sollte einen Score der korrekt beantworteten Karten und eine Liste aller Karten speichern.

#### setup(Scanner scanner)-Methode

- Ermöglicht dem Benutzer das Erstellen beliebig vieler Karteikarten
- Der Benutzer kann nach jeder Karte entscheiden, ob er eine weitere hinzufügen möchte

**Tipp:**

```java
boolean nextCard = true;
while (nextCard) {
    System.out.println("Enter card question:");
    String question = scanner.nextLine();
    // Implement retrieval of answer and adding of card to card list
    System.out.println("Do you want to add a new card? (y/n)");
    String input = scanner.nextLine();
    // Implement follow up logic
}
```

**Hinweis:** Sowohl setup(Scanner scanner) als auch play(Scanner scanner) sollten denselben Scanner überreicht bekommen, damit global mit einem Scanner gearbeitet werden kann.

#### play(Scanner scanner)-Methode

- Die gespeicherten Fragen werden nacheinander abgefragt
- Der Benutzer gibt eine Antwort ein, die mit der gespeicherten Antwort verglichen wird
- Richtige Antworten erhöhen den Score um 1
- Am Ende wird der erreichte Score als Nachricht ausgegeben

**Tipp:** Iterieren Sie durch die Liste der Karten in Game und Fragen Sie Antworten mithilfe des Scanners ab.

### 5. Implementierung der main-Methode

```java
public static void main(String[] args) {
    Game game = new Game();
    // One scanner for global use
    Scanner scanner = new Scanner(System.in);
    // Build game
    game.setup(scanner);
    // Play game
    game.play(scanner);
    scanner.close();
}
```

---

*Zuletzt geändert: Mittwoch, 18. März 2026, 09:14*

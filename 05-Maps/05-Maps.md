# 05 - Maps

## Aufgabe

Entwickeln Sie einen Wortzähler, der intern eine Map verwendet, um die Häufigkeit von Wörtern zu speichern.

## Anforderungen

Die Klasse `WordCounter` soll folgende Methoden enthalten:

### public void addToCounter(String input)

- Fügt ein Wort zum Zähler hinzu und erhöht die Häufigkeit des Wortes
- Beispiel: Bei der Eingabe "Test" wird Test: 1 gespeichert, bei erneuter Eingabe des Wortes wird Test: 2 gespeichert

### public Map<String, Integer> getWordCounts()

- Gibt die gespeicherten Wörter und deren Häufigkeiten zurück

### public int getTotalWords()
0
- Gibt die Gesamtanzahl aller Wörter, basierend auf ihren Häufigkeiten, zurück

### public String getMostFrequentWord()

- Gibt das am häufigsten in der Map enthaltene Wort zurück
- Kommen zwei Wörter gleich oft vor, reicht es, nur eines zurückzugeben

### public String getLeastFrequentWord()

- Gibt das am seltensten enthaltene Wort zurück
- Kommen zwei Wörter gleich oft vor, soll das Wort, welches in lexikographischer Reihenfolge später vorkommt, zurückgegeben werden
- Beispiel: a, b -> b

## App-Klasse

Erstellen Sie eine App-Klasse, die eine Benutzerschnittstelle bereitstellt, um mit dem WordCounter zu interagieren.

Die App soll:

1. Den Benutzer nach einer Eingabe fragen
2. Die Eingabe im Wortzähler speichern
3. Die Möglichkeit geben, alle Abfragen auszuführen (getWordCounts(), getTotalWords(), etc.)

Verwenden Sie den folgenden Code als Grundlage für Ihre Implementierung:

```java
boolean exit = false;
while (!exit) {
    System.out.println("Please select an option");
    System.out.println("1: Add Word");
    System.out.println("2: Get Word Counts");
    System.out.println("3: Get total number of words");
    System.out.println("4: Get most frequent word");
    System.out.println("5: Get least frequent word (last lexicographic)");
    System.out.println("0: Exit");
    String choice = scanner.nextLine();
    switch (choice) {
        case "1":
            // Implement your solution
    }
}
```

---

*Zuletzt geändert: Mittwoch, 22. April 2026, 13:42*

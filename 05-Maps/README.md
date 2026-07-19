# 05 - Maps (WordCounter)

## Ziel
Woerter zaehlen; interne Map<String, Integer>.

## Klassen
- WordCounter
- App — Menue (Scanner)

## Contracts (Signaturen)
WordCounter:
- void addToCounter(String input)             // Haeufigkeit +1
- Map<String, Integer> getWordCounts()
- int getTotalWords()                          // Summe aller Haeufigkeiten
- String getMostFrequentWord()                 // bei Gleichstand: eines genuegt
- String getLeastFrequentWord()                // bei Gleichstand: lexikografisch spaetere (a,b -> b)

## Build / Run
- ./gradlew run

## Beispiel-Ablauf
    1  (Add Word) > Test
    1  (Add Word) > Test
    2  (Get Word Counts)  -> {Test=2}
    4  (Most frequent)    -> Test

## Konzepte
Map als Zaehler, Iteration ueber Eintraege, Min/Max mit Tie-Break.

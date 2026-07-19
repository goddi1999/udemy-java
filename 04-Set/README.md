# 04 - Set (Produktverwaltung)

## Ziel
Produkte in Kategorien (Sets) verwalten und Mengenoperationen anbieten.

## Klassen
- ProductManager — Set<String> electronics, discounted (beide anfangs leer)
- ProductException
- App — Menue (Scanner)

## Contracts (Signaturen)
ProductManager:
- void addProduct(String category, String product) throws ProductException
      // unbekannte Kategorie oder nicht hinzufuegbar -> ProductException
- void removeProduct(String category, String product) throws ProductException
- List<String> getInElectronics()
- List<String> getInDiscounted()
- List<String> getElectronicsOrDiscounted()    // Vereinigung
- List<String> getElectronicsAndDiscounted()   // Schnittmenge

## Build / Run
- ./gradlew run

## Konzepte
Set-Operationen (Vereinigung/Schnitt), eigene Exceptions, Set vs. List.

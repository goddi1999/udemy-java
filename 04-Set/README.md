# 04 - Set

## Aufgabe

Ihre Aufgabe ist es ein System zur Produktverwaltung zu schreiben. Dazu erstellen Sie eine Klasse `ProductManager`.

Im ProductManager werden verschiedene Kategorien verwaltet. Diese werden jeweils als Set von Strings im Code repräsentiert. Benötigt werden:

- `Set<String> electronics`
- `Set<String> discounted`

Zu Beginn sind beide Kategorien leer.

Produkte, die im ProductManager verwaltet werden gehören immer mindestens einer Kategorie an, ein Produkt kann aber auch Teil von electronics und discounted sein.

## Methoden in ProductManager

### public void addProduct(String category, String product)

Mit dieser Methode kann ein Produkt einer Kategorie hinzugefügt werden.

- Ist die Kategorie nicht definiert, werfen Sie eine `ProductException`
- Ansonsten fügen Sie das Produkt der angegebenen Kategorie hinzu
- Falls das Hinzufügen nicht möglich ist, werfen Sie eine `ProductException`

### public void removeProduct(String category, String product)

Mit dieser Methode kann ein Produkt aus einer Kategorie entfernt werden.

- Ist die Kategorie nicht definiert, werfen Sie eine `ProductException`
- Ansonsten entfernen Sie das Produkt aus der angegebenen Kategorie
- Falls das Entfernen nicht möglich ist, werfen Sie eine `ProductException`

## Weitere Methoden

- `public List<String> getInElectronics:` Gibt alle Produkte in electronics zurück
- `public List<String> getInDiscounted:` Gibt alle Produkte in discounted zurück
- `public List<String> getElectronicsOrDiscounted:` Gibt alle Produkte zurück, die in Electronics, Discounted oder beiden Kategorien sind
- `public List<String> getElectronicsAndDiscounted:` Gibt alle Produkte zurück, die sowohl in Electronics als auch in Discounted sind

## Interaktion mit dem System

Implementieren Sie in der Klasse `App` die Interaktion mit dem System.

Nutzen Sie dafür folgenden Code als Einstieg:

```java
boolean exit = false;
while (!exit) {
    System.out.println("Please select one of the following options (0-6)");
    System.out.println("0. Exit");
    System.out.println("1. Add a product");
    System.out.println("2. Delete a product");
    System.out.println("3. Get electronics");
    System.out.println("4. Get discounted");
    System.out.println("5. Get discounted or electronics");
    System.out.println("6. Get discounted and electronics");
    String choice = scanner.nextLine();
    String category;
    String productName;
    List<String> products;
    switch(choice) {
        case "1":
            System.out.println("Enter category");
            category = scanner.nextLine();
            System.out.println("Enter product name");
            productName = scanner.nextLine();
            try {
                productManager.addProduct(category, productName);
                System.out.println("Product added successfully!");
            } catch (ProductException e) {
                System.out.printf(e.getMessage());
            }
            break;
        // Your code goes here
    }
}
```

---

*Zuletzt geändert: Dienstag, 14. April 2026, 10:07*

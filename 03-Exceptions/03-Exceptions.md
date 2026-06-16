# 03 - Exceptions

## Aufgabe: Nutzerverwaltungssystem

Ihre Aufgabe ist es, ein System zur Nutzerverwaltung zu schreiben.

Erstellen Sie dazu eine Klasse `User` und eine Klasse `AuthenticationManager`.

## Klasse User

Ein User besitzt die folgenden Attribute:

- `String username`
- `String password`
- `int attempts` (Standardwert: 3)

### Methoden:

#### Konstruktor

- Erstellt einen Nutzer mit einem Benutzernamen und einem Passwort
- Setzt attempts standardmäßig auf 3

#### Getter

- Für username, password und attempts

#### updateAttempts()

- Reduziert die Anzahl der Versuche um 1

#### resetAttempts()

- Setzt die Anzahl der Versuche auf 3 zurück

## Klasse AuthenticationManager

Diese Klasse verwaltet eine Liste von Nutzern.

### Methoden:

#### registerUser(String username, String password)

- Erstellt einen neuen Nutzer und fügt ihn zur Nutzerliste hinzu
- Falls der Benutzername bereits existiert, wird eine `RegistrationException` geworfen

#### login(String username, String password)

- Prüft, ob das eingegebene Passwort korrekt ist
  - Falls das Passwort falsch ist:
    - Wird eine `LoginException` geworfen
    - Die Anzahl der Versuche wird um 1 reduziert
  - Falls der Login erfolgreich ist:
    - Die Anzahl der Versuche wird zurückgesetzt
- Falls der Nutzer nicht existiert:
  - Wird eine `LoginException` geworfen
- Falls der Nutzer keine Versuche mehr übrig hat:
  - Wird eine `AccountLockedException` (RuntimeException) geworfen

**Hinweis:** Sowohl für `registerUser` als auch für `login` kann eine Schleife über alle Nutzer verwendet werden.

**Hinweis:** `RegistrationException`, `LoginException` und `AccountLockedException` sollen selbst implementiert werden.

## App-Klasse

In der App-Klasse soll mithilfe des Scanners die Möglichkeit implementiert werden:

1. Einen Nutzer zu registrieren
2. Sich anzumelden

Verwenden Sie diesen Code als Orientierung:

```java
boolean exit = false;
while (!exit) {
    System.out.println("Enter 1 to register or 2 to login or 0 to end");
    String selection = scanner.nextLine();
    String username;
    String password;
    switch (selection) {
        case "1":
            System.out.println("Please enter your username: ");
            username = scanner.nextLine();
            System.out.println("Please enter your password: ");
            password = scanner.nextLine();
            try {
                // Hier Code einfügen
            } catch (RegistrationException e) {
                // Hier Code einfügen
            }
            break;
        // Hier Code einfügen
    }
}
```

---

*Zuletzt geändert: Dienstag, 31. März 2026, 23:12*

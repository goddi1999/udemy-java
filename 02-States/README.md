# 02 - States

## Aufgabe

Implementieren Sie den Code für einen einfachen Roboter und ermöglichen Sie Nutzern, mit ihm zu interagieren. Das Ziel ist es in einer vorgegebenen Menge von Schritten so viele Punkte wie möglich zu erreichen (Reward).

## Struktur

Die Anwendung besteht aus zwei zentralen Klassen:

1. **Robot:** Enthält die Logik des Roboters
2. **App:** Steuert die Interaktion mit dem Roboter

Der Roboter kann sich in einem von drei Zuständen befinden:

- HIGH
- LOW
- EMPTY

Diese Zustände werden im Enum `State` definiert. Zusätzlich enthält `State` eine Methode `getNext()`, die den Zustand in der Reihenfolge HIGH → LOW → EMPTY verändert.

## Roboter-Attribute

Die Klasse `Robot` speichert folgende Eigenschaften:

- `State state` – aktueller Zustand des Roboters
- `int reward` – aktuelle Belohnung des Roboters
- `boolean asleep` – gibt an, ob der Roboter schläft

**Initialwerte:**

- state = HIGH
- reward = 0
- asleep = false

Getter-Methoden sollen den Zugriff auf diese Werte ermöglichen.

## Roboter-Aktionen

Der Roboter kann drei Aktionen ausführen:

### 1. idle()

- Der Roboter wartet und erhält dafür einen Reward von +1
- Gibt die Nachricht zurück: `"Idling successful, gained one reward, now in state [aktueller Zustand]"`

### 2. recharge()

- Falls der Roboter bereits in State HIGH ist, passiert nichts und eine entsprechende Nachricht wird zurückgegeben
- In allen anderen Fällen wird der Zustand auf HIGH gesetzt und ebenfalls eine Nachricht zurückgegeben

### 3. work()

- Es wird eine zufällige Zahl ermittelt: `double randomNum = Math.random();` (Wert zwischen 0 und 1)
- Mit 60 % Wahrscheinlichkeit wechselt der Roboter in den nächsten Zustand (getNext() von State)
- Anschließend wird der Zustand geprüft:
  - **Falls EMPTY:**
    - `asleep = true`
    - `reward -= 5`
    - Rückgabe einer Nachricht
  - **Andernfalls:**
    - `reward += 3`
    - Rückgabe einer Nachricht

## Interaktion über die App-Klasse

In der App-Klasse wird der Roboter gesteuert:

1. Ein Robot-Objekt wird erstellt
2. Eine Variable `availableSteps` wird definiert (z. B. 10 Schritte)
3. Ein Scanner wird geöffnet, um Nutzereingaben entgegenzunehmen
4. Solange `availableSteps > 0`, kann der Nutzer eine Aktion auswählen:
   - idle
   - work
   - recharge
   - Wird ein ungültiger Befehl eingegeben kann eine Nachricht zurückgegeben werden, ansonsten passiert nichts
5. Für jede korrekte Aktion wird `availableSteps` um 1 reduziert
6. Nach jedem Schritt wird geprüft, ob der Roboter `asleep` ist. Falls ja, wird `availableSteps = 0`
7. Nach jeder Iteration werden folgende Werte ausgegeben:
   - Verbleibende Schritte
   - Aktueller Reward
8. Am Ende wird der finale Reward ausgegeben und der Scanner geschlossen

**Tipp:**

```java
while (availableSteps > 0) {
    System.out.println("What should the robot do? (idle/recharge/work)");
    String input = scanner.nextLine();
    if (input.equals("idle")) {
        availableSteps--;
        System.out.println(robot.idle());
    }
    // Your code
}
```

---

*Zuletzt geändert: Mittwoch, 25. März 2026, 09:27*

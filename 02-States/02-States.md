# 02 - States (Roboter)

## Ziel
Roboter mit Ladezustaenden steuern und in begrenzten Schritten maximalen Reward erreichen.

## Typen
- enum State { HIGH, LOW, EMPTY } mit State getNext() (HIGH -> LOW -> EMPTY)
- Robot — Logik des Roboters
- App   — Interaktion (Scanner, Schritt-Schleife)

## Contracts (Signaturen)
State:
- State getNext()

Robot (Felder: state=HIGH, reward=0, asleep=false):
- State getState() / int getReward() / boolean isAsleep()
- String idle()      // reward +1
- String recharge()  // -> HIGH (falls schon HIGH: nichts)
- String work()      // 60% getNext(); EMPTY -> asleep=true, reward-5; sonst reward+3

## Regeln
- work(): double r = Math.random(); (0..1), mit 60% Wahrscheinlichkeit Zustandswechsel.
- App: availableSteps (z. B. 10); pro gueltiger Aktion -1; wenn asleep -> availableSteps=0.

## Build / Run
- ./gradlew run   (build.gradle: run { standardInput = System.in })

## Beispiel-Ablauf
    What should the robot do? (idle/recharge/work)
    > idle
    Idling successful, gained one reward, now in state HIGH
    Steps left: 9 | Reward: 1

## Konzepte
Enums, Zustandsuebergaenge, Math.random, Kontrollfluss.

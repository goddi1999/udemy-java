# 03 - Exceptions (Nutzerverwaltung)

## Ziel
Nutzer registrieren und anmelden, mit eigener Fehlerbehandlung.

## Klassen
- User — username, password, attempts (Start: 3)
- AuthenticationManager — Liste von Usern, register + login
- Exceptions: RegistrationException, LoginException (checked), AccountLockedException (RuntimeException)
- App — Menue (Scanner)

## Contracts (Signaturen)
User:
- User(String username, String password)
- String getUsername() / String getPassword() / int getAttempts()
- void updateAttempts()  // -1
- void resetAttempts()   // = 3

AuthenticationManager:
- void registerUser(String username, String password) throws RegistrationException
      // Name existiert -> RegistrationException
- void login(String username, String password) throws LoginException
      // falsches Passwort / kein User -> LoginException (+ attempts -1)
      // erfolgreich -> attempts reset
      // keine Versuche mehr -> AccountLockedException (runtime)

## Build / Run
- ./gradlew run

## Konzepte
Eigene Exceptions, checked vs. unchecked (RuntimeException), try/catch.

# AGENTS.md — 03 Exceptions

## Ueberblick
Gradle-Konsolenprojekt. Nutzerverwaltung mit selbst definierten Exceptions.

## Struktur
- app/src/main/java/de/rt/fp/auth/User.java
- app/src/main/java/de/rt/fp/auth/AuthenticationManager.java
- app/src/main/java/de/rt/fp/auth/RegistrationException.java
- app/src/main/java/de/rt/fp/auth/LoginException.java
- app/src/main/java/de/rt/fp/auth/AccountLockedException.java
- app/src/main/java/de/rt/fp/auth/App.java

## Tech-Stack
- Java 21, Gradle, Scanner (System.in)

## Konventionen
- Package: de.rt.fp.auth
- RegistrationException / LoginException extends Exception (checked)
- AccountLockedException extends RuntimeException (unchecked)

## Tutor-Hinweis
Ask-Mode = Hinweise statt Loesung (siehe .github/copilot-instructions.md).

# Mini-Social-Media-Plattform

## Ziel
Single-User-Prototyp (aehnlich Twitter/X) mit JavaFX + MVVM.
Genau EIN Post: erstellen, bearbeiten, loeschen, liken, Bild anhaengen.
Beliebig viele Kommentare zu diesem Post. Persistenz in einer Textdatei.

## Klassen (Model — ohne JavaFX-Imports)
- Post     — Text, Like-Zaehler, List<Comment>, optionaler Bildpfad
- Comment  — Text + Zeitstempel

## Contracts (Signaturen)
Post:
- Post(String text)                                 // 0 Likes, leere Kommentarliste
- String getText()  /  void setText(String text)    // nicht leer, max. 280
- int getLikeCount()
- void like()                                        // +1, nie negativ
- List<Comment> getComments()
- void addComment(Comment c)
- void removeComment(Comment c)
- String getImagePath()  /  void setImagePath(String path)   // null = kein Bild

Comment:
- Comment(String text)                               // nicht leer, max. 280
- String getText()
- LocalDateTime getTimestamp()

## UI (FXML, TabPane)
- Tab "Feed"     — Post anlegen/bearbeiten/loeschen/liken, Bild, Kommentar-Eingabe
- Tab "Comments" — alle Kommentare chronologisch (aelteste oben) + Loeschen

## Regeln
- Text nie leer, max. 280 Zeichen (Post UND Kommentar)
- Like-Zaehler startet bei 0, nie negativ
- Ohne Post: Bearbeiten/Loeschen/Kommentieren/Liken deaktiviert
- Post loeschen → alle Kommentare mit geloescht (Kaskade)
- Fehler → verstaendliche Meldung in der UI, kein Absturz

## Dateiformat (Persistenz, selbst gewaehlt)
Zeilenbasiert, menschenlesbar:
    <Post-Text>|<Likes>|<Bildpfad>
    <Kommentar 1>
    <Kommentar 2>
- Zeile 1 = Post; Felder mit | getrennt (Bildpfad leer = kein Bild).
- Danach je Zeile ein Kommentar.
- Leere Datei = kein Post.
- Zeilenumbrueche im Text werden beim Speichern durch Leerzeichen ersetzt.

## Build / Run
- ./gradlew run                       # App starten
- ./gradlew test jacocoTestReport     # Tests + Coverage (~80% Model)
- ./gradlew jar                       # startbare JAR

## Konzepte
Klassen & Kapselung, List<Comment>, MVVM, FileChooser, ImageView, Exceptions.
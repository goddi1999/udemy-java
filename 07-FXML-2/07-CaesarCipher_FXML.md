# 07 - CaesarCipher FXML

## Aufgabe

In dieser Aufgabe geht es darum, eine FXML-Anwendung zu erstellen, die den klassischen Caesar-Verschlüsselungsalgorithmus implementiert.

Der Caesar-Verschlüsselungsalgorithmus verschiebt jeden Buchstaben eines Klartexts um eine festgelegte Anzahl von Positionen im Alphabet.

In der Anwendung können Benutzer Text eingeben und den Verschlüsselungsschlüssel anpassen, um den Text zu verschlüsseln oder entschlüsseln.

## a) Erstellen einer minimalen FXML App

Hierfür können Sie sich an Aufgabe 6 - FXML 1 orientieren.

## b) Erstellen der FXML-Datei

Erstellen Sie eine Datei `CaesarCipher.fxml` in `resources/fxml`. Bearbeiten Sie mithilfe des Scene-Builders die Datei in `resources/fxml`. Diese soll das Benutzerinterface der Anwendung definieren.

Das Interface sollte aus folgenden Elementen bestehen:

- Label 'Key'
- Slider zum Einstellen des Schlüssels
- Textfeld für Klartext / verschlüsselten Text
- Button zum Verschlüsseln
- Button zum Entschlüsseln
- Button zum Zurücksetzen
- Label, welches entweder den verschlüsselten / entschlüsselten Text oder einen Fehler anzeigt

Verwenden Sie VBox und HBox zur Positionierung der Elemente. Achten Sie darauf, den Elementen sinnvolle Namen zu geben, die später im Code verwendet werden können.

## c) Einbinden des Models

Das Modell für die Anwendung wurde bereits für Sie erstellt. Erstellen Sie eine neue Klasse `CaesarCipherModel` und fügen Sie den folgenden Code dort ein. Nehmen Sie sich kurz Zeit, um das Modell zu verstehen.

Erstellen Sie auch die benötigte `CaesarCipherException`.

```java
public class CaesarCipherModel {
    public String cipher(String inputString, int key) throws CaesarCipherException {
        if (inputString.isEmpty()) {
            throw new CaesarCipherException("Input string is empty");
        }
        if (key < 1 || key > 26) {
            throw new CaesarCipherException("Invalid key");
        }
        StringBuilder encryptedString = new StringBuilder();
        for (char c : inputString.toCharArray()) {
            if (c < 'a' || c > 'z') {
                throw new CaesarCipherException("Illegal character in string");
            }
            char shifted = (char) ('a' + (c - 'a' + key) % 26);
            encryptedString.append(shifted);
        }
        return encryptedString.toString();
    }
}
```

## d) Implementierung der CaesarCipherViewModel-Klasse

Ergänzen Sie die Anwendung um die Klasse `CaesarCipherViewModel`, die folgende Aufgaben übernimmt:

### Textverschlüsselung

Implementieren Sie eine Methode, die den Text im Textfeld verschlüsselt und den verschlüsselten Text im entsprechenden Label darstellt.

### Textentschlüsselung

Implementieren Sie eine Methode, die den Text im Textfeld entschlüsselt und den entschlüsselten Text im entsprechenden Label darstellt.

### Fehlerbehandlung

Wenn beim Aufrufen der Methode `cipher()` eine Exception auftritt, fangen Sie diese ab und zeigen Sie die Fehlermeldung im Label entsprechend an (in rot).

**Hinweis:** Zum Verschlüsseln und Entschlüsseln kann dieselbe Methode im Modell verwendet werden. Wie müssen Sie den Aufruf dazu anpassen?

**Hinweis:** Um den Schlüsselwert vom Slider zu erhalten, kann folgender Methodenaufruf verwendet werden (bei einem Slider mit der ID `keySlider`):

```java
keySlider.valueProperty().getValue();
```

## e) Implementierung der Logik des Clear-Buttons

Implementieren Sie die Logik für den Clear-Button. Wenn der Button geklickt wird, soll:

- Das Textfeld geleert werden
- Das Message Label unsichtbar gemacht werden
- Der Slider auf die Position 1 zurückgesetzt werden

---

*Zuletzt geändert: Mittwoch, 6. Mai 2026, 07:55*

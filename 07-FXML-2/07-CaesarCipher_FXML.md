# 07 - CaesarCipher FXML

## Ziel
JavaFX-App, die Text per Caesar-Verschiebung ver- und entschluesselt.

## Klassen / Dateien
- App extends Application
- CaesarCipherModel — cipher(input, key)
- CaesarCipherViewModel — Controller (Slider, TextField, Buttons, Message-Label)
- CaesarCipherException
- resources/fxml/CaesarCipher.fxml

## FXML-Elemente
- Label "Key", Slider (fx:id keySlider), TextField (Klartext/Cipher)
- Buttons: verschluesseln, entschluesseln, clear
- Message-Label (zeigt Ergebnis ODER Fehler in rot)

## Contracts (Signaturen)
CaesarCipherModel:
- String cipher(String inputString, int key) throws CaesarCipherException
      // key 1..26, nur 'a'..'z', leerer Input -> Exception
- Entschluesseln nutzt dieselbe cipher-Methode mit transformiertem Key.

## FXML-Konventionen
- fx:controller="de.rt.fp.caesar.CaesarCipherViewModel"
- Slider-Wert: keySlider.valueProperty().getValue()
- Clear: TextField leeren, Message-Label unsichtbar, Slider auf 1

## Run
- ./gradlew run

## Konzepte
JavaFX, Slider-Wert, Fehleranzeige, Wiederverwendung des Algorithmus.

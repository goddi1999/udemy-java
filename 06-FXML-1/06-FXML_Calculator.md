# 06 - FXML Calculator

## Ziel

Das Ziel dieser Aufgabe ist das Erstellen eines einfachen Taschenrechners. Der Taschenrechner soll zwei Zahlen (Integer) addieren, subtrahieren, multiplizieren und dividieren können. Dazu sollen nur FXML Buttons und Labels erstellt werden.

Die Anwendung beinhaltet bereits eine laufende FXML Anwendung und alle benötigten Klassen.

## a) Minimale Anwendung erstellen und lauffähig machen

Bevor Sie damit beginnen die Anforderungen der Aufgabe zu bearbeiten sollten Sie ein Minimalbeispiel zum laufen bekommen.

Folgende Schritte sind hierfür notwendig:

1. Hinzufügen von id `'org.openjfx.javafxplugin'` version `'0.1.0'` in plugins in build.gradle

2. Hinzufügen der JavaFX Konfiguration in build.gradle unterhalb der plugins:

```gradle
javafx {
    version = '25'
    modules = [ 'javafx.controls', 'javafx.fxml' ]
}
```

3. Bevor Sie fortfahren, laden Sie das gradle-Projekt neu (Schaltfläche bei Änderung von build.gradle) und warten Sie bis die JavaFX Pakete in JAVA PROJECTS-app-Referenced Libraries sichtbar sind.

4. Ändern Sie außerdem den Eintrag in der Datei gradle.properties wie folgt:

```properties
org.gradle.configuration-cache=false
```

5. Erstellen einer FXML Datei `SimpleCalculator.fxml` in `resources/fxml`

6. Erstellen einer Pane mit einem Button in `SimpleCalculator.fxml`

7. Erstellen der App-Klasse:

```java
public class App extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/SimpleCalculator.fxml"));
        primaryStage.setTitle("Simple Calculator");
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
```

## b) Bearbeiten der FXML Datei

Öffnen Sie die Datei `SimpleCalculator.fxml` im SceneBuilder und fügen Sie die benötigten Elemente hinzu. Benötigt werden:

- Label für die erste Zahl
- Links davon ein Button -
- Rechts davon ein Button +
- Label für die zweite Zahl
- Links davon ein Button -
- Rechts davon ein Button +
- Buttons für Addieren, Subtrahieren, Multiplizieren und Dividieren
- Ein Label für das Ergebnis

## c) Erstellen des Models

In `SimpleCalculatorModel.java` definieren Sie die Datenfelder `first` und `second`.

- Schreiben Sie einen Konstruktor, der die beiden Werte auf 0 initialisiert
- Schreiben Sie die benötigten Methoden:
  - Erhöhen und Reduzieren von `first`
  - Erhöhen und Reduzieren von `second`
  - Addieren, Subtrahieren, Multiplizieren, Dividieren (Achtung - `SimpleCalculatorException` bei Division durch 0; Integer oder Floating Point Division sind erlaubt)

## d) Verbinden des Models und der View

### Erstellen der SimpleCalculatorViewModel-Klasse

In dieser die EventHandler der Buttons programmiert werden. Des Weiteren brauchen Sie die Labels der UI als Attribute (`@FXML`).

In `SimpleCalculatorViewModel.java` verbinden Sie die View und das Model:

- Erstellen Sie hierzu Referenzen zu allen Labels und Handler für die Buttons
- **Wichtig:** Vergessen Sie nicht den Controller im SceneBuilder anzugeben

### Implementierung der initialize Methode

Schreiben Sie eine `initialize` Methode in der:

- Ein Modell erstellt wird
- Die Labels `first` und `second` mit "0" initialisiert werden
- `result` mit "-" initialisiert wird

### Schreiben der Button Handler

Schreiben Sie für jeden der Buttons einen Handler. Für jeden Handler stellen Sie sich die Fragen:

- Welche Daten oder Aktionen benötigen Sie vom Model?
- Was müssen Sie in der View anpassen?

---

*Zuletzt geändert: Mittwoch, 29. April 2026, 13:46*

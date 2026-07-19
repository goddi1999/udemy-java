# 06 - FXML Calculator

## Ziel
JavaFX-Taschenrechner (Integer +, -, *, /) ueber FXML, Buttons und Labels.

## Klassen / Dateien
- App extends Application  (laedt /fxml/SimpleCalculator.fxml)
- SimpleCalculatorModel — Rechenlogik (Felder first, second)
- SimpleCalculatorViewModel — Controller (Labels + Button-Handler)
- SimpleCalculatorException — bei Division durch 0
- resources/fxml/SimpleCalculator.fxml

## build.gradle
- plugins: id 'org.openjfx.javafxplugin' version '0.1.0'
- javafx { version = '21'; modules = ['javafx.controls','javafx.fxml'] }

## Contracts (Signaturen)
SimpleCalculatorModel:
- SimpleCalculatorModel()   // first=0, second=0
- void incFirst() / void decFirst() / void incSecond() / void decSecond()
- int add() / int subtract() / int multiply()
- int divide() throws SimpleCalculatorException   // /0 -> Exception

## FXML-Konventionen
- fx:controller="de.rt.fp.calculator.SimpleCalculatorViewModel"
- fx:id im FXML = Feldname im Controller (z. B. firstLabel, secondLabel, resultLabel)
- Handler via onAction="#onAdd" etc.

## Run
- ./gradlew run

## Konzepte
JavaFX MVVM, FXML-Verdrahtung, onAction-Handler, Exception in der UI.

package org.example;

public class Person {

  private String name;
  private String vorname;


  public Person(String name, String vorname){
    this.name = name;
    this.vorname = vorname;
  }

@Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (name == null ? 0 : name.hashCode());
    result = 31 * result + (vorname == null ? 0 : vorname.hashCode());
    return result;
}


@Override
public boolean equals(Object obj) {

    // Schritt 1: Bin ich dasselbe Objekt wie obj?
    // "this == obj" vergleicht Speicheradressen (Referenzen)
    // Wenn ja → sofort true zurück, kein weiterer Vergleich nötig
    if (this == obj) return true;

    // Schritt 2: Ist obj null oder keine Person?
    // instanceof gibt false zurück wenn:
    //   - obj == null
    //   - obj nicht vom Typ Person (oder Unterklasse) ist
    // In beiden Fällen kann es nicht gleich sein → false
    if (!(obj instanceof Person)) return false;

    // Schritt 3: Casten – jetzt wissen wir sicher: obj ist eine Person
    // Ohne Cast können wir nicht auf .name oder .vorname zugreifen
    Person other = (Person) obj;

    // Schritt 4: Fachlicher Vergleich der Felder
    // name-Feld: null-sicher vergleichen
    if (name == null) {
        if (other.name != null) return false; // this.name=null, other.name!=null → ungleich
    } else if (!name.equals(other.name)) {
        return false; // beide nicht null, aber verschiedene Werte → ungleich
    }

    // vorname-Feld: gleiche null-sichere Logik
    if (vorname == null) {
        if (other.vorname != null) return false;
    } else if (!vorname.equals(other.vorname)) {
        return false;
    }

    // Schritt 5: Alle Felder sind gleich → Objekte sind inhaltlich gleich
    return true;
}

  



// Standardmäßig implementiert
// @Override
// public boolean equals(Object obj) {
//     return this == obj; // Referenzvergleich 
    
// }
    
}
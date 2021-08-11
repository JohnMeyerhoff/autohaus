package parkhaus.tests;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class BasicTest {
    /*
    Vorgehen:#
    Neuen Test (Methode) anlegen
    Erwartungswert ermitteln
        - Erwartungs-Output (expected) für spezifischen Input
    Programm / Methodenaufruf durchführen
        - Welche Methode wird aufgerufen
    Gespeichertes Ergebnis und Erwartungswert vergleichen (assertEquals)
        - Wie erhalte ich mein Ergebnis, wie berechnet sich mein Erwartungswert
    */


    //Fallbeispiel exceptionForPos(): Wird beim Zugriff mit get auf eine nicht vorhandene Position in
//einem nicht-leeren Puffer die richtige Exception geworfen?
/*
    Vorgehen:#
    Neuen Test (Methode) anlegen 
    Grundvoraussetzungen herstellen
    Erwartungswert ermitteln
        - Erwartungs-Output (expected) für spezifischen Input
    Programm / Methodenaufruf durchführen
        - Welche Methode wird aufgerufen
    Gespeichertes Ergebnis und Erwartungswert vergleichen (assertEquals)
        - Wie erhalte ich mein Ergebnis, wie berechnet sich mein Erwartungswert
    */

    @Test
    void exceptionForPos(){

        //neuen Puffer a erstellen
        //elemente einfügen

        assertThrows(NullPointerException.class, a.get(0));
        assertThrows(NullPointerException.class, a.get(25));
    }

}

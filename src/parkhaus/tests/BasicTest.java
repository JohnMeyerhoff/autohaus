package parkhaus.tests;

import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import parkhaus.Auto;
import parkhaus.Fahrzeug;
import parkhaus.Parkdeck;
import parkhaus.Parkhaus;
import parkhaus.Parkplatz;
import parkhaus.Zweirad;

public class BasicTest {
    Parkdeck<Fahrzeug> pd01;
    Parkdeck<Fahrzeug> pd02;
    Parkdeck<Fahrzeug> pd03;
    Parkdeck<Fahrzeug>[] haus;
    Parkhaus<Fahrzeug> ph01;

    @BeforeEach
    void before() {
        pd01 = new Parkdeck<>(); // je 30 plätze
        pd02 = new Parkdeck<>();
        pd03 = new Parkdeck<>();
        haus = (Parkdeck<Fahrzeug>[]) new Parkdeck[3];
        haus[0] = pd01;
        haus[1] = pd02;
        haus[2] = pd03;
        ph01 = new Parkhaus<>(haus);
    }

    @AfterEach
    void after() {
        ph01 = null;
    }
    /*
     * Vorgehen:# Neuen Test (Methode) anlegen Brauche ich weitere imports? Habe ich
     * eine Boilerplate, oder kann ich sie aus anderen Tests übernehmen? Kann ich
     * "Scaffolding" aus anderen Tests übernehmen? Erwartungswert ermitteln -
     * Erwartungs-Output (expected) für spezifischen Input Programm / Methodenaufruf
     * durchführen - Welche Methode wird aufgerufen Gespeichertes Ergebnis und
     * Erwartungswert vergleichen (assertEquals) - Wie erhalte ich mein Ergebnis,
     * wie berechnet sich mein Erwartungswert Habe ich eine Assertion, welche die
     * Frage Beantwortet
     */

    /*
     * Vorgehen:# Neuen Test (Methode) anlegen Brauche ich weitere imports? Habe ich
     * eine Boilerplate, oder kann ich sie aus anderen Tests übernehmen? Kann ich
     * "Scaffolding" aus anderen Tests übernehmen? Erwartungswert ermitteln -
     * Erwartungs-Output (expected) für spezifischen Input - Output null, für ein
     * nicht existierendes Parkdeck Programm / Methodenaufruf durchführen - Welche
     * Methode wird aufgerufen: ausparken() Gespeichertes Ergebnis ph01.ausparken(4,
     * 1) und Erwartungswert: null vergleichen (assertEquals) - Wie erhalte ich mein
     * Ergebnis, wie berechnet sich mein Erwartungswert
     */
    // nullForHigherDeck(): Wird beim versuch ein Fahrzeug aus einem Parkdeck
    // auszuparken welches nicht existiert null zurückgegeben?

    @Test
    void nullForHigherDeck() {
        assertEquals(null, ph01.ausparken(4, 1));

    }

    /*
     * Vorgehen:# Neuen Test (Methode) anlegen Brauche ich weitere imports? Habe ich
     * eine Boilerplate, oder kann ich sie aus anderen Tests übernehmen? Kann ich
     * "Scaffolding" aus anderen Tests übernehmen? Erwartungswert ermitteln -
     * Erwartungs-Output (expected) für spezifischen Input Programm / Methodenaufruf
     * durchführen - Welche Methode wird aufgerufen Gespeichertes Ergebnis und
     * Erwartungswert vergleichen (assertEquals) - Wie erhalte ich mein Ergebnis,
     * wie berechnet sich mein Erwartungswert
     */
    // nullForNotInsideFlaeche(): Wird beim versuch ein Fahrzeug aus einem Parkplatz
    // auszuparken welcher nicht existiert null zurückgegeben? Testen Sie dies mit
    // 10 Parkplätzen
    @Test
    void nullForNotInsideFlaeche() {
        assertEquals(null, ph01.ausparken(2, 36));
        assertEquals(null, ph01.ausparken(2, 37));
        assertEquals(null, ph01.ausparken(2, 39));
        assertEquals(null, ph01.ausparken(2, 40));
        assertEquals(null, ph01.ausparken(2, 45));
        assertEquals(null, ph01.ausparken(2, 31));
        assertEquals(null, ph01.ausparken(2, 33));
        assertEquals(null, ph01.ausparken(2, 32));
        assertEquals(null, ph01.ausparken(2, 34));
        assertEquals(null, ph01.ausparken(2, 35));
        assertEquals(null, ph01.ausparken(2, 41));
    }

    /*
     * testKennzeichenPersistenz(): Testen sie ob das Kennzeichen welches dem Auto
     * im Konstruktor gegeben wird auch das Kennzeichen des Autos ist wenn es
     * abgefragt wird.
     * 
     * Vorgehen:# Neuen Test (Methode) anlegen Brauche ich weitere imports? Habe ich
     * eine Boilerplate, oder kann ich sie aus anderen Tests übernehmen? Kann ich
     * "Scaffolding" aus anderen Tests übernehmen? Erwartungswert ermitteln -
     * Erwartungs-Output (expected) für spezifischen Input Programm / Methodenaufruf
     * durchführen - Welche Methode wird aufgerufen Gespeichertes Ergebnis und
     * Erwartungswert vergleichen (assertEquals) - Wie erhalte ich mein Ergebnis,
     * wie berechnet sich mein Erwartungswert
     * 
     * Habe ich eine Assertion, welche die Frage Beantwortet
     */
    /**
     * Dieser Test testet das Verhalten der Klasse Auto Der Test prüft, ob sich das
     * Kennzeichen wie erwartet Verhält und gleich bleibt.
     */
    @Test
    public void testKennzeichenPersistenz() {
        Auto blauerOpel = new Auto("BN FN 2");
        Auto gruenerOpel = new Auto("BN FN 2");
        Assertions.assertEquals("BN FN 2", blauerOpel.getKennzeichen());
        Assertions.assertEquals("BN FN 2", blauerOpel.toString());// "ergebnis" in return-Wert "gespeichert"
        Assertions.assertEquals(0, blauerOpel.compareTo(gruenerOpel));
        // Der letzte test prüft, ob Gleichheit besteht wenn mit dem kennzeichen
        // verglichen wird

        // Umformung
        final String actual = blauerOpel.toString();
        final String expected = "BN FN 2";
        Assertions.assertEquals(expected, actual);
    }

}

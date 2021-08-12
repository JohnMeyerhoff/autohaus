package parkhaus.tests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import parkhaus.Auto;
import parkhaus.Fahrzeug;
import parkhaus.Parkdeck;
import parkhaus.Parkplatz;

public class ParkdeckTest {
    /* testEinparken(): Testen Sie in einem Parkdeck ohne Parkhaus,
    ob das Ein-und Auspraken von 5 Fahrzeugen korrekt funktioniert.  
    Prüfen Sie nach jeder der 10 Operationen, ob die Fahrzeuge an den 
    korrekten Parkplätzen eingeparkt sind und ob das Parkdeck die 
    korrekte Anzahl an freien Parkplätzen meldet.

    */
    Parkdeck<Fahrzeug> pd01;
    Parkdeck<Fahrzeug> pd02;
    Parkdeck<Fahrzeug> pd03;
    Parkdeck<Fahrzeug>[] haus;
    @Test
    void testEinparken() {
        pd01 = new Parkdeck<>(); // je 30 plätze
        Auto b = new Auto("BN OP 1");
        Auto c = new Auto("BN OP 2");
        Auto d = new Auto("BN OP 3");
        Auto e = new Auto("BN OP 4");
        Auto f = new Auto("BN OP 5");
        pd01.einparken(b);
        assertEquals(0, pd01.fahrzeugSuche(b));
        assertEquals(-1, pd01.fahrzeugSuche(c));
        assertEquals(-1, pd01.fahrzeugSuche(d));
        assertEquals(-1, pd01.fahrzeugSuche(e));
        assertEquals(-1, pd01.fahrzeugSuche(f));
        pd01.einparken(c);
        assertEquals(0, pd01.fahrzeugSuche(b));
        assertEquals(1, pd01.fahrzeugSuche(c));
        assertEquals(-1, pd01.fahrzeugSuche(d));
        assertEquals(-1, pd01.fahrzeugSuche(e));
        assertEquals(-1, pd01.fahrzeugSuche(f));
        pd01.einparken(d);
        assertEquals(0, pd01.fahrzeugSuche(b));
        assertEquals(1, pd01.fahrzeugSuche(c));
        assertEquals(2, pd01.fahrzeugSuche(d));
        assertEquals(-1, pd01.fahrzeugSuche(e));
        assertEquals(-1, pd01.fahrzeugSuche(f));
        pd01.einparken(e);
        assertEquals(0, pd01.fahrzeugSuche(b));
        assertEquals(1, pd01.fahrzeugSuche(c));
        assertEquals(2, pd01.fahrzeugSuche(d));
        assertEquals(3, pd01.fahrzeugSuche(e));
        assertEquals(-1, pd01.fahrzeugSuche(f));
        pd01.einparken(f);
        assertEquals(0, pd01.fahrzeugSuche(b));
        assertEquals(1, pd01.fahrzeugSuche(c));
        assertEquals(2, pd01.fahrzeugSuche(d));
        assertEquals(3, pd01.fahrzeugSuche(e));
        assertEquals(4, pd01.fahrzeugSuche(f));

        assertEquals(5, pd01.anzahlBelegteParkplaetze());

        pd01.ausparken(4);
        assertEquals(true, pd01.kennzeichenSuche(b.getKennzeichen()));
        assertEquals(true, pd01.kennzeichenSuche(c.getKennzeichen()));
        assertEquals(true, pd01.kennzeichenSuche(d.getKennzeichen()));
        assertEquals(true, pd01.kennzeichenSuche(e.getKennzeichen()));
        assertEquals(false, pd01.kennzeichenSuche(f.getKennzeichen()));
        pd01.ausparken(3);
        assertEquals(true, pd01.kennzeichenSuche(b.getKennzeichen()));
        assertEquals(true, pd01.kennzeichenSuche(c.getKennzeichen()));
        assertEquals(true, pd01.kennzeichenSuche(d.getKennzeichen()));
        assertEquals(false, pd01.kennzeichenSuche(e.getKennzeichen()));
        assertEquals(false, pd01.kennzeichenSuche(f.getKennzeichen()));
        pd01.ausparken(2);
        assertEquals(true, pd01.kennzeichenSuche(b.getKennzeichen()));
        assertEquals(true, pd01.kennzeichenSuche(c.getKennzeichen()));
        assertEquals(false, pd01.kennzeichenSuche(d.getKennzeichen()));
        assertEquals(false, pd01.kennzeichenSuche(e.getKennzeichen()));
        assertEquals(false, pd01.kennzeichenSuche(f.getKennzeichen()));
        pd01.ausparken(1);
        assertEquals(true, pd01.kennzeichenSuche(b.getKennzeichen()));
        assertEquals(false, pd01.kennzeichenSuche(d.getKennzeichen()));
        assertEquals(false, pd01.kennzeichenSuche(e.getKennzeichen()));
        assertEquals(false, pd01.kennzeichenSuche(f.getKennzeichen()));
        assertEquals(false, pd01.kennzeichenSuche(c.getKennzeichen()));
        pd01.ausparken(0);
        assertEquals(false, pd01.kennzeichenSuche(b.getKennzeichen()));
        assertEquals(false, pd01.kennzeichenSuche(d.getKennzeichen()));
        assertEquals(false, pd01.kennzeichenSuche(e.getKennzeichen()));
        assertEquals(false, pd01.kennzeichenSuche(f.getKennzeichen()));
        assertEquals(false, pd01.kennzeichenSuche(c.getKennzeichen()));


        assertEquals(0, pd01.anzahlBelegteParkplaetze());
    }

    @Test
    void testFahrzeugSuche() {

    }

    @Test
    void testGetFreiePlaetze() {

    }

    @Test
    void testIterator() {

    }

    @Test
    void testKennzeichenSuche() {

    }

    @Test
    void testToString() {

    }
}

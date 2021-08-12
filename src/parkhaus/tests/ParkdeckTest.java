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
    Wenn bei einem Test dieser Art die Suchmethoden verwendet werden, kann es sein,
    dass die Musterlösung bzw. der korrekte Test fehlschlägt, obwohl der Test 
    korrekt geschrieben wurde.
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
        assertEquals(b, pd01.pPlatz(0));
        assertEquals(null, pd01.pPlatz(1));
        assertEquals(null, pd01.pPlatz(2));
        assertEquals(null, pd01.pPlatz(3));
        assertEquals(null, pd01.pPlatz(4));
        assertEquals("Freie Plaetze: " + 29, pd01.getFreiePlaetze());
        
        pd01.einparken(c); 
        assertEquals(b, pd01.pPlatz(0));
        assertEquals(c, pd01.pPlatz(1));
        assertEquals(null, pd01.pPlatz(2));
        assertEquals(null, pd01.pPlatz(3));
        assertEquals(null, pd01.pPlatz(4));
        assertEquals("Freie Plaetze: " + 28, pd01.getFreiePlaetze());

        pd01.einparken(d);
        assertEquals(b, pd01.pPlatz(0));
        assertEquals(c, pd01.pPlatz(1));
        assertEquals(d, pd01.pPlatz(2));
        assertEquals(null, pd01.pPlatz(3));
        assertEquals(null, pd01.pPlatz(4));
        assertEquals("Freie Plaetze: " + 27, pd01.getFreiePlaetze());

        pd01.einparken(e);
        assertEquals(b, pd01.pPlatz(0));
        assertEquals(c, pd01.pPlatz(1));
        assertEquals(d, pd01.pPlatz(2));
        assertEquals(e, pd01.pPlatz(3));
        assertEquals(null, pd01.pPlatz(4));
        assertEquals("Freie Plaetze: " + 26, pd01.getFreiePlaetze());

        pd01.einparken(f);
        assertEquals(b, pd01.pPlatz(0));
        assertEquals(c, pd01.pPlatz(1));
        assertEquals(d, pd01.pPlatz(2));
        assertEquals(e, pd01.pPlatz(3));
        assertEquals(f, pd01.pPlatz(4));
        assertEquals("Freie Plaetze: " + 25, pd01.getFreiePlaetze());

        pd01.ausparken(4);
        assertEquals(b, pd01.pPlatz(0));
        assertEquals(c, pd01.pPlatz(1));
        assertEquals(d, pd01.pPlatz(2));
        assertEquals(e, pd01.pPlatz(3));
        assertEquals(null, pd01.pPlatz(4));
        assertEquals("Freie Plaetze: " + 26, pd01.getFreiePlaetze());
        pd01.ausparken(2);
        assertEquals(b, pd01.pPlatz(0));
        assertEquals(c, pd01.pPlatz(1));
        assertEquals(null, pd01.pPlatz(2));
        assertEquals(e, pd01.pPlatz(3));
        assertEquals(null, pd01.pPlatz(4));
        assertEquals("Freie Plaetze: " + 27, pd01.getFreiePlaetze());
        pd01.ausparken(3);
        assertEquals(b, pd01.pPlatz(0));
        assertEquals(c, pd01.pPlatz(1));
        assertEquals(null, pd01.pPlatz(2));
        assertEquals(null, pd01.pPlatz(3));
        assertEquals(null, pd01.pPlatz(4));
        assertEquals("Freie Plaetze: " + 28, pd01.getFreiePlaetze());
        pd01.ausparken(1);
        assertEquals(b, pd01.pPlatz(0));
        assertEquals(null, pd01.pPlatz(1));
        assertEquals(null, pd01.pPlatz(2));
        assertEquals(null, pd01.pPlatz(3));
        assertEquals(null, pd01.pPlatz(4));
        assertEquals("Freie Plaetze: " + 29, pd01.getFreiePlaetze());
        pd01.ausparken(0);
        assertEquals(null, pd01.pPlatz(0));
        assertEquals(null, pd01.pPlatz(1));
        assertEquals(null, pd01.pPlatz(2));
        assertEquals(null, pd01.pPlatz(3));
        assertEquals(null, pd01.pPlatz(4));
        assertEquals("Freie Plaetze: " + 30, pd01.getFreiePlaetze());

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

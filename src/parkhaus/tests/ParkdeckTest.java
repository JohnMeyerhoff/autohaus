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
    /*
     * testEinparken(): Testen Sie in einem Parkdeck ohne Parkhaus, ob das Ein-und
     * Auspraken von 5 Fahrzeugen korrekt funktioniert. Prüfen Sie nach jeder der 10
     * Operationen, ob die Fahrzeuge an den korrekten Parkplätzen eingeparkt sind
     * und ob das Parkdeck die korrekte Anzahl an freien Parkplätzen meldet. Wenn
     * bei einem Test dieser Art die Suchmethoden verwendet werden, kann es sein,
     * dass die Musterlösung bzw. der korrekte Test fehlschlägt, obwohl der Test
     * korrekt geschrieben wurde.
     */
    Parkdeck<Fahrzeug> pd01;
    Parkdeck<Fahrzeug> pd02;
    Parkdeck<Fahrzeug> pd03;

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
        pd01 = new Parkdeck<>(); // je 30 plätze
        Auto b = new Auto("BN OP 1");
        Auto c = new Auto("BN OP 2");
        pd01.einparken(b);
        assertEquals(0, pd01.fahrzeugSuche(b));
        assertEquals(-1, pd01.fahrzeugSuche(c));
        pd01.einparken(b);
        pd01.einparken(b);
        pd01.einparken(b);
        pd01.einparken(b);
        pd01.einparken(b);
        pd01.einparken(c);

        pd01.ausparken(0);
        pd01.ausparken(1);
        pd01.ausparken(2);
        pd01.ausparken(3);
        pd01.ausparken(4);
        pd01.ausparken(5);

        assertEquals(true, pd01.kennzeichenSuche("BN OP 2"));
        assertEquals("Freie Plaetze: " + 29, pd01.getFreiePlaetze());
        assertEquals(6, pd01.fahrzeugSuche(c));
    }

    @Test
    void testGetFreiePlaetze() {
        pd01 = new Parkdeck<>(); // je 30 plätze
        Auto b = new Auto("BN OP 1");
        // falls kein PArkplatz besetzt ist
        assertEquals("Freie Plaetze: " + 30, pd01.getFreiePlaetze());
        pd01.einparken(b);
        //1 Parkplatz besetzt
        assertEquals("Freie Plaetze: " + 29, pd01.getFreiePlaetze());
        for(int i = 0; i < 29; i++){ //besetzt alle Parkplätze besetzt 
            pd01.einparken(b);
        }
        assertEquals("Freie Plaetze: " + 0, pd01.getFreiePlaetze());
        pd01.einparken(b);
        //EIn auto wird mehr eingeparkt als Kapazität 30
        assertEquals("Freie Plaetze: " + 0, pd01.getFreiePlaetze());
    }

    @Test
    void testIterator() {
        int i = 0;
        pd01 = new Parkdeck<>(); // je 30 plätze
        for (Parkplatz<Fahrzeug> p : pd01) {
            i++;
        }
        assertEquals(30, i);

    }
    // ziel für morgen ist es die suche bzw eine der suchen lückenfreundlich zu
    // gestalten so dass leere parkplätze nicht anfangen zu brennen
    // bei suche beheben schauen ob der Parkplatz null ist bevor wir uns das
    // belegtdurch ansehen, dann schauen ob belegtdurch null ist bevor wir uns
    // belegtdurch.kennzeichen ansehen

    @Test
    void testKennzeichenSuche() {
        pd01 = new Parkdeck<>(); // je 30 plätze
        Auto b = new Auto("BN OP 1");
        pd01.einparken(b);
        assertEquals(true, pd01.kennzeichenSuche("BN OP 1"));
        pd01.ausparken(0);
        assertEquals(false, pd01.kennzeichenSuche("BN OP 1"));
        assertEquals(true, pd01.kennzeichenSuche("BN OP 2"));

    }

    @Test
    void testToString() {
        pd01 = new Parkdeck<>(); // je 30 plätze
        Auto b = new Auto("BN OP 1");
        Auto c = new Auto("BN OP 2");
        Auto d = new Auto("BN OP 3");
        pd01.einparken(b);
        pd01.einparken(c);
        pd01.einparken(d);
        assertEquals("", pd01.toString());
    }

    /*
     * Dieser Test testet das Verhalten des Parkdecks wenn: - 3 Autos eingeparkt
     * werden - das mittlere dieser 3 autos ausgeparkt wird - ein neues Auto
     * eingeparkt wird die Erwartung ist, dass sich alle 3 Autos auf dem Parkdeck
     * befinden mit folgender Platzierung: (Auto 1) (?) (Auto 3)(?) Welches
     * Fragezeichen nimmt Auto 4?
     */
    @Test

    void testAusparken() {
        pd01 = new Parkdeck<>(); // je 30 plätze
        Auto b = new Auto("BN OP 1");
        Auto c = new Auto("BN OP 2");
        Auto d = new Auto("BN OP 3");
        Auto e = new Auto("BN OP 4");
        pd01.einparken(b);
        pd01.einparken(c);
        pd01.einparken(d);
        pd01.ausparken(1);
        pd01.einparken(e);
        assertEquals(b, pd01.pPlatz(0));
        assertEquals(e, pd01.pPlatz(1));
        assertEquals(d, pd01.pPlatz(2));
        assertEquals(null, pd01.pPlatz(3));
    }

    @Test
    void testPPlatz() {
        pd01 = new Parkdeck<>(); // je 30 plätze
        Auto b = new Auto("BN OP 1");
        Auto c = new Auto("BN OP 2");
        pd01.einparken(b);
        assertEquals(b, pd01.pPlatz(0));
        assertEquals(null, pd01.pPlatz(1));

        pd01.einparken(c);
        assertEquals(b, pd01.pPlatz(0));
        assertEquals(c, pd01.pPlatz(1));

        pd01.ausparken(0);
        pd01.ausparken(1);

        for (int i = 0; i < 1; i++) {
            assertEquals(null, pd01.pPlatz(i));
        }

    }
}

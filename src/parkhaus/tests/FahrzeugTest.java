package parkhaus.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import parkhaus.Auto;
import parkhaus.Zweirad;
import parkhaus.Fahrzeug;

public class FahrzeugTest {
   
    Auto b;
    Auto c;
    Auto e;
    Zweirad d;
    Fahrzeug w;
    Fahrzeug l;

    @BeforeEach
    void before(){
        b = new Auto("BN OP 1");
        d = new Zweirad("BN OP 3");
        w = new Fahrzeug("BN OP 4");
        l = new Fahrzeug("BN OP 3");
        e = new Auto("BN OP 1", true);
    }
    
    /*      
     * testCompareTo(): Stellen sie sicher, dass mehrere Fahrzeuge durch den
     * compareTo Aufruf gleich oder ungleich sind, je nach kennzeichen, unabhängig
     * von ihrer Klasse. verwenden sie ein Zweirad, ein Auto und zwei Fahrzeuge,
     * vergleichen sie diese untereinander.
     */
    @Test
    void testCompareTo() {
        assertEquals(true, (b.compareTo(b) == 0));
        assertEquals(true, (b.compareTo(d) < 0));
        assertEquals(true, (b.compareTo(w) < 0));
        assertEquals(true, (b.compareTo(l) < 0));

        assertEquals(true, (d.compareTo(b) > 0));
        assertEquals(true, (d.compareTo(d) == 0));
        assertEquals(true, (d.compareTo(w) < 0));
        assertEquals(true, (d.compareTo(l) == 0));

        assertEquals(true, (w.compareTo(b) > 0));
        assertEquals(true, (w.compareTo(d) > 0));
        assertEquals(true, (w.compareTo(w) == 0));
        assertEquals(true, (w.compareTo(l) > 0));

        assertEquals(true, (l.compareTo(b) > 0));
        assertEquals(true, (l.compareTo(d) == 0));
        assertEquals(true, (l.compareTo(w) < 0));
        assertEquals(true, (l.compareTo(l) == 0));
    }

    @Test
    void testHatBehindertenAusweis() {
        assertEquals(true, e.hatBehindertenAusweis()); //Auto
        assertEquals(false, d.hatBehindertenAusweis());// Zweirad
        assertEquals(false, l.hatBehindertenAusweis()); //Fahrzeug
    }
    @Test
    void testGetKennzeichen() {
        assertEquals("BN OP 1", b.getKennzeichen());//auto
        assertEquals("BN OP 3", d.getKennzeichen());//zweirad
        assertEquals("BN OP 4", w.getKennzeichen());//fahrzeug
    }

    @Test
    void testToString() {
        assertEquals("BN OP 4", w.toString());
        assertEquals("BN OP 1", b.toString());// auto
        assertEquals("BN OP 3", d.toString());// zweirad
    }
}

package parkhaus.tests;

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

@SuppressWarnings("unchecked")

public class ParkhausTest {
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
    // Das fahrzeug nimmt einen Platz ein, wir haben 90 plätze. 80 sollte passen.
    // Generieren sie mit eienr schelife 80 autos die sie einparken. Gebe denen
    // kein Varialennamen.

    @Test
    public void einfach() {
        int a = 0;
        for (Parkplatz neuer : pd01) {
            Auto parker = new Auto("MS 03 " + a);
            neuer.einparken(parker);
        }
        for (int i = 0; i < pd01.getSize(); i++) {
            Assertions.assertEquals(true, ph01.istEingeparkt(new Auto(("MS 03 " + i))));
        }
    }

    @Test
    void achzigAutos() {
        for (int i = 0; i < 80; i++) {
            ph01.einparken(new Auto(("BN TO " + i)));
        }
        for (int i = 0; i < 80; i++) {
            Assertions.assertEquals(true, ph01.istEingeparkt(new Auto(("BN TO " + i))));
        }
    }

    @Test

    void einparkenTest() {
        for (int i = 0; i < 80; i++) {
            ph01.einparken(new Fahrzeug(("BN TO " + i)));
        }
        Fahrzeug a = ph01.ausparken(0, 1);
        ph01.ausparken(0, 2);
        ph01.ausparken(1, 1);
        ph01.ausparken(2, 1);
        ph01.ausparken(2, 2);

        assertEquals(0, new Fahrzeug(("BN TO " + 1)).compareTo(a));
        assertEquals(null, ph01.ausparken(0, 1));

    }

    @Test
    void istEingeparktTest() {
        for (int i = 0; i < 80; i++) {
            ph01.einparken(new Auto(("BN TO " + i)));
        }
        for (int i = 0; i < 80; i++) {
            Assertions.assertEquals(true, ph01.istEingeparkt(new Auto(("BN TO " + i))));
        }
    }
    // TODO
    /*
     * Es könnte sein, dass einparken und ausparken wie folgt implementiert sind:
     * einparken : return true istEingeparkt: return true Dieser Test muss
     * verifiziert werden, durch zwei andere Tests. Es muss geprüft werden, ob nach
     * dem einparken der Autos die Funktion istEingeparkt korrekt funktioniert.
     * D.h.: Sie gibt False zurück für nicht Eingeparkte autos.
     * 
     * Es muss geprüft werden ob autos tatsächlich im Parkhaus sind, dazu kann
     * manuell auf das Parkdeck zugegriffen werden, bzw es könnte eine getParkplatz
     * methode implementiert werden, falls dies nicht zu aufwändig ist.
     */
}

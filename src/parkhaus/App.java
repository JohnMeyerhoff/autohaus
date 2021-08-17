package parkhaus;

import fahzeug.Auto;
import fahzeug.Fahrzeug;
import fahzeug.Zweirad;

public class App {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Parkdeck<Fahrzeug> pd01 = new Parkdeck<>(); // je 30 plätze
        Parkdeck<Fahrzeug> pd02 = new Parkdeck<>();
        Parkdeck<Fahrzeug> pd03 = new Parkdeck<>();
        Parkdeck<Fahrzeug>[] haus = (Parkdeck<Fahrzeug>[]) new Parkdeck[3];
        Parkdeck<Fahrzeug>[] etage = (Parkdeck<Fahrzeug>[]) new Parkdeck[5];
        haus[0] = pd01;
        haus[1] = pd02;
        haus[2] = pd03;
        Parkhaus<Fahrzeug> ph = new Parkhaus<>(haus);
        etage[0] = pd01;
        etage[1] = pd02;
        etage[2] = pd03;
        etage[3] = pd01;
        etage[4] = pd02;
        Parkhaus<Fahrzeug> ph1 = new Parkhaus<>(etage);
        Fahrzeug blauerOpel = new Auto("BN FN 2");
        Fahrzeug moped = new Zweirad("MS KG 3");
        ph.woIstFahrzeug(blauerOpel);
        ph.einparken(blauerOpel);
        ph1.einparken(moped);

        System.out.println("Parkhaus 1:");
        System.out.println(ph);
        ph.woIstFahrzeug(blauerOpel);

    }

    // Struktur
    // Autohaus: (Parkhaus)
    // Zwei etagen
    // Autos auf etage 1
    // Motorräder auf etage 2
    // Mopeds auf etage 3
    // Behinderten-Parkplatz

    // Klassen:
    // Parkplatz
    // Parkdeck
    // Parkhaus
    // Fahrzeug
    // Zweirad +-+
    // Auto +-+

    // +-+ = HatBehindertenAusweis
    // (Parkdauer) Park-Start-Zeit

    // Fahrzeug Parken
    // Freie Plätze anzeigen
    // Kosten anzeigen
    // Fahzeug (AusParken)

    // Uebungen:
    // Tests schreiben, wird der richtige fehler gegeben wenn ein parkdeck voll ist?

    // Parkhausausgabe via Iterator PD01 Tostring usw
    // Parkdeckausgabe via Iterator Parkplatz07 Tostring
    // Parkplatzausgabe via Kennzeichen Tostring + Kosten Tostring

    // Deck 0:
    // "BN LO 87", 5.75 Eur; "SU WG 50", 17.00 Eur
    // Deck 1:
    // "BN LO 87", 5.75 Eur; null, 0.00 Eur

    // Instanceof beim Einparken testen

    // forEach einbinden
    // - iteriere über das Gebäude und dann über die Parkflächen

}

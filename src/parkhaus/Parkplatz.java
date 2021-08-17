package parkhaus;

import fahzeug.Fahrzeug;

public class Parkplatz<G extends Fahrzeug> {
    // extends Fahrzeug in unserer App redundant aber:
    // Die Klasse Parkplatz WEISS NICHT dass sie nur mit
    // Unterklassen von Fahrzeug als G
    // Aufgerufen wird und benötigt eine Typeinschränkung für den Typ G um auf das
    // Kennzeichen zuzugreifen.
    boolean istBehindertenParkplatz;
    boolean istBelegt;
    G belegtDurchFahrzeug;
    int kosten = 5;

    Parkplatz() {
        istBehindertenParkplatz = false;
        istBelegt = false;
        belegtDurchFahrzeug = null;
    }

    public void einparken(G einparker) {
        // TODO: behindertenparkplätze implementieren
        this.belegtDurchFahrzeug = einparker;
        this.istBelegt = true;

        this.kosten = 5;
    }

    public int getKosten() {
        return this.kosten;
    }

    public String toString() {
        if (this.belegtDurchFahrzeug == null) {
            return "Kennzeichen: -- -- --, " + kosten + " Euro";
        }
        return "Kennzeichen: " + this.belegtDurchFahrzeug.getKennzeichen() + ", " + this.kosten + " Euro";
    }
}

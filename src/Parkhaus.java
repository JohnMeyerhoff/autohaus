import java.util.Iterator;

public class Parkhaus implements Iterable<Parkdeck> {
    Parkdeck<Fahrzeug>[] gebaeude;

    Parkhaus(Parkdeck<Fahrzeug>[] haus) {
        this.gebaeude = haus;
    }

    public boolean einparken(Fahrzeug einparker) {
        if (this.gebaeude[0] == null) {
            System.out.println("fehler");
        }
        return this.gebaeude[0].einparken(einparker);
    }

    public boolean istEingeparkt(Fahrzeug anders) {
        for (int i = 0; i < gebaeude.length; i++) {
            if (gebaeude[i].kennzeichenSuche(anders.kennzeichen)) {
                return true;
            }
        }
        return false;
    }

    public int woIstFahrzeug(Fahrzeug a) {
        int erg = -1;
        for (int i = 0; i < gebaeude.length; i++) {
            erg = gebaeude[i].fahrzeugSuche(a);
            if (erg != -1) {
                System.out.println("Ihr Auto mit Kennzeichen "+a.kennzeichen+" gefunden:");
                System.out.println("Parkdeck: " + i);
                System.out.println("Platznummer: " + erg);
                return erg;
            }
        }
        System.out.println("Leider haben wir Ihr Auto mit Kennzeichen "+a.kennzeichen+" nicht gefunden.");
        return erg;// Hier -1
    }

    public void printFreiePlaetze() {
        for (Parkdeck<Fahrzeug> a : gebaeude) {
            System.out.println(a.getFreiePlaetze());
        }
    }

    public String toString() {
        return gebaeude[0].toString() + "\n" + gebaeude[1].toString() + "\n" + gebaeude[2].toString();
    }

    @Override
    public Iterator<Parkdeck> iterator() {
        
        return new Ebeneniterator();
    }
    public class Ebeneniterator implements Iterator<Pardeck>{
        int bookmark = 0;

        @Override
        public boolean hasNext() {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public Pardeck next() {
            // TODO Auto-generated method stub
            return null;
        }

    }
}

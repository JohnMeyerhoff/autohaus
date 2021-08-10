package parkhaus;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class Parkhaus<F extends Fahrzeug> implements Iterable<Parkdeck<F>> {
    Parkdeck<F>[] gebaeude;
    int size = 0; //wie viele Etagen gibt es?

    public Parkhaus(Parkdeck<F>[] haus) {
        this.gebaeude = haus;
        size = gebaeude.length;
    }

    /**
     * 
     * @param haus Parkdeckarray
     * @param fuellstand Beschreibt wie weit der Parkdeckarray gefüllt ist.
     */
    Parkhaus(Parkdeck<F>[] haus, int fuellstand) {
        this.gebaeude = haus;
        this.size = fuellstand;
    }

    public boolean einparken(F einparker) {
        if (this.gebaeude[0] == null) {
            System.out.println("fehler");
        }
        int i = 0;
        while(this.gebaeude[i].capacity==this.gebaeude[i].size && (i < gebaeude.length)){
            i++;
        }
        if(this.gebaeude[i].capacity==this.gebaeude[i].size){// i ist der index des letzen decks 
            //Wenn i nicht der index des letzten decks ist, ist es definitiv nicht voll, durch die
            //while Schleife.
            //Also ist hier alles voll wenn die Bedingung zu TRUE evaluiert.
            throw new NoSuchElementException("Alles VOLL!");
        }
        return this.gebaeude[i].einparken(einparker);
    }

    public F ausparken(int parkdeckNummer, int parkplatzNummer){

        if (this.gebaeude[0] == null) {
            System.out.println("fehler");
        }
        if(parkdeckNummer < getGebaeudeSize()){
            return gebaeude[parkdeckNummer].ausparken(parkplatzNummer);
        }else{
            System.out.println("Parkdeck gibt es nicht.");
            return null;
        }

    }

    private int getGebaeudeSize() {
        return size;
    }

    public boolean istEingeparkt(F anders) {
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
                System.out.println("Ihr Auto mit Kennzeichen " + a.kennzeichen + " gefunden:");
                System.out.println("Parkdeck: " + i);
                System.out.println("Platznummer: " + erg);
                return erg;
            }
        }
        System.out.println("Leider haben wir Ihr Auto mit Kennzeichen " + a.kennzeichen + " nicht gefunden.");
        return erg;// Hier -1
    }

    public void printFreiePlaetze() {
        for (Parkdeck<F> a : gebaeude) {
            System.out.println(a.getFreiePlaetze());
        }
    }

    public String toString() {
        StringBuilder bld = new StringBuilder();
        for (Parkdeck<F> pd : this) {
            bld.append(pd.toString() + "\n");
        }
        return bld.toString();
       // return gebaeude[0].toString() + "\n" + gebaeude[1].toString() + "\n" + gebaeude[2].toString();
    }

    @Override
    public Iterator<Parkdeck<F>> iterator() {
        return new Ebeneniterator();
    }

    public class Ebeneniterator implements Iterator<Parkdeck<F>> {
        int bookmark = 0;

        @Override
        public boolean hasNext() {
            if (bookmark < size) {
                return true;
            }
            return false;
        }

        @Override
        public Parkdeck<F> next() {
           if(!hasNext()){
                throw new NoSuchElementException("Es gibt gar nix nächstes.");
           }
            return gebaeude[bookmark++];
        }

    }
}

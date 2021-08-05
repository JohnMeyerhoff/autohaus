import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Parkdeck<T extends Fahrzeug> implements Iterable<Parkplatz>{
    /* Frage: Warum ist das Parkdeck hier generisch?
    Wenn die Begründung für die generische Implementierung der Klasse 
    Parkdeck lautet "damit alle Fahrzeuge einparken dürfen" MUSS der typ T 
    bei Instanziierung "Fahrzeug" sein. - Keine Unterklasse von Fahrzeug, 
    Keine Klasse die ein Fahrzeug ist, sondern die Tatsächliche Klasse Fahrzeug.
    Dadurch verändert sich die Signatur der Methode Einparken so, dass der Typ T 
    des Einparkers immer Fahrzeug ist.
    Wenn der Typ immer der selbe Typ sein muss, können wir diesen Typen auch 
    eintragen und die signatur zu (Fahrzeug einparker) ändern.
    Jetzt wird T aber nirgends mehr verwendet, die begründung der Generik liegt 
    also darin, dass die generik nicht verwendet wird und ist folglich falsch.
    "T ist Fahrzeug" (T == Fahrzeug) ist eine andere Aussage 
    als "T ist ein Fahrzeug"(T extends Fahrzeug)(Nonsense)

    T ist also die einzige Klasse, die auf unserem Parkdeck eine Erlaubnis hat.
    "damit jedes Fahrzeug der Klasse einparken dar, welches als Parameter übergeben 
    wurde."
    */
    Parkplatz[] parkflaeche;
    int capacity = 30;
    int size = 0;

    Parkdeck(){
        this.parkflaeche = new Parkplatz[30];
    }
    public boolean einparken(T einparker) {
        if(size>=capacity){
            return false;
        }
        this.parkflaeche[size] = new Parkplatz();
        this.parkflaeche[size].einparken(einparker);
        size++;
        return true;
    }
    public String getFreiePlaetze() {
        return "Freie Plaetze: "+ (capacity-size);
    }
    public String toString(){
        String result = getFreiePlaetze();
        result += "\nbelegte Parkplaetze: ";
       for(int i = 0; i < size;i++){ //die size ist max 30
            result += "\n"+i+" " + parkflaeche[i].toString();
       }
       return result;
    }
    @Override
    public Iterator<Parkplatz> iterator() {
        return new ParkdeckIterierbar();
    }
    class ParkdeckIterierbar implements Iterator<Parkplatz>{
        int bookmark = 0; 
        @Override
        public boolean hasNext() {
            if(bookmark > size){
                return false;
            }
            return true;
        }

        @Override
        public Parkplatz next() {
            if(!hasNext()){
                throw new NoSuchElementException("Es gibt nix mehr.");
            }
            return  parkflaeche[bookmark++];
        }
        
    }
}

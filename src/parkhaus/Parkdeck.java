package parkhaus;
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

    public Parkdeck(){
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
       /* String result = getFreiePlaetze();
        result += "\nbelegte Parkplaetze: "+ size;
       for(int i = 0; i < size;i++){ //die size ist max 30
            result += "\n"+i+" " + parkflaeche[i].toString();
       }
       return result;*/
       String result = getFreiePlaetze();
        result += "\nbelegte Parkplaetze: "+ size;
        for (Parkplatz x: this) {
            result += "\n"+ x;
        }
       return result;
    }
    public boolean kennzeichenSuche(String k){
        //Wenn size ==0 ist wird die foreach schleife nicht iteriert bzw hat 0 iterationen
        // ==>> return false
        for(Parkplatz x : this){ //Für alle Parkplätze
            if(k.equals(x.belegtDurchFahrzeug.kennzeichen)){
                return true;//Vergleiche Kennzeichen bis Übereinstimmung
            }
        }
        return false;//Es gab keine übereinstimmung bei den Parkplätzen dieses Parkdecks
    }
    public int fahrzeugSuche(Fahrzeug b){
        int gefunden = -1;
        for(int i = 0; (gefunden ==-1) && (i < size); i++){
            if((b.kennzeichen.equals(parkflaeche[i].belegtDurchFahrzeug.kennzeichen))){
                return i;
            }
        }
        return gefunden;
    }
    @Override
    public Iterator<Parkplatz> iterator() {
        return new ParkdeckIterierbar();
    }
    class ParkdeckIterierbar implements Iterator<Parkplatz>{
        int bookmark = 0; 
        @Override
        public boolean hasNext() {
            if(bookmark < size){
                return true;
            }
            return false;
        }

        @Override
        public Parkplatz next() {
            if(!hasNext()){
                throw new NoSuchElementException("Es gibt nix mehr.");
            }
            return  parkflaeche[bookmark++];
        }
        
    }
    public int getSize() {
        return this.size;
    }
    public Fahrzeug ausparken(int parkplatzNummer) {
        Fahrzeug a;
        if(parkplatzNummer < 0 || parkplatzNummer > anzahlParkplaetze()){
            System.out.println("Ungültige Nummer.");
            return null;
        }else{
            a = parkflaeche[parkplatzNummer].belegtDurchFahrzeug;
            if(a != null){ //Parkplatz ist belegt
                parkflaeche[parkplatzNummer].belegtDurchFahrzeug = null;
                size--;

            }
            return a;
        }
    }
    public int anzahlParkplaetze(){
        return parkflaeche.length; //oder capacity
    }
    
    public int anzahlBelegteParkplaetze() {
        return size;
    }
}

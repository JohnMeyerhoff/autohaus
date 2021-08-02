public class Parkdeck {
    Parkplatz[] parkflaeche;
    int capacity = 30;
    int size = 0;
    Parkdeck(){
        this.parkflaeche = new Parkplatz[30];
    }
    public boolean einparken(Fahrzeug einparker) {
        if(size>=capacity){
            return false;
        }
        this.parkflaeche[size] = new Parkplatz();
        this.parkflaeche[size++].einparken(einparker);
        return true;
    }
    public String getFreiePlaetze() {
        return " Freie Plaetze: "+ (capacity-size);
    }
}

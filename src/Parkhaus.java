import java.util.Arrays;


public class Parkhaus {
    Parkdeck<Fahrzeug>[] gebaeude;
    
    Parkhaus(Parkdeck<Fahrzeug>[] haus) {
        this.gebaeude = haus;
    }

    public boolean einparken(Fahrzeug einparker){
        if(this.gebaeude[0]== null){
            System.out.println("fehler");
        }
        return this.gebaeude[0].einparken(einparker);
    }

    public void printFreiePlaetze() {
        for(Parkdeck<Fahrzeug> a : gebaeude){
            System.out.println(a.getFreiePlaetze());
        }
    }
    public String toString(){
        return gebaeude[0].toString()+ "\n" + gebaeude[1].toString() + "\n" + gebaeude[2].toString();
    }
}

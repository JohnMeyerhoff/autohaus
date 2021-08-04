import java.util.Arrays;


public class Parkhaus<T extends Fahrzeug> {
    Parkdeck<T>[] gebaeude;
    
    Parkhaus(Parkdeck<T>[] haus) {
        this.gebaeude = haus;
    }

    public boolean einparken(T einparker){
        if(this.gebaeude[0]== null){
            System.out.println("fehler");
        }
        System.out.println(Arrays.toString(this.gebaeude));
        //return this.gebaeude[0].einparken(einparker);
        return this.gebaeude[0].equals(einparker); ??
    }

    public void printFreiePlaetze() {
        for(Parkdeck a : gebaeude){
            System.out.println(a.getFreiePlaetze());
        }
    }
}

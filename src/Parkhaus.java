import java.util.Arrays;

public class Parkhaus {
    Parkdeck[] gebaeude;
    
    Parkhaus(Parkdeck[] haus) {
        this.gebaeude = haus;
    }

    public boolean einparken(Fahrzeug einparker){
        if(this.gebaeude[0]== null){
            System.out.println("fehler");
        }
        System.out.println(Arrays.toString(this.gebaeude));
        return this.gebaeude[0].einparken(einparker);
    }

    public void printFreiePlaetze() {
        for(Parkdeck a : gebaeude){
            System.out.println(a.getFreiePlaetze());
        }
    }
}

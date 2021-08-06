import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.NoSuchElementException;


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
    public boolean istEingeparkt(Fahrzeug anders){
       for (int i = 0; i < gebaeude.length; i++) {
          if(gebaeude[i].kennzeichenSuche(anders.kennzeichen)){
            return true;
          }
        }
        return false;
    }
    public int woIstFahrzeug(Fahrzeug a) throws NoSuchAlgorithmException{
        int erg = 0;
        if(!istEingeparkt(a)){
            throw new NoSuchElementException("Das Auto steht nicht im Parkhaus.");
        }else{
            for (int i = 0; i < gebaeude.length;i++) {
                erg = gebaeude[i].fahrzeugSuche(a);
                if(erg != -1){
                   System.out.println(i);
                   return erg;
                }
              }
        }
        return erg;
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

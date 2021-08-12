package parkhaus;

import java.util.NoSuchElementException;

public class Fahrzeug implements Comparable<Fahrzeug>{
    protected String kennzeichen;
    protected boolean hatBehindertenAusweis;
    public Fahrzeug(String kennz) {
        if(kennz== null){
           throw new NoSuchElementException("Das ist illegal");
        }
        this.kennzeichen = kennz;
    }
    public String getKennzeichen(){
        return this.kennzeichen;
    }
    public boolean getHatBehindertenAusweis(){
        return this.hatBehindertenAusweis;
    }
    @Override
    public int compareTo(Fahrzeug o) {
        return this.kennzeichen.compareTo(o.kennzeichen);
    }

    public String toString(){
        if(this.kennzeichen== null){//Durch konstruktor verhindert
            return "";
        }
        return this.kennzeichen;
    }
}

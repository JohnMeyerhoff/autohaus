package fahzeug;

import java.util.NoSuchElementException;

public class Fahrzeug implements Comparable<Fahrzeug>{
    protected String kennzeichen;
    protected boolean hatBehindertenAusweis; //defaults to false
    public Fahrzeug(String kennz) {
       this(kennz, false);
    }
    public Fahrzeug(String kennz, boolean behindert){
        if (kennz == null) {
            throw new NoSuchElementException("Das ist illegal");
        }
        this.kennzeichen = kennz;
        this.hatBehindertenAusweis = behindert;

    }
    public String getKennzeichen(){
        return this.kennzeichen;
    }
    public boolean getHatBehindertenAusweis(){
        return this.hatBehindertenAusweis;
    }
    /**
     * diese Methode gibt in der Komandozeile aus, ob das Fahrzeug einen Behindertenausweis hat
     * @return gibt den Wert von hatBehindertenAusweis zurück
     */
    public boolean hatBehindertenAusweis() {
        if (hatBehindertenAusweis) {
            System.out.println(kennzeichen + ": Hat Ausweis.");
        } else {
            System.out.println(kennzeichen + ": Kein Ausweis.");
        }
        return this.hatBehindertenAusweis;
    }
    @Override
    public int compareTo(Fahrzeug o) {
        return this.kennzeichen.compareTo(o.kennzeichen);
    }
    @Override
    public boolean equals(Object o){
        if(o instanceof Fahrzeug){
            return (this.compareTo((Fahrzeug)o)==0);
        }else{
            return this==o;
        }
    }
    
    public String toString(){
        if(this.kennzeichen== null){//Durch konstruktor verhindert
            return "";
        }
        return this.kennzeichen;
    }
}

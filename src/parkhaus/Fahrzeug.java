package parkhaus;
public class Fahrzeug implements Comparable<Fahrzeug>{
    protected String kennzeichen;
    protected boolean hatBehindertenAusweis;
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
}

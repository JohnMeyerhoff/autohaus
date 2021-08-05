public class Parkplatz {
    boolean istBehindertenParkplatz;
    boolean istBelegt;
    Fahrzeug belegtDurchFahrzeug;
    Parkdeck<Fahrzeug> eins;
    int kosten = 5;
    Parkplatz(){
        istBehindertenParkplatz = false;
        istBelegt = false;
        belegtDurchFahrzeug = null;
    }
    public void einparken(Fahrzeug einparker) {
        if(istBehindertenParkplatz == false){
        this.belegtDurchFahrzeug = einparker;
        this.istBelegt = true;
        //von Klara
        this.istBehindertenParkplatz = false;
        }else{
        this.belegtDurchFahrzeug = einparker;
        this.istBelegt = true;
        this.istBehindertenParkplatz = true;
        }
        kosten = 5;
    }
    public int getKosten(){
        return this.kosten;
    }
    public String toString(){
        return "[Kennzeichen: " + this.belegtDurchFahrzeug.kennzeichen+ ", " + kosten + " Euro]";
    }
}

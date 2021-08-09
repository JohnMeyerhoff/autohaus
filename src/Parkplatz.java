public class Parkplatz {
    boolean istBehindertenParkplatz;
    boolean istBelegt;
    Fahrzeug belegtDurchFahrzeug;
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
        this.kosten = 5;
    }
    public int getKosten(){
        return this.kosten;
    }
    public String toString(){
        if(this.belegtDurchFahrzeug == null){
            return "Kennzeichen: -- -- --, " + kosten + " Euro";
        }
        return "Kennzeichen: " + this.belegtDurchFahrzeug.kennzeichen+ ", " + this.kosten + " Euro";
    }
}

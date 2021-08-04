public class Parkplatz {
    boolean istBehindertenParkplatz;
    boolean istBelegt;
    Fahrzeug belegtDurchFahrzeug;
    int kosten = 0; //5 euro pro Parkplatz
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
}

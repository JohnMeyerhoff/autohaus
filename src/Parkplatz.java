public class Parkplatz {
    boolean istBehindertenParkplatz;
    boolean istBelegt;
    Fahrzeug belegtDurchFahrzeug;
    Parkplatz(){
        istBehindertenParkplatz = false;
        istBelegt = false;
        belegtDurchFahrzeug = null;
    }
    public void einparken(Fahrzeug einparker) {
        this.belegtDurchFahrzeug = einparker;
        this.istBelegt = true;
    }
}

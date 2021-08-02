public class App {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        Parkdeck pd01 = new Parkdeck();
        Parkdeck pd02 = new Parkdeck();
        Parkdeck pd03 = new Parkdeck();
        Parkdeck[] haus =  new Parkdeck[3];
        haus[0]= pd01;
        haus[1]= pd02;
        haus[2]= pd03;
        Parkhaus ph = new Parkhaus(haus);
        Fahrzeug blauerOpel = new Auto("BN FN 2");
        ph.einparken(blauerOpel);
        ph.printFreiePlaetze();
        
    }

    //Struktur
    //Autohaus: (Parkhaus)
    //Zwei etagen
    //Autos auf etage 1
    //Motorräder auf etage 2
    //Mopeds auf etage 3
    //Behinderten-Parkplatz


    //Klassen:
    //Parkplatz
    //Parkdeck
    //Parkhaus
    //Fahrzeug
    //Zweirad +-+
    //Auto +-+

    // +-+ = HatBehindertenAusweis
    //(Parkdauer) Park-Start-Zeit


    //Fahrzeug Parken
    //Freie Plätze anzeigen
    //Kosten anzeigen
    //Fahzeug (AusParken)
}

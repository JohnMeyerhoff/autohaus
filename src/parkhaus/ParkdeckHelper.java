package parkhaus;

import fahzeug.Fahrzeug;

public class ParkdeckHelper {
    public static <T extends Fahrzeug> String[] parkDeckToArray(Parkdeck<T> pd) {
        String[] res = new String[pd.capacity];
        int x = 0;
        for (Parkplatz<T> pp : pd) {
            if (pp.belegtDurchFahrzeug != null) {
                res[x] = x+ " HB: " + pp.belegtDurchFahrzeug.getHatBehindertenAusweis() + " "
                        + pp.belegtDurchFahrzeug.toString();
                // HB: hat behindertenausweis
            } else {
                res[x] = x + ": leer";
            }
            x++;
        }
        return res;
    }
    //Es ist nicht Ziel dieser Methoden möglichst optimiert zu sein. Sie dürfen parkdeckToArray benutzen. 
    public static <T extends Fahrzeug> String[] parkDeckGeradeToArray(Parkdeck<T> x) {
        String[] alle = parkDeckToArray(x);
        String[] links = new String[(alle.length)/2];
        //x wird nicht mehr verwendet und zurückgegben werden soll eine Kopie von alle/abgeänderte Form von alle, die nur noch
        //die geraden Parkplätze enthält
       
        int i = 0;
        for( int f = 0; f < links.length;f++){
            links[f] = alle[i];
            i = i + 2;
        }
        return links;
    }
    
    public static <T extends Fahrzeug> String[] parkDeckUngeradeToArray(Parkdeck<T> x) {
        String[] alle = parkDeckToArray(x);
        int laenge =  (alle.length%2 == 0) ? alle.length/2: ((alle.length)/2) + 1;
        String[] rechts = new String[laenge];
        int f = 0;
        for (int i = 1; i <= alle.length; i = i +2) {
            rechts[f] = alle[i];
            f++;
        }
        return rechts;
    }
    
}

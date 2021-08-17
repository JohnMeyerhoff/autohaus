package parkhaus;

import fahzeug.Fahrzeug;

public class ParkdeckHelper {
    public static <T extends Fahrzeug> String[] parkDeckToArray(Parkdeck<T> pd) {
        String[] res = new String[pd.capacity];
        int x = 0;
        for (Parkplatz<T> pp : pd) {
            if (pp.belegtDurchFahrzeug != null) {
                res[x++] = "HB: "+ pp.belegtDurchFahrzeug.getHatBehindertenAusweis()
                + " "+ pp.belegtDurchFahrzeug.toString();
            } else {
                res[x++] = "leer";
            }
        }
        return res;
    }
}

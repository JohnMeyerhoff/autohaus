package parkhaus;

public class Auto extends Fahrzeug {
    public Auto(String kzeichen) {
        super(kzeichen);
    }
    
    public Auto(String kzeichen, boolean behindert) {
        super(kzeichen, behindert);
    }
}

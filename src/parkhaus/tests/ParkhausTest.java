package parkhaus.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import parkhaus.Auto;
import parkhaus.Fahrzeug;
import parkhaus.Parkdeck;
import parkhaus.Parkhaus;
import parkhaus.Zweirad;
@SuppressWarnings("unchecked")

public class ParkhausTest {
    Parkdeck<Auto> pd01 = new Parkdeck<>();
    Parkdeck<Auto>[] gebaeude;
    

   @BeforeEach
   void before(){
    gebaeude = (Parkdeck<Auto>[]) new Parkdeck[5];
   } 

   @AfterEach
   void after(){
    gebaeude = null;
   }
    //Das fahrzeug nimmt einen Platz ein, wir haben 90 plätze. 80 sollte passen. 
    // Generieren sie mit eienr schelife 80 autos die sie einparken. Gebe denen
    //kein Varialennamen. 

    @Test
    public void einfach(){
    for (Auto parker : pd01) {
        parker.einparken();
    }
    }
}



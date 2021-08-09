package parkhaus;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class NeuerTest {
    Parkdeck<Fahrzeug>[] etage;
    
   @BeforeEach
   void before(){
    Parkhaus<Fahrzeug> erstes = new Parkhaus<>(etage);
   } 
   @AfterEach
   void after(){

   }
    //Das fahrzeug nimmt einen Platz ein, wir haben 90 plätze. 80 sollte passen. 
    // Generieren sie mit eienr schelife 80 autos die sie einparken. Gebe denen
    //kein Varialennamen. 

    @Test
    public void einfach(){
    
    }
}



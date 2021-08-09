package tests;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ParkhausTest {
   @BeforeEach
   void before(){
    
   } 
   @AfterEach
   void after(){

   }
    //Das fahrzeug nimmt einen Platz ein, wir haben 90 plätze. 80 sollte passen. 
    // Generieren sie mit eienr schelife 80 autos die sie einparken. Gebe denen
    //kein Varialennamen. 

    @Test
    public void einfach(){
    Parkdeck<Fahrzeug> etage = new Parkdeck<>();
    Parkhaus<Fahrzeug> erstes = new Parkhaus<>(etage);
    }
}

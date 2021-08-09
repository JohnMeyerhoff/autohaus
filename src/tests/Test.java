package tests;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import Parkdeck;

public class Test {
   @BeforeEach
   void before(){
    Parkdeck<Fahrzeug> etage = new Parkdeck<>();
    Parkhaus<Fahrzeug> erstes = new Parkhaus<>(etage);
   } 
   @AfterEach
   void after(){

   }
    //Das fahrzeug nimmt einen Platz ein, wir haben 90 plätze. 80 sollte passen. 
    // Generieren sie mit eienr schelife 80 autos die sie einparken. Gebe denen
    //kein Varialennamen. 
}

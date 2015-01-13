
/**
 * Write a description of class Contant here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Contant extends Betaalwijze
{
   /**
    * Methode om betaling af te handelen
    */
   public boolean betaal(double tebetalen){
       if(saldo >= tebetalen){
           saldo -= tebetalen;
           return true;
       }
        else {
            return false;
       }
   }
}
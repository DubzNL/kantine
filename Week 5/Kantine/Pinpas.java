
/**
 * Write a description of class Pinpas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pinpas extends Betaalwijze
{
   private double kredietlimiet;
   
   /**
    * Methode om redietlimiet te zetten
    * @param kredietlimiet
    */
   public void setKredietLimiet(double kredietlimiet){
       this.kredietlimiet = kredietlimiet;
    }
    
    /**
     * Methode om betaling af te handelen
     */
    public boolean betaal(double tebetalen){
        if(this.kredietlimiet < tebetalen){
            System.out.println("Heeft te weinig krediet");
            return false;
        } else {
            this.kredietlimiet -= tebetalen;
            this.saldo -= tebetalen;
            return true;
        }
    }
}

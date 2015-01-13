
/**
 * Write a description of class Pinpas here.
 * 
 * @author Eric Gunnink & Jelmer Postma 
 * @version 10-1-2015
 */
public class Pinpas extends Betaalwijze
{
   private double kredietlimiet;
   
   /**
    * Methode om kredietlimiet te zetten
    * @param kredietlimiet
    */
   public void setKredietLimiet(double kredietlimiet){
       this.kredietlimiet = kredietlimiet;
    }
    
   /**
    * methode om kredietlimiet op te vragen
    */
   public double getKredietLimiet(){
       return kredietlimiet;
    }
    
    /**
     * Methode om betaling af te handelen
     */
    public boolean betaal(double tebetalen){
        boolean temp = false;
        if(tebetalen <= this.saldo){
            saldo -= tebetalen;
            temp = true;
        }
        return temp;
    }
}

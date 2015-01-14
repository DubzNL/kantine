
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
     * Methode om kredietlimiet te zetten
     * @param kredietlimiet
     */
    public void setKredietLimiet(double kredietlimiet){
        this.kredietlimiet = kredietlimiet;
    }
    
    /**
     * Methode om betaling af te handelen
     */
    public void betaal(double tebetalen)throws TeWeinigGeldException{
        if(kredietlimiet <= saldo - tebetalen){
            saldo -= tebetalen;
            
        }
        else {
            throw new TeWeinigGeldException("Te weinig geld!");
        }
    }
}

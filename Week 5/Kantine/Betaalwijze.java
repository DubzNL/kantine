
/**
 * Abstract class Betaalwijze - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Betaalwijze
{
    protected double saldo;
    
    /**
     * Methode om krediet te initialiseren
     * @param krediet
     */
    public void setSaldo(double saldo){
        this.saldo = saldo;
    }
     
    /** 
     * Getter methode om het saldo op te vragen
     */
    public double getSaldo(){
        return saldo;
    }
    
    /**
     * Methode om betaling af te handelen
     * @param tebetalen
     */
    public abstract void betaal(double tebetalen) throws TeWeinigGeldException;
}

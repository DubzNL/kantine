import java.util.ArrayList;
import java.util.Stack;
import java.util.Iterator;

/**
 * De klasse Dienblad zorgt voor de Stack van artikelen op het
 * dienblad. Ook geeft hij de totaalprijs van het dienblad terug.
 * 
 * @author Eric Gunnink & Jelmer Postma 
 * @version 5-12-2014
 */

public class Dienblad
{
    private Stack<Artikel> artikelen;
    
    /**     
     * Constructor voor de objecten van de klasse Dienblad
     */    
    
    public Dienblad() 
    {        
        artikelen = new Stack<Artikel>(); 
    }
    
    /**     
     * Methode om artikel aan dienblad toe te voegen 
     * @param artikel     
     */    
    public void voegToe(Artikel naam) 
    {        
        artikelen.add(naam);
    }
    
    /**     
     * Methode om aantal artikelen op dienblad te tellen    
     * @return Het aantal artikelen      
     */    
    public int getAantalArtikelen() 
     {        
        return artikelen.size();
     }
     
    /**     
     * Methode om de totaalprijs van de artikelen      
     * op dienblad uit te rekenen     
     * @return De totaalprijs     
     */    
    public double getTotaalPrijs() 
    {        
        double totaal = 0;
        int index = 0;
          while (index < artikelen.size())
          {
              totaal = totaal + artikelen.get(index).getPrijs();
              index++;
          }
        return totaal;
    }    
    
    /**
     *  De Iterator om door de artikelen op het dienblad te lopen
     *  @return artikelen.iterator()
     */
    public Iterator<Artikel> getArtikelIterator()
    {
        return artikelen.iterator();
    }
}

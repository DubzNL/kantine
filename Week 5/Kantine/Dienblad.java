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
    /**
     *  De Iterator om door de artikelen op het dienblad te lopen
     *  @return artikelen.iterator()
     */
    public Iterator<Artikel> getArtikel()
    {
        return artikelen.iterator();
    }
}

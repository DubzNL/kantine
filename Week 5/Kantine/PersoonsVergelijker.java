
/**
 * Persoonsvergelijker classe voor het vergelijken van de methodes equals en ==.
 * 
 * @author (Eric Gunnink && Jelmer Postma
 * @version (08/01/2015)
 */
public class PersoonsVergelijker
{
    // instance variables - replace the example below with your own
    static Persoon persoon;
    static Persoon identiekePersoon;
    /**
     * Constructor for objects of class PersoonsVergelijker
     */
    public PersoonsVergelijker()
    {
       
    }
    
    /**
     *  Static methode voor het maken van twee 'identieke' personen
     * 
     */
    public static void main(String[] args)
    {   
        persoon=new Persoon("persoon","achternaam",01,05,1990,'m',1212); 
        identiekePersoon=new Persoon("persoon","achternaam",01,05,1990,'m',1212); 
            
        if(persoon == identiekePersoon)
        {
            System.out.println("persoon == identiekePersoon");
        }
        else
        {
            System.out.println("persoon en identiekePersoon zijn niet gelijk");
        }
   
        if(persoon.equals((Persoon) identiekePersoon))
        {
            System.out.println("beide zijn ze gelijk (equals)");
        }
        else
        {
            System.out.println("beide zijn ze niet gelijk (equals)");
                
        }
    }    
}

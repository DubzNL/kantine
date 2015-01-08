
/**
 * De klasse Artikel bevat informatie over de naam en prijs van een artikel 
 * uit de kantine.
 * 
 * @author Eric Gunnink & Jelmer Postma 
 * @version 24-11-2014
 */
public class Artikel
{
    // de velden van het artikel
    private String naam;
    private double prijs;

    /**
     * Geeft een naam en prijs wanneer het object aangemaakt wordt.
     */
    public Artikel(String naam, double prijs)
    {
        this.naam = naam;
        this.prijs = prijs;
    }

    /**
     * Parameterloze constructor van het object
     */
    public Artikel()
    {
        
    }
    
    /**
     * Wijzig de naam van het artikel
     */
    public void setNaam(String naamArtikel)
    {
        this.naam = naamArtikel;
    }
    
    /**
     * Wijzig de prijs van het artikel.
     */
    public void setPrijs(double prijsArtikel)
    {
        this.prijs = prijsArtikel;
    }
    
    /**
     * Geeft de prijs van het artikel weer.
     */
    public double getPrijs()
    {
        return prijs;
    }
    
    /**
     * Geeft de naam van het artikel weer.
     */
    public String getNaam()
    {
        return naam;
    }
    
    /**
     * Print functie van alle gegevens van het artikel. 
     */
    public void printInfo()
    {
        System.out.println("Artikel: " + naam);
        System.out.println("Prijs: " + prijs);
    }
}

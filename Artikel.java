
/**
 * De klasse Artikel bevat informatie over de naam en prijs van een artikel 
 * uit de kantine.
 * 
 * @author Eric Gunnink 
 * @version 19-11-2014
 */
public class Artikel
{
    // de velden van het artikel
    private String naam;
    private String prijs;

    /**
     * Geeft een naam en prijs wanneer het object aangemaakt wordt.
     */
    public Artikel(String naamArtikel, String prijsArtikel)
    {
        naam = naamArtikel;
        prijs = prijsArtikel;
    }

    /**
     * Wijzig de naam van het artikel
     */
    public void setNaam(String naamArtikel)
    {
        naam = naamArtikel;
    }
    
    /**
     * Wijzig de prijs van het artikel.
     */
    public void setPrijs(String prijsArtikel)
    {
        prijs = prijsArtikel;
    }
    
    /**
     * Geeft de naam van het artikel weer.
     */
    public String getNaam()
    {
        return naam;
    }
}

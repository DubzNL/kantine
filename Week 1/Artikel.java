
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
    public String naam;
    public double prijs;

    /**
     * Geeft een naam en prijs wanneer het object aangemaakt wordt.
     */
    public Artikel()
    {
        naam = "test";
        prijs = 2.50;
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
    public void setPrijs(int prijsArtikel)
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
        System.out.println("Prijs (in eurocent): " + prijs);
    }
}

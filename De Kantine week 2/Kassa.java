/**
 * De klasse Kassa bevat informatie over de verwerking van de kassarij. Er wordt
 * wordt bijgehouden hoeveel artikelen en hoeveel geld er verwerkt is.
 * 
 * @author Eric Gunnink & Jelmer Postma 
 * @version 24-11-2014
 */
public class Kassa 
{
    private int aantalArtikelen;
    private KassaRij kassarij;
    private double hoeveelheidGeld;
    /**
     * Constructor
     */
    public Kassa(KassaRij kassarij) {
        this.kassarij = kassarij;
    } 
    
    /**
       * vraag het aantal artikelen en de totaalprijs op.
       * De implementatie wordt later vervangen
       * door een echte betaling door de persoon.
       * @param persoon die moet afrekenen
     */
    public void rekenAf(Persoon persoon) 
    {
        double totaalPrijs = persoon.getTotaalPrijs();
        int aantalArtikelen = persoon.getAantalArtikelen();
        this.aantalArtikelen = this.aantalArtikelen + aantalArtikelen;
        hoeveelheidGeld = hoeveelheidGeld + totaalPrijs;
    }
    
    /**
       * Geeft het aantal artikelen dat de kassa
       * heeft gepasseerd,
       * vanaf het moment dat de methode resetWaarden
       * is aangeroepen.
       * @return aantal artikelen
    */
    public int getAantalArtikelen() 
    {
        return aantalArtikelen;
    }
    
    /**
      * Geeft het totaalbedrag van alle artikelen die
      * de kassa zijn gepasseerd, vanaf het moment dat de methode
      *resetKassa
      * is aangeroepen.
      * @return hoeveelheid geld in de kassa
     */
    public double hoeveelheidGeldInKassa() 
    {
        return hoeveelheidGeld;
    }
    
    /**
      * reset de waarden van het aantal gepasseerde artikelen en
      * de totale hoeveelheid geld in de kassa.
    */
    public void resetKassa() 
    {
        aantalArtikelen = 0;
        hoeveelheidGeld = 0;
    }
        
}
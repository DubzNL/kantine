import java.util.Iterator;
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
    private Dienblad dienblad;
    
    /**
     * Constructor
     */
    public Kassa(KassaRij kassarij){
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
        Iterator<Artikel> artikelen = persoon.getDienblad().getArtikel();
        double totaalPrijs = 0;
        dienblad = persoon.getDienblad();
        
        while(artikelen.hasNext())
        {
            Artikel artikel = artikelen.next();
            totaalPrijs += artikel.getPrijs();
            aantalArtikelen++;
        }
        
        if(persoon instanceof KortingskaartHouder)
        {
            KortingskaartHouder kortingPersoon = (KortingskaartHouder) persoon;
            double kortingInEuros = totaalPrijs * kortingPersoon.geefKortingsPercentage();
            if(kortingPersoon.heeftMaximum()&&kortingPersoon.geefMaximum()<kortingInEuros)
            {
                kortingInEuros = kortingPersoon.geefMaximum();
            }
            totaalPrijs = totaalPrijs - kortingInEuros;
            System.out.println("Deze persoon heeft " + kortingInEuros + " korting gekregen");
        }
        if(persoon.getBetaalwijze() != null)
        {
            Betaalwijze persoonBetaalwijze = persoon.getBetaalwijze();
            try 
            {
                persoonBetaalwijze.betaal(totaalPrijs);
                hoeveelheidGeld += totaalPrijs;
                System.out.println("Persoon:");
                System.out.println(persoon.getVoornaam() + " " + persoon.getAchternaam() + " Heeft succesvol een betaling afgerond.");
                System.out.println(" ");
            }
            catch(TeWeinigGeldException teweiniggeld)
            {
                System.out.println("Persoon:");
                System.out.println(persoon.getVoornaam() + " " + persoon.getAchternaam() + " kan niet afrekenen, niet genoeg geld:");
                System.out.println(" ");
            } 
        }
        else 
        {
            System.out.println("Deze persoon heeft geen betaalwijze!");
        }   
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
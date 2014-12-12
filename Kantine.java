/**
 * De klasse Kantine worden alle acties verwerkt. 
 * 
 * @author Eric Gunnink & Jelmer Postma 
 * @version 24-11-2014
 */
public class Kantine 
{
    private Kassa kassa;
    private KassaRij kassarij;
    public String Persoon;
    public String Dienblad;
    private Persoon persoon;
    private Dienblad dienblad;
    /**
      * Constructor van de klasse kantine
    */
   public Kantine() 
   {
       kassarij=new KassaRij();
       kassa=new Kassa(kassarij);
    }
    
    /**
    * In deze methode wordt een Persoon en Dienblad
    * gemaakt en aan elkaar
    * gekoppeld. Maak twee Artikelen aan en plaats
    * deze op het dienblad.
    * Tenslotte sluit de Persoon zich aan bij de rij
    * voor de kassa.
    
   */
    
     public void loopPakSluitAan()
     {
        persoon = new Persoon();
        dienblad = new Dienblad();
        persoon.pakDienblad();
        Artikel artikel1 = new Artikel();
        Artikel artikel2 = new Artikel();
        persoon.pakArtikel(artikel1);
        persoon.pakArtikel(artikel2);
        kassarij.sluitAchteraan(persoon);
     }
   
   /**
    * Deze methode handelt de rij voor de kassa af.
    */
    public void verwerkRijVoorKassa() 
    {
        while(kassarij.erIsEenRij() == true)
        {
            this.persoon = kassarij.eerstePersoonInRij();
            kassa.rekenAf(this.persoon);
        }
    }
    
    /**
    * Deze methode telt het geld uit de kassa
    * @return hoeveelheid geld in kassa
    */
   public double hoeveelheidGeldInKassa() 
   {
       return kassa.hoeveelheidGeld;
   }
   
     /**
    * Deze methode geeft het aantal gepasseerde artikelen.
    * @return het aantal gepasseerde artikelen
    */
   public int aantalArtikelen()
   {
       return kassa.aantalArtikelen;
   }
   
   /**
    * Deze methode reset de bijgehouden telling van
    * het aantal artikelen
    * en "leegt" de inhoud van de kassa.
    */
   public void resetKassa() 
    {
        kassa.resetKassa();
    }
}
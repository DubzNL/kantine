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
   private Persoon persoon;
   private KantineAanbod kantineAanbod;
   private Artikel artikel;
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
    * In deze methode kiest een Persoon met een dienblad
    * de artikelen in artikelnamen.
    * @param persoon
    * @artikelnamen
   */
   public void loopPakSluitAan(Persoon persoon, String[] artikelnamen)
   {    
       Artikel artikel;
       Dienblad dienblad = persoon.getDienblad();
       for(String artikelNaam : artikelnamen)
       {
           artikel = kantineAanbod.getArtikel(artikelNaam);
           persoon.getDienblad().voegToe(artikel);
       }
       kassarij.sluitAchteraan(persoon);

   }
   
   /**
    * Deze methode handelt de rij voor de kassa af.
    */
   public void verwerkRijVoorKassa() 
   {
        while(kassarij.erIsEenRij() == true)
        {
            Persoon persoon = kassarij.eerstePersoonInRij();
            kassa.rekenAf(persoon);
        }
   }
   /**
    * methode voor het aanroepen van de klasse Kassa
    * 
    */
   public Kassa getKassa()
   {
       return kassa;
    }
   /**
    *  Methode voor het aanroepen van de klasse KantineAanbod
    */ 
   public KantineAanbod getKantineAanbod()
   {
       return kantineAanbod;
   }
   /**
    *  Methode om een nieuwe instantie van KantineAanbod aan te maken
    * 
    */
   public void setKantineAanbod(String[] artikelnamen, double[] artikelprijzen, int[] hoeveelheden)
   {
       this.kantineAanbod = new KantineAanbod(artikelnamen, artikelprijzen, hoeveelheden);
    }
   
}
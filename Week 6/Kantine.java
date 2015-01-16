import java.util.*;
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
   // private Persoon persoon;
   private KantineAanbod kantineAanbod;
   //private Artikel artikel;
   //private Dienblad dienblad;
   // artikelen
    private ArrayList<String> artikelnamen;
   // private String[] artikelnamen;
    // prijzen
   // private ArrayList<double> artikelPrijzen;
    private ArrayList<Double> artikelPrijzen = new ArrayList<Double>();
    
    private ArrayList<Integer> hoeveelheden;
   
    /**
      * Constructor van de klasse kantine
    */
   public Kantine() 
   {
       kassarij=new KassaRij();
       kassa=new Kassa(kassarij);
       artikelnamen=new ArrayList<String>();
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
       //dienblad = persoon.getDienblad();
       for(String artikelNaam : artikelnamen)
       {
           if(kantineAanbod == null)
           {
               System.err.println("geen kantineaanbod");
            }
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
   public void setKantineAanbod(ArrayList<String> artikelnaam, ArrayList<Double> prijs, ArrayList<Integer> hoeveelheid)
   {
       this.kantineAanbod = new KantineAanbod(artikelnamen, artikelPrijzen, hoeveelheden);
    }
   
}
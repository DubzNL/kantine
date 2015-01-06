import java.util.ArrayList;
/**
 * Write a description of class Persoon here.
 * 
 * @author Eric Gunnink & Jelmer Postma
 * @version 1-12-2014
 */
public class Persoon
{
    // instance variables - replace the example below with your own
    private int bsn;
    private String voornaam;
    private String achternaam;
    private int geboortedag;
    private int geboortemaand;
    private int geboortejaar;
    private char geslacht;
    private Dienblad dienblad;
    private int aantalArtikelen;
    private double totaalPrijs;

    /**
     * Parameterloze constructor voor objecten van de klasse Persoon
     */
    public Persoon ()
    {
       geboortedag = 0;
       geboortemaand = 0;
       geboortejaar = 0;
       geslacht = 'O';
    }
    
    /**
     * Constructor voor objecten van de klasse Persoon
     */
    public Persoon(String voornaam, String achternaam, int geboortedag, int geboortemaand, int geboortejaar, char geslacht, int bsn)
    {
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.geboortedag = geboortedag;
        this.geboortemaand = geboortemaand;
        this.geboortejaar = geboortejaar;
        this.geslacht = geslacht;
        this.bsn = bsn;
    }

    /**
     * Voeg een voornaam toe aan de persoon.
     */
    public void setVoornaam(String voornaam)
    {
        this.voornaam = voornaam;
    }
    
    /**
     * Voeg een achternaam toe aan de persoon.
     */
    public void setAchternaam(String achternaam)
    {
        this.achternaam = achternaam;        
    }
    
    /**
     *  zet de waarde van bsn in private bsn
     */
    public void setBSN(int bsn)
    {
        this.bsn = bsn;
    }
    
    /**
     * Setter voor de geboorte datum wanneer deze correct is
     */
    private void setGeboortedatumChecked(int dag, int maand, int jaar)
    {
        
        if(jaar >= 1900 && jaar <= 2100){
         this.geboortedag = dag;
         this.geboortemaand = maand;
         this.geboortejaar = jaar;
        }else{
         this.geboortedag = 0;
         this.geboortemaand = 0;
         this.geboortejaar = 0;
        }
                    
    }
        
    /**
     * Controle of de ingevoerde datum correct is.
     */
    public void setGeboortedatum(int dag, int maand, int jaar)
    {
            if(maand == 1 || maand == 3 || maand == 5 || maand == 7 || maand == 8 || maand == 10 || maand == 12){
                if(dag >= 1 && dag <= 31){
                    setGeboortedatumChecked(dag, maand, jaar);
                }else{
                    setGeboortedatumChecked(dag, maand, jaar);
                }
            }else if(maand == 4 || maand == 6 || maand == 9 || maand == 11){
                if(dag >= 1 && dag <= 30){
                    setGeboortedatumChecked(dag, maand, jaar);
                }else{
                    setGeboortedatumChecked(dag, maand, jaar);
                }
            }else if(maand == 2){
                if(dag >= 1 && dag <= 28){
                    setGeboortedatumChecked(dag, maand, jaar);
                }else if(dag == 29)
                    {
                        if (((jaar % 4 == 0) && (jaar % 100 != 0)) || (jaar % 400 == 0) && (jaar >= 1900 && jaar <= 2100))
                        {
                        setGeboortedatumChecked(dag, maand, jaar);
                        }    
                        else
                        {
                        setGeboortedatumChecked(dag, maand, jaar);
                        }    
                    }
                    else
                    {
                    setGeboortedatumChecked(dag, maand, jaar);
                    }
            }else{
                setGeboortedatumChecked(dag, maand, jaar);
            }
    }
    
    /**
    * Get functie voor de geboortedatum. Geeft onbekend weer bij een ongeldige geboortedatum.
    */
    public String getGeboorteDatum()
    {
        String temp;
        if(geboortedag == 0 && geboortemaand == 0 && geboortejaar == 0){
            temp = "Onbekend";
        } else {
            temp = geboortedag + "/" + geboortemaand + "/" + geboortejaar;
        }
        return temp;
    }
    
    /**
     *  zet de waarde van geslacht in private geslacht
     */
    public void setGeslacht(char geslacht)
    {
        if(geslacht == 'V' || geslacht == 'M' || geslacht == 'm' || geslacht == 'v'){
           this.geslacht = geslacht;
        } else {
            this.geslacht = 'O';
        }
    }
    
    /**
     * Get functie voor het geslacht. bij waarde 'M' wordt Man weergegeven, bij de waarde 'V' wordt Vrouw weergegeven. Voor een
     * 'O' waarde komt er Onbekend
     */
    public String getGeslacht()
    {
        String tempGeslacht;
        if (geslacht == 'M' || geslacht == 'm'){
            tempGeslacht = "Man";
        }else if(geslacht == 'V' || geslacht == 'v'){
            tempGeslacht = "Vrouw";
        }else{
            tempGeslacht = "Onbekend";
        }
        return tempGeslacht;
    }
    
    /**
     * Get functie voor het BSN van de persoon
     */
    public int getBSN()
    {
        return bsn;
    }
    
    /**
     * Get functie voor de voornaam
     */
    public String getVoornaam()
    {
        return voornaam;
    }
    
    /**
     * Get functie voor de voornaam van de persoon
     */
    public String getAchternaam()
    {
        return achternaam;
    }
    
    /**
     * Print functie van alle informatie over de persoon.
     * BSN, Naam, Geboortedatum en geslacht.
     */
    public void printInfo()
    {
        System.out.println("Naam: " + voornaam + " " + achternaam);
        System.out.println("BSN: " + bsn);
        System.out.println("Geboortedatum: " + getGeboorteDatum());
        System.out.println("Geslacht: " + getGeslacht());
    }
    
    /** 
     * Methode om dienblad te koppelen aan een persoon 
     * @param dienblad */ 
   public void pakDienblad() 
   {    
       this.dienblad = new Dienblad();
   }
   
   /**
    * Methode om artikel te pakken en te plaatsen op het dienblad
    * @param artikel
    */
   public void pakArtikel(Artikel artikel)
   {
       if(dienblad != null)
        {
            dienblad.voegToe(artikel);
        }
        else
        {
            System.out.println("U heeft nog geen dienblad gepakt.");
        }
   }
   
   /**
    * Methode om de totaalprijs van de artikelen
    * op dienblad dat bij de persoon hoort uit te rekenen
    * @return De totaalrpijs
    */
   public double getTotaalPrijs()
   {
        double tempPrijs;
        if(dienblad != null)
        {
            tempPrijs = dienblad.getTotaalPrijs();
        }
        else
        {
            tempPrijs = 0.0;
        }
        return tempPrijs;
   }
   
   /**
    * Methode om het aantal artikelen op dienblad dat bij de
    * persoon hoort te tellen
    * @return Het aantal artikelen
    */
   public int getAantalArtikelen()
   {
       int tempAantal;
        if(dienblad != null)
        {
            tempAantal = dienblad.getAantalArtikelen();
        }
        else
        {
            tempAantal = 0;
        }
        return tempAantal;
   }
}
        


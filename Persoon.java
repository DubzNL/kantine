
/**
 * Write a description of class Persoon here.
 * 
 * @author Eric Gunnink 
 * @version 21-11-2014
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

    /**
     * Constructor for objects of class Persoon
     */
    public Persoon()
    {
        // initialise instance variables
        
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
     * 
     */
    public void setBSN(int bsn)
    {
        this.bsn = bsn;
    }
    
    /**
     * 
     */
    public void setGeboortedatum(int dag, int maand, int jaar)
    {
            if(maand == 1 || maand == 3 || maand == 5 || maand == 7 || maand == 8 || maand == 10 || maand == 12){
                if(dag >= 1 && dag <= 31){
                    if(jaar >= 1900 && jaar <= 2100){
                        geboortedag = dag;
                        geboortemaand = maand;
                        geboortejaar = jaar;
                    }else{
                        geboortedag = 0;
                        geboortemaand = 0;
                        geboortejaar = 0;
                    }
                }else{
                    geboortedag = 0;
                    geboortemaand = 0;
                    geboortejaar = 0;
                }
            }else if(maand == 4 || maand == 6 || maand == 9 || maand == 11){
                if(dag >= 1 && dag <= 30){
                    if(jaar >= 1900 && jaar <= 2100){
                        geboortedag = dag;
                        geboortemaand = maand;
                        geboortejaar = jaar;
                    }else{
                        geboortedag = 0;
                        geboortemaand = 0;
                        geboortejaar = 0;
                    }
                }else{
                    geboortedag = 0;
                    geboortemaand = 0;
                    geboortejaar = 0;
                }
            }else if(maand == 2){
                if(dag >= 1 && dag <= 28){
                    if(jaar >= 1900 && jaar <= 2100){
                        geboortedag = dag;
                        geboortemaand = maand;
                        geboortejaar = jaar;
                    }else{
                        geboortedag = 0;
                        geboortemaand = 0;
                        geboortejaar = 0;
                    }
                }else{
                    geboortedag = 0;
                    geboortemaand = 0;
                    geboortejaar = 0;
                }
            }else{
                geboortedag = 0;
                geboortemaand = 0;
                geboortejaar = 0;
            }
           }
        }


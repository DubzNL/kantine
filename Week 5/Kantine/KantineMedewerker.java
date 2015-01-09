
/**
 * Write a description of class KantineMedewerker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class KantineMedewerker extends Persoon implements KortingskaartHouder
{
    private boolean kassaToegang;
    
    /**
     * Constructor voor de subklasse Kantinemedewerker
     */
    public KantineMedewerker(boolean kassaToegang, int persoonBurgerServiceNummer, String persoonVoornaam, String persoonAchternaam, int persoonGeboorteDag, int persoonGeboorteMaand, int persoonGeboorteJaar, char persoonGeslacht)
    {
       super(persoonVoornaam, persoonAchternaam, persoonGeboorteDag, persoonGeboorteMaand, persoonGeboorteJaar, persoonGeslacht, persoonBurgerServiceNummer);
       this.kassaToegang = kassaToegang;
    }
    
    /**
     * constructor voor een object van de subklasse KantineMedewerker
     */
    public KantineMedewerker()
    {
        super();
        kassaToegang = false;
    }
     /**
     * methode voor het kortingspercentage te geven
     */
    public double geefKortingsPercentage()
    {
        return 0.35;
    }
     /** 
     *  methode om op te vragen of er maximum per keer aan de korting zit
     */
    public boolean heeftMaximum()
    {
        return false;
    }
    /**
     * methode om het maximum kortingsbedrag op te vragen
     */
    public double geefMaximum()
    {
        return 0.0;
    }
    
    /**
    * Methode voor het aanpassen van KassaToegang.
    */
    public void setKassaToegang(boolean kassaToegang)
    {
        this.kassaToegang = kassaToegang;
    }
    
    /**
     * Methode voor het krijgen van de waarde van Kassatoegang
     * @return kassaToegang
     */
    public boolean getKassatoegang()
    {
        return kassaToegang;
    }
   
    /**
     * Print gegevens KantineMedewerker
     */
    public void drukAf()
    {
        System.out.println("Kassatoegang:"+ getKassatoegang());
    }
    /**
     * String toString methode
     */
    public String toString()
    {
        return "Kassatoegang:"+ getKassatoegang();
    }
}

/**
 * Klasse Docent
 * 
 * @authors Eric Gunnink & Jelmer Postma
 * @versie 8-1-2014
 */

public class Docent extends Persoon
{
    private String afdeling;
    private String afkorting;
    
    /**
     * Constructor voor de subklasse Docent 
     */
    public Docent(String afkorting, String afdeling, int persoonBurgerServiceNummer, String persoonVoornaam, String persoonAchternaam, int persoonGeboorteDag, int persoonGeboorteMaand, int persoonGeboorteJaar, char persoonGeslacht)
    {
        super(persoonVoornaam, persoonAchternaam, persoonGeboorteDag, persoonGeboorteMaand, persoonGeboorteJaar, persoonGeslacht, persoonBurgerServiceNummer);
        this.afkorting = afkorting;
        this.afdeling = afdeling;
    }
    
    /**
     * Parameterloze constructor voor een object van de subklasse Docent
     */
    public Docent()
    {
        super();
        afkorting = "HEBL";
        afdeling = "Communicatie, Media & IT";
    }
    
    /**
     * Methode voor het aanpassen van afkorting
     * @param afkorting
     */
    public void setAfkorting(String afkorting)
    {
        this.afkorting = afkorting;
    }
    
    /**
     * Mehtode voor het aanpassen van afdeling
     * @param afdeling
     */
    public void setAfdeling(String afdeling)
    {
        this.afdeling = afdeling;
    }
    
    /**
     * Methode voor het krijgen van de waarde afdeling
     * @return afdeling
     */
    public String getAfdeling()
    {
        return afdeling;
    }
    
    /**
     * Methode voor het krijgen van de waarde afkorting
     * @return afkorting
     */
    public String getAfkorting()
    {
        return afkorting;
    }
         
    /**
     * print gegevens Docent.
     */
    public void drukAf()
    {
        System.out.println("Afdeling: "+ getAfdeling());
        System.out.println("Afkorting: "+ getAfkorting());
    }
    
}
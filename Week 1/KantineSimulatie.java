/**
* Deze klasse simuleert een in te vullen aantal dagen in de kantine. Hij maakt de objecten aan, en verwerkt ze.
* Hij geeft per dag aan hoeveel producten verkocht zijn en hoeveel geld er in de kassa zit.
*
* @gemaakt door Jelmer Postma & Eric Gunnink
* @version 05-12-2014
*/
public class KantineSimulatie
{   
    private Kantine kantine;
    
    /**
    * Constructor van een object voor de klasse kantinesimulatie
    */
    public KantineSimulatie()
    {
        kantine=new Kantine();
    }
    
    /**
    * Deze methode simuleert een aantal dagen in het
    * verloop van de kantine
    * @param dagen
    */
    public void simuleer(int dagen)
    {
        // for lus voor dagen
        for (int d=0; d<dagen; d++)
        {
            // per dag nu even vast 10+i personen naar binnen
            // laten gaan, wordt volgende week veranderd...
            // for lus voor personen
            
            int i=0;
            for (int j=0;j<10+i;j++)
            {
                kantine.loopPakSluitAan();
            }
            
            // verwerk rij voor de kassa
            // toon dagtotalen (artikelen en geld in kassa)
            // reset de kassa voor de volgende dag
            
            kantine.verwerkRijVoorKassa();
            System.out.println("");
            System.out.println("Totaal geld: " + kantine.hoeveelheidGeldInKassa());
            System.out.println("Aantal artikelen verkocht: "+ kantine.aantalArtikelen());
            kantine.resetKassa();
        }
    }
}
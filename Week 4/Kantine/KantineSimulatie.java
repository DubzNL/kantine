import java.util.*;
import java.text.*;
/**
* Deze klasse simuleert een in te vullen aantal dagen in de kantine. Hij maakt de objecten aan, en verwerkt ze.
* Hij geeft per dag aan hoeveel producten verkocht zijn en hoeveel geld er in de kassa zit.
*
* @gemaakt door Jelmer Postma & Eric Gunnink
* @version 06-01-2014
*/
public class KantineSimulatie 
{
    // kantine
    private Kantine kantine;
    
    // kantineaanbod
    private KantineAanbod kantineaanbod;
    
    // random generator
    private Random random;
    
    // aantal artikelen
    private static final int AANTAL_ARTIKELEN=4;
    
    // artikelen
    private static final String[] artikelnamen = new String[] {"Koffie", "Broodje pindakaas", "Broodje kaas", "Appelsap"};
    
    // prijzen
    private static double[] artikelprijzen= new double[]{1.50, 2.10, 1.65, 1.65};
    
    // minimum en maximum aantal artikelen per soort
    private static final int MIN_ARTIKELEN_PER_SOORT=10000;
    private static final int MAX_ARTIKELEN_PER_SOORT=20000;
    
    // minimum en maximum aantal personen per dag
    private static final int MIN_PERSONEN_PER_DAG=50;
    private static final int MAX_PERSONEN_PER_DAG=100;
    
    // minimum en maximum artikelen per persoon
    private static final int MIN_ARTIKELEN_PER_PERSOON=1;
    private static final int MAX_ARTIKELEN_PER_PERSOON=4;
    
    // Kans op soort persoon
    private static final int STUDENT_KANS = 89;
    private static final int DOCENT_KANS = 10;
    
    /**
     * Constructor
     */
    public KantineSimulatie(){
        kantine=new Kantine();
        random=new Random();
        int[] hoeveelheden=getRandomArray(AANTAL_ARTIKELEN,MIN_ARTIKELEN_PER_SOORT, MAX_ARTIKELEN_PER_SOORT);
        kantine.setKantineAanbod(artikelnamen, artikelprijzen, hoeveelheden);
    }
    
    /**
     * Methode om een array van random getallen liggend tussen min en max
     * van de gegeven lengte te genereren
     * @param lengte
     * @param min
     * @param max
     * @return De array met random getallen
     */
    
    private int[] getRandomArray(int lengte, int min, int max){
        int[] temp = new int[lengte];
        for(int i=0; i < lengte; i++){
            temp[i]=getRandomValue(min, max);
        }
        return temp;
    }
    
    /**
     * Methode om een random getal tussen min(incl) en
     * max(incl) te genereren.
     * @param min
     * @param max
     * @return Een random getal
     */
    
    private int getRandomValue(int min, int max){
        return random.nextInt(max-min+1)+min;
    }
    
    /**
     * Methode om op basis van een array van indexen voor de array
     * artikelnamen de bijhorende array van artikelnamen te maken
     * @param indexen
     * @return De array met artikelnamen
     */
    
    private String[] geefArtikelNamen(int[] indexen){
        String[] artikelen=new String[indexen.length];
        for(int i=0; i<indexen.length; i++){
            artikelen[i]= artikelnamen[indexen[i]];
        }
        return artikelen;
    }
    
    /**
     * Deze methode simuleert een aantal dagen in het
     * verloop van de kantine
     * @param dagen
     */
    
    public void simuleer(int dagen) 
    {
        //array met aantal artikelen per dag.
        int[] aantal = new int[dagen];
        //array met omzet per dag.
        double[] omzet = new double[dagen];
        for(int i=0;i<dagen;i++) {
            int aantalPersonen= getRandomValue(MIN_PERSONEN_PER_DAG, MAX_PERSONEN_PER_DAG);
            
            for(int j=0;j<aantalPersonen;j++) {
                Persoon persoon = new Persoon();
                persoon.pakDienblad();
                int[] tePakken=getRandomArray(AANTAL_ARTIKELEN, 0, AANTAL_ARTIKELEN-1);
                String[] artikelen=geefArtikelNamen(tePakken);
                kantine.loopPakSluitAan(persoon, artikelen);
                updateArtikelVoorraad(artikelen);
            }
            
            kantine.verwerkRijVoorKassa();
            DecimalFormat df = new DecimalFormat("#.##");
            int dag = i + 1;
            System.out.println("Dag: " + dag + "");
            System.out.println("Aantal klanten: " + aantalPersonen);
            System.out.println("Totaal geld: " + df.format(kantine.getKassa().hoeveelheidGeldInKassa()));
            System.out.println("Aantal artikelen verkocht: "+ kantine.getKassa().getAantalArtikelen());
            
            //dagtotalen aan arrays toevoegen.
            aantal[i] = kantine.getKassa().getAantalArtikelen();
            omzet[i] = kantine.getKassa().hoeveelheidGeldInKassa();
            
            System.out.println("Gemiddelde aantal artikelen per dag: " + Administratie.berekenGemiddeldAantal(aantal));         
            System.out.println("Gemiddelde omzet per dag: " + df.format(Administratie.berekenGemiddeldeOmzet(omzet)));
            kantine.getKassa().resetKassa();
        }
    }
    
    /**
     * Methode voor het updaten van de voorraad
     */
    private void updateArtikelVoorraad(String[] artikelen)
    {
        for(String artikel : artikelen)
        {
            // Check of voorraad onder minimum voorraad ligt
            if(kantine.getKantineAanbod().getArrayList(artikel).size() < MIN_ARTIKELEN_PER_SOORT)
            {
                // Verhoog de voorraad aan in KantineAanbod 
                
            }
        }
    }
    
    /**
     * Creeërt een persoon en verwerkt deze. Vervolgens sluit hij achteraan in de rij.
     */
    private void genereerPersoon() {
        int kans = getRandomValue(0, 100);
        Persoon persoon;
        if(kans <= STUDENT_KANS) {
            persoon = new Student();
        } else if (kans <= (STUDENT_KANS + DOCENT_KANS)) {
            persoon = new Docent();
        } else {
            persoon = new KantineMedewerker();
        }
        Dienblad dienblad = new Dienblad();
        persoon.pakDienblad();
        int aantalartikelen=getRandomValue(MIN_ARTIKELEN_PER_PERSOON, MAX_ARTIKELEN_PER_PERSOON);
        int[] tepakken=getRandomArray(aantalartikelen, 0, AANTAL_ARTIKELEN-1);
        String[] artikelen=geefArtikelNamen(tepakken);
        kantine.loopPakSluitAan(persoon, artikelen);
    }
}
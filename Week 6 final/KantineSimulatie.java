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
    private int aantalArtikelen;
    
    // artikelen
    private String[] artikelnamen;
    
    private int[] artikelaantal;
    // prijzen
    private double[] artikelprijzen;
    
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
    
    private static final String[] namenVanKlassen = new String[] {"Docent",  "KantineMedewerker", "Student"};

    private int[] personenBinnen;
    
    private ArrayList<String> artikelNaam = new ArrayList<String>();
    private ArrayList<Double> artikelPrijs = new ArrayList<Double>();
    private ArrayList<Double> artikelAantal = new ArrayList<Double>();
   
    
    /**
     * methode om artikelen toe te voegen
     * 
     */
    public void addArtikelen(double prijs, String naam, double aantal)
    {
        artikelNaam.add(naam);
        artikelPrijs.add(prijs);
        artikelAantal.add(aantal);
    }
    
    /**
     * Constructor
     */
    public KantineSimulatie(){
        kantine=new Kantine();
        random=new Random();
        
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
        if (artikelNaam.size() != 0){
            
            String[] artikelnamen = new String[artikelNaam.size()];
            double[] artikelprijzen = new double[artikelPrijs.size()];
            int[] artikelaantal = new int[artikelPrijs.size()];
            for (int arrayPositie=0; arrayPositie < artikelPrijs.size(); arrayPositie++)
            {
                artikelnamen[arrayPositie]=artikelNaam.get(arrayPositie);
                artikelprijzen[arrayPositie]=artikelPrijs.get(arrayPositie);
                artikelaantal[arrayPositie]=artikelAantal.get(arrayPositie).intValue();
            } 
            kantine.setKantineAanbod(artikelnamen, artikelprijzen, artikelaantal);
            this.artikelnamen=artikelnamen;
            this.aantalArtikelen=artikelNaam.size();
            
            
            //array met aantal artikelen per dag.
            int[] aantal = new int[dagen];
            //array met omzet per dag.
            double[] omzet = new double[dagen];
            DecimalFormat df = new DecimalFormat("#.##");
            
            for(int i=0;i<dagen;i++) {
                int aantalPersonen= getRandomValue(MIN_PERSONEN_PER_DAG, MAX_PERSONEN_PER_DAG);
                personenBinnen = new int[namenVanKlassen.length];
                for(int j=0;j<aantalPersonen;j++) {
                    Persoon persoon = genereerPersoon();
                    verwerkPersoon(persoon);
                    int[] tePakken=getRandomArray(aantalArtikelen, 0, aantalArtikelen-1);
                    String[] artikelen=geefArtikelNamen(tePakken);
                    //String[] artikelen=
                    kantine.loopPakSluitAan(persoon, artikelen);
                    updateArtikelVoorraad(artikelen);
                }
                printPersoonTotaal();
                kantine.verwerkRijVoorKassa();
                int dag = i + 1;
                System.out.println("Dag: " + dag + "");
                System.out.println("Aantal klanten: " + aantalPersonen);
                System.out.println("Totaal geld: " + df.format(kantine.getKassa().hoeveelheidGeldInKassa()));
                System.out.println("Aantal artikelen verkocht: "+ kantine.getKassa().getAantalArtikelen());
                System.out.println("");
    
                //dagtotalen aan arrays toevoegen.
                aantal[i] = kantine.getKassa().getAantalArtikelen();
                omzet[i] = kantine.getKassa().hoeveelheidGeldInKassa();
                
                
                kantine.getKassa().resetKassa();
            }
            
            System.out.println("Gemiddelde aantal artikelen per dag: " + Administratie.berekenGemiddeldAantal(aantal));         
            System.out.println("Gemiddelde omzet per dag: " + df.format(Administratie.berekenGemiddeldeOmzet(omzet)));
        }
        else{
            System.out.println("Er dienen eerst artikelen toegevoegd te worden voordat de simulatie wordt uitgevoerd");
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
     * Methode om persoon te genereren.
     * 
     */
     private Persoon genereerPersoon() {
        int kans = getRandomValue(0, 100);
        Persoon persoon;
            if(kans <= STUDENT_KANS) {
                persoon = new Student("2309", "HBO", "BSNnr2332", "Student", "AchternaamStudent", getRandomValue(1, 30), getRandomValue(1,12),getRandomValue(1950,2010), 'o', 01 );
            } else if (kans <= (STUDENT_KANS + DOCENT_KANS)) {
                persoon = new Docent("Dc","docent",1,"docent","docentAchternaam",1,2,2001,'o');
            } else {
                persoon = new KantineMedewerker(false, 1,"kantineMedewerker","KMachternaam",2,3,1999,'o');
            }
        Dienblad dienblad = new Dienblad();
        persoon.pakDienblad(dienblad);
        
        int betaaltype = getRandomValue(0, 1);
        Betaalwijze betaalwijze;
            if(betaaltype == 0) {
                betaalwijze = new Contant();
                betaalwijze.setSaldo(500);
            }
            else if(betaaltype == 1) {
                betaalwijze = new Pinpas();
                betaalwijze.setSaldo(500);
                Pinpas pinpas = (Pinpas) betaalwijze;
                if (getRandomValue(0,5) == 2)
                {
                    pinpas.setKredietLimiet(getRandomValue(0,200));
                }
            }
            else {
                betaalwijze = null;
            }
        persoon.setBetaalwijze(betaalwijze);
        return persoon;
    }
    /**
     *  telt het aantal personen per soort
     */
    private void verwerkPersoon(Persoon persoon)
    {
        
        if(persoon instanceof Docent)
        {
            //System.out.println("Dit is een Docent");
            personenBinnen[0]++;
        }
        else if(persoon instanceof KantineMedewerker)
        {
            //System.out.println("Dit is een KantineMedewerker");
            personenBinnen[1]++;
        }
        else if(persoon instanceof Student)
        {
            //System.out.println("Dit is een Student");
            personenBinnen[2]++;
        }
    }
    /**
     *  Geef het aantal personen per soort weer
     */
    private void printPersoonTotaal()
    {
        System.out.println("Personen die hebben bezocht");
        for(int i = 0 ; i< namenVanKlassen.length ; i++)
        {
            System.out.println(namenVanKlassen[i] + ": " + personenBinnen[i]);
        }
    }
}
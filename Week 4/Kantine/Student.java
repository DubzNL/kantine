
/**
 * Write a description of class Student here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Student extends Persoon
{
    private String studieRichting;
    private String studentNummer;
        
    /**
     * Constructor voor de subklasse student
     */
      public Student(String studentNummer, String studieRichting, String BurgerServiceNummer, String voornaam, String achternaam, int geboortedag, int geboortemaand, int geboortejaar, char geslacht, int bsn)
    {
        this.studentNummer = studentNummer;
        this.studieRichting = studieRichting;
    }
    public Student()
    {
        super();
        studentNummer = "123";
        studieRichting = "Informatica";
    }
    
    /**
     * Methode voor het aanpassen van StudentNummer
     */
    public void setstudentNummer(String studentNummer)
    {
        this.studentNummer = studentNummer;
    }
    
    /**
     * Methode voor het aanpassen van StudieRichting
     */
    public void setStudieRichting(String studieRichting)
    {
        this.studieRichting = studieRichting;
    }
    
    /**
     *  Methode voor het verkrijgen van het studentNummer van de student
     *  @return studentnummer
     */
    public String getStudentNummer()
    {
        return studentNummer;
    }
    
    /**
     * Methode voor het verkrijgen van het studentRichting van de student
     * @return studierichting
     */
    public String getStudieRichting()
    {
        return studieRichting;
    }
      
    /**
     * print gegevens student, Dit zijn StudentNummer en StudieRichting
     */
    public void drukAf()
    {
        System.out.println("StudentNummer: "+ getStudentNummer());
        System.out.println("StudieRichting: "+ getStudieRichting());
    }
}
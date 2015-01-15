
/**
 * Write a description of class TeWeinigGeldException here.
 * 
 * @author Jelmer Postma & Eric Gunnink
 * @version (14/01/2014)
 */
public class TeWeinigGeldException extends Exception
{
    

    /**
     * Constructor for objects of class TeWeinigGeldException
     */
    public TeWeinigGeldException()
    {
        super("Niet genoeg geld.");
    }

    public TeWeinigGeldException(Exception e)
    {
        super(e);
    }
    
    public TeWeinigGeldException(String message)
    {
        super(message);
    }
}

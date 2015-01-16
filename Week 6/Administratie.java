public class Administratie {
  private final static int DAYS_IN_WEEK = 7;
      /**
     * Lege private constructor
     */
  private Administratie()
  {
      //Leeg
  }  
    
    /**
   * Deze methode berekent van de int array aantal de 
   * gemiddelde waarde
   * @param aantal
   * @return het gemiddelde
   */
  public static double berekenGemiddeldAantal(int[] aantal) 
  {
      int arrayOpsomming=0;
      double returnwaarde;
      if( aantal == null)
      {
          return 0;
      }
      int lengte = aantal.length;
      if (lengte == 0)
      {
          returnwaarde = 0;
      }
      
      else
      {
          for(int arrayWaarde : aantal)
          {
              arrayOpsomming += arrayWaarde;  
          }
          returnwaarde = (double)arrayOpsomming / (double)lengte;
        }
      return returnwaarde;
  }

  /**
   * Deze methode berekent van de double array omzet de 
   * gemiddelde waarde
   * @param omzet
   * @return Het gemiddelde
   */
  public static double berekenGemiddeldeOmzet(double[] omzet) 
  {
      double arrayOpsomming=0;
      double returnwaarde;
      if( omzet == null)
      {
          returnwaarde = 0;
      }
      double lengte = omzet.length;
      if (lengte == 0)
      {
          returnwaarde = 0;
      }
      
      else
      {
          for(double arrayWaarde : omzet)
          {
              arrayOpsomming += arrayWaarde;  
          }
          returnwaarde = arrayOpsomming / lengte;
        }
      return returnwaarde;
  }
  
  /**
   * Methode om dagomzet uit te rekenen
   * @param omzet
   * @return array (7 elementen) met dagomzetten
   */
  
    public static double[] berekenDagOmzet(double[] omzet)
  {
      double lengte = omzet.length;
      double[] temp=new double[DAYS_IN_WEEK];
      int j=0;
      int k=0;
      while (lengte > 0)
      {
          temp[j] += omzet[k];
          k++;
          lengte--;
          if (j==6)
          {
              j=0;
          }
          else
          {
              j++;
          }
      }
      
      return temp;
  }
  
}

public class Administratie {
  /**
   * Deze methode berekent van de int array aantal de 
   * gemiddelde waarde
   * @param aantal
   * @return het gemiddelde
   */
  public double berekenGemiddeldAantal(int[] aantal) 
  {
      int arrayOpsomming=0;
      int returnwaarde;
      if( aantal == null)
      {
          returnwaarde = 0;
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
          returnwaarde = arrayOpsomming / lengte;
        }
      return returnwaarde;
  }

  /**
   * Deze methode berekent van de double array omzet de 
   * gemiddelde waarde
   * @param omzet
   * @return Het gemiddelde
   */
  public double berekenGemiddeldeOmzet(double[] omzet) 
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
}

package dailyQuest;

import exceptions.Day07Exception;

public class Daily07 {
  public static void main(String[] args) {
    
    try {
      simpleCalculation();
    } catch (Day07Exception e) {
      System.out.println(e.getMessage());
    }
    System.out.println("End");
  }
  
  public static void simpleCalculation() throws Day07Exception {
    int x = 10;
    int y = 0;
    int z;
    
    z = x / y;
    System.out.println("z = " + z);
  }
}

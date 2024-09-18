package warmup1;

public class StartHi {
  public static boolean startHi(String str) {
    String[] arrOfSting = str.trim().split(" ", 2);
    return arrOfSting[0].equals("hi");
  }
}

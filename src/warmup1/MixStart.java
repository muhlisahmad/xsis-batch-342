package warmup1;

public class MixStart {
  public static boolean mixStart(String str) {
    String[] arrOfStr = str.trim().split(" ", 2);
    return (arrOfStr[0].length() == 3 && arrOfStr[0].substring(1).equals("ix"));
  }
}

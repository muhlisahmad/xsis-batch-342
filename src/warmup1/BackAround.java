package warmup1;

public class BackAround {
  public static String backAround(String str) {
    return str.charAt(str.length() - 1) + str + str.charAt(str.length() - 1);
  }
}

package warmup1;

public class NotString {
  public static String notString(String str) {
    String[] arrOfStr = str.trim().split(" ", 2);
    if (arrOfStr[0].equals("not")) {
      return str;
    } else {
      return "not " + str;
    }
  }
}

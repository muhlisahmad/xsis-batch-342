package codewars;

public class RegexValidation {
  private static boolean validateTime(String time) {
    return time.matches("^((([0-1]\\d|2[0-3])|(\\d)):[0-5]\\d)$");
  }

  public static void main(String[] args) {
    System.out.println(validateTime("01:00"));  // true
    System.out.println(validateTime("1:00"));   // true
    System.out.println(validateTime("00:00"));  // true
    System.out.println(validateTime("13:1"));   // false
    System.out.println(validateTime("12:60"));  // false
  }
}

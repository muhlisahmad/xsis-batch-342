package codewars;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RemoveTime {
  public static String shortenToDate(String longDate) {
    String upperCaseDate = longDate.substring(0, longDate.length() - 2) + longDate.substring(longDate.length() - 2).toUpperCase();
    LocalDateTime localDateTime = LocalDateTime.parse(upperCaseDate, DateTimeFormatter.ofPattern("EEEE MMMM d, ha"));
    return localDateTime.format(DateTimeFormatter.ofPattern("EEEE MMMM d"));
  }

  public static void main(String[] args) {
    System.out.println(shortenToDate("Friday May 2, 9am"));
  }
}

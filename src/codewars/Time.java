package codewars;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Time {
  public static String convertTime(String time) {
    LocalTime localTime = LocalTime.parse(time, DateTimeFormatter.ofPattern("hh:mm:ssa"));
    return localTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
  }

  public static void main(String[] args) {
    System.out.println(convertTime("07:05:45PM"));
    System.out.println(convertTime("07:05:45AM"));
  }
}

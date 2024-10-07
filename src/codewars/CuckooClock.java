package codewars;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class CuckooClock {
  private static String cuckooClock(String inputTime, int chimes) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
    LocalTime clockTime = LocalTime.parse(inputTime, formatter);
    int chimesSum = 0;
    while (chimesSum < chimes) {
      if (clockTime.getMinute() == 0) {
        chimesSum += clockTime.getHour();
        if (chimesSum >= chimes) break;
      } else if (clockTime.getMinute() % 15 == 0) {
        chimesSum++;
      }
      clockTime = clockTime.plusMinutes(1);
    }

    return clockTime.format(formatter);
  }
  public static void main(String[] args) {
    LocalTime localTime = LocalTime.of(23, 59, 30);
    System.out.println(localTime);
    System.out.println(localTime.plusMinutes(1).getMinute());
    System.out.println(localTime.plusMinutes(1).getHour());
    System.out.println(localTime.getMinute());

    System.out.println();
  }
}

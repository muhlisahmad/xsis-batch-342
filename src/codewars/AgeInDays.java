package codewars;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class AgeInDays {
  public static String ageInDays(int year, int month, int day) {
    LocalDate birthday = LocalDate.of(year, month, day);
    return new StringBuilder("You are ")
      .append(ChronoUnit.DAYS.between(birthday, LocalDate.now()))
      .append(" days old")
      .toString();
  }

  public static void main(String[] args) {
    System.out.println(ageInDays(LocalDate.now().minusYears(1).getYear(), LocalDate.now().minusYears(1).getMonthValue(), LocalDate.now().minusYears(1).getDayOfMonth()));
  }
}

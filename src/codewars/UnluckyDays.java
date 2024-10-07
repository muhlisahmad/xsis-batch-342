package codewars;

import java.time.LocalDate;

public class UnluckyDays {
  private static int unluckyDays(int year) {
    int sum = 0;
    LocalDate begin = LocalDate.ofYearDay(year, 1);
    while (begin.getYear() == year) {
      begin = begin.plusDays(1);
      if (begin.getDayOfWeek().toString().equals("FRIDAY") && begin.getDayOfMonth() == 13) {
        sum++;
      }
    }
    return sum;
  }
  public static void main(String[] args) {
    System.out.println(unluckyDays(2015));
    System.out.println(unluckyDays(1986));
    // LocalDate localDate = LocalDate.ofYearDay(2015, 1);
    // System.out.println(localDate.plusDays(1).getDayOfWeek());
    // System.out.println(localDate.getDayOfMonth());
    // System.out.println(localDate.plusDays(1).getDayOfMonth());
    // System.out.println(localDate.getYear());
    // System.out.println(localDate.getDayOfWeek().toString().equals("THURSDAY"));
  }
}

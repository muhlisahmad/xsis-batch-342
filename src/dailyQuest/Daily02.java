package dailyQuest;

import java.lang.StringBuilder;
public class Daily02 {
  public static String dayName(int nth) {
    switch (nth) {
      case 1:
        return "senin";
      case 2:
        return "selasa";
      case 3:
        return "rabu";
      case 4:
        return "kamis";
      case 5:
        return "jumat";
      case 6:
        return "sabtu";
      case 7:
        return "minggu";
      default:
        return "There's only 7 days a week";
    }
  }

  public static int dayNumber(String day) {
    String cleanStrDay = day.trim().toLowerCase();
    switch (cleanStrDay) {
      case "senin":
        return 1;
      case "selasa":
        return 2;
      case "rabu":
        return 3;
      case "kamis":
        return 4;
      case "jumat":
        return 5;
      case "sabtu":
        return 6;
      case "minggu":
        return 7;
      default:
        return -1;
    }
  }

  public static void weekComposition(String day) {
    String cleanStrDay = day.trim().toLowerCase();
    int nthDay = dayNumber(cleanStrDay);
    if (nthDay == -1) {
      System.out.println("Invalid day");
      return;
    }

    System.out.println("kemarin lusa adalah hari " + dayName(nthDay <= 2 ? (7 - 2) + nthDay : nthDay - 2));
    System.out.println("kemarin adalah hari " + dayName(nthDay == 1 ? 7 : nthDay - 1));
    System.out.println("hari ini adalah hari " + cleanStrDay);
    System.out.println("besok adalah hari " + dayName(nthDay == 7 ? 1 : nthDay + 1));
    System.out.println("besok lusa adalah hari " + dayName(nthDay >= 6 ? 2 - (7 - nthDay) : nthDay + 2));
  }

  public static String leapYear(int year) {
    if (year > 2024) {
      return "Year out of range";
    }

    StringBuilder strBuilder = new StringBuilder();
    for (int i = 0; i <= 2024 - year; i++) {
      if ((year + i) % 4 == 0) {
        if ((year + i) % 100 == 0) {
          if ((year + i) % 400 == 0) {
            strBuilder.append(i == 0 ? "" + (year + i) : ", " + (year + i));
          } else {
            continue;
          }
        } else {
          strBuilder.append(i == 0 ? "" + (year + i) : ", " + (year + i));
        }
      }
    }

    return strBuilder.toString();
  }

  public static void oddEvenAddition(int n) {
    if (n <= 0) {
      System.out.println("n numbers must be more than 0");
    }
    for (int i = 1; i <= n*2; i += 2) {
      System.out.println(i + " + " + (i + 1) + " = " + (i + (i + 1)));
    }
  }
}

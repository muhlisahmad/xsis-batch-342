package dailyQuest;

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

  public static String dayNumber(String day) {
    String cleanStrDay = day.trim().toLowerCase();
    switch (cleanStrDay) {
      case "senin":
        return "1";
      case "selasa":
        return "2";
      case "rabu":
        return "3";
      case "kamis":
        return "4";
      case "jumat":
        return "5";
      case "sabtu":
        return "6";
      case "minggu":
        return "7";
      default:
        return "Invalid day";
    }
  }

  public static void weekComposition(String day) {
    String cleanStrDay = day.trim().toLowerCase();
    if (!(cleanStrDay.equals("senin") ||
          cleanStrDay.equals("selasa") ||
          cleanStrDay.equals("rabu") ||
          cleanStrDay.equals("kamis") ||
          cleanStrDay.equals("jumat") ||
          cleanStrDay.equals("sabtu") ||
          cleanStrDay.equals("minggu")
    )) {
      System.out.println("Invalid day");
    } else {
      int nthDay = Integer.parseInt(dayNumber(cleanStrDay));
  
      System.out.println("kemarin lusa adalah hari " + dayName(nthDay <= 2 ? (7 - 2) + nthDay : nthDay - 2));
      System.out.println("kemarin adalah hari " + dayName(nthDay == 1 ? 7 : nthDay - 1));
      System.out.println("hari ini adalah hari " + cleanStrDay);
      System.out.println("besok adalah hari " + dayName(nthDay == 6 ? 7 : nthDay + 1));
      System.out.println("besok lusa adalah hari " + dayName(nthDay >= 6 ? 2 - (7 - nthDay) : nthDay + 2));
    }

  }
}

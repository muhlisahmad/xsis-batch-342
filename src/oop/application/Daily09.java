package oop.application;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import oop.data.ParkingLot;

public class Daily09 {
  public static void number3() {
    Scanner sc = new Scanner(System.in);
    ParkingLot parkingLot;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    
    while (true) {
      System.out.print("Masukkan waktu check-in\t: ");
      String checkIn = sc.nextLine();
      if (checkIn.matches("^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])\\s([01]\\d|2[0-3]):[0-5]\\d:[0-5]\\d$")) {
        try {
          parkingLot = new ParkingLot(LocalDateTime.parse(checkIn, formatter));
          break;
        } catch (DateTimeException e) {
          System.out.println(e.getCause().getMessage());
          continue;
        }
      } else {
        System.out.println("Invalid input!!!\n");
        continue;
      }
    }

    while (true) {
      System.out.print("Masukkan waktu check-out\t: ");
      String checkOut = sc.nextLine();
      if (checkOut.matches("^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])\\s([01]\\d|2[0-3]):[0-5]\\d:[0-5]\\d$")) {
        try {
          parkingLot.checkOut(LocalDateTime.parse(checkOut, formatter));
          break;
        } catch (IllegalArgumentException e) {
          System.out.println(e.getMessage());
          continue;
        }
      } else {
        System.out.println("Invalid input!!!\n");
        continue;
      }
    }

    System.out.println("Harga parkir\t: " + parkingLot.getPrice());
    sc.close();
  }

  public static String onlineShop(int initialDate, String initialDay, Set<Integer> holidayList) {
    ArrayList<String> days = new ArrayList<>(List.of("senin", "selasa", "rabu", "kamis", "jumat", "sabtu", "minggu"));
    int duration = 7;
    int endDate = initialDate;
    int initialIndex = days.indexOf(initialDay);
    boolean nextMonth = false;

    while (duration != 1) {
      if (days.get(initialIndex % 7).equals("sabtu") || days.get(initialIndex % 7).equals("minggu") || holidayList.contains(endDate)) {
        endDate++;
        initialIndex++;
      } else {
        duration--;
        endDate++;
        initialIndex++;
      }
    }

    if (Math.floorDiv(endDate, 31) > 0 && endDate != 31) {
      nextMonth = true;
    }

    return nextMonth ? "tanggal " + endDate % 31 + " di bulan selanjutnya" : "tanggal " + endDate;
  }

  public static void number5() {
    System.out.println(onlineShop(25, "sabtu", Set.of(26, 29)));
  }
}

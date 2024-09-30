package oop.application;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
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

    return nextMonth ? "tanggal " + endDate % 31 + " di bulan selanjutnya" : "tanggal " + endDate + 1;
  }

  public static void number5() {
    Scanner sc = new Scanner(System.in);
    String day = null;
    String tryAgain = null;
    int date = 0;
    HashSet<Integer> holidays = new HashSet<>();

    while (true) {
      while (true) {
        System.out.print("Masukkan hari pesan\t\t\t\t: ");
        day = sc.nextLine().trim().toLowerCase();
        if (
          day.equals("senin") ||
          day.equals("selasa") ||
          day.equals("rabu") ||
          day.equals("kamis") ||
          day.equals("jumat") ||
          day.equals("sabtu") ||
          day.equals("minggu")
          ) 
        {
          break;
        } else {
          System.out.println("Invalid input!!!\n");
          continue;
        }
      }

      while (true) {
        System.out.print("Masukkan tanggal pesan\t\t\t\t: ");
        String dateString = sc.nextLine();
        if (!dateString.matches("^(0[1-9]|[12]\\d|3[01])$")) {
          System.out.println("Invalid input!!!\n");
          continue;
        } else {
          date = Integer.parseInt(dateString);
          break;
        }
      }

      while (holidays.size() < 31) {
        System.out.print("Masukkan hari libur nasional (press q to quit)\t: ");
        String holidayDate = sc.nextLine();
        if (!holidayDate.matches("^(0[1-9]|[12]\\d|3[01])|q$")) {
          System.out.println("Invalid input!!!\n");
          continue;
        } else {
          if (holidayDate.matches("^(0[1-9]|[12]\\d|3[01])$")) {
            holidays.add(Integer.valueOf(holidayDate));
            continue;
          } else if (holidayDate.equals("q")) {
            break;
          } else {
            System.out.println("Invalid input!!!\n");
            continue;
          }
        }
      }

      System.out.println(onlineShop(date, day, holidays));

      while (true) {
        System.out.print("Pesan lagi? (Y/n)\t\t\t\t: ");
        tryAgain = sc.nextLine();
        if (!(tryAgain.trim().equalsIgnoreCase("y") || tryAgain.trim().equalsIgnoreCase("n"))) {
          System.out.println("Invalid Input!!!\n");
          continue;
        } else {
          break;
        }
      }

      if (tryAgain.trim().equalsIgnoreCase("n")) {
				break;
			} else {
        continue;
      }
    }

    sc.close();
  }
}

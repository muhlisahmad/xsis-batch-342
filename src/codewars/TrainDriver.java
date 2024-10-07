package codewars;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TrainDriver {
  private static String arrivalTime(final String[] route, final String departureTime) {
    List<Map<String, Object>> trainDrivers = new ArrayList<>(){{
      add(new LinkedHashMap<>(
        Map.of(
          "origin", "Skyport",
          "destination", "Crystalium",
          "standByTime", 15,
          "tripDuration", 120
        )
      ));
      add(new LinkedHashMap<>(
        Map.of(
          "origin", "Crystalium",
          "destination", "Skyport",
          "standByTime", 10,
          "tripDuration", 120
        )
      ));
      add(new LinkedHashMap<>(
        Map.of(
          "origin", "Skyport",
          "destination", "Oasis",
          "standByTime", 20,
          "tripDuration", 180
        )
      ));
      add(new LinkedHashMap<>(
        Map.of(
          "origin", "Oasis",
          "destination", "Skyport",
          "standByTime", 15,
          "tripDuration", 180
        )
      ));
      add(new LinkedHashMap<>(
        Map.of(
          "origin", "Oasis",
          "destination", "Crystalium",
          "standByTime", 15,
          "tripDuration", 90
        )
      ));
      add(new LinkedHashMap<>(
        Map.of(
          "origin", "Crystalium",
          "destination", "Oasis",
          "standByTime", 10,
          "tripDuration", 90
        )
      ));
      add(new LinkedHashMap<>(
        Map.of(
          "origin", "Skyport",
          "destination", "Nexus",
          "standByTime", 15,
          "tripDuration", 240
        )
      ));
      add(new LinkedHashMap<>(
        Map.of(
          "origin", "Nexus",
          "destination", "Skyport",
          "standByTime", 10,
          "tripDuration", 240
        )
      ));
    }};
    LocalTime departure = LocalTime.parse(departureTime, DateTimeFormatter.ofPattern("HH:mm"));
    String depart = "Skyport";

    for (String station: route) {
      for (Map<String,Object> driver : trainDrivers) {
        if (driver.get("origin").equals(depart) && driver.get("destination").equals(station)) {
          departure = departure.plusMinutes((Integer) driver.get("standByTime")).plusMinutes((Integer) driver.get("tripDuration"));
        } else if (depart.equals(station)) {
          departure = departure.plusHours(1);
        }
      }
      depart = station;
    }
    
    return departure.format(DateTimeFormatter.ofPattern("HH:mm"));
  }

  public static void main(String[] args) {
    // Integer int1 = 2313;
    // Float float1 = 231.9f;

    // System.out.println(float1.intValue());
    System.out.println(arrivalTime(new String[] {"Crystalium"}, "10:00"));
    System.out.println(arrivalTime(new String[] {"Crystalium", "Skyport", "Oasis"}, "10:00"));
    System.out.println(arrivalTime(new String[] {"Nexus", "Skyport", "Oasis"}, "21:30"));
    System.out.println(arrivalTime(new String[] {"Skyport"}, "22:00"));
    System.out.println(arrivalTime(new String[] {"Crystalium", "Nexus"}, "12:00"));
  }
}

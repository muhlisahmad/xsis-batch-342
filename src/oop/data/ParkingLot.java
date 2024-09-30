package oop.data;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class ParkingLot {
  private LocalDateTime checkInDateTime;
  private long price;
  
  public ParkingLot() {
    this.checkInDateTime = LocalDateTime.now();
  }

  public ParkingLot(LocalDateTime checkInDateTime) {
    this.checkInDateTime = checkInDateTime;
  }

  public void checkOut(LocalDateTime checkout) {
    if (checkInDateTime.compareTo(checkout) < 0) {
      throw new IllegalArgumentException("Check-Out Time cannot be before Check-In Time");
    }

    long timeDiff = ChronoUnit.HOURS.between(checkInDateTime, checkout);
    if (timeDiff >= 8 && timeDiff <= 24) {
      price = 8000L;
    } else if (timeDiff > 24) {
      price = (Math.floorDiv(timeDiff, 24) * 15000) + timeDiff % 24 >= 8 && timeDiff % 24 < 24 ? (timeDiff % 24) * 8000 : (timeDiff % 24) * 1000;
    } else {
      price = timeDiff * 1000;
    }
  }

  public LocalDateTime getCheckInDateTime() {
    return checkInDateTime;
  }

  public long getPrice() {
    return price;
  }
}

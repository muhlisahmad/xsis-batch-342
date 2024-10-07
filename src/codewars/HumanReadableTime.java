package codewars;

import java.time.Duration;

public class HumanReadableTime {
  public static String makeReadable(int seconds) {
    Duration duration = Duration.ofSeconds(seconds);
    
    return new StringBuilder(duration.toHours() > 9 ? String.valueOf(duration.toHours()) : "0" + duration.toHours())
              .append(":")
              .append(duration.toMinutesPart() > 9 ? String.valueOf(duration.toMinutesPart()) : "0" + duration.toMinutesPart())
              .append(":")
              .append(duration.toSecondsPart() > 9 ? String.valueOf(duration.toSecondsPart()) : "0" + duration.toSecondsPart())
              .toString();
  }

  public static void main(String[] args) {
    System.out.println(makeReadable(0));
    System.out.println(makeReadable(359999));
  }
}

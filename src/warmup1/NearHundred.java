package warmup1;

public class NearHundred {
  public static boolean nearHundred (int num) {
    return (Math.abs(num - 100) <= 10 || Math.abs(num - 200) <= 10);
  }
}

// import warmup1.*;
import daily2.*;
import java.util.Arrays;
public class Main {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(Daily.minMax(2, 8, 9, 4))); // not candy
    System.out.println(Arrays.toString(Daily.minMax(9, 12, 42, 32))); // not candy
    System.out.println(Arrays.toString(Daily.minMax(82, 231, 322, 231))); // not candy
  }
}
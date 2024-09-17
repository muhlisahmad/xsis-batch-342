import warmup1.*;

public class Main {
  public static void main(String[] args) {
    System.out.println(PosNeg.posNeg(1, -1, false)); // true
    System.out.println(PosNeg.posNeg(-1, 1, false)); // true
    System.out.println(PosNeg.posNeg(-4, -5, true)); // true
  }
}
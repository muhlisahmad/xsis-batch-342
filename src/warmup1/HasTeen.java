package warmup1;

public class HasTeen {
  public static boolean hasTeen(int a, int b, int c) {
    int[] ages = new int[] {a, b, c};
    boolean result = false;
    for (var age : ages) {
      if (age >= 13 && age <= 19) {
        result = true;
        break;
      }
    }
    return result;
  }
}

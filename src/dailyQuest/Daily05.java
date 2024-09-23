package dailyQuest;

public class Daily05 {
  public static void strokeAsteriskArray(int size) {
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        System.out.print((i == 0 || i == size - 1 || j == 0 || j == size - 1) ? "* " : "  ");
      }
      System.out.println();
    }
  }

  public static void crossAsteriskArray(int size) {
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        System.out.print((i == j || i == size - 1 - j) ? "* " : "  ");
      }
      System.out.println();
    }
  }
}

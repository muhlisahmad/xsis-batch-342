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

  public static String[][] strokeReturnArray(int size) {
    String[][] result = new String[size][size];
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        result[i][j] = (i == 0 || i == size - 1 || j == 0 || j == size - 1) ? "* " : "  ";
      }
    }
    return result;
  }

  public static String[][] crossReturnArray(int size) {
    String[][] result = new String[size][size];
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        result[i][j] = (i == j || i == size - 1 - j) ? "* " : "  ";
      }
    }
    return result;
  }

  public static void reversedArray(int size) {
    int substract = 0;
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        System.out.print(size * size - substract + "\t");
        substract++;
      }
      System.out.println();
    }
  }

  public static int[][] oddEvenArray(int size) {
    int num = 1;
    int[][] result = new int[size][size];
    for (int i = 0; i < size; i+=2) {
      for (int j = 0; j < size; j++) {
        result[i][j] = num;
        if (i+1 < size) {
          result[i+1][j] = num + 1;
        }
        num+=2;
      }
    }
    return result;
  }
}

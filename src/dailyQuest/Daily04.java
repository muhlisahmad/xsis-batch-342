package dailyQuest;

public class Daily04 {
  /*
   * 1. Dengan menggunakan scanner, Buatlah function untuk mencetak matrix dengan parameter sebagai size
   *    matrix nya(kotak). munculkan index nya.
   * 2. Dengan menggunakan scanner, Buatlah function untuk mencetak matrix dengan parameter column and row
   *    sebagai ukuran matrix nya. munculkan index nya.
   * 3. Sama seperti soal nomer 1 dan 2, tetapi cetak bintang(*)
   */
  
  public static void indexSquareArray(int n) {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        System.out.print((i == 0 && j == 0) ? "[[" + i + ", " + j + "]; " : (j == 0) ? " [" + i + ", " + j + "]; " : (i == n - 1 && j == n - 1) ? "[" + i + ", " + j + "]]" : "[" + i + ", " + j + "]; ");
      }
      System.out.println();
    }
  }

  public static void indexArray(int rows, int cols) {
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        System.out.print((i == 0 && j == 0) ? "[[" + i + ", " + j + "]; " : (j == 0) ? " [" + i + ", " + j + "]; " : (i == rows - 1 && j == cols - 1) ? "[" + i + ", " + j + "]]" : "[" + i + ", " + j + "]; ");
      }
      System.out.println();
    }
  }

  public static void asteriskArray(int rows, int cols) {
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        System.out.print("* ");
      }
      System.out.println();
    }
  }
}

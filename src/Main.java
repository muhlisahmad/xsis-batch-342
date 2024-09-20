// import warmup1.*;
// import java.util.Arrays;
import java.util.Scanner;

import dailyQuest.*;
public class Main {
  public static void main(String[] args) {
    // System.out.println(Arrays.toString(Daily.minMax(2, 8, 9, 4))); // not candy
    // System.out.println(Arrays.toString(Daily.minMax(9, 12, 42, 32))); // not candy
    // System.out.println(Arrays.toString(Daily.minMax(82, 231, 322, 231))); // not candy

    Scanner scannerInput = new Scanner(System.in);

    // System.out.print("Insert n numbers of fibonacci sequence to be return: ");
    // int nFibonacci = scannerInput.nextInt();
    // Daily.nFibonacciSequence(nFibonacci);
    
    // System.out.println();
    // System.out.print("Insert n numbers of factorials to be return: ");
    // int nFactorial = scannerInput.nextInt();
    // System.out.println(Daily.nFactorial(nFactorial));

    // System.out.print("Insert n numbers for n*n size unit matrix: ");
    // int nSizeMatrix = scannerInput.nextInt();
    // System.out.println(Arrays.deepToString(Daily.nSizeUnitMatrix(nSizeMatrix)));
    // for (int[] row : Daily01.nSizeUnitMatrix(nSizeMatrix)) {
    //   System.out.println(Arrays.toString(row));
    // }

    // System.out.print("Insert nth day in a week: ");
    // int nthDay = scannerInput.nextInt();
    // System.out.println(Daily02.dayName(nthDay));
    // System.out.print("Insert day name: ");
    // String dayName = scannerInput.next();
    // System.out.println(Daily02.dayNumber(dayName));

    // System.out.print("Insert day: ");
    // String dayName = scannerInput.next();
    // Daily02.weekComposition(dayName);

    // System.out.print("Insert year: ");
    // int year = scannerInput.nextInt();
    // Daily03.leapYear(year);

    // System.out.print("Insert n numbers of additions: ");
    // int nAddition = scannerInput.nextInt();
    // Daily03.oddEvenAddition(nAddition);

    // System.out.print("Insert the size of n*n square array: ");
    // int nSize = scannerInput.nextInt();
    // Daily04.indexSquareArray(nSize);

    // System.out.println("\nInsert the size of n*m array");
    // System.out.print("row size\t: ");
    // int rowSize = scannerInput.nextInt();
    // System.out.print("column size\t: ");
    // int colSize = scannerInput.nextInt();
    // Daily04.indexArray(rowSize, colSize);
    
    // System.out.println("\nInsert the size of n*m array to print out asterisk");
    // System.out.print("row size\t: ");
    // int asteriskRow = scannerInput.nextInt();
    // System.out.print("column size\t: ");
    // int asteriskCol = scannerInput.nextInt();
    // Daily04.asteriskArray(asteriskRow, asteriskCol);

    System.out.print("Insert the height of the left triangle\t: ");
    int leftHeight = scannerInput.nextInt();
    System.out.print("Wanna print out as asterisk (Y/n)\t: ");
    String isLeftAsteriskInput = scannerInput.next();
    boolean isLeftAsterisk = isLeftAsteriskInput.equalsIgnoreCase("y");
    Daily04.leftTriangle(leftHeight, isLeftAsterisk);

    System.out.print("Insert the height of the right triangle\t: ");
    int rightHeight = scannerInput.nextInt();
    System.out.print("Wanna print out as asterisk (Y/n)\t: ");
    String isRightAsteriskInput = scannerInput.next();
    boolean isRightAsterisk = isRightAsteriskInput.equalsIgnoreCase("y");
    Daily04.rightTriangle(rightHeight, isRightAsterisk);

    scannerInput.close();
  }
}
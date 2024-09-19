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

    System.out.print("Insert year: ");
    int year = scannerInput.nextInt();
    Daily02.leapYear(year);

    System.out.print("Insert n numbers of additions: ");
    int nAddition = scannerInput.nextInt();
    Daily02.oddEvenAddition(nAddition);
;
    scannerInput.close();
  }
}
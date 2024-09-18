// import warmup1.*;
import java.util.Scanner;

import daily2.*;
public class Main {
  public static void main(String[] args) {
    // System.out.println(Arrays.toString(Daily.minMax(2, 8, 9, 4))); // not candy
    // System.out.println(Arrays.toString(Daily.minMax(9, 12, 42, 32))); // not candy
    // System.out.println(Arrays.toString(Daily.minMax(82, 231, 322, 231))); // not candy

    Scanner scannerInput = new Scanner(System.in);
    System.out.print("Insert n numbers of fibonacci sequence to be return: ");
    int nFibonacci = scannerInput.nextInt();
    Daily.nFibonacciSequence(nFibonacci);
    
    System.out.println();
    System.out.print("Insert n numbers of factorials to be return: ");
    int nFactorial = scannerInput.nextInt();
    System.out.println(Daily.nFactorial(nFactorial));

    scannerInput.close();
  }
}
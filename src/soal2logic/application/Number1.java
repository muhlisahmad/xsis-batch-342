package soal2logic.application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Number1 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    List<Integer> result;

    while (true) {
      System.out.print("Insert nth of odd numbers to be printed out\t: ");
      try {
        int nthOdd = sc.nextInt();
        sc.nextLine();
        if (nthOdd < 1) {
          System.out.println("Invalid input!!!\n");
          continue;
        }
        result = nthOddNumbers(nthOdd);
        break;
      } catch (InputMismatchException e) {
        System.out.println("Invalid input!!!\n");
        sc.nextLine();
        continue;
      }
    }

    Integer lastNumber = result.getLast();
    Integer lastNumberReversed = result.reversed().getLast();
    result.forEach(number -> System.out.print(number + (lastNumber == number ? "\n" : " ")));
    result.reversed().forEach(number -> System.out.print(number + (lastNumberReversed == number ? "\n" : " ")));
    sc.close();
  }

  private static List<Integer> nthOddNumbers(int n) {
    List<Integer> oddNumbers = new ArrayList<>();

    for (int i = 1; i <= (n * 2) - 1; i += 2) {
      oddNumbers.add(i);
    }

    return oddNumbers;
  }


}

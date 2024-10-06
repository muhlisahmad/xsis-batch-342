package soal2logic.application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Number8 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Map<String, List<Integer>> result;

    while (true) {
      System.out.print("Insert nth of odd and even numbers to be printed out\t: ");
      try {
        int nthOddEven = sc.nextInt();
        sc.nextLine();
        if (nthOddEven < 1) {
          System.out.println("Invalid input!!!\n");
          continue;
        }
        result = oddEvenNumbers(nthOddEven);
        break;
      } catch (InputMismatchException e) {
        System.out.println("Invalid input!!!\n");
        sc.nextLine();
        continue;
      }
    }

    Integer lastOddNumber = result.get("odd").getLast();
    Integer lastEvenNumber = result.get("even").getLast();
    result.forEach((key, intList) -> {
      intList.forEach(number -> System.out.print(number +
        (key.equals("odd")
          ? lastOddNumber == number ? "\n"
            : " "
            : lastEvenNumber == number
          ? "\n" : " " )));
    });
    sc.close();
  }

  private static Map<String, List<Integer>> oddEvenNumbers(int n) {
    Map<String, List<Integer>> result = new LinkedHashMap<>() {{
      put("odd", new ArrayList<>(Arrays.asList(1)));
      put("even", new ArrayList<>(Arrays.asList(2)));
    }};
    for (int i = 3; i <= n; i++) {
      if (i % 2 == 0) {
        result.get("even").add(i);
      } else {
        result.get("odd").add(i);
      }
    }
    return result;
  }
}

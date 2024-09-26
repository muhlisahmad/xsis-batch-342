package oop.application;

import java.util.Scanner;

import oop.data.SimpleCalculator;

public class Daily08 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    SimpleCalculator calculation = new SimpleCalculator();
    String firstMatcher = "^\\d+(\\.\\d+)?[\\+\\-\\*/:]\\d+(\\.\\d+)?$";
    String nonFirstMatcher = "^[\\+\\-\\*/:]\\d+(\\.\\d+)?$";
    boolean first = true;
    String tryAgain = null;

    System.out.println("Simple Calculator");

    while (true) {
      while (true) {
        // System.out.print("\t: ");
        String input = sc.nextLine();
        if (input.matches(first ? firstMatcher : nonFirstMatcher)){
          if (first) {
            for (int i = 0; i < input.length(); i++) {
              if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*' || input.charAt(i) == '/' || input.charAt(i) == ':') {
                calculation.setResult(Float.valueOf(input.substring(0, i - 1)), "addition");
                switch (input.charAt(i)) {
                  case '+' -> {
                    calculation.setResult(Float.valueOf(input.substring(i + 1, input.length())), "addition");
                  }
                  case '-' -> {
                    calculation.setResult(Float.valueOf(input.substring(i + 1, input.length())), "substraction");
                  }
                  case '*' -> {
                    calculation.setResult(Float.valueOf(input.substring(i + 1, input.length())), "multiplication");
                  }
                  default -> {
                    calculation.setResult(Float.valueOf(input.substring(i + 1, input.length())), "division");
                  }
                }
              } else {
                continue;
              }
            }
            first = false;
          } else {
            switch (input.charAt(0)) {
              case '+' -> {
                calculation.setResult(Float.valueOf(input.substring(1, input.length())), "addition");
              }
              case '-' -> {
                calculation.setResult(Float.valueOf(input.substring(1, input.length())), "substraction");
              }
              case '*' -> {
                calculation.setResult(Float.valueOf(input.substring(1, input.length())), "multiplication");
              }
              default -> {
                calculation.setResult(Float.valueOf(input.substring(1, input.length())), "division");
              }
            }
          }
          break;
        } else {
          System.out.println("Invalid Input!!!\n");
          continue;
        }
      }

      while (true) {
        System.out.print("Hitung lagi? (Y/n)\t: ");
        tryAgain = sc.nextLine();
        if (!(tryAgain.trim().equalsIgnoreCase("y") || tryAgain.trim().equalsIgnoreCase("n"))) {
          System.out.println("Invalid Input!!!\n");
          continue;
        } else {
          break;
        }
      }

      if (tryAgain.trim().equalsIgnoreCase("n")) {
				break;
			} else {
        continue;
      }
    }

    sc.close();
  }
}

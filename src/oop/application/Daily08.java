package oop.application;

import java.util.InputMismatchException;
import java.util.Scanner;

import oop.data.Circle;
import oop.data.Shape;
import oop.data.SimpleCalculator;
import oop.data.Tetragon;
import oop.data.Trigon;

public class Daily08 {
  public static void simpleCalculator() {
    Scanner sc = new Scanner(System.in);
    SimpleCalculator calculation = new SimpleCalculator();
    String firstMatcher = "^\\d+(\\.\\d+)?[\\+\\-\\*/:]\\d+(\\.\\d+)?$";
    String nonFirstMatcher = "^[\\+\\-\\*/:]\\d+(\\.\\d+)?$";
    boolean first = true;
    String tryAgain = null;

    System.out.println("Simple Calculator");

    while (true) {
      while (true) {
        String input = sc.nextLine();
        if (input.matches(first ? firstMatcher : nonFirstMatcher)){
          if (first) {
            for (int i = 0; i < input.length(); i++) {
              if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*' || input.charAt(i) == '/' || input.charAt(i) == ':') {
                calculation.setResult(Float.valueOf(input.substring(0, i)), "addition");
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

    System.out.println("= " + calculation.getResult());

    sc.close();
  }

  public static void planeFigures() {
    Scanner sc = new Scanner(System.in);
    double area = 0;
    double circumference = 0;
    int option = 0;
    Shape shape;
    String tryAgain;

    while (true) {
      while (true) {
        System.out.println("| ================================================ |");
        System.out.println("|              Pilih Tipe Bangun Datar             |");
        System.out.println("| ================================================ |");
        System.out.println("| [1] Segi Empat    [2] Segi Tiga    [3] Lingkaran |");
        System.out.println("| ================================================ |");
        try {
          option = sc.nextInt();
          sc.nextLine();
          if (option == 1 || option == 2 || option == 3) {
            break;
          } else {
            System.out.println("Invalid input!!!\n");
            sc.nextLine();
            continue;
          }
        } catch (InputMismatchException e) {
          System.out.println("Invalid input!!!\n");
          sc.nextLine();
          continue;
        }
      }

      while (true) {
        if (option == 1) {
          System.out.print("Panjang sisi 1\t: ");
          double a = sc.nextDouble();
          sc.nextLine();
          
          System.out.print("Panjang sisi 2\t: ");
          double b = sc.nextDouble();
          sc.nextLine();
          
          System.out.print("Panjang sisi 3\t: ");
          double c = sc.nextDouble();
          sc.nextLine();
          
          System.out.print("Panjang sisi 4\t: ");
          double d = sc.nextDouble();
          sc.nextLine();
          
          System.out.print("Panjang diagonal 1\t: ");
          double e = sc.nextDouble();
          sc.nextLine();
          
          System.out.print("Panjang diagonal 2\t: ");
          double f = sc.nextDouble();
          sc.nextLine();

          try {
            shape = new Tetragon(a, b, c, d, e, f);
            area = shape.calculateArea();
            circumference = shape.calculateCircumference();
            break;
          } catch (IllegalArgumentException err) {
            System.out.println(err.getMessage() + "\n");
            continue;
          }
        } else if (option == 2) {
          System.out.print("Panjang sisi 1\t: ");
          double a = sc.nextDouble();
          sc.nextLine();
          
          System.out.print("Panjang sisi 2\t: ");
          double b = sc.nextDouble();
          sc.nextLine();
          
          System.out.print("Panjang sisi 3\t: ");
          double c = sc.nextDouble();
          sc.nextLine();
  
          try {
            shape = new Trigon(a, b, c);
            area = shape.calculateArea();
            circumference = shape.calculateCircumference();
            break;
          } catch (Exception e) {
            System.out.println(e.getMessage() + "\n");
            continue;
          }
        } else {
          System.out.print("Panjang jari-jari\t: ");
          double a = sc.nextDouble();
          sc.nextLine();

          try {
            shape = new Circle(a);
            area = shape.calculateArea();
            circumference = shape.calculateCircumference();
            break;
          } catch (Exception e) {
            System.out.println(e.getMessage() + "\n");
            continue;
          }
        }
      }

      System.out.println("Luas dari " + shape.getClass().getSimpleName().toLowerCase() + "\t: " + area);
      System.out.println("Keliling dari " + shape.getClass().getSimpleName().toLowerCase() + "\t: " + circumference);

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

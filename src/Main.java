// import warmup1.*;
// import java.util.Arrays;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

import dailyQuest.*;
import oop.application.*;
public class Main {
  public static void main(String[] args) {
    // System.out.println(Arrays.toString(Daily.minMax(2, 8, 9, 4))); // not candy
    // System.out.println(Arrays.toString(Daily.minMax(9, 12, 42, 32))); // not candy
    // System.out.println(Arrays.toString(Daily.minMax(82, 231, 322, 231))); // not candy

    // Scanner scannerInput = new Scanner(System.in);

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

    // System.out.print("Insert the height of the left triangle\t: ");
    // int leftHeight = scannerInput.nextInt();
    // System.out.print("Wanna print out as asterisk (Y/n)\t: ");
    // String isLeftAsteriskInput = scannerInput.next();
    // boolean isLeftAsterisk = isLeftAsteriskInput.equalsIgnoreCase("y");
    // Daily04.leftTriangle(leftHeight, isLeftAsterisk);

    // System.out.print("Insert the height of the right triangle\t: ");
    // int rightHeight = scannerInput.nextInt();
    // System.out.print("Wanna print out as asterisk (Y/n)\t: ");
    // String isRightAsteriskInput = scannerInput.next();
    // boolean isRightAsterisk = isRightAsteriskInput.equalsIgnoreCase("y");
    // Daily04.rightTriangle(rightHeight, isRightAsterisk);

    // System.out.print("Insert the size of the square\t: ");
    // int squareSize = scannerInput.nextInt();
    // // Daily05.strokeAsteriskArray(squareSize);
    // // System.out.println();
    // for (String[] arrStr : Daily05.strokeReturnArray(squareSize)) {
    //   for (String str : arrStr) {
    //     System.out.print(str);
    //   }
    //   System.out.println();
    // }

    // System.out.print("Insert the size of the square\t: ");
    // int crossSize = scannerInput.nextInt();
    // // Daily05.crossAsteriskArray(crossSize);
    // // System.out.println();
    // for (String[] arrStr : Daily05.crossReturnArray(crossSize)) {
    //   for (String str : arrStr) {
    //     System.out.print(str);
    //   }
    //   System.out.println();
    // }

    // System.out.print("Insert the size of the square\t: ");
    // int squareSize = scannerInput.nextInt();
    // Daily05.reversedArray(squareSize);
    // System.out.println();
    
    // System.out.print("Insert the size of the square\t: ");
    // int oddEvenSize = scannerInput.nextInt();
    // for (int[] arrInteger : Daily05.oddEvenArray(oddEvenSize)) {
    //   for (int integer : arrInteger) {
    //     System.out.print(integer + "\t");
    //   }
    //   System.out.println();
    // }

    // System.out.print("Insert the size of the array\t: ");
    // int arrSize = scannerInput.nextInt();
    // int[] arr = new int[arrSize];
    // for (int i = 0; i < arrSize; i++) {
    //   System.out.print("- insert element\t: ");
    //   arr[i] = scannerInput.nextInt();
    // }
    // System.out.println("Mean\t: " + Daily05.meanArray(arr));
    // System.out.println("Median\t: " + Daily05.medianArray(arr));
    // System.out.println("Modus\t: " + Daily05.modusArray(arr));
    // System.out.println("Max\t: " + Daily05.maxArray(arr));
    // System.out.println("Min\t: " + Daily05.minArray(arr));

    // System.out.print("Insert words or sentences\t: ");
    // String words = scannerInput.nextLine();
    // Daily06.alphabet(words).forEach((key, value) -> {
    //   System.out.println("Huruf " + key + "\t: " + value);
    // });
    
    // Daily06.orderMenu();
    
    // System.out.print("Insert amount\t: ");
    // int amount = scannerInput.nextInt();
    // scannerInput.nextLine();
    // String unit = null;
    // while (true) {
    //   System.out.print("Insert unit\t: ");
    //   unit = scannerInput.next();
    //   if (unit.trim().equalsIgnoreCase("botol") ||
    //       unit.trim().equalsIgnoreCase("gelas") || 
    //       unit.trim().equalsIgnoreCase("teko") || 
    //       unit.trim().equalsIgnoreCase("cangkir")) {
    //         break;
    //   } else {
    //     System.out.println("Invalid input!!!");
    //     System.out.println("valid input\t: botol, gelas, teko, cangkit");
    //     continue;
    //   }
    // }

    // System.out.println(amount + " " + unit + " : " + Daily06.cupConversion(amount, unit) + " cangkir");
    
    // Daily07.atmMachine();

    // Daily08.simpleCalculator();

    // Daily08.planeFigures();

    Daily09.number5();

    // LocalDateTime before = LocalDateTime.now();
    // LocalDateTime after = before.plusMinutes(6).plusHours(2).plusDays(2);

    // // System.out.println(after.compareTo(before));
    // System.out.println(ChronoUnit.HOURS.between(before, after));
    // System.out.println(18%24);
    
    // try {
    //   LocalDateTime dateTime = LocalDateTime.parse("2024-09-31T02:00:32");
    //   System.out.println(dateTime);
    // } catch (DateTimeException e) {
    //   System.out.println(e.getCause().getMessage());
    // }
    // scannerInput.close();
  }
}
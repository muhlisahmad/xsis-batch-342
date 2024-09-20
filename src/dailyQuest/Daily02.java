package dailyQuest;

public class Daily02 {
  /*
   * Buatlah funciton untuk soal2 berikut
   * 1. menentukan generasi berdasarkan tahun lahir
   * 2. menentukan badan kurus, gemuk atau ideal berdasarkan tinggi dan berat badan. jangan lupa hitung BMI
   * 3. menentukan nilai maksimal dan minimal dari 4 buah angka
   */
  public static String gen(int year) {
    if (year < 1946) {
      return "Damn you're old";
    } else if (year >= 1946 && year <= 1964) {
      return "OK Boomers";
    } else if (year >= 1965 && year <= 1980) {
      return "Gen X";
    } else if (year >= 1981 && year <= 1996) {
      return "Millenials";
    } else if (year >= 1997 && year <= 2012) {
      return "Gen Z";
    } else {
      return "Skibidi toilet goonmaxxing gyat +10000 aura";
    }
  }

  public static String fatnessCalculator(float weight, float height) {
    float bmi = weight / (height * height);
    if (bmi < 18.5) {
      return "Gain some weight";
    } else if (bmi >= 18.5 && bmi <= 24.9) {
      return "Just normal";
    } else if (bmi >= 25.0 && bmi <= 29.9) {
      return "Go to the gym";
    } else if (bmi >= 30 && bmi <= 34.9) {
      return "Shaqueel O'meal";
    } else if (bmi >= 35.0 && bmi <= 39.9) {
      return "Bro has his own gravitiational pull";
    } else {
      return "CaseOh considered skinny compared to you";
    }
  }

  public static int[] minMax(int num1, int num2, int num3, int num4) {
    // Versi #1
    int[] nums = new int[] {num1, num2, num3, num4};
    for (var i = 0; i < nums.length - 1; i++) {
      for (var j = i + 1; j < nums.length; j++) {
        if (nums[i] > nums[j]) {
          var tempNum = nums[i];
          nums[i] = nums[j];
          nums[j] = tempNum;
        } else {
          continue;
        }
      }
    }

    // Versi #2
    // int max = 0;
    // int min = 0;
    // for (var i = 0; i < nums.length; i++) {
    //   if (i == 0) {
    //     min = nums[i];
    //     max = nums[i];
    //   } else {
    //     min = (min < nums[i]) ? min : nums[i];
    //     max = (max > nums[i]) ? max : nums[i];
    //   }
    // }

    return new int[] {nums[0], nums[nums.length - 1]};
    // return new int[] {min, max};
  }

  public static boolean inRange(int num1, int num2) {
    return (num1 >= 30 && num1 <= 50 && num2 >= 30 && num2 <= 50);
  }

  /*
   * 5. Buatlah fungsi deret fibonacci. parameter merupakan panjang deret angka yang tercetak
   * 6. Buatlah fungsi faktorial
   */

  public static void nFibonacciSequence(int n) {
    long[] nFibonacci = new long[n];
    if (n <= 0) {
      System.out.println("n must be more than 0");
    }

    for (int i = 0; i < nFibonacci.length; i++) {
      nFibonacci[i] = i <= 1 ? 1 : nFibonacci[i - 2] + nFibonacci[i - 1];
    }

    for (long num : nFibonacci) {
      System.out.print(num + " ");
    }
  }

  public static int nFactorial(int n) {
    if (n == 1) {
      return 1;
    } else {
      return n * nFactorial(n - 1);
    }
  }

  public static int[][] nSizeUnitMatrix(int n) {
    int[][] result = new int[n][n];
    for (int i = 0; i < result.length; i++) {
      for (int j = 0; j < result[i].length; j++) {
        result[i][j] = i == j ? 1 : 0;
      }
    }
    return result;
  }
}
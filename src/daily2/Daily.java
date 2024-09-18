package daily2;

public class Daily {
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
    int[] nums = new int[] {num1, num2, num3, num4};
    // int[] sortNums = new int[4];
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
    return new int[] {nums[0], nums[nums.length - 1]};
  }

  public static boolean inRange(int num1, int num2) {
    return (num1 >= 30 && num1 <= 50 && num2 >= 30 && num2 <= 50);
  }
}
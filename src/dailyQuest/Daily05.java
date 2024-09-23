package dailyQuest;

import java.util.Arrays;

public class Daily05 {
  public static void strokeAsteriskArray(int size) {
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        System.out.print((i == 0 || i == size - 1 || j == 0 || j == size - 1) ? "* " : "  ");
      }
      System.out.println();
    }
  }

  public static void crossAsteriskArray(int size) {
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        System.out.print((i == j || i == size - 1 - j) ? "* " : "  ");
      }
      System.out.println();
    }
  }

  public static String[][] strokeReturnArray(int size) {
    String[][] result = new String[size][size];
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        result[i][j] = (i == 0 || i == size - 1 || j == 0 || j == size - 1) ? "* " : "  ";
      }
    }
    return result;
  }

  public static String[][] crossReturnArray(int size) {
    String[][] result = new String[size][size];
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        result[i][j] = (i == j || i == size - 1 - j) ? "* " : "  ";
      }
    }
    return result;
  }

  public static void reversedArray(int size) {
    int substract = 0;
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        System.out.print(size * size - substract + "\t");
        substract++;
      }
      System.out.println();
    }
  }

  public static int[][] oddEvenArray(int size) {
    int num = 1;
    int[][] result = new int[size][size];
    for (int i = 0; i < size; i+=2) {
      for (int j = 0; j < size; j++) {
        result[i][j] = num;
        if (i+1 < size) {
          result[i+1][j] = num + 1;
        }
        num+=2;
      }
    }
    return result;
  }

  public static float meanArray(int[] nums) {
    float sum = 0;
    for (int num : nums) {
      sum += num;
    }
    return sum / nums.length;
  }

  public static float medianArray(int[] nums) {
    Arrays.sort(nums);
    return nums.length % 2 == 0 ? ((float) nums[nums.length/2] + (float) nums[(nums.length/2) - 1]) / 2 : nums[(nums.length - 1)/2];
  }

  public static int maxArray(int[] nums) {
    Arrays.sort(nums);
    return nums[nums.length - 1];
  }
  
  public static int minArray(int[] nums) {
    Arrays.sort(nums);
    return nums[0];
  }

  public static int modusArray(int[] nums) {
    int uniqueCount = 0;
    Arrays.sort(nums);
    for (int i = 0; i < nums.length; i++) {
      if (i == 0 || (nums[i] != nums[i-1] && i != 0)) {
        uniqueCount++;
      } else {
        continue;
      }
    }
    int[] eachCount = new int[uniqueCount];
    int[] uniqueArr = new int[uniqueCount];
    int uniqueIdx = 0;
    for (int i = 0; i < nums.length; i++) {
      if (i == 0 || (nums[i] != nums[i-1] && i != 0)) {
        if (i != 0) {
          uniqueIdx++;
        }
        uniqueArr[uniqueIdx] = nums[i];
        eachCount[uniqueIdx]++;
      } else {
        eachCount[uniqueIdx]++;
      }
    }

    int result = 0;
    int[] copyEachCount = Arrays.copyOf(eachCount, eachCount.length);
    for (int i = 0; i < copyEachCount.length; i++) {
      if (copyEachCount[i] == maxArray(eachCount)) {
        result = uniqueArr[i];
      } else {
        continue;
      }
    }
    return result;
  }
}

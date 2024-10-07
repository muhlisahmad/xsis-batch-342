package codewars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Snail {
  public static int[] snail(int[][] array) {
    if (array.length == 0 || (array.length == 1 && array[0].length == 0)) {
      return new int[0];
    }
    int[] result = new int[array.length * array.length];
    List<Integer> resultList = new ArrayList<>();
    int headRight = array.length;
    int headLeft = array.length - 1;
    int headDown = array.length - 1;
    int headUp = array.length - 2;
    int step = 1;
    String direction = "right";
    
    int[] coordinate = new int[] {0, 0};
    
    while (resultList.size() != array.length * array.length) {
      resultList.add(array[coordinate[0]][coordinate[1]]);
      switch (direction) {
        case "right":
          if (step == headRight){
            direction = "down";
            coordinate[0]++;
            headRight-=2;
            step = 1;
            continue;
          }
          coordinate[1]++;
          step++;
          break;
        case "down":
          if (step == headDown) {
            direction = "left";
            coordinate[1]--;
            headDown-=2;
            step = 1;
            continue;
          }
          coordinate[0]++;
          step++;
          break;
        case "left":
          if (step == headLeft) {
            direction = "up";
            coordinate[0]--;
            headLeft-=2;
            step = 1;
            continue;
          }
          coordinate[1]--;
          step++;
          break;
        default:
          if (step == headUp) {
            direction = "right";
            coordinate[1]++;
            headUp-=2;
            step = 1;
            continue;
          }
          coordinate[0]--;
          step++;
          break;
      }
    }

    for (int i = 0; i < resultList.size(); i++) {
      result[i] = resultList.get(i);
    }
    
    return result;
  }  public static void main(String[] args) {
    System.out.println(Arrays.toString(snail(new int[][] {{1, 2, 3, 9},
                                                          {4, 5, 6, 4},
                                                          {7, 8, 9, 1},
                                                          {1, 2, 3, 4}})));
    System.out.println(Arrays.toString(snail(new int[][] {{1, 2, 3},
                                                          {4, 5, 6},
                                                          {7, 8, 9}})));
  }
}

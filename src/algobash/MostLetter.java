package algobash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostLetter {
  public static String mostLetter(String inputStr) {
    String cleanStr = inputStr.toLowerCase().replaceAll("\\s|[!<>\":\\/|?*]", "");
    Map<Character, Integer> charFreq = new HashMap<>();
    
    for (int i = 0; i < cleanStr.length(); i++) {
      charFreq.merge(cleanStr.charAt(i), 1, (oldValue, newValue) -> oldValue + newValue);
    }

    List<Map.Entry<Character, Integer>> charFreqList = new ArrayList<>(charFreq.entrySet());
    Collections.sort(charFreqList, (e1, e2) -> {
      int comparison = e2.getValue().compareTo(e1.getValue());
      if (comparison == 0) {
        return e1.getKey().compareTo(e2.getKey());
      } else {
        return comparison;
      }
    });

    return String.valueOf(charFreqList.get(0).getKey());
  }
  
  public static void main(String[] args) {
    System.out.println(mostLetter("i love coding!<>: /? *"));
  }
}

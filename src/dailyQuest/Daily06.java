package dailyQuest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Daily06 {
    /*
     * Problem      : urutkan huruf/karakter dari gabungan beberapa kata atau sebuah
     *                kalimat sesuai dengan abjad alfabet
     * Input        : gabungan beberapa kata atau sebuah kalimat
     * Constraints  : - mengandung huruf vokal dan konsonan
     *                - urut dan pisahkan huruf/karakter tersebut ke dalam 2 kelompok;kelompok vokal dan konsonan
     *                - pisahkan antara vokal dan konsonan
     *                - diproses sebagai huruf kecil (spasi diabaikan)
     * Output       : 2 kelompok huruf; vokal dan konsonan
     * Example      : input n   : Sample Case                       input n   : Next Case
     *                output    : Huruf vokal : aaee                output    : Huruf vokal : aee
     *                            Huruf konsonan : clmpss                       Huruf konsonan : cnstx
     */
    
    public static Map<String, String> alphabet(String str) {
        List<Character> vocal = new ArrayList<>(List.of('a', 'i', 'u', 'e', 'o'));
        String cleanedStr = str.trim().toLowerCase().replaceAll("\s", "");
        char[] tempChars = cleanedStr.toCharArray();
        Arrays.sort(tempChars);
        String finalStr = new String(tempChars);
        // Map<String, String> result = new HashMap<>(Map.of("Huruf vokal", null, "Huruf konsonan", null));
        Map<String, String> result = new HashMap<>();
        for (int i = 0; i < finalStr.length(); i++) {
            if (vocal.contains(finalStr.charAt(i))) {
                result.put("vokal", result.get("vokal") == null ? String.valueOf(finalStr.charAt(i)) : result.get("vokal") + finalStr.charAt(i));
            } else {
                result.put("konsonan", result.get("konsonan") == null ? String.valueOf(finalStr.charAt(i)) : result.get("konsonan") + finalStr.charAt(i));
            }
        }
        return result;
    }
}

package dailyQuest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

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
		String cleanedStr = str.toLowerCase().replaceAll("\s", "");
		char[] tempChars = cleanedStr.toCharArray();
		Arrays.sort(tempChars);
		String finalStr = new String(tempChars);
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

	/*
	 * Tiap 1 orang dewasa laki0laki memakan 2 piring nasi goreng, 1 orang dewasa perempuan memakan 1 piring mie goreng,
	 * 2 orang remaja memakan 2 mangkok mie ayam, 1 orang anak-anak memakan 1/2 piring nasi goreng,
	 * 1 orang balita memakan 1 mangkok kecil bubur sehat. Berapa total porsi makanan yang dimakan?
	 * Constraints:
	 * 		- Jika total yang sedang makan jumlahnya ganjil lebih dari 5 orang maka tiap orang dewasa perempuan
	 * 			tambah 1 piring nasi goreng
	 * 		- Inputan bisa saja acak (misalnya: laki-laki dewasa 3, balita 2, laki-laki dewasa 2, balita 2, perempuan dewasa 3)
	 * Contoh:
	 * Input: laki-laki dewasa = 3 orang; Perempuan dewasa = 1 orang; Balita = 1 orang; Laki-laki dewasa = 1 orang
	 * Output: 10 porsi
	 */
	private static float portion(int men, int women, int teens, int children, int toddlers) {
		int people = men + women + teens + children + toddlers;
		float result = (men * 2) + teens + (children/2) + toddlers;
		if (people > 5 && people % 2 != 0) {
			result += (women * 2) ;
		} else {
			result += women;
		}
		return result;
	}

	private static Map<String, Integer> menuCliInterface() {
		Scanner scannerInput = new Scanner(System.in);
		Map<String, Integer> result = new HashMap<>();
		int manyPeople = 0;
		String kind = null;
		String tryAgain = null;
		
		while (true) {
			System.out.print("For how many people?\t: ");
			manyPeople = scannerInput.nextInt();
			scannerInput.nextLine();

			while (true) {
				System.out.print("For who?\t\t: ");
				kind = scannerInput.nextLine();
	
				if (kind.trim().equalsIgnoreCase("laki-laki dewasa") ||
						kind.trim().equalsIgnoreCase("perempuan dewasa") ||
						kind.trim().equalsIgnoreCase("remaja") ||
						kind.trim().equalsIgnoreCase("anak-anak") ||
						kind.trim().equalsIgnoreCase("balita")
				) {
					break;
				} else {
					System.out.println("Invalid input!!! Valid input (Laki-laki Dewasa, Perempuan Dewasa, Remaja, Anak-anak, Balita)");
					continue;
				}
			}

			result.put(kind, result.get(kind) == null ? manyPeople : result.get(kind) + manyPeople);

			while (true) {
				System.out.print("Anything else? (Y/n)\t: ");
				tryAgain = scannerInput.next();
				if (!(tryAgain.trim().equalsIgnoreCase("y") || tryAgain.trim().equalsIgnoreCase("n"))) {
					System.out.println("Invalid input!!!");
					continue;
				} else {
					break;
				}
			}

			if (tryAgain.trim().equalsIgnoreCase("n")) {
				break;
			}
		}
		scannerInput.close();
		return result;
	}

	public static void orderMenu() {
		System.out.println("Input your order");
		Map<String, Integer> peopleDetails = menuCliInterface();
		System.out.println("Total\t: " + portion(
			peopleDetails.get("laki-laki dewasa") == null ? 0 : peopleDetails.get("laki-laki dewasa"), 
			peopleDetails.get("perempuan dewasa") == null ? 0 : peopleDetails.get("perempuan dewasa"), 
			peopleDetails.get("remaja") == null ? 0 : peopleDetails.get("remaja"), 
			peopleDetails.get("anak-anak") == null ? 0 : peopleDetails.get("anak-anak"), 
			peopleDetails.get("balita") == null ? 0 : peopleDetails.get("balita")));
	}

	/*
	 * Jika 1 botol = 2 gelas, 1 teko = 25 cangkir, 1 gelas = 2.5 cangkir.
	 * Buatlah sistem konversi volume berdasarkan data diatas
	 * Contoh:
	 * 1 botol = ... cangkir?
	 * 1 botol = 5 cangkir
	 */

	public static float cupConversion(int input, String unit) {
		float result = 0;
		switch (unit.trim().toLowerCase()) {
			case "botol":
				result = 2.5f * 2 * input;
				break;
			case "teko":
				result = 25 * input;
				break;
			case "gelas":
				result = 2.5f * input;
				break;
			default:
				result = input;
				break;
		}
		return result;
	}
}

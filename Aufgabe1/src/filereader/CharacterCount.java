package filereader;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CharacterCount {

	public static void main(String[] args) throws IOException {
		TreeMap<Character, Integer> charactersMap = new TreeMap<Character, Integer>();
		Scanner scannerObj = null; // Instantiating scanner object to null

		try {
			scannerObj = new Scanner(new File(args[0])); // taking input file from CLI
//			scanner = new Scanner(new File("C:\\Users\\Hem\\Desktop\\LoremIpsum.txt"), "utf-8");

			while (scannerObj.hasNext()) {
				char[] lineObj = scannerObj.nextLine().toLowerCase().toCharArray(); // Forming an Array of characters
				// retrieved from scanner object

				for (Character character : lineObj) {
					if (Character.isLetter(character)) {
						if (charactersMap.containsKey(character)) {
							charactersMap.put(character, charactersMap.get(character) + 1); // adding individual chars
																							// to the
							// characters TreeMap
						} else {
							charactersMap.put(character, 1);
						}
					}
				}
			}
		} finally {
			if (scannerObj != null) {
				scannerObj.close();
			}
		}

		for (Map.Entry<Character, Integer> occurenceEntry : charactersMap.entrySet()) {
			System.out.println("Frequency of " + occurenceEntry.getKey() + ": " + occurenceEntry.getValue());
		}

	}
}

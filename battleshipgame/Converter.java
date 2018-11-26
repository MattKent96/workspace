package battleshipgame;

import java.util.HashMap;
import java.util.Map;

public class Converter {
	
	// Converts a String letter into a number for comparisons and looping purposes
	public int convertLetterToNumber(String letter) {
		letter = letter.toUpperCase();
		Map<String, Integer> converter = new HashMap<String, Integer>();
		converter.put("A", 1);
		converter.put("B", 2);
		converter.put("C", 3);
		converter.put("D", 4);
		converter.put("E", 5);
		converter.put("F", 6);
		converter.put("G", 7);
		converter.put("H", 8);
		converter.put("I", 9);
		converter.put("J", 10);
		try {
			return converter.get(letter);
		} catch (NullPointerException e) {
			return 0;
		}
	}
	
	// Converts a number into a String for comparisons and looping purposes
	public String convertNumberToLetter(int num) {
		Map<Integer, String> converter = new HashMap<Integer, String>();
		converter.put(1, "A");
		converter.put(2, "B");
		converter.put(3, "C");
		converter.put(4, "D");
		converter.put(5, "E");
		converter.put(6, "F");
		converter.put(7, "G");
		converter.put(8, "H");
		converter.put(9, "I");
		converter.put(10, "J");
		try {
			return converter.get(num);
		} catch (NullPointerException e) {
			return "";
		}

	}
}

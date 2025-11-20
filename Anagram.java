import java.util.Random;

/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		
		str2 = preProcess(str2);
		str1 = preProcess(str1);
		if (str1.length() != str2.length()){
			return false;
		}
		Character list[] = new Character[str1.length()];
		for (int i = 0; i < str1.length(); i++){
			list[i] = str1.charAt(i);
		}
		for (int i = 0; i < str2.length(); i++){
			Boolean k = false;
			for (int j = 0; j < list.length && k == false; j++){
				if (list[j] != null && list[j] == str2.charAt(i)) {
					list[j] = null;
					k = true;
				}
			}
			if (k == false) {
				return false;
			}
		}
		for (int i = 0; i < list.length; i++){
			if(list[i] != null){
				return false;
			}
		}
		return true;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		StringBuilder newstring = new StringBuilder();
		for (int i = 0; i < str.length();i++){
			char r = str.charAt(i);
			if (Character.isLetter(r)) {
				newstring.append(r);
			}
		}
		String f = newstring.toString().toLowerCase();
		return f;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		StringBuilder newstring = new StringBuilder();
		Random rand = new Random();
		str = preProcess(str);
		if (str.length() == 0) {
            return "";
        }
		int r = rand.nextInt(str.length());
		newstring.append(str.substring(r, str.length()));
		newstring.append(str.substring(0, r));
		String n = newstring.toString();
		return n;
	}
}

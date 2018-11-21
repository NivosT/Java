/** 
* Encodes and decodes strings based on "Cycle shift encoding" technique
* Given text, key (string, int) as args (in this order) - encodes && decodes based on key
* Given text (string) as args[0] - searches for a key and decodes
* Program works only for lower case letters
*/
public class CodeOps {
	static final int ALPHABET_SIZE = 26; // 26 letters in the English language
	
	public static void main(String[] args) {
		// Initializing vars
		String getText = args[0];
		String decodedText;
	
		if (args.length == 2) {
			int key = Integer.parseInt(args[1]); // Case of given key
			key %= ALPHABET_SIZE; // Ensures key length is set for one iteration 
			
			String encodedText = encode(getText, key); // Encode
			System.out.println("\n" + "Encoded: " + encodedText); 
			decodedText = decode(encodedText, key); // Decode
		}
		else {
			decodedText = decode(getText); // Case of no key - try to only decode
		}
		System.out.println("\n" + "Decoded: " + decodedText);
	}
	/*
	 * Adds to each char of the given String the value of the key, loops back to 'a' if passes 'z'
	 * white space or any char besides lower case English letters will be ignored
	 * For example: char 'a' key 4 - output 'e', char 'w' key 5 - output b
	 * 
	 * @param String to encode, key to encode by
	 * @return String of encoded text
	 */
	public static String encode(String toEncode, int key) {
		String encoded = ""; 
		
		for (int i = 0; i <= (toEncode.length() - 1); i++) {
			if ((int) toEncode.charAt(i) >= 97 && (int) toEncode.charAt(i) <= 122) { // Encodes only lower case chars
				if ((int) toEncode.charAt(i) + key >= 97 && (int) toEncode.charAt(i) + key <= 122) {
					encoded += (char) ((toEncode.charAt(i) + key));
				}
				else {
					encoded += (char) ((toEncode.charAt(i) - ALPHABET_SIZE) + key); // Resets to 'a' if passes 'z'
				}
			}
			else {
				encoded += toEncode.charAt(i); // Plain copy for non lower case chars
			}
		}
        return encoded;
	}
	/*
	 * Subtracts each char of the given String by the value of the key, loops up to 'z' if passes 'a'
	 * For example: char 'e' key 4 - output 'a', char 'b' key 5 - output w
	 * 
	 * @param String to decode, key to decode by
	 * @return String of decoded text
	 */
	public static String decode(String toDecode, int key) {
		String decoded = "";
		for (int i = 0; i <= (toDecode.length() - 1); i++) {
			if ((int) toDecode.charAt(i) >= 97 && (int) toDecode.charAt(i) <= 122) { // Decodes only lower case chars
				if ((int) toDecode.charAt(i) - key >= 97 && (int) toDecode.charAt(i) - key <= 122) {
					decoded += (char) ((toDecode.charAt(i) - key));
				}
				else {
					decoded += (char) ((toDecode.charAt(i) + ALPHABET_SIZE) - key); // Resets to 'z' if passes 'a'
				}
			}
			else {
				decoded += toDecode.charAt(i); // Plain copy for non lower case chars
			}
		}
		return decoded;
	}
	/*
	 * Calculates the most common char in the given String. Assuming the most frequent char is 'e', sets key to be the difference
	 * Decodes the text by the calculated key
	 * 
	 * @param String to decode
	 * @return String of decoded text
	 */
	public static String decode(String toDecode) {
		// Array of counted appearances of chars in toDecode
		int[] count = new int[ALPHABET_SIZE];
		for (int i = 0; i <= toDecode.length() - 1; i++) {
			if ((int) toDecode.charAt(i) >= 97 && (int) toDecode.charAt(i) <= 122) {
				count[Math.abs(toDecode.charAt(i) - 97)]++; 
			}
		}
		// Find most common char in toDecode
		int max = 0;
		int chIndex = 0;
		for (int j = 0; j <count.length - 1; j++) {
			if (count[j] > max) {
				max = count[j];
				chIndex = 97 + j; // Returns ascii value of the most common char
			}
		}
		// Ascii of 'e' is 101, calculates key
		int key = (int) Math.abs(101 - chIndex);
		String decoded = decode(toDecode, key);	// Decodes String with decode(String, int)
		
        return decoded;
	}
}

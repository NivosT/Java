/**
*
* A few functions to perform numerous string operations
*/
public class StringOps {
	
	public static void main(String[] args) {
		test_concat();
		test_trim();
		test_charRunCount();
		test_tokenize();
		test_removeChar();
	}
	
    private static void test_concat() {
    	String[] strings = new String[3];
	    strings[0] = "wiki";
	    strings[1] = "pe";
	    strings[2] = "dia";
	    System.out.println(concat(strings)); 		// Should print: wikipedia
	}
    
	private static void test_trim() {
        String s = "aaahappy birthdayaaaaaaaaa";
        System.out.println(trim(s,'a'));  			// should print "happy birthday"
    }
	
	private static void test_charRunCount() {
		String s = "GCCAATGGGGCCGGTTGGGGGGGGG";
		System.out.println(charRunCount(s,'G')); 	// should print 4
	}
	
	private static void test_tokenize() {
        String s = "   x  + Math.sqrt(x)    - rate  ";
        // creates an array of tokens, using the space character ' ' as a separator
        String[] tokens = tokenize(s, ' ');
        for (int i = 0; i < tokens.length; i++) {
        	System.out.println(tokens[i]);
	    }
        // Should print:
        // x
        // +
        // Math.sqrt(x)
        // -
        // rate
    }
	
	// Tests the removeChar function
    private static void test_removeChar() {
	    String s = "   x  + Math.sqrt(x)    - rate  ";
	    System.out.println(removeChar(s,' ')); 		// Should print: x+Math.sqrt(x)-rate
	}
    
    /**
	 * Returns a string which is the concatenation of the given array of strings
	 */
	public static String concat (String[] arr) {
		
		String concatString = "";
		
		for (int i = 0; i <= (arr.length) - 1; i++  ) {
				concatString += arr[i];		// Builds up string from each entry
			}
		
	    return concatString;
	}
	
	/**
	 * Trims the given character from the beginning and end of the given string.
	 * For example, if the given string is "aaahappy birthdayaaaaaaa", and the given
	 * character is 'a', returns the string "happy birthday".
	 */
	public static String trim(String str, char c) {
		
		int cursor = 0;
		int trimStart = 0;
		int trimEnd = 0;
		
		while (str.charAt(cursor) == c ) { 		// Counts the beginning set to trim
			trimStart++;
			cursor++;
		}
		
		cursor = (str.length() - 1);
		while (str.charAt(cursor) == c ) { 		// Counts the end set to trim
				trimEnd++;
				cursor--;
		}
		
		String trimString = str.substring(trimStart, (str.length() - trimEnd));
								// Sets new string with calculated amounts to remove
		return trimString;
	}
	
	/**
	 * Counts how many "runs" of the given character appear in the given string.
	 * A "run" is a consecutive block of one or more occurrences of the same character.
	 * For example, if the string is "AATGGGGCCGGTTGGGGGGGGGAAGC" and the character
	 * is "G", returns 4.
	 */
	public static int charRunCount(String str, char c){
		
		int runCount = 0;
		
		for (int i = 0; i <= (str.length() - 1); i++) {
			if (str.charAt(i) == c) {		// Runs through the given string
				runCount++;			// Counts when reaching given char
				
				while (i <= (str.length() - 1) && str.charAt(i) == c) {
					i++;			// For joint chars with same value:
				}				// Continuing the char flow through the str without extra counts
			}
		}
		return runCount;
	}

	/**
	 * Separates a given string into tokens, which are the "words" that are
	 * separated by one or more occurrences of the given separator character.
	 * Returns the tokens as an array of String values.
	 */
	public static String[] tokenize (String str, char separator) {
		// Removes all the occurrences of the separator at the beginning and end of str
		String source = trim(str, separator);
		String[] tokens = new String[(charRunCount(str, separator) - 1)];
		int arrCursor = 0;
		
		for (int i = 0; i <= (str.length() - 1); i++) {
								// Runs through the given string
			if (str.charAt(i) != separator) {
				tokens[arrCursor] = "";		// Collects char values that are not whitespaces (char 32)
									
				while (i <= (str.length() - 1) && str.charAt(i) != separator) {
					tokens[arrCursor] += str.charAt(i);
					i++;						
				}
				arrCursor++;
			}
		}
		return tokens;
	}
	
	/**
	 * Removes all occurrences of the given character from the given string
	 */
	public static String removeChar(String s, char c) {
		
		String output = concat(tokenize(s, c));
								// Uses tokenize() to set the given string as a "tokens" array
								// Uses concat() to combine the "tokens" to one string
	    return output;
	}
}

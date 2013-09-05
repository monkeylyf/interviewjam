/*Roman_to_Integer
leetcode

Given a roman numeral, convert it to an integer.
Input is guaranteed to be within the range from 1 to 3999.
*/


public class leetcode_Roman_to_Integer {

    public static void main(String[] args) {
		// Test case. 
		System.out.println(romanToInt("I"));
		System.out.println(romanToInt("II"));
    }

    public static int romanToInt(String roman) {
		if (roman.length() == 0) {
        	throw new NumberFormatException("An empty string does not define a Roman numeral.");
		}
        roman = roman.toUpperCase();
        int i = 0, arabic = 0, number, nextNumber;
		char letter;
        while (i < roman.length()) {
           letter = roman.charAt(i);
           number = letterToNumber(letter);  // Numerical equivalent of letter.
           i++;
           if (i == roman.length()) {
			   // Last roman char. Simply convert it to numeric value and add it up. 
              arabic += number;
           } else {
              // Look at the next letter in the string.  If it has a larger Roman numeral
              // equivalent than number, then the two letters are counted together as
              // a Roman numeral with value (nextNumber - number).
              nextNumber = letterToNumber(roman.charAt(i));
              if (nextNumber > number) {
                 // Combine the two letters to get one value, and move on to next position in string.
                 arabic += (nextNumber - number);
                 i++;
              } else {
                 arabic += number;
              }
           }
        }
        if (arabic > 3999) {
           throw new NumberFormatException("Roman numeral must have value 3999 or less.");
		}
        return arabic;
    }

	// Map Roman char to numeric value.
	private static int letterToNumber(char letter) {
		switch (letter) {
           case 'I':  return 1;
           case 'V':  return 5;
           case 'X':  return 10;
           case 'L':  return 50;
           case 'C':  return 100;
           case 'D':  return 500;
           case 'M':  return 1000;
           default:   throw new NumberFormatException(
                        "Illegal character \"" + letter + "\" in Roman numeral");
		}
	}
}

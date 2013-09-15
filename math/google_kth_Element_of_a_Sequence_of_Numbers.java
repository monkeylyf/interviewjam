/*kth_Element_of_a_Sequence_of_Numbers
google

Given a sequence of the form 0123456789101112131415... where each digit is in a
position, for example the digit in the position 5 is 5, in the position 13 is
1, in the position 19 is 4, etc.
Write a function that given a position returns the digit in that position.
(You could think that this sequence is an array where each cell only holds one
digit so given an index return what digit is in that index, however you cannot
really create an array since the sequence is infinite, you need a way to based
on the index calculate the digit that goes there).
The function has to return a single digit.
Other examples:
index = 100, result = 5
index = 30, result = 2
index = 31, result = 0
index = 1000, result = 3
*/


public class google_kth_Element_of_a_Sequence_of_Numbers {

    public static void main(String[] args) {
        for (int i = 1; i <= 250; ++i) {
            System.out.println(getKthElement(i));
        }
    }

    public static int getKthElement(int index) {
		if (index == 1) {
			return 0; // Edge case. And makes all ranges 9 * 10^n.
		}
		--index;
        // The idea behind this is 
        // 1 - 9   total 9, each takes one digit, total 1 * 9 = 9 digits
        // 10 - 99 total 90, each takes two digits, total 90 * 2 = 180 digits.
        // 100 - 999 total 900, each takes three digits, total 900 * 3 = 270.
        // First we need to find out which range input arg index should fall in.
        int digits = 0, min = 0, max = -1, tmp, size;
        while (true) {
            digits += 1;
            min = max + 1; // The min of current range is the max of last range + 1.
            // digits = 2, max = 99; digits = 5, max = 99999;
            max = 9;
			for (int i = digits; i > 1; --i) {
                max = 10 * max + 9; // Calculate max.
			}
            // Total number of digits current range has.
            // 1 - 9, 9 digits; 10 - 99, 180 digits.
            size = (max - min + 1) * digits;
            if (size > index) {
                // Find the range index falls in.
                break;
            } else {
                index -= size; 
            }
        }
        String number = Integer.toString(min + (index / digits)); // The number that index falls in.
        int digit = index % digits; // Index of the exact digit should be returned.
        return Character.digit(number.charAt(digit), 10);
    }
}

/*Count_and_Say

The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.

*/

public class leetcode_Count_and_Say {

    public static void main(String[] args) {
		// Test cases.
        System.out.println(countAndSay(1));
        System.out.println(countAndSay(2));
        System.out.println(countAndSay(3));
        System.out.println(countAndSay(4));
        System.out.println(countAndSay(5));
        System.out.println(countAndSay(6));
        System.out.println(countAndSay(7));
    }

    public static String countAndSay(int n) {
        String sequence = "1", acc;
		char last_char;
		int count, i;
        while (--n > 0) {
            acc = "";
            last_char = sequence.charAt(0);
            count = 0;
			// Start counting.
            for (i = 0; i < sequence.length(); ++i) {
                if (sequence.charAt(i) == last_char) {
                    ++count;
                } else {
					// Different char. Say and switch base char.
                    acc += "" + count + last_char;
                    count = 1; // Reset count to 1 since a different char's been already observed.
                    last_char = sequence.charAt(i);
                }
            }
            acc += "" + count + last_char;
            sequence = acc;
        }
        return sequence;
    }
}

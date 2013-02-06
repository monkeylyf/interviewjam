/*String_to_Integer_atoi

Implement atoi to convert a string to an integer.
Hint: Carefully consider all possible input cases. If you want a challenge,
please do not see below and ask yourself what are the possible input cases.
Notes: It is intended for this problem to be specified vaguely (ie, no given
input specs). You are responsible to gather all the input requirements up
front.

Requirements for atoi:
The function first discards as many whitespace characters as necessary until
the first non-whitespace character is found. Then, starting from this
character, takes an optional initial plus or minus sign followed by as many
numerical digits as possible, and interprets them as a numerical value.
The string can contain additional characters after those that form the integral
number, which are ignored and have no effect on the behavior of this function.
If the first sequence of non-whitespace characters in str is not a valid
integral number, or if no such sequence exists because either str is empty or
it contains only whitespace characters, no conversion is performed.
If no valid conversion could be performed, a zero value is returned. If the
correct value is out of the range of representable values, INT_MAX (2147483647)
or INT_MIN (-2147483648) is returned.
*/


class leetcode_String_to_Integer_atoi {
    public static void main(String[] args) {
    }
    public static int atoi(String str) {
        if (str.length() == 0) {
            return 0; // Input "" output 0. Corner case.
        }
        boolean isNeg = false;
        boolean overFlow = false;
        char c = ' '; // Init c, doesn't need to be a whitespace.
        int i = 0;
        while (i < str.length()) {
            c = str.charAt(i);
            if (Character.isWhitespace(c)) {
                i++; // whitespace, move on.
            } else if (c == '+' || c == '-' || Character.isDigit(c)) {
                // Detected neg/pos sign or detected digit.
                break;
            } else {
                // Illegal string.
                return 0;
            }
        }
        if (c == '-') {
            isNeg = true;
            ++i;
        }
        if (c == '+') {
            ++i;
        }
        int n = 0;
        while (i < str.length()) {
            c = str.charAt(i);
            if (Character.isDigit(c)) {
                int x = Character.digit(c, 10);
                if ((Integer.MAX_VALUE - x) / 10 >= n) {
                    n = 10 * n + x;
                } else {
                    overFlow = true;
                    break;
                }
                i++;
            } else {
                break;
            }
        }
        if (overFlow) {
            if (isNeg) {
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }
        } else {
            if (isNeg) {
                return -n;
            } else {
                return n;
            }
        }
    }
}

/*Implement an algorithm to print all valid(e.g., properly opened and closed)
combinations of n-pairs of parentheses.
EXAMPLE:
input: 3(e.g., 3 pairs of parentheses)
Output:
{{{}}}
{{}{}}
{{}}{}
{}{{}}
{}{}{}
*/

import java.util.*;

class test_53 {
	public static void main(String[] args) {
        my(3);
	}
    public static void my(int n) {
        ArrayList<String> sol = new ArrayList<String>();
        nextParentheses("{", n, 1, 0, sol);
        for (String i : sol) System.out.println(i);
    }
    public static void nextParentheses(String set, int n, int left, int right, ArrayList<String> sol) {
        if (set.length() == n * 2) sol.add(set);
        else {
            if (left < n) nextParentheses(set + "{", n, left + 1, right, sol);
            if (left - right > 0 && right < n) nextParentheses(set + "}", n, left, right + 1, sol);
        }
    }
}

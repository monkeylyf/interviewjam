/*Combinations_Of_N_Pair_Parentheses
careercup

Implement an algorithm to print all valid(e.g., properly opened and closed)
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

public class cap_Combinations_Of_N_Pair_Parentheses {

	public static void main(String[] args) {
		// Test case.
        solve(3);
	}

    public static void solve(int n) {
        ArrayList<String> all = new ArrayList<String>();
        nextParentheses("", n, 0, 0, all);
        for (String i : all) System.out.println(i);
    }

    public static void nextParentheses(String acc, int n, int left, int right, ArrayList<String> all) {
        if (left == n && right == n) {
			all.add(acc);
		} else {
            if (left < n) {
				nextParentheses(acc + "{", n, left + 1, right, all);
			}
            if (left > right) { //if (left > right && right < n) right < n is not neccesary. max left is n.
				nextParentheses(acc + "}", n, left, right + 1, all);
			}
        }
    }
}

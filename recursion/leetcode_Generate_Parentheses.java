/*Generate_Parentheses

Given n pairs of parentheses, write a function to generate all combinations
of well-formed parentheses.
For example, given n = 3, a solution set is:
"((()))", "(()())", "(())()", "()(())", "()()()"

Mark as duplicate of ./cap_Combinations_Of_N_Pair_Parentheses.java
*/

import java.util.ArrayList;


public class leetcode_Generate_Parentheses {

    public static void main(String[] args) {

    }

    public static ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> all = new ArrayList<String>();
        nextParenthesis("(", n, 1, 0, all);
        return all;
    }

    public static void nextParenthesis(String set, int n, int left, int right, ArrayList<String> all) {
        if (set.length() == n * 2) {
            all.add(set);
        } else {
            if (left < n) {
                nextParenthesis(set + "(", n, left + 1, right, all);
            }
            if (left - right > 0 && right < n) {
                nextParenthesis(set + ")", n, left, right + 1, all);
            }
        }
    }
}

/*Letter_Combinations_of_a_Phone_Number

Given a digit string, return all possible letter combinations that the number
could represent.
A mapping of digit to letters (just like on the telephone buttons) is given
below.
Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:
Although the above answer is in lexicographical order, your answer could be in
any order you want.
*/

import java.util.ArrayList;
import java.util.HashMap;

public class leetcode_Letter_Combinations_of_a_Phone_Number {

    public static void main(String[] args) {
        letterCombinations("2345");
    }

    public static ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> all = new ArrayList<String>();
        ArrayList<String> num = new ArrayList<String>();
        HashMap<Integer, String> phoneMap = new HashMap<Integer, String>();
        phoneMap.put(2, "abc");
        phoneMap.put(3, "def");
        phoneMap.put(4, "ghi");
        phoneMap.put(5, "jkl");
        phoneMap.put(6, "mno");
        phoneMap.put(7, "pqrs");
        phoneMap.put(8, "tuv");
        phoneMap.put(9, "wxyz");
        for (int i = 0; i < digits.length(); ++i) {
            int digit = Integer.parseInt(digits.charAt(i) + "");
            num.add(phoneMap.get(digit));
        }
        nextLetter("", num, all);
		System.out.println(all);
        return all; 
    }

    public static void nextLetter(String acc, ArrayList<String> num, ArrayList<String> all) {
        if (num.size() == 0) {
            all.add(acc);
        } else {
            String str = num.remove(num.size() - 1);
            for (int i = 0; i < str.length(); ++i) {
                nextLetter(str.charAt(i) + acc, num, all);
            }
            num.add(str);
        }
    }
}

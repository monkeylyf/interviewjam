/*Word_Frequency
careercup

Design a method to find the frequency of occurrences of any given word in a book
*/

import java.util.*;


public class cap_Word_Frequency {

	public static void main(String[] args) {
		String[] book = {"In", "this", "case", "we", "simply", "go", "through",
				 "the", "book", "word", "by", "word", "and", "count",
				 "the", "number", "of", "times", "that", "a", "word",
				 "appears", "This", "will", "take", "O(n)", "time",
				 "We", "know", "we", "can’t", "do", "better", "than",
				 "that", "as", "we", "must", "look", "at", "every",
				 "word", "in", "the", "book"};
		System.out.println(getFren(book, "we"));
	}

	public static double getFren(String[] book, String str) {
		HashMap<String, Integer> dict = new HashMap<String, Integer>();
		for (String word : book) {
			word = word.toLowerCase();
			if (!dict.containsKey(word)) {
                dict.put(word, 1);
            } else {
                dict.put(word, dict.get(word) + 1);
            }
		}
		double sum = 0;
        for (int i : dict.values()) {
			sum += i;
		}
		if (dict.containsKey(str)) {
			return dict.get(str) / sum;
		} else {
            return 0.0;
		}
	}
}

/*Design a method to find the frequency of occurrences of any given word in a book*/

import java.util.*;

class test_130 {
	public static void main(String[] args) {
		String[] book = {"In", "this", "case", "we", "simply", "go", "through",
				 "the", "book", "word", "by", "word", "and", "count",
				 "the", "number", "of", "times", "that", "a", "word",
				 "appears", "This", "will", "take", "O(n)", "time",
				 "We", "know", "we", "can’t", "do", "better", "than",
				 "that", "as", "we", "must", "look", "at", "every",
				 "word", "in", "the", "book"};
		getFren(book, "we");
	}

	public static int getFren(String[] book, String str) {
		Hashtable<String, Integer> dict = new Hashtable<String, Integer>();
		for (String word : book) {
			word = word.toLowerCase();
			if (!dict.containsKey(word)) dict.put(word, 1);
			else dict.put(word, dict.get(word) + 1);
		}
		Set set = dict.keySet();
		Iterator itr = set.iterator();
		double sum = 0;
		while (itr.hasNext()) {
			String word = (String) itr.next();
			int num = dict.get(word);
			System.out.println(word + ": " + num);
			sum += num;
		}
		if (dict.containsKey(str)) {
			System.out.println("The frequency of occurrences of word " + str +
				"is " + dict.get(str) / sum);
			return dict.get(str);
		} else {
			System.out.println("Book doesn't contain word " + str);
			return -1;
		}
	}
}

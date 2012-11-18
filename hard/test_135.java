/*Write a method to shuffle a deck of cards It must be a perfect shuffle - in
other words, each 52! permutations of the deck has to be equally likely. Assume
that you are given a random number generator which is perfect*/

import java.util.Random;


class test_135 {
	public static void main(String[] args) {
		int loop = 100;
		for (int i = 0; i < loop; ++i) {
			int num = 3;
			int[] card = new int[num];
			for (int j = 0; j < num; ++j) card[j] = j + 1;
			shuffle(card);
		}
	}

	public static int[] shuffle(int[] card) {
		Random rand = new Random();
		for (int i = card.length; i > 0; --i) {
			int random = rand.nextInt(i);
			int tmp = card[random];
			card[random] = card[i - 1];
			card[i - 1] = tmp;
		}

		System.out.println("After shuffling...");
		for (int i : card) System.out.print(i + " ");
		System.out.println("");
		System.out.println("-------------");

		return card;
	}
}

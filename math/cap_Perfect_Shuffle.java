/*Perfect_Shuffle
careercup

Write a method to shuffle a deck of cards It must be a perfect shuffle - in
other words, each 52! permutations of the deck has to be equally likely. Assume
that you are given a random number generator which is perfect
*/

import java.util.Random;


class cap_Perfect_Shuffle {
	public static void main(String[] args) {
		int loop = 100;
		for (int i = 0; i < loop; ++i) {
			int[] card = new int[] {1, 2, 3};
			shuffle(card);
		}
	}
	public static void shuffle(int[] card) {
		Random rand = new Random();
        int random, tmp;
		for (int i = card.length; i > 0; --i) {
			random = rand.nextInt(i); // Pick k in [0, i-1] with uniform distribution.
			tmp = card[random]; // swap k, i
			card[random] = card[i - 1];
			card[i - 1] = tmp;
		}
		System.out.println("After shuffling...");
		for (int i : card) System.out.print(i + " ");
		System.out.println();
		return;
	}
}

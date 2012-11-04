/*Write a method to generate a random number between 1 and 7, given a method
that generates a random number between 1 and 5 (i e , implement rand7() using
rand5())*/

public int rand7() {
	while (true) {
		int i = rand5() * 5 + rand5() - 6; // U[0, 24]
		if (num < 21) return num % 7 + 1;
	}
}

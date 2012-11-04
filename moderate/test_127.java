/*The Game of Master Mind is played as follows:
The computer has four slots containing balls that are red (R), yellow (Y),
green (G) or blue (B). For example, the computer might have RGGB (e.g., Slot #1
is red, Slots #2 and #3 are green, Slot #4 is blue)
You, the user, are trying to guess the solution. You might, for example, guess
YRGB.
When you guess the correct color for the correct slot, you get a “hit” If you
guess a color that exists but is in the wrong slot, you get a “pseudo-hit”.
For example, the guess YRGB has 2 hits and one pseudo-hit.
For each guess, you are told the number of hits and pseudo-hits.
Write a method that, given a guess and a solution, returns the number of hits
and pseudo-hits*/

class test_127 {
	public static void main(String[] args) {
		masterMind("YRGB", "RGGB");
	}

	public static int[] masterMind(String guess, String real) {
		if (guess.length() != real.length()) return new int[] {0, 0};
		int hit = 0;
		int pse = 0;
		int len = guess.length();
		
		char[] g = guess.toCharArray();
		char[] r = real.toCharArray();
		int mask = 0;
		for (int i = 0; i < len; ++i) mask |= 1 << (1 + r[i] - 'A');
		for (int i = 0; i < len; ++i) {
			if (g[i] == r[i]) ++hit;
			else if ((mask & (1 << (1 + g[i] - 'A'))) >= 1) ++pse;
		}
		System.out.println(hit + " " + pse);
		return new int[] {hit, pse};
	}
}

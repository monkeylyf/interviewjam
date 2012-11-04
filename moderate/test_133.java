/*Design an algorithm to find all pairs of integers within an array which sum
to a specified value*/
import java.util.*;


class test_133 {
	public static void main(String[] args) {
		int[] input= {0, 3, 5, 14, 6, -1, 7, 8, 13, -2};
		printPair(input, 5);
	}

	public static void printPair(int[] input, int sum) {
		Arrays.sort(input);
		int first = 0;
		int last = input.length - 1;
		while (first < last) {
			if (input[first] + input[last] == sum) {
				System.out.println(input[first] + " and " + input[last]);
				++first;
				--last;
			} else if (input[first] + input[last] < sum) ++first;
			else --last;
		}
	
	}
}

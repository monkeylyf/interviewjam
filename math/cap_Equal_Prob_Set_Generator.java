/*Equal_Prob_Set_Generator
careercup

Write a method to randomly generate a set of m integers from an array of size
n. Each element must have equal probability of being chosen
*/

import java.util.Arrays;
import java.util.Random;


class cap_Equal_Prob_Set_Generator {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6};
		int[] arr1 = {1,2,3};
        for (int i = 0; i < 10; ++i) {
		    pickRandomly(arr, 3);
        }
	}
	public static int[] pickRandomly(int[] arr, int m) {
        int[] copy = Arrays.copyOfRange(arr, 0, arr.length), retval = new int[m];
		Random rand = new Random();
		int index = arr.length, random;
		for (int i = 0; i < m; ++i) {
			random = rand.nextInt(index);
			retval[i] = copy[random];
			copy[random] = copy[index - 1]; // Same as perfect shuffle.
			--index;
		}
		for (int i : retval) System.out.print(i + " ");
		System.out.println();
		return retval;
	}
}

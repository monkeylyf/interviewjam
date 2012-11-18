/*Write a method to randomly generate a set of m integers from an array of size
n. Each element must have equal probability of being chosen*/

import java.util.Random;


class test_136 {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6};
		int[] arr1 = {1,2,3};
		pickRandomly(new int[] {1,2,3}, 2);
		pickRandomly(new int[] {1,2,3}, 2);
		pickRandomly(new int[] {1,2,3}, 2);
		pickRandomly(new int[] {1,2,3}, 2);
		pickRandomly(new int[] {1,2,3}, 2);
		pickRandomly(new int[] {1,2,3}, 2);
		pickRandomly(new int[] {1,2,3}, 2);
		pickRandomly(new int[] {1,2,3}, 2);
		pickRandomly(new int[] {1,2,3}, 2);
		pickRandomly(new int[] {1,2,3}, 2);

	}

	public static int[] pickRandomly(int[] arr, int m) {
		int[] retval = new int[m];
		Random rand = new Random();
		int index = arr.length;
		for (int i = 0; i < m; ++i) {
			int random = rand.nextInt(index);
			retval[i] = arr[random];
			arr[random] = arr[index - 1];
			--index;
		}
		for (int i : retval) System.out.print(i + " ");
		System.out.println("");
		return retval;
	}
}

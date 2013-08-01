/*Merge_Two_Sorted_Arrays
careercup

You are given two sorted arrays, A and B, and A has a large enough buffer at
the end to hold B. Write a method to merge B into A in sorted order
*/

public class cap_Merge_Two_Sorted_Arrays {

	public static void main(String[] args) {
		int[] a = new int[9];
		int[] b = new int[4];
		for (int i = 0; i < 5; ++i) {
            a[i] = i * 2 + 1;
        }
		b[0] = 2; b[1] = 8; b[2] = 10;b[3] = 11;
		// a: 1,3,5,7,9,0,0,0,0
		// b: 2,8,10,11
		// output: 1,2,3,5,7,8,9,10,11
		// In this case b is depleted first.
		mergeSorted(a, b, 5, 4);
		System.out.println("------");
		for (int i = 0; i < 5; ++i) {
            a[i] = i * 2 + 2;
        }
		b[0] = 1; b[1] = 1; b[2] = 1;b[3] = 1;
		// a: 2,4,6,8,10,0,0,0,0
		// b: 1,1,1,1
		// output: 1,1,1,1,2,4,6,8,10
		// In this case a is depleted first.
		mergeSorted(a, b, 5, 4);
		print(a);
	}

	public static void mergeSorted(int[] a, int[] b, int m, int n) {
		int i = m - 1; // Point to last element of a.
		int j = n - 1; // Point to last element of b.
		int cur = m + n - 1;
		while (i != -1 && j != -1) {
			if (a[i] >= b[j]) {
                a[cur--] = a[i--];
            } else {
                a[cur--] = b[j--];
            }
			for (int k : a) System.out.print(" " + k);
			System.out.println();
		}
		while (j > -1) {
            a[cur--] = b[j--];
        }
	}

	public static void print(int[] arr) {
		for (int i : arr) System.out.print(i);	
		System.out.println();
	}
}

/*BST_Identical_Check_Without_Building_Trees
geeksforgeeks

Given two arrays which represent a sequence of keys. Imagine we make a
Binary Search Tree from each array by inserting the elements sequentially
one by one. We need to tell whether two BSTs will be identical or not
without actually constructing the tree.

Examples For example, the input arrays are {2, 4, 3, 1} and {2, 1, 4, 3}
will construct the same tree
*/

public class BST_Identical_Check_Without_Building_Trees {

	public static void main(String[] args) {
		int[] a = { 8, 3, 6, 1, 4, 7, 10, 14, 13 };
		int[] b = { 8, 10, 14, 3, 6, 4, 1, 7, 13 };
		System.out.println(isIdenticalBST(a, b));
	}

	public static boolean isIdenticalBST(int[] a, int[] b) {
		assert (a.length == b.length);
		return isIdenticalBSTUtil(a, b, 0, 0, Integer.MAX_VALUE,
				Integer.MIN_VALUE);
	}

	public static boolean isIdenticalBSTUtil(int[] a, int[] b, int i1, int i2,
			int min, int max) {
		// Scan for the first element falls int[min, max] for both arrays.
		int j, k;
		for (j = i1; j < a.length; ++j) {
			if (a[j] > min && a[j] < max) { // <= max depends on the definition of BST.
				break;
			}
		}
		for (k = i2; k < b.length; ++k) {
			if (b[k] > min && b[k] < max) {
				break;
			}
		}

		// Both reaches the end of array.
		if (j == a.length && k == b.length) { // Done scanning subtree.
			return true;
		}

		// If the value of a is not equal to value of b then it's not idential node
		// at the same position. Return false.
		// If Either of the element is last of the arrays, then current position one tree
		// has subtree (either left or right) but another doesn't. return false.
		if (a[j] != b[k] || ((j == a.length) ^ (k == b.length))) {
			return false;
		}

		// Recursively check if substree is identical.
		// The value of current node you just locate, is the uplimit of left subtree
		// and the dowlimit of right subtree.
		return isIdenticalBSTUtil(a, b, j + 1, k + 1, a[j], max)
				&& isIdenticalBSTUtil(a, b, j + 1, k + 1, min, a[j]);
	}
}

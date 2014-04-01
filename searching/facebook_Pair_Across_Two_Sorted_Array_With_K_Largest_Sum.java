/** facebook_Pair_Across_Two_Sorted_Array_With_K_Largest_Sum.
 *
 * Given two sorted arrays of numbers, we want to find the pair with the kth
 * largest possible sum. (A pair is one element from the first array and one 
 * element from the second array). For example, with arrays:
 *
 * [2, 3, 5, 8, 13]
 * [4, 8, 12, 16]
 *
 * The pairs with largest sums are:
 * 13 + 16 = 29
 * 13 + 12 = 25
 * 8 + 16 = 24
 * 13 + 8 = 21
 * 8 + 12 = 20
 *
 */

import java.util.ArrayList;
import java.util.PriorityQueue;


public class facebook_Pair_Across_Two_Sorted_Array_With_K_Largest_Sum {

  public static void main(String[] args) {
	facebook_Pair_Across_Two_Sorted_Array_With_K_Largest_Sum instance = new facebook_Pair_Across_Two_Sorted_Array_With_K_Largest_Sum();
	instance.solve();
  }

  public void solve() {
	// Test case.
	int[] a = new int[] {13, 8, 5, 3, 2};
	int[] b = new int[] {16, 12, 8, 4, 1};
	System.out.println(findKthLargestPair(a, b, 5));
  }

  /** Time complexity O(lg k * k).
   *  The idea is more like level-order traversal. When you have pair(x, y)
   *  then the next smaller pair is either pair(x - 1, y) or pair(x, y - 1)
   *  Using max heap to keep the element inserted sorted.
   */
  public ArrayList<Pair> findKthLargestPair(int[] a, int[] b, int k) {
	ArrayList<Pair> ret = new ArrayList<Pair>();
	PriorityQueue<Pair> q = new PriorityQueue<Pair>(k);
	q.add(new Pair(a[0], b[0], 0, 0));

	for (int i = k; i > 0; --i) {
	  Pair cur = q.poll();
	  q.add(new Pair(a[cur.idxX + 1], b[cur.idxY], cur.idxX + 1, cur.idxY));
	  q.add(new Pair(a[cur.idxX], b[cur.idxY + 1], cur.idxX, cur.idxY + 1));
	  ret.add(cur);
	}
	return ret;
  }

  class Pair implements Comparable<Pair>{
	int x;
	int y;
	int idxX;
	int idxY;

	Pair(int x, int y, int idxX, int idxY) {
	  this.x = x;
	  this.y = y;
	  this.idxX = idxX;
	  this.idxY = idxY;
	}

	@Override
	  public int compareTo(Pair that) {
		return that.x + that.y - this.x - this.y;
	  }

	public String toString() {
	  return "<" + this.x + ", " + this.y + ">";
	}
  }
}

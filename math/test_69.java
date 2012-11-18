/*Design an algorithm to find the kth number such that the only prime factors
are 3, 5, and 7*/

import java.util.*;

class test_69 {
	public static void main(String[] args) {
		for (int i = 1; i < 50; ++i) System.out.println(getKth(i));
	}
	public static int getKth(int k) {
		Queue<Integer> H3 = new LinkedList<Integer>();
		Queue<Integer> H5 = new LinkedList<Integer>();
		Queue<Integer> H7 = new LinkedList<Integer>();
		Stack<Integer> sorted = new Stack<Integer>();
		int seed = 1;
		sorted.push(seed);
		H3.offer(seed * 3);
		H5.offer(seed * 5);
		H7.offer(seed * 7);
		for (int i = 0; i < k - 1; ++i) {
			int smallest = Math.min(Math.min(H3.peek(), H5.peek()), H7.peek());
			if (smallest == H3.peek()) {
				sorted.push(H3.poll());
				H3.offer(sorted.peek() * 3);
				H5.offer(sorted.peek() * 5);
				H7.offer(sorted.peek() * 7);
			}
			if (smallest == H5.peek()) {
				sorted.push(H5.poll());
				H5.offer(sorted.peek() * 5);
				H7.offer(sorted.peek() * 7);
			}
			if (smallest == H7.peek()) {
				sorted.push(H7.poll());
				H7.offer(sorted.peek() * 7);
			}
		}
		return sorted.peek();
	}
}

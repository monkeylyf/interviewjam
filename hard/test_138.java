/*You have a large text file containing words. Given any two words, find the
shortest distance (in terms of number of words) between them in the file. Can
you make the searching operation in O(1) time? What about the space complexity
for your solution?*/

import java.util.Queue;
import java.util.LinkedList;

class test_138 {
	public static void main(String[] args) {
		String[] input = {"b","c","b","a","d","d","e","e","b", "f", "f", "f", "d"};
		findShortest(input, "b", "d");
	}

	public static int findShortest(String[] arr, String a, String b) {
		step s = new step();
		String last = null;
		int shortest = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; ++i) {
			if (arr[i] == a || arr[i] == b) {
				s.takeStep(i);
				if (s.size() == 2) {
					if (last != arr[i]) {
						shortest = Math.min(shortest, s.span());
						System.out.println("Location " + i + " get span " + s.span());
					}
				}
				last = arr[i];
			}
		}
		System.out.println("Shortest span is: " + shortest);
		return shortest;
	}
}

class step {
	public Queue<Integer> q = new LinkedList<Integer>();

	public void takeStep(int i) {
		if (size() < 2) q.add(i);
		else {q.remove();q.add(i);}
	}

	public int size() {return q.size();}

	public int span() {
		if (size() == 2) {
			Object[] arr = q.toArray();
			return (Integer)arr[1] - (Integer)arr[0];
		}
		return Integer.MAX_VALUE;
	}
}

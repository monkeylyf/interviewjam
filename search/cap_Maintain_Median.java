/*Maintain_Median

careercup

Numbers are randomly generated and passed to a method. Write a program to
find and maintain the median value as new values are generated
*/

import java.util.*;

public class cap_Maintain_Median {

	public static void main(String[] args) {
		Solution median = new Solution();
		for (int i = 0; i < 9; ++i) {
			median.push(i);
			System.out.println(median.getMedian());
		}
	}
}


class Solution {

	private Comparator<Integer> maxHeapComparator = new maxComparator();
	private Comparator<Integer> minHeapComparator = new minComparator();

	private PriorityQueue<Integer> max = new PriorityQueue<Integer>(100, maxHeapComparator);
	private PriorityQueue<Integer> min = new PriorityQueue<Integer>(100, minHeapComparator);

	private int size = 0;
	private int median = 0;

	public void push(int i ) {
		if (size++ == 0) {
            median = i;
		} else {
			if (median < i) {
                max.offer(i);
			} else {
                min.offer(i);
            }
			if (max.size() - min.size() > 1) {
				min.offer(median);
				median = max.poll();
			}
			if (min.size() - max.size() > 1) {
				max.offer(median);
				median = min.poll();
			}
		}
	}

	public int getSize() {
        return size;
    }

	public int getMedian() {
        return median;
    }
}


class maxComparator implements Comparator<Integer> {
	@Override
	public int compare(Integer a, Integer b) {
		if (a > b) return 1;
		if (a < b) return -1;
		return 0;
	}
}


class minComparator implements Comparator<Integer> {
	@Override
	public int compare(Integer a, Integer b) {
		if (a < b) return 1;
		if (a > b) return -1;
		return 0;
	}
}

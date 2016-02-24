/*Median
hackerrank

Tracking the median of live integer stream. Add and Remove operations are supported.
*/
import java.util.*;


public class Median {

    public static void main(String[] args) {
        // test case.
        //System.out.println(median(new String[] {}, new int[] {}));
        //System.out.println(liveStream(new String[] {"r", "a", "a", "a", "r", "r", "r"}, new int[] {1, 1, 2, 1, 1, 2, 1}));
        //System.out.println(liveStream(new String[] {"r", "r", "r"}, new int[] {1, 1, 1}));
        //System.out.println(liveStream(new String[] {"a", "a", "a"}, new int[] {1, 1, 1}));
        //System.out.println(liveStream(new String[] {"a", "a", "a"}, new int[] {-1, -1, -1}));
        //System.out.println(liveStream(new String[] {"a", "a", "a"}, new int[] {1, 2, 3}));
        liveStream(new String[] {"a", "r", "a", "r", "a", "r"}, new int[] {1, 1, 1, 1, 1, 1});
        //System.out.println(liveStream(new String[] {"a", "a", "a", "a", "r", "r", "r", "r"}, new int[] {2,   2,   3,   1,   1,   2,   3,   2}));
        //System.out.println(liveStream(new String[] {"a", "a", "r", "a", "a", "a", "r", "r", "r", "r"}, new int[] {-10, -5, -10, 8, 2, 3, 2, 3, 8, -5}));
        //System.out.println(liveStream(new String[] {"r", "r"}, new int[] {1, 1}));
    }
    public static void liveStream(String[] op, int[] arr) {

            if (op == null || arr == null || op.length <= 0 || arr.length <= 0 || op.length != arr.length) {
                return;
            }
            HashMap<Integer, Integer> dict = new HashMap<Integer, Integer>();
            PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>();
            PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(100, new minComparator());
            for (int i = 0; i < arr.length; ++i) {
                if (op[i].equals("a")) {
                    // Hash key.
                    if (dict.containsKey(arr[i])) {
                        dict.put(arr[i], dict.get(arr[i]) + 1);
                    } else {
                        dict.put(arr[i], 1);
                    }
                    if (maxHeap.size() == 0 || arr[i] <= minHeap.peek()) {
                        minHeap.offer(arr[i]);
                    } else {
                        maxHeap.offer(arr[i]);
                    }
                    if (minHeap.size() - maxHeap.size() == 2) {
                        maxHeap.offer(minHeap.poll());
                    } else if (maxHeap.size() - minHeap.size() == 1) {
                        minHeap.offer(maxHeap.poll());
                    }
                } else { // op[i].equals("r")
                    if (minHeap.size() == 0 || !dict.containsKey(arr[i])) {
                        System.out.println("Wrong!");
                        continue;
                    }
                    if (arr[i] <= minHeap.peek()) {
                        minHeap.remove(arr[i]);
                        if (minHeap.size() < maxHeap.size() && maxHeap.size() >= 1) {
                            minHeap.offer(maxHeap.poll());
                        }
                    } else {
                        maxHeap.remove(arr[i]);
                        if (minHeap.size() - maxHeap.size() == 2) {
                            maxHeap.offer(minHeap.poll());
                        }
                    }
                    if (dict.get(arr[i]) == 1) {
                        dict.remove(arr[i]); // Remove key from dict.
                    } else {
                        dict.put(arr[i], dict.get(arr[i]) - 1);
                    }
                }
                if (minHeap.size() == 0) {
                    // Successfull removed on element.
                    System.out.println("Wrong!");
                } else if (minHeap.size() == maxHeap.size()) {
                    // maxHeap.peek() - minHeap.peek() might int overflow. Converted to double.
                    if ((minHeap.peek() & 0x1) == (maxHeap.peek() & 0x1)) {
                        System.out.println((int)(((double)maxHeap.peek() - minHeap.peek()) / 2) + minHeap.peek());
                    } else {
                        System.out.format("%.1f%n", ((double)maxHeap.peek() - minHeap.peek()) / 2.0 + minHeap.peek()); // No trailing 0s.
                } else {
                    System.out.println(minHeap.peek());
                }
            }
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

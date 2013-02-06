/*kth_Maximum_Element_in_Sorted_Matrix
google

Find the k-th maximum element in a sorted matrix.

e.g,.
[
    [1, 2, 6, 10]
    [3, 4, 7, 13]
    [5, 9, 11, 14]
    [8, 12,15, 16]
]

For a sorted, matrix, every row is sorted and every column is sorted.
*/

import java.util.Comparator;
import java.util.Hashtable;
import java.util.PriorityQueue;


class google_kth_Maximum_Element_in_Sorted_Matrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 6, 10},
                          {3, 4, 7, 13},
                          {5, 9, 11, 14},
                          {8, 12, 15, 16}};
        for (int i = 1; i <= 16; ++i) {
            System.out.println(kthMaximum(matrix, i));
        }
    }
    public static int kthMaximum(int[][] matrix, int k) {
        int ret = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        Comparator<Integer> max = new minComparator();
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(100, max);
        Hashtable<Integer, int[]> dict= new Hashtable<Integer, int[]>();
        minHeap.offer(matrix[m - 1][n - 1]);
        dict.put(matrix[m - 1][n - 1], new int[] {m - 1, n - 1});
        while (k > 0) {
            ret = minHeap.poll();
            int[] cor = dict.get(ret);
            if (cor[0] > 0 && !dict.containsKey(matrix[cor[0] - 1][cor[1]])) {
                minHeap.offer(matrix[cor[0] - 1][cor[1]]);
                dict.put(matrix[cor[0] - 1][cor[1]], new int[] {cor[0] - 1, cor[1]});
            }
            if (cor[1] > 0 && !dict.containsKey(matrix[cor[0]][cor[1] - 1])) {
                minHeap.offer(matrix[cor[0]][cor[1] - 1]);
                dict.put(matrix[cor[0]][cor[1] - 1], new int[] {cor[0], cor[1] - 1});
            }
            --k;
        }
        return ret;
    }
}


class minComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer a, Integer b) {
        if (a < b) {
            return 1;
        } else if (a > b) {
            return -1;
        } else {
            return 0;
        }
    }
}

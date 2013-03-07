/*Triplets

here is an integer array d which does not contain more than two elements of
the same value. How many distinct ascending triples (d[i] < d[j] < d[k],
i < j < k) are present? 

Input format
The first line contains an integer N denoting the number of elements in the
array. This is followed by a single line containing N integers separated by a
single space with no leading/trailing spaces

Output format:
A single integer that denotes the number of distinct ascending triples present in the array

Constraints:
N <= 10^5
Every element of the array is present at most twice
Every element of the array is a 32-bit non-negative integer

Sample input:
6
1 1 2 2 3 4

Sample output:
4

Explanation:
The distinct triplets are
(1,2,3)
(1,2,4)
(1,3,4)
(2,3,4)
*/

import java.util.*;

class hackerrank_Triplets {
    public static void main(String[] args) {
        Solution test = new Solution();
        test.triplets(new int[] {1, 1, 2, 2});
        test.triplets(new int[] {1, 1, 2, 2, 3, 4});
        test.triplets(new int[] {1, 1, 2, 2, 3, 4, 6, 9, 9, 10});
    }
}


class Solution {

    public void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int i = 0; i < n; ++i){
            ar[i] = in.nextInt(); 
        }
    }
    // Some thoughs here:
    // Method 1: 
    public void triplets(int[] arr) {
        // Remove the duplicate elements. O(N^2)
        int processed = 1;
        for (int cur = 1; cur < arr.length; ++cur) {
            int i = 0;
            for (; i < processed; ++i) {
                if (arr[i] == arr[cur]) {
                    break;
                }
            }
            if (i == processed) {
                arr[processed] = arr[cur];
                ++processed;
            }
        }
        int[] count = new int[1];
        ArrayList<Integer> track = new ArrayList<Integer>();
        dfs(Arrays.copyOfRange(arr, 0, processed), 0, track, count);
        System.out.println(count[0]);
    }
    public void dfs(int[] arr, int start, ArrayList<Integer> track, int[] count) {
        if (track.size() == 3) {
            for (int i : track) {
                System.out.print(i + " ");
            }
            System.out.println();
            ++count[0];
        } else {
            for (int i = start; i < arr.length; ++i) {
                track.add(arr[i]);
                dfs(arr, i + 1, track, count);
                track.remove(track.size() - 1);
            }
        }
    }
}

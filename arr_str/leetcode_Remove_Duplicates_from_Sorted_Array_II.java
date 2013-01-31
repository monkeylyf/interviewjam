/*Remove_Duplicates_from_Sorted_Array_II

Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?
For example,
Given sorted array A = [1,1,1,2,2,3],
Your function should return length = 5, and A is now [1,1,2,2,3].
*/

import java.util.HashSet;


class leetcode_Remove_Duplicates_from_Sorted_Array_II {
    public static void main(String[] args) {
        removeDuplicates(new int[] {1, 2, 2, 2, 3, 3});
    }
    public static int removeDuplicates(int[] A) {
        if (A.length == 0) {
            return 0;
        }
        int len = A.length;
        int processed = 1;
        for (int cur = 1; cur < len; ++cur) {
            // In this question, duplicates are allowed at most twice so HashSet works.
            // If they are allowed more than three times, use Hashtable instead to set
            // the key value pair.
            HashSet<Integer> counter = new HashSet<Integer>();
            int j = 0; 
            for (;j < processed; ++j) {
                if (A[cur] == A[j]) {
                    if (!counter.contains(A[cur])) {
                        counter.push(A[cur]);
                    } else {
                        break;
                    }
                }
            }   
            if (j == processed) {
                A[processed] = A[cur];
                ++processed; 
            }   
        }   
        return processed;
    }
}

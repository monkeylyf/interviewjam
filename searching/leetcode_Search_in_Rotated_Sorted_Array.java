/*Search_in_Rotated_Sorted_Array

Suppose a sorted array is rotated at some pivot unknown to you beforehand.
(i.e., [0 1 2 4 5 6 7] might become [4 5 6 7 0 1 2]).
You are given a target value to search. If found in the array return its index,
otherwise return -1.
You may assume no duplicate exists in the array.
*/


public class leetcode_Search_in_Rotated_Sorted_Array {

    public static void main(String[] args) {

    }

    public static int search(int[] A, int target) {
        int start = 0, end = A.length - 1, middle;
        while (start <= end) {
			middle = (end - start) / 2 + start;
            if (target == A[middle]) {
                return middle;
            } else if (A[start] <= A[middle]) {
                // [3 4 5 6 7 0 1 2] middle 6 > start 3
                if (A[start] <= target && target <= A[middle]) {
                    end = middle - 1;
                } else {
                    start = middle + 1;
                }
            } else {
                // A[start] > A[middle] [6 7 0 1 2 3 4 5]
                if (A[middle] <= target && target <= A[end]) {
                    start = middle + 1;
                } else {
                    end = middle - 1;
                }
            }
        }
        return -1;
    }
}

/* Python Version
def search(self, A, target):
    if not A:
        return -1
    
    head = 0
    tail = len(A)- 1
    
    while head <= tail:
        mid = head + (tail - head) / 2
        if A[mid] == target:
            return mid
        elif A[head] <= A[mid]:
            # 2 3 4 5 6 7 1
            if A[head] <= target and target <= A[mid]:
                tail = mid - 1
            else:
                head = mid + 1
        else:
            # A[head] > A[mid]
            # 5 6 7 1 2 3 4
            if A[mid] <= target and target <= A[tail]:
                head = mid + 1
            else:
                tail = mid - 1
    return -1
*/

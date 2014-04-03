/*Search_for_a_Range

Given a sorted array of integers, find the starting and ending position of a
given target value.
Your algorithm's runtime complexity must be in the order of O(log n).
If the target is not found in the array, return [-1, -1].
For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
*/


public class leetcode_Search_for_a_Range {

    public static void main(String[] args) {
        searchRange(new int[] {5, 7, 7, 8, 8, 10}, 8);
        searchRange(new int[] {0,1,1,1,1,2,3,3,4,4,4,4,5,5,6,6,7,8,10,10,10}, 6);
    }

    public static int[] searchRange(int[] A, int target) {
        int[] res = new int[] {-1, -1};
        search(A, 0, A.length - 1, target, res);
        return res;
    }

    public static void search(int[] A, int start, int end, int target, int[] res) {
        int index = binarySearch(A, start, end, target);
        if (index != -1) {
            if (res[0] == -1 && res[1] == -1) {
                // In case there is only on target.
                res[0] = index;
                res[1] = index;
            } else {
                res[0] = Math.min(res[0], index);
                res[1] = Math.max(res[1], index);
            }
            search(A, start, index - 1, target, res);
            search(A, index + 1, end, target, res);
        }
    }

    public static int binarySearch(int[] A, int start, int end, int target) {
        if (start > end) {
            return -1;
        } else {
			int middle = (end - start) / 2 + start;
            if (target == A[middle]) {
                return middle;
            } else if (target > A[middle]) {
                return binarySearch(A, middle + 1, end, target);
            } else {
                return binarySearch(A, start, middle - 1, target);
            }
        }
    }
}

/* Python Version
def searchRange(self, A, target):
    if not A:
        return -1

    left = self.binarySearch(0, len(A) - 1, A, target)
    right = self.binarySearch(0, len(A) - 1, A, target, leftBound=False)
    return [left, right]

def binarySearch(self, head, tail, A, target, leftBound=True):
    if head > tail:
        return -1

    while head <= tail:
        mid = head + (tail - head) / 2
        if A[mid] == target:
            if leftBound:
                if mid != 0 and A[mid - 1] == target:
                    return self.binarySearch(head, mid - 1, A, target)
                else:
                    return mid
            else:   
                if mid != len(A) - 1 and A[mid + 1] == target:
                    return self.binarySearch(mid + 1, tail, A, target, leftBound=False)
                else:
                    return mid
        elif A[mid] > target:
            tail = mid - 1
        else:
            head = mid + 1
            
    return -1
*/

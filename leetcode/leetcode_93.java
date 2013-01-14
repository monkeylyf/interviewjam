/*Search for a Range

Given a sorted array of integers, find the starting and ending position of a
given target value.
Your algorithm's runtime complexity must be in the order of O(log n).
If the target is not found in the array, return [-1, -1].
For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
*/


class leetcode_93 {
    public static void main(String[] args) {
        searchRange(new int[] {5, 7, 7, 8, 8, 10}, 8);
        searchRange(new int[] {0,1,1,1,1,2,3,3,4,4,4,4,5,5,6,6,7,8,10,10,10}, 6);
    }
    public static int[] searchRange(int[] A, int target) {
        int[] res = new int[] {-1, -1};
        int start = 0;
        int end = A.length - 1;
        int middle = 0;
        while (start <= end) {
            middle = A[(start + end) / 2];
            if (middle == target) {
                break;
            } else if (middle > target) {
                end = (start + end ) / 2 - 1;
            } else {
                start = ( start + end ) / 2 + 1;
            }
        }
        if (start > end) return res;
        // range start.
        int tmpStart = start;
        int tmpEnd = (start + end) / 2;
        while (tmpStart <= tmpEnd) {
            int index = (tmpStart + tmpEnd) / 2;
            int tmpMiddle = A[index];
            if (tmpMiddle < target) {
                tmpStart = index + 1;
            } else if (tmpMiddle == target) {
                if (index == 0) {
                    res[0] = 0;
                    break;
                } else if (A[index - 1] != target) {
                    res[0] = index;
                    break;
                } else {
                    tmpEnd = index - 1;
                }
            } else {
            }
        }
        // range right.
        tmpStart = (start + end) / 2;
        tmpEnd = end;
        while (tmpStart <= tmpEnd) {
            int index = (tmpStart + tmpEnd) / 2;
            int tmpMiddle = A[index];
            if (tmpMiddle > target) {
                tmpEnd = index - 1; 
            } else if (tmpMiddle == target) {
                if (index == A.length - 1) {
                    res[1] = A.length - 1;
                    break;
                } else if (A[index + 1] != target) {
                    res[1] = index;
                    break;
                } else {
                    tmpStart = index + 1;
                }
            } else {
            }
        }
        return res;
    }
}

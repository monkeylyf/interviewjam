/*Search Insert Position

Given a sorted array and a target value, return the index if the target is
found. If not, return the index where it would be if it were inserted in
order.
You may assume no duplicates in the array.
Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0
*/


class leetcode_96 {
    public static void main(String[] args) {
    }
    public static int searchInsert(int[] A, int target) {
        if (target <= A[0]) return 0;
        for (int i = 1;i < A.length; ++i) {
            if (A[i] >= target && A[i - 1] < target) {
                return i;
            }
        }
        return A.length;
    }
}

/*Jump_Game

Given an array of non-negative integers, you are initially positioned at the
first index of the array.
Each element in the array represents your maximum jump length at that position.
Determine if you are able to reach the last index.
For example:
A = [2,3,1,1,4], return true.
A = [3,2,1,0,4], return false.
*/

class leetcode_Jump_Game {
    public static void main(String[] args) {
    
    }
    // You can always reach the last index as long as you don't step on 0.
    public static boolean canJump(int[] A) {
        if (A.length == 0) {
            return false;
        }
        int ptr = 0;
        while (ptr < A.length - 1) {
            if (A[ptr] == 0) {
                return false; // Get trapped.
            }
            ptr += A[ptr];
        }
        // Now ptr >= A.length - 1 meaning you've reached the last index.
        return true;
    }
}

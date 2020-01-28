/**
 * Given an array A of integers, return true if and only if we can partition the
 * array into three non-empty parts with equal sums.
 *
 * Formally, we can partition the array if we can find indexes i+1 < j with
 * (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1]
 * + ... + A[A.length - 1])
 *
 * Example 1:
 * Input: [0,2,1,-6,6,-7,9,1,2,0,1]
 * Output: true
 * Explanation: 0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
 *
 * Example 2:
 * Input: [0,2,1,-6,6,7,9,-1,2,0,1]
 * Output: false
 *
 * Example 3:
 * Input: [3,3,6,5,-2,2,5,1,-9,4]
 * Output: true
 * Explanation: 3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4
 *
 * Note:
 * 3 <= A.length <= 50000
 * -10000 <= A[i] <= 10000
 */

fn main() {
    let input1: Vec<i32> = vec![0,2,1,-6,6,-7,9,1,2,0,1];
    assert!(Solution::can_three_parts_equal_sum(input1));
    let input2: Vec<i32> = vec![0,2,1,-6,6,7,9,1,2,0,1];
    assert!(!Solution::can_three_parts_equal_sum(input2));
    let input3: Vec<i32> = vec![3,3,6,5,-2,2,5,1,-9,4];
    assert!(Solution::can_three_parts_equal_sum(input3));
    let input4: Vec<i32> = vec![0,2,1,-6,6,7,9,-1,2,0,1];
    assert!(!Solution::can_three_parts_equal_sum(input4));
}

struct Solution {}

impl Solution {
    pub fn can_three_parts_equal_sum(a: Vec<i32>) -> bool {
        let s: i32 = a.iter().sum();
        if s % 3 != 0 {
            return false;
        }
        let partition_sum: i32 = s / 3;
        let mut num_of_partitions: i32 = 0;
        let mut acc: i32 = 0;
        for i in a {
            acc += i;
            if acc == partition_sum {
                num_of_partitions += 1;
                acc = 0;
            }
        }
        return num_of_partitions >= 3 && acc == 0;
    }
}

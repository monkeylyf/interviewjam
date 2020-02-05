/**
 * Given an array A of non-negative integers, half of the integers in A are odd,
 * and half of the integers are even.
 *
 * Sort the array so that whenever A[i] is odd, i is odd; and whenever A[i] is
 * even, i is even.
 * You may return any answer array that satisfies this condition.
 *
 * Example 1:
 * Input: [4,2,5,7]
 * Output: [4,5,2,7]
 * Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.
 *
 * Note:
 * 2 <= A.length <= 20000
 * A.length % 2 == 0
 * 0 <= A[i] <= 1000
 */

fn main() {
    assert_eq!(vec![4, 5, 2, 7], Solution::sort_array_by_parity_ii(vec![4, 2, 5, 7]));
}

struct Solution {}

impl Solution {
    pub fn sort_array_by_parity_ii(a: Vec<i32>) -> Vec<i32> {
        let mut copied: Vec<i32> = a.iter().cloned().collect();
        let mut i: usize = 0;
        let mut j: usize = 1;
        let length: usize = a.len();
        while i < length && j < length {
            while i < length && copied[i] % 2 == 0 {
                i += 2;
            }
            while j < length && copied[j] % 2 != 0 {
                j += 2;
            }

            if i < length && j < length {
                let temp: i32 = copied[i];
                copied[i] = copied[j];
                copied[j] = temp;
                i += 2;
                j += 2;
            }
        }
        return copied;
    }
}

/**
 * Given an array A of non-negative integers, return an array consisting of all
 * the even elements of A, followed by all the odd elements of A.
 *
 * You may return any answer array that satisfies this condition.
 *
 * Example 1:
 * Input: [3,1,2,4]
 * Output: [2,4,3,1]
 * The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 *
 * Note:
 * 1 <= A.length <= 5000
 * 0 <= A[i] <= 5000
 */

fn main() {
    assert_eq!(vec![4, 2, 1, 3], Solution::sort_array_by_parity(vec![3, 1, 2, 4]));
}

struct Solution {}

impl Solution {
    pub fn sort_array_by_parity(a: Vec<i32>) -> Vec<i32> {
        let mut copied: Vec<i32> = a.iter().cloned().collect();
        let mut i: usize = 0;
        let mut j: usize = a.len() - 1;
        while i < j {
            while i < j && copied[i] % 2 == 0 {
                i += 1
            }
            while i < j && copied[j] % 2 != 0 {
                j -= 1
            }

            if i < j {
                copied.swap(i, j);
            } else {
                break;
            }
        }
        return copied;
    }
}

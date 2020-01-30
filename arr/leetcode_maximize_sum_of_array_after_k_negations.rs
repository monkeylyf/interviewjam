/**
 * Given an array A of integers, we must modify the array in the following way:
 * we choose an i and replace A[i] with -A[i], and we repeat this process K
 * times in total.  (We may choose the same index i multiple times.)
 *
 * Return the largest possible sum of the array after modifying it in this way.
 *
 * Example 1:
 * Input: A = [4,2,3], K = 1
 * Output: 5
 * Explanation: Choose indices (1,) and A becomes [4,-2,3].
 *
 * Example 2:
 * Input: A = [3,-1,0,2], K = 3
 * Output: 6
 * Explanation: Choose indices (1, 2, 2) and A becomes [3,1,0,2].
 *
 * Example 3:
 * Input: A = [2,-3,-1,5,-4], K = 2
 * Output: 13
 * Explanation: Choose indices (1, 4) and A becomes [2,3,-1,5,4].
 *
 * Note:
 * 1 <= A.length <= 10000
 * 1 <= K <= 10000
 * -100 <= A[i] <= 100
 */

use std::cmp::Reverse;
use std::i32::MAX;
use std::i32::MIN;
use std::collections::BinaryHeap;

fn main() {
    let input1: Vec<i32> = vec![3, -1, 0, 2];
    assert_eq!(6, Solution::largest_sum_after_k_negations(input1, 3));
    let input2: Vec<i32> = vec![4, 2, 3];
    assert_eq!(5, Solution::largest_sum_after_k_negations(input2, 1));
    let input3: Vec<i32> = vec![2,-3,-1,5,-4];
    assert_eq!(13, Solution::largest_sum_after_k_negations(input3, 2));
}

struct Solution {}

impl Solution {
    pub fn largest_sum_after_k_negations(a: Vec<i32>, k: i32) -> i32 {
        let mut heap: BinaryHeap<Reverse<i32>> = BinaryHeap::new();
        let mut has_zero: bool = false;
        let mut sum_of_positive = 0;
        let mut min_positive = MAX;
        let mut max_negative = MIN;
        for i in a {
            if i == 0 {
                has_zero = true;
            } else if i < 0 {
                heap.push(Reverse(i));
                if i > max_negative {
                    max_negative = i;
                }
            } else {
                sum_of_positive += i;
                if i < min_positive {
                    min_positive = i;
                }
            }
        }
        if heap.len() >= k as usize {
            // Number of negatives is no less than K. Flip the smallest K
            // negatives and sum it all.
            let mut acc: i32 = 0;
            for _ in 0..k {
                acc -= heap.pop().unwrap().0;
            }
            while !heap.is_empty() {
                acc += heap.pop().unwrap().0;
            }
            return sum_of_positive + acc;
        } else if ((k as usize - heap.len()) % 2 == 0) || has_zero {
            // Number of negatives is smaller than K. First flip smallest
            // negative numbers to make the sum as max as possible.
            // 1. There is zero in this sequence and flip any number of zero
            //    has no effect.
            // 2. After fliping all negatives there is still an even number to
            //    flip. Pick any number to flip even times has no effect.
            let mut acc: i32 = 0;
            while !heap.is_empty() {
                acc -= heap.pop().unwrap().0;
            }
            return sum_of_positive + acc;
        } else {
            // Based on the case above, flip the smallest positive or largest
            // negative to reach the max.
            let mut acc: i32 = 0;
            while !heap.is_empty() {
                acc -= heap.pop().unwrap().0;
            }
            if max_negative < -min_positive {
                return sum_of_positive + acc - 2 * min_positive;
            } else {
                return sum_of_positive + acc + 2 * max_negative;
            }
        }
    }
}

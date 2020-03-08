/**
 * Given two arrays, write a function to compute their intersection.
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 * Example 2:
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 * Note:
 *
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 * Follow up:
 *
 * What if the given array is already sorted? How would you optimize your algorithm?
 * What if nums1's size is small compared to nums2's size? Which algorithm is better?
 * What if elements of nums2 are stored on disk, and the memory is limited such
 * that you cannot load all elements into the memory at once?
 */

use std::collections::HashMap;

fn main() {
    assert_eq!(vec![4, 9], Solution::intersect(vec![4, 9, 5], vec![9, 4, 9, 8, 4]));
}

struct Solution {
}

impl Solution {
    pub fn intersect(nums1: Vec<i32>, nums2: Vec<i32>) -> Vec<i32> {
        let counter1: HashMap<i32, i32> = Self::count(nums1);
        let counter2: HashMap<i32, i32> = Self::count(nums2);
        let mut intersection: Vec<i32> = vec![];
        for (i, frequency) in counter1.iter() {
            if let Some(f) = counter2.get(i) {
                let min: i32 = std::cmp::min(*f, *frequency);
                for _ in 0..min {
                    intersection.push(*i);
                }
            }
        }
        return intersection;
    }

    fn count(nums: Vec<i32>) -> HashMap<i32, i32> {
        let mut counter: HashMap<i32, i32> = HashMap::new();
        for i in nums {
            *counter.entry(i).or_insert(0) += 1;
        }
        return counter;
    }
}

/**
 * Given the array nums, for each nums[i] find out how many numbers in the array
 * are smaller than it. That is, for each nums[i] you have to count the number
 * of valid j's such that j != i and nums[j] < nums[i].
 *
 * Return the answer in an array.
 *
 * Example 1:
 * Input: nums = [8,1,2,2,3]
 * Output: [4,0,1,1,3]
 * Explanation:
 * For nums[0]=8 there exist four smaller numbers than it (1, 2, 2 and 3).
 * For nums[1]=1 does not exist any smaller number than it.
 * For nums[2]=2 there exist one smaller number than it (1).
 * For nums[3]=2 there exist one smaller number than it (1).
 * For nums[4]=3 there exist three smaller numbers than it (1, 2 and 2).
 *
 * Example 2:
 * Input: nums = [6,5,4,8]
 * Output: [2,1,0,3]
 *
 * Example 3:
 * Input: nums = [7,7,7,7]
 * Output: [0,0,0,0]
 *
 * Constraints:
 * 2 <= nums.length <= 500
 * 0 <= nums[i] <= 100
 */

fn main() {
    assert_eq!(vec![4, 0, 1, 1, 3], Solution::smaller_numbers_than_current(vec![8, 1, 2, 2, 3]));
    assert_eq!(vec![2, 1, 0, 3], Solution::smaller_numbers_than_current(vec![6, 5, 4, 8]));
}

struct Solution {}

impl Solution {
    pub fn smaller_numbers_than_current(nums: Vec<i32>) -> Vec<i32> {
        let mut count: [i16; 101] = [0; 101];
        for i in &nums {
            let index: usize = *i as usize;
            count[index] += 1;
        }
        let mut acc: i16 = 0;
        for i in 0..101 {
            if count[i] != 0 {
                let temp = count[i];
                count[i] = acc;
                acc += temp;
            }
        }
        let mut retval: Vec<i32> = Vec::with_capacity(nums.len());
        for i in &nums {
            let index: usize = *i as usize;
            retval.push(count[index] as i32);
        }
        return retval;
    }
}

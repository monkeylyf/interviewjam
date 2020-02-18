/**
 * Given an integer array with even length, where different numbers in this
 * array represent different kinds of candies. Each number means one candy of
 * the corresponding kind. You need to distribute these candies equally in
 * number to brother and sister. Return the maximum number of kinds of candies
 * the sister could gain.
 *
 * Example 1:
 * Input: candies = [1,1,2,2,3,3]
 * Output: 3
 * Explanation:
 * There are three different kinds of candies (1, 2 and 3), and two candies for
 * each kind.
 * Optimal distribution: The sister has candies [1,2,3] and the brother has
 * candies [1,2,3], too.
 * The sister has three different kinds of candies.
 *
 * Example 2:
 * Input: candies = [1,1,2,3]
 * Output: 2
 * Explanation: For example, the sister has candies [2,3] and the brother has
 * candies [1,1].
 * The sister has two different kinds of candies, the brother has only one kind
 * of candies.
 *
 * Note:
 * The length of the given array is in range [2, 10,000], and will be even.
 * The number in given array is in range [-100,000, 100,000].
 */

fn main() {
    assert_eq!(2, Solution::distribute_candies(vec![1, 1, 2, 3]));
    assert_eq!(3, Solution::distribute_candies(vec![1, 1, 2, 2, 3, 3]));
}

struct Solution {}

impl Solution {
    pub fn distribute_candies(candies: Vec<i32>) -> i32 {
        let unique: usize = candies.iter().collect::<std::collections::HashSet<&i32>>().len();
        return std::cmp::min(candies.len() / 2, unique) as i32;
    }
}

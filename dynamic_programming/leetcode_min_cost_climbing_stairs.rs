/**
 * On a staircase, the i-th step has some non-negative cost cost[i] assigned (0
 * indexed).
 *
 * Once you pay the cost, you can either climb one or two steps. You need to
 * find minimum cost to reach the top of the floor, and you can either start
 * from the step with index 0, or the step with index 1.
 *
 * Example 1:
 * Input: cost = [10, 15, 20]
 * Output: 15
 * Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
 * Example 2:
 * Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * Output: 6
 * Explanation: Cheapest is start on cost[0], and only step on 1s, skipping
 * cost[3].
 *
 * Note:
 * cost will have a length in the range [2, 1000].
 * Every cost[i] will be an integer in the range [0, 999].
 */

use std::cmp::min;

fn main() {
    assert_eq!(15, Solution::min_cost_climbing_stairs(vec![10, 15, 20]));
    assert_eq!(6, Solution::min_cost_climbing_stairs(vec![1, 100, 1, 1, 1, 100, 1, 1, 100, 1]));
}

struct Solution {}

impl Solution {
    pub fn min_cost_climbing_stairs(cost: Vec<i32>) -> i32 {
        let length: usize = cost.len();
        let mut dp: [i32; 1_000] = [0; 1_000];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for i in 2..length {
            dp[i] = min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        return min(dp[length - 1], dp[length - 2]);
    }
}

/**
 * There are 2N people a company is planning to interview. The cost of flying
 * the i-th person to city A is costs[i][0], and the cost of flying the i-th
 * person to city B is costs[i][1].
 *
 * Return the minimum cost to fly every person to a city such that exactly N
 * people arrive in each city.
 *
 * Example 1:
 * Input: [[10,20],[30,200],[400,50],[30,20]]
 * Output: 110
 * Explanation:
 * The first person goes to city A for a cost of 10.
 * The second person goes to city A for a cost of 30.
 * The third person goes to city B for a cost of 50.
 * The fourth person goes to city B for a cost of 20.
 *
 * The total minimum cost is 10 + 30 + 50 + 20 = 110 to have half the people
 * interviewing in each city.
 *
 * Note:
 *
 * 1 <= costs.length <= 100
 * It is guaranteed that costs.length is even.
 * 1 <= costs[i][0], costs[i][1] <= 1000
 */

fn main() {
    let input: Vec<Vec<i32>> = vec![
        vec![10, 20], vec![30, 200], vec![400, 50], vec![30, 20]];
    assert_eq!(110, Solution::two_city_sched_cost(input));
}

struct Solution {}

impl Solution {
    pub fn two_city_sched_cost(costs: Vec<Vec<i32>>) -> i32 {
        let length: usize = costs.len();
        let mut relative_cost: Vec<(i32, usize)> = Vec::with_capacity(length);
        for (i, vec) in costs.iter().enumerate() {
            relative_cost.push((vec[0] - vec[1], i));
        }
        relative_cost.sort();
        let left_sum: i32 = relative_cost[0..length / 2].into_iter().map(|(_, y)| costs[*y][0]).sum();
        let right_sum: i32 = relative_cost[length / 2..length].into_iter().map(|(_, y)| costs[*y][1]).sum();
        return left_sum + right_sum;
    }
}

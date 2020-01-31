/**
 * In a town, there are N people labelled from 1 to N.  There is a rumor that
 * one of these people is secretly the town judge.
 *
 * If the town judge exists, then:
 *
 * The town judge trusts nobody.
 * Everybody (except for the town judge) trusts the town judge.
 * There is exactly one person that satisfies properties 1 and 2.
 * You are given trust, an array of pairs trust[i] = [a, b] representing that
 * the person labelled a trusts the person labelled b.
 *
 * If the town judge exists and can be identified, return the label of the town
 * judge.  Otherwise, return -1.
 *
 * Example 1:
 * Input: N = 2, trust = [[1,2]]
 * Output: 2
 *
 * Example 2:
 * Input: N = 3, trust = [[1,3],[2,3]]
 * Output: 3
 *
 * Example 3:
 * Input: N = 3, trust = [[1,3],[2,3],[3,1]]
 * Output: -1
 *
 * Example 4:
 * Input: N = 3, trust = [[1,2],[2,3]]
 * Output: -1
 *
 * Example 5:
 * Input: N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
 * Output: 3
 *
 * Note:
 * 1 <= N <= 1000
 * trust.length <= 10000
 * trust[i] are all different
 * trust[i][0] != trust[i][1]
 * 1 <= trust[i][0], trust[i][1] <= N
 */

use std::collections::HashSet;

fn main() {
    let trust1: Vec<Vec<i32>> = vec![
        vec![1, 3], vec![1, 4], vec![2, 3], vec![2, 4], vec![4, 3]];
    assert_eq!(3, Solution::find_judge(4, trust1));

    let trust2: Vec<Vec<i32>> = vec![vec![1, 2], vec![2, 3]];
    assert_eq!(-1, Solution::find_judge(3, trust2));
}

struct Solution {}

impl Solution {
    pub fn find_judge(n: i32, trust: Vec<Vec<i32>>) -> i32 {
        let mut people: HashSet<i32> = (1..=n).collect();
        for t in &trust {
            let trustee: i32 = t[0];
            people.remove(&trustee);
        }
        if people.is_empty() {
            return -1;
        }
        let judge_list: Vec<&i32> = people.iter().collect();
        let judge_candidate: i32 = *judge_list[0];
        let trusters: HashSet<i32> = trust.iter()
            .filter(|t| t[1] == judge_candidate)
            .map(|p| p[0])
            .collect();
        return if trusters.len() == (n - 1) as usize {
            judge_candidate
        } else {
            -1
        }
    }
}

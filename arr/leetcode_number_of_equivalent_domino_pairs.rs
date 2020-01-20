/**
 * Given a list of dominoes, dominoes[i] = [a, b] is equivalent to
 * dominoes[j] = [c, d] if and only if either (a==c and b==d), or (a==d and b==c)
 * - that is, one domino can be rotated to be equal to another domino.
 *
 *Return the number of pairs (i, j) for which 0 <= i < j < dominoes.length, and
 dominoes[i] is equivalent to dominoes[j].
 *
 *Example 1:
 *Input: dominoes = [[1,2],[2,1],[3,4],[5,6]]
 *Output: 1
 *
 *Constraints:
 *1 <= dominoes.length <= 40000
 *1 <= dominoes[i][j] <= 9
 */

use std::collections::HashMap;
use std::cmp::max;
use std::cmp::min;

fn main() {
    let input: Vec<Vec<i32>> = vec![
        vec![1, 2], vec![2, 1], vec![3, 4], vec![5, 6]];
    assert_eq!(1, Solution::num_equiv_domino_pairs(input));
}

struct Solution {}

impl Solution {
    pub fn num_equiv_domino_pairs(dominoes: Vec<Vec<i32>>) -> i32 {
        let mut counter: HashMap<(&i32, &i32), i32> = HashMap::new();
        for vec in dominoes.iter() {
            let i: &i32 = vec.get(0).unwrap();
            let j: &i32 = vec.get(1).unwrap();
            let t: (&i32, &i32) = (min(i, j), max(i, j));
            *counter.entry(t).or_insert(0) += 1;
        }
        let mut ret: i32 = 0;
        for i in counter.values() {
            ret += i * (i - 1) / 2;
        }
        return ret;
    }
}

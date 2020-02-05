/**
 * In a deck of cards, each card has an integer written on it.
 *
 * Return true if and only if you can choose X >= 2 such that it is possible to
 * split the entire deck into 1 or more groups of cards, where:
 *
 * Each group has exactly X cards.
 * All the cards in each group have the same integer.
 *
 * Example 1:
 * Input: [1,2,3,4,4,3,2,1]
 * Output: true
 * Explanation: Possible partition [1,1],[2,2],[3,3],[4,4]
 *
 * Example 2:
 * Input: [1,1,1,2,2,2,3,3]
 * Output: false
 * Explanation: No possible partition.
 *
 * Example 3:
 * Input: [1]
 * Output: false
 * Explanation: No possible partition.
 *
 * Example 4:
 * Input: [1,1]
 * Output: true
 * Explanation: Possible partition [1,1]
 *
 * Example 5:
 * Input: [1,1,2,2,2,2]
 * Output: true
 * Explanation: Possible partition [1,1],[2,2],[2,2]
 *
 * Note:
 * 1 <= deck.length <= 10000
 * 0 <= deck[i] < 10000
 */

fn main() {
    assert!(Solution::has_groups_size_x(vec![1,2,3,4,4,3,2,1]));
    assert!(!Solution::has_groups_size_x(vec![1]));
    assert!(Solution::has_groups_size_x(vec![1,1]));
}

struct Solution {}

impl Solution {
    pub fn has_groups_size_x(deck: Vec<i32>) -> bool {
        let mut counter: [i32; 10_000] = [0; 10_000];
        for i in &deck {
            counter[*i as usize] += 1;
        }
        let min_frequency: i32 = *counter.into_iter().filter(|x| *x > &0).max().unwrap();
        for i in 2..=min_frequency {
            if Solution::is_all_dividable(&deck, &counter, &i) {
                return true;
            }
        }

        return false;
    }

    fn is_all_dividable(deck: &Vec<i32>, counter: &[i32; 10_000], dividor: &i32) -> bool {
        for j in deck {
            if counter[*j as usize] % dividor != 0 {
                return false;
            }
        }
        return true;
    }
}

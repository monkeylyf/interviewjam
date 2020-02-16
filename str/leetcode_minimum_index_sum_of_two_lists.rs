/**
 * Suppose Andy and Doris want to choose a restaurant for dinner, and they both
 * have a list of favorite restaurants represented by strings.
 *
 * You need to help them find out their common interest with the least list
 * index sum. If there is a choice tie between answers, output all of them with
 * no order requirement. You could assume there always exists an answer.
 *
 * Example 1:
 * Input:
 * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 * ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
 * Output: ["Shogun"]
 * Explanation: The only restaurant they both like is "Shogun".
 *
 * Example 2:
 * Input:
 * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 * ["KFC", "Shogun", "Burger King"]
 * Output: ["Shogun"]
 * Explanation: The restaurant they both like and have the least index sum is
 * "Shogun" with index sum 1 (0+1).
 * Note:
 * The length of both lists will be in the range of [1, 1000].
 * The length of strings in both lists will be in the range of [1, 30].
 * The index is starting from 0 to the list length minus 1.
 * No duplicates in both lists.
 */

use std::collections::HashMap;

fn main() {
    let list1: Vec<String> = vec![
        "Shogun".to_string(), "Tapioca Express".to_string(), "Burger King".to_string(), "KFC".to_string()];
    let list2: Vec<String> = vec![
        "KFC".to_string(), "Shogun".to_string(), "Burger King".to_string()];
    assert_eq!(vec!["Shogun".to_string()], Solution::find_restaurant(list1, list2));
}

struct Solution {}

impl Solution {
    pub fn find_restaurant(list1: Vec<String>, list2: Vec<String>) -> Vec<String> {
        let map: HashMap<&String, usize> = list1.iter().enumerate()
            .map(|e| (e.1, e.0))
            .collect();
        let mut common: Vec<String> = vec![];
        let mut min_index_sum: usize = list1.len() + list2.len();
        for (i, restaurant) in list2.iter().enumerate() {
            if let Some(j) = map.get(restaurant) {
                let index_sum: usize = i + j;
                if index_sum < min_index_sum {
                    min_index_sum = index_sum;
                    common = vec![restaurant.to_owned()];
                } else if index_sum == min_index_sum {
                    common.push(restaurant.to_owned());
                }
            }
        }
        return common;
    }
}

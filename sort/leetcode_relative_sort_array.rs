/**
 * Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all
 * elements in arr2 are also in arr1.
 *
 * Sort the elements of arr1 such that the relative ordering of items in arr1
 * are the same as in arr2.  Elements that don't appear in arr2 should be placed
 * at the end of arr1 in ascending order.
 *
 * Example 1:
 * Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * Output: [2,2,2,1,4,3,3,9,6,7,19]
 *
 * Constraints:
 * arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * Each arr2[i] is distinct.
 * Each arr2[i] is in arr1.
 */

use std::cmp::Ordering;
use std::collections::HashMap;

fn main() {
    let input = vec![2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19];
    let unique = vec![2, 1, 4, 3, 9, 6];
    assert_eq!(
        vec![2, 2, 2, 1, 4, 3, 3, 9, 6, 7, 19], Solution::relative_sort_array(input, unique));
}

struct Solution { }

impl Solution {
    pub fn relative_sort_array(arr1: Vec<i32>, arr2: Vec<i32>) -> Vec<i32> {
        if arr1.is_empty() {
            return arr1;
        }
        let mut to_sort: Vec<i32> = arr1.iter().cloned().collect();
        if arr2.is_empty() {
            to_sort.sort();
            return to_sort;
        }

        let mut value_by_index: HashMap<i32, usize> = HashMap::new();
        for (index, &value) in arr2.iter().enumerate() {
            value_by_index.insert(value, index);
        }

        to_sort.sort_by(|a, b| {
            if value_by_index.contains_key(&a) && value_by_index.contains_key(&b) {
                return value_by_index.get(a).cmp(&value_by_index.get(&b));
            } else if !value_by_index.contains_key(&a) && value_by_index.contains_key(&b) {
                return Ordering::Greater;
            } else if value_by_index.contains_key(&a) && !value_by_index.contains_key(&b) {
                return Ordering::Less;
            } else {
                return a.cmp(&b);
            }
        });
        return to_sort;
    }
}

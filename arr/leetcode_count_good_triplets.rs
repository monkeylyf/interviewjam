/**
 * Given an array of integers arr, and three integers a, b and c. You need to
 * find the number of good triplets.
 *
 * A triplet (arr[i], arr[j], arr[k]) is good if the following conditions are
 * true:
 *
 * 0 <= i < j < k < arr.length
 * |arr[i] - arr[j]| <= a
 * |arr[j] - arr[k]| <= b
 * |arr[i] - arr[k]| <= c
 * Where |x| denotes the absolute value of x.
 * Return the number of good triplets.
 *
 * Example 1:
 * Input: arr = [3,0,1,1,9,7], a = 7, b = 2, c = 3
 * Output: 4
 * Explanation: There are 4 good triplets: [(3,0,1), (3,0,1), (3,1,1), (0,1,1)].
 *
 * Example 2:
 * Input: arr = [1,1,2,2,3], a = 0, b = 0, c = 1
 * Output: 0
 * Explanation: No triplet satisfies all conditions.
 *
 * Constraints:
 * 3 <= arr.length <= 100
 * 0 <= arr[i] <= 1000
 * 0 <= a, b, c <= 1000
 */

fn main() {
    assert_eq!(4, Solution::count_good_triplets(vec![3, 0, 1, 1, 9, 7], 7, 2, 3));
    assert_eq!(0, Solution::count_good_triplets(vec![1, 1, 2, 2, 3], 0, 0, 1));
    assert_eq!(12, Solution::count_good_triplets(vec![7,3,7,3,12,1,12,2,3], 5, 8, 1));
}

struct Solution {}


impl Solution {
    pub fn count_good_triplets(arr: Vec<i32>, a: i32, b: i32, c: i32) -> i32 {
        let length: usize = arr.len();
        let mut count: i32 = 0;
        for i in 0..length {
            for j in i + 1..length {
                if (arr[i] - arr[j]).abs() > a {
                    continue;
                }
                for k in j + 1..length {
                    if (arr[j] - arr[k]).abs() > b {
                        continue;
                    }
                    if (arr[i] - arr[k]).abs() > c {
                        continue;
                    }
                    count += 1;
                }
            }
        }
        return count;
    }
}

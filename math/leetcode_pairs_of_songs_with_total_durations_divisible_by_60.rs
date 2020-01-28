/**
 * In a list of songs, the i-th song has a duration of time[i] seconds.
 *
 * Return the number of pairs of songs for which their total duration in seconds
 * is divisible by 60.  Formally, we want the number of indices i < j with
 * (time[i] + time[j]) % 60 == 0.
 *
 * Example 1:
 * Input: [30,20,150,100,40]
 * Output: 3
 * Explanation: Three pairs have a total duration divisible by 60:
 * (time[0] = 30, time[2] = 150): total duration 180
 * (time[1] = 20, time[3] = 100): total duration 120
 * (time[1] = 20, time[4] = 40): total duration 60
 *
 * Example 2:
 * Input: [60,60,60]
 * Output: 3
 * Explanation: All three pairs have a total duration of 120, which is divisible by 60.
 *
 * Note:
 * 1 <= time.length <= 60000
 * 1 <= time[i] <= 500
 */

use std::collections::HashMap;

fn main() {
    let input1: Vec<i32> = vec![30, 20, 150, 100, 40];
    assert_eq!(3, Solution::num_pairs_divisible_by60(input1));
    let input2: Vec<i32> = vec![60, 60, 60];
    assert_eq!(3, Solution::num_pairs_divisible_by60(input2));
}

struct Solution {}

impl Solution {
    pub fn num_pairs_divisible_by60(time: Vec<i32>) -> i32 {
        let mut counter: HashMap<i32, i32> = HashMap::new();
        for duration in time {
            let remainder: i32 = duration - (duration / 60 * 60);
            *counter.entry(remainder).or_insert(0) += 1;
        }
        println!("{:?}", counter);
        let mut count: i32 = 0;
        for (value, frequency) in counter.iter() {
            if *value == 30 || *value == 0 {
                count += frequency * (frequency - 1);
            } else {
                let to_pair_key: i32 = 60 - value;
                let to_pair_with: Option<&i32> = counter.get(&to_pair_key);
                if to_pair_with.is_some() {
                    count += to_pair_with.unwrap() * frequency;
                }
            }
        }
        return count / 2;
    }
}

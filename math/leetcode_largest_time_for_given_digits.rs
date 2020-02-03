/**
 * Given an array of 4 digits, return the largest 24 hour time that can be made.
 *
 * The smallest 24 hour time is 00:00, and the largest is 23:59.  Starting from
 * 00:00, a time is larger if more time has elapsed since midnight.
 *
 * Return the answer as a string of length 5.  If no valid time can be made,
 * return an empty string.
 *
 * Example 1:
 * Input: [1,2,3,4]
 * Output: "23:41"
 *
 * Example 2:
 * Input: [5,5,5,5]
 * Output: ""
 */

fn main() {
    assert_eq!("23:41", Solution::largest_time_from_digits(vec![1, 2, 3, 4]));
    assert_eq!("", Solution::largest_time_from_digits(vec![5, 5, 5, 5]));
    assert_eq!("20:40", Solution::largest_time_from_digits(vec![2, 0, 0, 4]));
}

struct Solution {}

impl Solution {
    pub fn largest_time_from_digits(a: Vec<i32>) -> String {
        let mut used: [bool; 4] = [false; 4];
        let mut permutations: Vec<String> = vec![];
        let mut acc: Vec<i32> = vec![];
        Solution::permutate(&a, &mut used, &mut permutations, &mut acc);
        let max_value: Option<&String> = permutations.iter().max();
        return match max_value {
            Some(max) => max.to_string(),
            None => "".to_string()
        };
    }

    fn permutate(a: &Vec<i32>, used: &mut [bool; 4],
                 permutations: &mut Vec<String>, acc: &mut Vec<i32>) {
        if acc.len() == 1 && acc[0] > 2 {
            return;
        } else if acc.len() == 2 && acc[0] * 10 + acc[1] > 24 {
            return;
        } else if acc.len() == 3 && acc[2] > 6 {
            return;
        } else if acc.len() == 4 {
            if acc[2] * 10 + acc[3] > 59 {
                return;
            } else if acc[0] * 10 + acc[1] == 24 && (acc[2] != 0 || acc[3] != 0) {
                return;
            }
            let time: String = format!("{}{}:{}{}", acc[0], acc[1], acc[2], acc[3]);
            if time == "24:00" {
                permutations.push("00:00".to_string());  // Edge case.
            } else {
                permutations.push(time);
            }
        } else {
            for (i, value) in a.iter().enumerate() {
                if !used[i] {
                    acc.push(*value);
                    used[i] = true;
                    Solution::permutate(a, used, permutations, acc);
                    used[i] = false;
                    acc.pop();
                }
            }
        }
    }
}

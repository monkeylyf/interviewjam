/**
 * You're now a baseball game point recorder.
 *
 * Given a list of strings, each string can be one of the 4 following types:
 *
 * Integer (one round's score): Directly represents the number of points you get
 * in this round.
 * "+" (one round's score): Represents that the points you get in this round are
 * the sum of the last two valid round's points.
 * "D" (one round's score): Represents that the points you get in this round are
 * the doubled data of the last valid round's points.
 * "C" (an operation, which isn't a round's score): Represents the last valid
 * round's points you get were invalid and should be removed.
 * Each round's operation is permanent and could have an impact on the round
 * before and the round after.
 *
 * You need to return the sum of the points you could get in all the rounds.
 *
 * Example 1:
 * Input: ["5","2","C","D","+"]
 * Output: 30
 * Explanation:
 * Round 1: You could get 5 points. The sum is: 5.
 * Round 2: You could get 2 points. The sum is: 7.
 * Operation 1: The round 2's data was invalid. The sum is: 5.
 * Round 3: You could get 10 points (the round 2's data has been removed). The
 * sum is: 15.
 * Round 4: You could get 5 + 10 = 15 points. The sum is: 30.
 *
 * Example 2:
 * Input: ["5","-2","4","C","D","9","+","+"]
 * Output: 27
 * Explanation:
 * Round 1: You could get 5 points. The sum is: 5.
 * Round 2: You could get -2 points. The sum is: 3.
 * Round 3: You could get 4 points. The sum is: 7.
 * Operation 1: The round 3's data is invalid. The sum is: 3.
 * Round 4: You could get -4 points (the round 3's data has been removed). The
 * sum is: -1.
 * Round 5: You could get 9 points. The sum is: 8.
 * Round 6: You could get -4 + 9 = 5 points. The sum is 13.
 * Round 7: You could get 9 + 5 = 14 points. The sum is 27.
 * Note:
 * The size of the input list will be between 1 and 1000.
 * Every integer represented in the list will be between -30000 and 30000.
 */

fn main() {
    let ops: Vec<String> = vec![
        "5".to_string(),
        "2".to_string(),
        "C".to_string(),
        "D".to_string(),
        "+".to_string()];
    assert_eq!(30, Solution::cal_points(ops));
    let input: Vec<String> = vec![
        "5".to_string(),
        "-2".to_string(),
        "4".to_string(),
        "C".to_string(),
        "D".to_string(),
        "9".to_string(),
        "+".to_string(),
        "+".to_string()];
    assert_eq!(27, Solution::cal_points(input));
    let input1: Vec<String> = vec![
        "-60".to_string(),
        "D".to_string(),
        "-36".to_string(),
        "30".to_string(),
        "13".to_string(),
        "C".to_string(),
        "C".to_string(),
        "-33".to_string(),
        "53".to_string(),
        "79".to_string()];
    assert_eq!(-117, Solution::cal_points(input1)); }

struct Solution {}

impl Solution {
    pub fn cal_points(ops: Vec<String>) -> i32 {
        let mut filtered_ops: Vec<&String> = Vec::new();
        for val in &ops {
            if val == "C" && !filtered_ops.is_empty() {
                filtered_ops.pop();
            } else {
                filtered_ops.push(&val);
            }
        }
        let mut scores: Vec<i32> = vec![0; filtered_ops.len()];
        for (i, op) in filtered_ops.iter().enumerate() {
            if *op == "D" {
                if i > 0 {
                    scores[i] = 2 * scores[i - 1];
                }
            } else if *op == "+" {
                if i > 0 {
                    scores[i] += scores[i - 1];
                }
                if i > 1 {
                    scores[i] += scores[i - 2];
                }
            } else {
                let mut value: i32 = op.parse().unwrap();
                scores[i] = value;
            }
        }
        return scores.iter().sum::<i32>();
    }
}

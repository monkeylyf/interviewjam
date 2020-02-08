/**
 * In a row of seats, 1 represents a person sitting in that seat, and 0
 * represents that the seat is empty.
 *
 * There is at least one empty seat, and at least one person sitting.
 *
 * Alex wants to sit in the seat such that the distance between him and the
 * closest person to him is maximized.
 *
 * Return that maximum distance to closest person.
 *
 * Example 1:
 * Input: [1,0,0,0,1,0,1]
 * Output: 2
 * Explanation:
 * If Alex sits in the second open seat (seats[2]), then the closest person has
 * distance 2.
 * If Alex sits in any other open seat, the closest person has distance 1.
 * Thus, the maximum distance to the closest person is 2.
 *
 * Example 2:
 * Input: [1,0,0,0]
 * Output: 3
 * Explanation:
 * If Alex sits in the last seat, the closest person is 3 seats away.
 * This is the maximum distance possible, so the answer is 3.
 * Note:
 *
 * 1 <= seats.length <= 20000
 * seats contains only 0s or 1s, at least one 0, and at least one 1.
 */

fn main() {
    assert_eq!(2, Solution::max_dist_to_closest(vec![1, 0, 0, 0, 1, 0, 1]));
    assert_eq!(3, Solution::max_dist_to_closest(vec![1, 0, 0, 0]));
    assert_eq!(3, Solution::max_dist_to_closest(vec![0, 0, 0, 1]));
}

struct Solution {}

impl Solution {
    pub fn max_dist_to_closest(seats: Vec<i32>) -> i32 {
        let mut i: usize = 0;
        let length: usize = seats.len();
        // Find first chair.
        while i < length - 1 && seats[i] != 1 {
            i += 1;
        }
        let mut distance: i32 = i as i32;
        // Find space between chairs.
        let mut prev: i32 = -1;
        for (i, seat) in seats.iter().enumerate() {
            let ii: i32 = i as i32;
            if *seat == 1 {
                let space: i32 = (ii - prev) / 2;
                if prev != -1 && space > distance {
                    distance = space;
                }
                prev = ii;
            }
        }
        // Find space between last space to end.
        if seats.len() as i32 - 1 - prev > distance {
            distance = seats.len() as i32 - 1 - prev;
        }
        return distance;
    }
}

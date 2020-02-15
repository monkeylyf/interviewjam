/**
 * There is a robot starting at position (0, 0), the origin, on a 2D plane.
 * Given a sequence of its
 * moves, judge if this robot ends up at (0, 0) after it completes its moves.
 *
 * The move sequence is represented by a string, and the character moves[i]
 * represents its ith move.
 * Valid moves are R (right), L (left), U (up), and D (down). If the robot
 * returns to the origin * after it finishes all of its moves, return true.
 * Otherwise, return false.
 *
 * Note: The way that the robot is "facing" is irrelevant. "R" will always make
 * the robot move to the right once, "L" will always make it move left, etc.
 * Also, assume that the magnitude of the robot's movement is the same for each move.
 *
 * Example 1:
 * Input: "UD"
 * Output: true
 * Explanation: The robot moves up once, and then down once. All moves have the
 * same magnitude, so it ended up at the origin where it started. Therefore, we
 * return true.
 *
 * Example 2:
 * Input: "LL"
 * Output: false
 * Explanation: The robot moves left twice. It ends up two "moves" to the left
 * of the origin. We return false because it is not at the origin at the end of
 * its moves.
 */

fn main() {
    assert!(Solution::judge_circle("UD".to_string()));
    assert!(!Solution::judge_circle("LL".to_string()));
}

struct Solution {}

impl Solution {
    pub fn judge_circle(moves: String) -> bool {
        if moves.len() % 2 != 0 {
            return false;
        }
        let mut count: [i32; 4] = [0; 4];
        for c in moves.chars() {
            if c == 'U' {
                count[0] += 1;
            } else if c == 'D' {
                count[1] += 1;
            } else if c == 'L' {
                count[2] += 1;
            } else if c == 'R' {
                count[3] += 1;
            } else {
                // Do nothing.
            }
        }
        return count[0] == count[1] && count[2] == count[3];
    }
}

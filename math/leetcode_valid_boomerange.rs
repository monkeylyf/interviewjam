/**
 * A boomerang is a set of 3 points that are all distinct and not in a straight
 * line. Given a list of three points in the plane, return whether these points
 * are a boomerang.
 *
 * Example 1:
 * Input: [[1,1],[2,3],[3,2]]
 * Output: true
 *
 * Example 2:
 * Input: [[1,1],[2,2],[3,3]]
 * Output: false
 *
 * Note:
 * points.length == 3
 * points[i].length == 2
 * 0 <= points[i][j] <= 100
 */

fn main() {
    let input1: Vec<Vec<i32>> = vec![vec![1, 1], vec![2, 3], vec![3, 2]];
    assert!(Solution::is_boomerang(input1));
    let input2: Vec<Vec<i32>> = vec![vec![1, 1], vec![2, 2], vec![3, 3]];
    assert!(!Solution::is_boomerang(input2));
}

struct Solution {}

impl Solution {
    pub fn is_boomerang(points: Vec<Vec<i32>>) -> bool {
        let a1: i32 = points[0][0];
        let b1: i32 = points[0][1];
        let a2: i32 = points[1][0];
        let b2: i32 = points[1][1];
        let a3: i32 = points[2][0];
        let b3: i32 = points[2][1];
        return (a2 - a1) * (b3 - b2) != (b2 - b1) * (a3 - a2);
    }
}

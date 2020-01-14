/**
 * You are given an array coordinates, coordinates[i] = [x, y], where [x, y]
 * represents the coordinate of a point. Check if these points make a straight
 * line in the XY plane.
 *
 * Example 1:
 * Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
 * Output: true
 *
 * Example 2:
 * Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
 * Output: false
 *
 * Constraints:
 * 2 <= coordinates.length <= 1000
 * coordinates[i].length == 2
 * -10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
 * coordinates contains no duplicate point.
 */

fn main() {
    let coordinates: Vec<Vec<i32>> = vec![
        vec!(1,2), vec!(2,3), vec!(3,4), vec!(4,5), vec!(5,6), vec!(6,7)];
    assert!(Solution::check_straight_line(coordinates));
}

struct Solution {}

impl Solution {
    pub fn check_straight_line(coordinates: Vec<Vec<i32>>) -> bool {
        let base_slope: (i32, i32) = Solution::get_slope_tuple(
            coordinates.get(0).unwrap(), coordinates.get(1).unwrap());
        for i in 1..(coordinates.len() - 1) {
            let slope: (i32, i32) = Solution::get_slope_tuple(
            coordinates.get(i).unwrap(), coordinates.get(i + 1).unwrap());
            if base_slope != slope {
                return false;
            }
        }
        return true;
    }

    fn get_slope_tuple(p1: &Vec<i32>, p2: &Vec<i32>) -> (i32, i32) {
        let a: &i32 = p1.get(0).unwrap();
        let b: &i32 = p1.get(1).unwrap();
        let c: &i32 = p2.get(0).unwrap();
        let d: &i32 = p2.get(1).unwrap();
        let dx: i32 = a - c;
        let dy: i32 = b - d;
        let gcd: i32 = Solution::gcd(dx, dy);
        return (dx / gcd, dy / gcd);
    }

    fn gcd(a: i32, b: i32) -> i32 {
        match b {
            0 => a,
            _ => Solution::gcd(b, a - (a / b) * b)
        }
    }
}

/*
class Solution:
    def checkStraightLine(self, coordinates: List[List[int]]) -> bool:
        slope = None
        for i in range(len(coordinates) - 1):
            cur_slope = self.get_slope(coordinates[i], coordinates[i + 1])
            if slope is None:
                slope = cur_slope
            elif slope != cur_slope:
                return False
            else:
                pass
        return True

    def get_slope(self, p1, p2):
        a, b = p1
        c, d = p2
        dx = a - c
        dy = b - d
        gcd = self.gcd(a - c, b - d)
        return dx // gcd, dy // gcd

    def gcd(self, a, b):
        return a if b == 0 else self.gcd(b, a % b);
 */

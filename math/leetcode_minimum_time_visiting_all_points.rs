/**
 * On a plane there are n points with integer coordinates points[i] = [xi, yi].
 * Your task is to find the minimum time in seconds to visit all points.
 *
 * You can move according to the next rules:
 *
 * In one second always you can either move vertically, horizontally by one unit
 * or diagonally (it means to move one unit vertically and one unit horizontally
 * in one second).
 * You have to visit the points in the same order as they appear in the array.
 *
 * Example 1:
 * Input: points = [[1,1],[3,4],[-1,0]]
 * Output: 7
 * Explanation: One optimal path is [1,1] -> [2,2] -> [3,3] -> [3,4] -> [2,3] -> [1,2] -> [0,1] -> [-1,0]
 * Time from [1,1] to [3,4] = 3 seconds
 * Time from [3,4] to [-1,0] = 4 seconds
 * Total time = 7 seconds
 *
 * Example 2:
 * Input: points = [[3,2],[-2,2]]
 * Output: 5
 *
 * Constraints:
 * points.length == n
 * 1 <= n <= 100
 * points[i].length == 2
 * -1000 <= points[i][0], points[i][1] <= 1000
 */

use std::cmp::max;

fn main () {
}

struct Solution {}

impl Solution {
    pub fn min_time_to_visit_all_points(points: Vec<Vec<i32>>) -> i32 {
        let mut distance: i32 = 0;
        let mut i: usize = 0;
        while i < points.len() - 1 {
            let p1: &Vec<i32> = &points[i];
            let a: &i32 = &p1[0];
            let b: &i32 = &p1[1];
            let p2: &Vec<i32> = &points[i + 1];
            let c: &i32 = &p2[0];
            let d: &i32 = &p2[1];
            distance += max((a - c).abs(), (b - d).abs());
            i += 1;
        }
        return distance;
    }
}
/*
class Solution:
    def minTimeToVisitAllPoints(self, points: List[List[int]]) -> int:
        distance = 0
        i = 0
        while i < len(points) - 1:
            a, b = points[i]
            x, y = points[i + 1]
            abs_x = abs(a - x)
            abs_y = abs(b - y)
            distance += max(abs_x, abs_y)
            i += 1
        return distance
 */

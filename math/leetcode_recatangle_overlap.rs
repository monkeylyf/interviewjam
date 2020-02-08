/**
 * A rectangle is represented as a list [x1, y1, x2, y2], where (x1, y1) are the
 * coordinates of its bottom-left corner, and (x2, y2) are the coordinates of
 * its top-right corner.
 *
 * Two rectangles overlap if the area of their intersection is positive.  To be
 * clear, two rectangles that only touch at the corner or edges do not overlap.
 *
 * Given two (axis-aligned) rectangles, return whether they overlap.
 *
 * Example 1:
 * Input: rec1 = [0,0,2,2], rec2 = [1,1,3,3]
 * Output: true
 *
 * Example 2:
 * Input: rec1 = [0,0,1,1], rec2 = [1,0,2,1]
 * Output: false
 *
 * Notes:
 * Both rectangles rec1 and rec2 are lists of 4 integers.
 * All coordinates in rectangles will be between -10^9 and 10^9.
 */

fn main() {
    assert!(Solution::is_rectangle_overlap(vec![0, 0, 2, 2], vec![1, 1, 3, 3]));
    assert!(!Solution::is_rectangle_overlap(vec![0, 0, 1, 1], vec![1, 0, 2, 1]));
}

struct Solution {}

impl Solution {
    pub fn is_rectangle_overlap(rec1: Vec<i32>, rec2: Vec<i32>) -> bool {
        let x1: i32 = rec1[0];
        let y1: i32 = rec1[1];
        let x2: i32 = rec1[2];
        let y2: i32 = rec1[3];
        let i1: i32 = rec2[0];
        let j1: i32 = rec2[1];
        let i2: i32 = rec2[2];
        let j2: i32 = rec2[3];
        let intersected_at_x_axis: bool = (x1 < i1 && i1 < x2) || (x1 < i2 && i1 < x2);
        let intersected_at_y_axis: bool = (y1 < j1 && j1 < y2) || (y1 < j2 && j1 < y2);
        return intersected_at_x_axis && intersected_at_y_axis;
    }
}

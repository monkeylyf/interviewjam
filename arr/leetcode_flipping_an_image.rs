/**
 * Given a binary matrix A, we want to flip the image horizontally, then invert
 * it, and return the resulting image.
 *
 * To flip an image horizontally means that each row of the image is reversed.
 * For example, flipping [1, 1, 0] horizontally results in [0, 1, 1].
 *
 * To invert an image means that each 0 is replaced by 1, and each 1 is replaced
 * by 0. For example, inverting [0, 1, 1] results in [1, 0, 0].
 *
 * Example 1:
 * Input: [[1,1,0],[1,0,1],[0,0,0]]
 * Output: [[1,0,0],[0,1,0],[1,1,1]]
 * Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
 * Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
 *
 * Example 2:
 * Input: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
 * Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * Explanation: First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]].
 * Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 *
 * Notes:
 * 1 <= A.length = A[0].length <= 20
 * 0 <= A[i][j] <= 1
 */

fn main() {
    assert_eq!(vec![vec![1, 0, 0], vec![0, 1, 0], vec![1, 1, 1]],
             Solution::flip_and_invert_image(vec![vec![1, 1, 0], vec![1, 0, 1], vec![0, 0, 0]]));
    assert_eq!(vec![vec![0]],
             Solution::flip_and_invert_image(vec![vec![1]]));
}

struct Solution {}

impl Solution {
    pub fn flip_and_invert_image(a: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        let mut reversed: Vec<Vec<i32>> = a.iter().map(|x| x.iter().cloned().collect()).collect();
        let length: usize = a[0].len();
        for row in reversed.iter_mut() {
            let mut i: usize = 0;
            let mut j: usize = length - 1;
            while i <= j {
                if row[i] == row[j] {
                    let to_replace: i32 = if row[i] == 1 {
                        0
                    } else {
                        1
                    };
                    row[i] = to_replace;
                    row[j] = to_replace;
                }
                i += 1;
                if j > 1 {
                    j -= 1;  // Rust usize overflow protection.
                } else {
                    break;
                }
            }
        }
        return reversed;
    }
}

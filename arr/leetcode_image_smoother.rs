/**
 * Given a 2D integer matrix M representing the gray scale of an image, you need
 * to design a smoother to make the gray scale of each cell becomes the average
 * gray scale (rounding down) of all the 8 surrounding cells and itself. If a
 * cell has less than 8 surrounding cells, then use as many as you can.
 *
 * Example 1:
 * Input:
 * [[1,1,1],
 *  [1,0,1],
 *  [1,1,1]]
 * Output:
 * [[0, 0, 0],
 *  [0, 0, 0],
 *  [0, 0, 0]]
 * Explanation:
 * For the point (0,0), (0,2), (2,0), (2,2): floor(3/4) = floor(0.75) = 0
 * For the point (0,1), (1,0), (1,2), (2,1): floor(5/6) = floor(0.83333333) = 0
 * For the point (1,1): floor(8/9) = floor(0.88888889) = 0
 * Note:
 * The value in the given matrix is in the range of [0, 255].
 * The length and width of the given matrix are in the range of [1, 150].
 */

fn main() {
    println!("{:?}", Solution::image_smoother(vec![
                                              vec![1, 1, 1],
                                              vec![1, 0, 1],
                                              vec![1, 1, 1]]));
    println!("{:?}", Solution::image_smoother(vec![
                                              vec![2, 3, 4],
                                              vec![5, 6, 7],
                                              vec![8, 9, 10],
                                              vec![11, 12, 13],
                                              vec![14, 15, 16]]));
}

struct Solution {}

impl Solution {
    pub fn image_smoother(m: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        let length: usize = m.len();
        let width: usize = m[0].len();
        let directions: Vec<(i32, i32)> = vec![
            (-1, -1),
            (-1, 0),
            (-1, 1),
            (0, -1),
            (0, 0),
            (0, 1),
            (1, -1),
            (1, 0),
            (1, 1)];
        let mut smoothed: Vec<Vec<i32>> = Vec::with_capacity(length);
        for i in 0..length {
            let mut row: Vec<i32> = Vec::with_capacity(width);
            for j in 0..width {
                let mut sum: i32 = 0;
                let mut count: i32 = 0;
                for (dx, dy) in &directions {
                    let x: i32 = i as i32 + dx;
                    let y: i32 = j as i32 + dy;
                    if 0 <= x && x < length as i32 && 0 <= y && y < width as i32 {
                        count += 1;
                        sum += m[x as usize][y as usize];
                    }
                }
                row.push(sum / count);
            }
            smoothed.push(row);
        }
        return smoothed;
    }
}

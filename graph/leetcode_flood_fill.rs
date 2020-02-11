/**
 * An image is represented by a 2-D array of integers, each integer representing
 * the pixel value of the image (from 0 to 65535).
 *
 * Given a coordinate (sr, sc) representing the starting pixel (row and column)
 * of the flood fill, and a pixel value newColor, "flood fill" the image.
 *
 * To perform a "flood fill", consider the starting pixel, plus any pixels
 * connected 4-directionally to the starting pixel of the same color as the
 * starting pixel, plus any pixels connected 4-directionally to those pixels
 * (also with the same color as the starting pixel), and so on. Replace the
 * color of all of the aforementioned pixels with the newColor.
 *
 * At the end, return the modified image.
 *
 * Example 1:
 * Input:
 * image = [[1,1,1],[1,1,0],[1,0,1]]
 * sr = 1, sc = 1, newColor = 2
 * Output: [[2,2,2],[2,2,0],[2,0,1]]
 * Explanation:
 * From the center of the image (with position (sr, sc) = (1, 1)), all pixels
 * connected by a path of the same color as the starting pixel are colored with
 * the new color.
 *
 * Note the bottom corner is not colored 2, because it is not 4-directionally connected
 * to the starting pixel.
 *
 * Note:
 * The length of image and image[0] will be in the range [1, 50].
 * The given starting pixel will satisfy 0 <= sr < image.length and
 * 0 <= sc < image[0].length.
 * The value of each color in image[i][j] and newColor will be an integer in
 * [0, 65535].
 */

fn main() {
    let image: Vec<Vec<i32>> = vec![
        vec![1, 1, 1],
        vec![1, 1, 0],
        vec![1, 0, 1]];
    let flooded: Vec<Vec<i32>> = vec![
        vec![2, 2, 2],
        vec![2, 2, 0],
        vec![2, 0, 1]];
    assert_eq!(flooded, Solution::flood_fill(image, 1, 1, 2));

    let image1: Vec<Vec<i32>> = vec![
        vec![0, 0, 0],
        vec![0, 1, 1]];
    Solution::flood_fill(image1, 1, 1, 1);
}

struct Solution {}

impl Solution {
    pub fn flood_fill(image: Vec<Vec<i32>>, sr: i32, sc: i32, new_color: i32) -> Vec<Vec<i32>> {
        let color: i32 = image[sr as usize][sc as usize];
        if color == new_color {
            return image;
        }
        let directions: Vec<(i32, i32)> = vec![(1, 0), (-1, 0), (0, 1), (0, -1)];
        let length: i32 = image.len() as i32;
        let width: i32 = image[0].len() as i32;
        let mut copied: Vec<Vec<i32>> = image.iter()
            .map(|x| x.iter().cloned().collect())
            .collect();
        let mut queue: Vec<(i32, i32)> = vec![(sr, sc)];
        while !queue.is_empty() {
            let coordinate: (i32, i32) = queue.pop().unwrap();
            let x: i32 = coordinate.0;
            let y: i32 = coordinate.1;
            copied[x as usize][y as usize] = new_color;
            for (dx, dy) in &directions {
                let xx: i32 = x + dx;
                let yy: i32 = y + dy;
                if 0 <= xx && xx < length &&
                    0 <= yy && yy < width &&
                        copied[xx as usize][yy as usize] == color {
                    queue.push((xx, yy));
                }
            }
        }
        return copied;
    }
}

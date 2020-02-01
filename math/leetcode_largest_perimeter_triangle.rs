/**
 * Given an array A of positive lengths, return the largest perimeter of a
 * triangle with non-zero area, formed from 3 of these lengths.
 *
 * If it is impossible to form any triangle of non-zero area, return 0.
 *
 * Example 1:
 * Input: [2,1,2]
 * Output: 5
 *
 * Example 2:
 * Input: [1,2,1]
 * Output: 0
 *
 * Example 3:
 * Input: [3,2,3,4]
 * Output: 10
 *
 * Example 4:
 * Input: [3,6,2,3]
 * Output: 8
 *
 * Note:
 * 3 <= A.length <= 10000
 * 1 <= A[i] <= 10^6
 */

fn main() {
    let input1: Vec<i32> = vec![3, 6, 2, 3];
    assert_eq!(8, Solution::largest_perimeter(input1));

    let input2: Vec<i32> = vec![3, 2, 3, 4];
    assert_eq!(10, Solution::largest_perimeter(input2));

    let input3: Vec<i32> = vec![1, 2, 1];
    assert_eq!(0, Solution::largest_perimeter(input3));
}

struct Solution {}

impl Solution {
    pub fn largest_perimeter(a: Vec<i32>) -> i32 {
        if a.len() < 3 {
            return 0;
        }
        let mut aa: Vec<i32> = a.iter().cloned().collect();
        aa.sort();
        let mut i: usize = a.len();
        let mut perimeter: i32 = 0;
        let mut found: bool = false;
        while !found && i >= 3 {
            let a: i32 = aa[i - 3];
            let b: i32 = aa[i - 2];
            let c: i32 = aa[i - 1];
            perimeter = a + b + c;
            found = a + b > c;
            i -= 1;
        }
        return if found { perimeter } else { 0 };
    }
}

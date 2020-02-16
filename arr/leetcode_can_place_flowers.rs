/**
 * Suppose you have a long flowerbed in which some of the plots are planted and
 * some are not. However, flowers cannot be planted in adjacent plots - they
 * would compete for water and both would die.
 *
 * Given a flowerbed (represented as an array containing 0 and 1, where 0 means
 * empty and 1 means not empty), and a number n, return if n new flowers can be
 * planted in it without violating the no-adjacent-flowers rule.
 *
 * Example 1:
 * Input: flowerbed = [1,0,0,0,1], n = 1
 * Output: True
 * Example 2:
 * Input: flowerbed = [1,0,0,0,1], n = 2
 * Output: False
 * Note:
 * The input array won't violate no-adjacent-flowers rule.
 * The input array size is in the range of [1, 20000].
 * n is a non-negative integer which won't exceed the input array size.
 */

fn main() {
    assert!(Solution::can_place_flowers(vec![1, 0, 0, 0, 1], 1));
    assert!(Solution::can_place_flowers(vec![0, 0, 0, 0, 1], 2));
    assert!(Solution::can_place_flowers(vec![1, 0, 0, 0, 0], 2));
    assert!(Solution::can_place_flowers(vec![0, 0, 0, 0, 0], 3));
}

struct Solution {}

impl Solution {
    pub fn can_place_flowers(flowerbed: Vec<i32>, n: i32) -> bool {
        let mut available_plots: i32 = 0;
        let mut i: usize = 0;
        let length: usize = flowerbed.len();
        while i < length {
            if flowerbed[i] == 0 {
                let mut end: usize = i;
                while end < length {
                    if flowerbed[end] != 0 {
                        break;
                    }
                    end += 1;
                }
                if i == 0 && end == length {
                    available_plots += (end - i + 1) as i32 / 2;
                } else if i == 0 || end == length {
                    available_plots += (end - i) as i32 / 2;
                } else {
                    available_plots += (end as i32 - i as i32 - 1) / 2;
                }
                i = end;
            }
            i += 1;
        }
        return available_plots >= n;
    }
}

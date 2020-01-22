/**
 * Given a fixed length array arr of integers, duplicate each occurrence of
 * zero, shifting the remaining elements to the right.
 *
 * Note that elements beyond the length of the original array are not written.
 * Do the above modifications to the input array in place, do not return
 * anything from your function.
 *
 * Example 1:
 * Input: [1,0,2,3,0,4,5,0]
 * Output: null
 * Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
 *
 * Example 2:
 * Input: [1,2,3]
 * Output: null
 * Explanation: After calling your function, the input array is modified to: [1,2,3]
 *
 * Note:
 * 1 <= arr.length <= 10000
 * 0 <= arr[i] <= 9
 */

fn main() {
    let mut input1: Vec<i32> = vec![0, 0, 0, 0, 0, 0, 0];
    Solution::duplicate_zeros(&mut input1);
    assert_eq!(vec![0, 0, 0, 0, 0, 0, 0], input1);

    let mut input2: Vec<i32> = vec![8,4,5,0,0,0,0,7];
    Solution::duplicate_zeros(&mut input2);
    assert_eq!(vec![8, 4, 5, 0, 0, 0, 0, 0], input2);
}

struct Solution {}

impl Solution {
    /*
     * The approach is to scan array first to find out the index that in the
     * extended array is the last. The update the arr in reverse order to avoid
     * extra O(n) space required.
     */
    pub fn duplicate_zeros(arr: &mut Vec<i32>) {
        let mut length: usize = arr.len();
        let mut i: usize = 0;
        let mut last: usize = 0;
        //  Flat when the last element is 0 and there is not space to dup.
        let mut is_last_zero_and_odd: bool = false;
        while last < length {
            if arr[i] == 0 {
                last += 2;
                if last > length {
                    is_last_zero_and_odd = true;
                }
            } else {
                last += 1;
            }
            i += 1;
        }
        while i > 0 {
            let value: i32 = arr[i - 1];
            if is_last_zero_and_odd && length == arr.len() {
                // Special handling to not duplicate the last zero.
                arr[length - 1] = value;
                length -= 1;
            } else if value == 0 {
                arr[length - 1] = 0;
                if length >= 2 {
                    arr[length - 2] = 0;
                    length -= 2;
                } else {
                    length -= 1;
                }
            } else {
                arr[length - 1] = value;
                length -= 1;
            }
            i -= 1;
        }
    }
}

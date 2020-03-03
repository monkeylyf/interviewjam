/**
 * A binary watch has 4 LEDs on the top which represent the hours (0-11), and
 * the 6 LEDs on the bottom represent the minutes (0-59).
 *
 * Each LED represents a zero or one, with the least significant bit on the
 * right.
 *
 * For example, the above binary watch reads "3:25".
 *
 * Given a non-negative integer n which represents the number of LEDs that are
 * currently on, return all possible times the watch could represent.
 *
 * Example:
 * Input: n = 1
 * Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
 * Note:
 * The order of output does not matter.
 * The hour must not contain a leading zero, for example "01:00" is not valid,
 * it should be "1:00".
 * The minute must be consist of two digits and may contain a leading zero, for
 * example "10:2" is not valid, it should be "10:02".
 */

fn main() {
    println!("{:?}", Solution::read_binary_watch(1));
}

struct Solution {}

impl Solution {
    pub fn read_binary_watch(num: i32) -> Vec<String> {
        let mut times: Vec<String> = vec![];
        Self::recursive(num, 0, &mut times, &mut [false; 10]);
        return times;
    }

    fn recursive(num: i32, i: usize, acc: &mut Vec<String>, position: &mut [bool; 10]) {
        if i == 10 {
            if num == 0 {
                // Collect.
                if let Some(time) = Self::collect(&position) {
                    acc.push(time);
                }
            }
        } else {
            Self::recursive(num, i + 1, acc, position);
            position[i] = true;
            Self::recursive(num - 1, i + 1, acc, position);
            position[i] = false;
        }
    }

    fn collect(position: &[bool; 10]) -> Option<String> {
        let mut base: i32 = 1;
        let mut hour: i32 = 0;
        for i in (0_usize..4_usize).rev() {
            if position[i] {
                hour += base;
            }
            base *= 2;
        }
        base = 1;
        let mut minutes: i32 = 0;
        for i in (4_usize..10_usize).rev() {
            if position[i] {
                minutes += base;
            }
            base *= 2;
        }
        println!("{:?} {} {}", position, hour, minutes);
        if hour >= 12 || minutes >= 60 {
            // 12:00 is invalid. Neither is 13:xx.
            return None;
        }
        let mut time: String = "".to_owned();
        time.push_str(&hour.to_string());
        time.push_str(":");
        if minutes < 10 {
            time.push_str("0");
        }
        time.push_str(&minutes.to_string());
        return Some(time);
    }
}

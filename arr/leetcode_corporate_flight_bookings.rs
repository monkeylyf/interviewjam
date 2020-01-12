/* There are n flights, and they are labeled from 1 to n.
 *
 * We have a list of flight bookings.  The i-th booking bookings[i] = [i, j, k]
 * means that we booked k seats from flights labeled i to j inclusive.
 * Return an array answer of length n, representing the number of seats booked
 * on each flight in order of their label.
 *
 * Example 1:
 * Input: bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
 * Output: [10,55,45,25,25]
 *
 * Constraints:
 * 1 <= bookings.length <= 20000
 * 1 <= bookings[i][0] <= bookings[i][1] <= n <= 20000
 * 1 <= bookings[i][2] <= 10000
 */


fn main() {
    let input: Vec<Vec<i32>> = vec![
        vec![1, 2, 10],
        vec![2, 3, 20],
        vec![2, 5, 25]
    ];
    assert_eq!(vec![10, 55, 45, 25, 25], Solution::corp_flight_bookings(input, 5));
}

struct Solution { }

impl Solution {
    pub fn corp_flight_bookings(bookings: Vec<Vec<i32>>, n: i32) -> Vec<i32> {
        let length = n as usize;
        let mut res: Vec<i32> = vec![0; length];
        for booking in bookings {
            let i = booking[0] as usize;
            let j = booking[1] as usize;
            let k = booking[2];
            res[i - 1] += k;
            if j < length {
                res[j] -= k;
            }
        }

        for i in 1..length {
            res[i] += res[i - 1];  // Accumulate.
        }

        return res;
    }
}

/*
from itertools import accumulate

class Solution:
    def corpFlightBookings(self, bookings: List[List[int]], n: int) -> List[int]:
        res = [0] * n
        for i, j, k in bookings:
            res[i - 1] += k
            if j < n:
                res[j] -= k
        return list(accumulate(res))
 */

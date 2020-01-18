/**
 * A bus has n stops numbered from 0 to n - 1 that form a circle. We know the
 * distance between all pairs of neighboring stops where distance[i] is the
 * distance between the stops number i and (i + 1) % n.
 *
 * The bus goes along both directions i.e. clockwise and counterclockwise.
 * Return the shortest distance between the given start and destination stops.
 *
 * Example 1:
 * Input: distance = [1,2,3,4], start = 0, destination = 1
 * Output: 1
 * Explanation: Distance between 0 and 1 is 1 or 9, minimum is 1.
 *
 * Example 2:
 * Input: distance = [1,2,3,4], start = 0, destination = 2
 * Output: 3
 * Explanation: Distance between 0 and 2 is 3 or 7, minimum is 3.
 *
 * Example 3:
 * Input: distance = [1,2,3,4], start = 0, destination = 3
 * Output: 4
 * Explanation: Distance between 0 and 3 is 6 or 4, minimum is 4.
 *
 * Constraints:
 * 1 <= n <= 10^4
 * distance.length == n
 * 0 <= start, destination < n
 * 0 <= distance[i] <= 10^4
 */

use std::cmp::max;
use std::cmp::min;

struct Solution {}

impl Solution {
    pub fn distance_between_bus_stops(distance: Vec<i32>, start: i32, destination: i32) -> i32 {
        let s: usize = min(start, destination) as usize;
        let e: usize = max(start, destination) as usize;
        let clockwise: i32 = distance[s .. e].iter().sum();
        let counter_clockwise_s: i32 = distance[.. s].iter().sum();
        let counter_clockwise_e: i32 = distance[e ..].iter().sum();
        return min(clockwise, counter_clockwise_e + counter_clockwise_s);
    }
}

/*
class Solution:
    def distanceBetweenBusStops(self, distance: List[int], start: int, destination: int) -> int:
        s, e = min(start, destination), max(start, destination)
        return min(sum(distance[s:e]), sum(distance[:s]) + sum(distance[e:]))
 */

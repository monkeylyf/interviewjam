/**
 * A robot on an infinite grid starts at point (0, 0) and faces north.  The
 * robot can receive one of three possible types of commands:
 *
 * -2: turn left 90 degrees
 * -1: turn right 90 degrees
 * 1 <= x <= 9: move forward x units
 * Some of the grid squares are obstacles.
 *
 * The i-th obstacle is at grid point (obstacles[i][0], obstacles[i][1])
 *
 * If the robot would try to move onto them, the robot stays on the previous
 * grid square instead (but still continues following the rest of the route.)
 *
 * Return the square of the maximum Euclidean distance that the robot will be
 * from the origin.
 *
 * Example 1:
 * Input: commands = [4,-1,3], obstacles = []
 * Output: 25
 * Explanation: robot will go to (3, 4)
 *
 * Example 2:
 * Input: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
 * Output: 65
 * Explanation: robot will be stuck at (1, 4) before turning left and going to (1, 8)
 *
 * Note:
 * 0 <= commands.length <= 10000
 * 0 <= obstacles.length <= 10000
 * -30000 <= obstacle[i][0] <= 30000
 * -30000 <= obstacle[i][1] <= 30000
 * The answer is guaranteed to be less than 2 ^ 31.
 */

use std::collections::HashMap;

fn main() {
    //assert_eq!(25, Solution::robot_sim(vec![4, -1, 3], vec![]));
    assert_eq!(65, Solution::robot_sim(vec![4, -1, 4, -2, 4], vec![vec![2, 4]]));
}

struct Solution {}

impl Solution {
    pub fn robot_sim(commands: Vec<i32>, obstacles: Vec<Vec<i32>>) -> i32 {
        let mut obstacles_by_row: HashMap<i32, Vec<i32>> = HashMap::new();
        for obstacle in &obstacles {
            let i: i32 = obstacle[0];
            let j: i32 = obstacle[1];
            let rows: &mut Vec<i32> = obstacles_by_row.entry(i).or_insert(vec![]);
            rows.push(j);
        }
        let mut obstacles_by_column: HashMap<i32, Vec<i32>> = HashMap::new();
        for obstacle in &obstacles {
            let i: i32 = obstacle[0];
            let j: i32 = obstacle[1];
            let rows: &mut Vec<i32> = obstacles_by_column.entry(j).or_insert(vec![]);
            rows.push(i);
        }
        let mut i: i32 = 0;
        let mut j: i32 = 0;
        let mut facing_north: bool = true;
        let mut facing_south: bool = false;
        let mut facing_east: bool = false;
        let mut facing_west: bool = false;
        for command in commands {
            if command == -1 {
                if facing_north {
                    facing_north = false;
                    facing_east = true;
                } else if facing_east {
                    facing_east = false;
                    facing_south = true;
                } else if facing_south {
                    facing_south = false;
                    facing_west = true
                } else {
                    facing_west = false;
                    facing_north = true;
                }
            } else if command == -2 {
                if facing_north {
                    facing_north = false;
                    facing_west = true;
                } else if facing_west {
                    facing_west = false;
                    facing_south = true;
                } else if facing_south {
                    facing_south = false;
                    facing_east = true
                } else {
                    facing_east = false;
                    facing_north = true;
                }
            } else {
                let next_destination: (i32, i32) = Solution::get_next_destination(
                    &i, &j, &command, facing_north, facing_west, facing_south,
                    &obstacles_by_row, &obstacles_by_column);
                i = next_destination.0;
                j = next_destination.1;
            }
        }
        return i * i + j * j;
    }

    fn get_next_destination(i: &i32, j: &i32, command: &i32, facing_north: bool,
                            facing_west: bool, facing_south: bool,
                            obstacles_by_row: &HashMap<i32, Vec<i32>>,
                            obstacles_by_column: &HashMap<i32, Vec<i32>>) -> (i32, i32) {
        if facing_north {
            let mut dest_j: i32 = j + command;
            let jj: Option<&Vec<i32>> = obstacles_by_row.get(i);
            if jj.is_some() {
                let min: Option<&i32> = jj.unwrap().iter().filter(|x| j < *x && *x < &dest_j).min();
                if min.is_some() {
                    dest_j = *min.unwrap() - 1;
                }
            }
            return (*i, dest_j);
        } else if facing_west {
            let mut dest_i: i32 = i - command;
            let ii: Option<&Vec<i32>> = obstacles_by_column.get(j);
            if ii.is_some() {
                let max: Option<&i32> = ii.unwrap().iter().filter(|x| &dest_i < *x && *x < i).max();
                if max.is_some() {
                   dest_i = *max.unwrap() + 1;
                }
            }
            return (dest_i, *j);
        } else if facing_south {
            let mut dest_j: i32 = j - command;
            let jj: Option<&Vec<i32>> = obstacles_by_row.get(i);
            if jj.is_some() {
                let max: Option<&i32> = jj.unwrap().iter().filter(|x| &dest_j < *x && *x < j).max();
                if max.is_some() {
                    dest_j = *max.unwrap() + 1;
                }
            }
            return (*i, dest_j);
        } else {
            let mut dest_i: i32 = i + command;
            let ii: Option<&Vec<i32>> = obstacles_by_column.get(j);
            if ii.is_some() {
                let min: Option<&i32> = ii.unwrap().iter().filter(|x| i < *x && *x < &dest_i).min();
                if min.is_some() {
                    dest_i = *min.unwrap() - 1;
                }
            }
            return (dest_i, *j);
        }
    }
}

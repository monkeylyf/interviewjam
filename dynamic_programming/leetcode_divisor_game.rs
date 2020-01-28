/**
 * Alice and Bob take turns playing a game, with Alice starting first.
 *
 * Initially, there is a number N on the chalkboard. On each player's turn, that
 * player makes a move consisting of:
 *
 * Choosing any x with 0 < x < N and N % x == 0.
 * Replacing the number N on the chalkboard with N - x.
 * Also, if a player cannot make a move, they lose the game.
 *
 * Return True if and only if Alice wins the game, assuming both players play
 * optimally.
 *
 * Example 1:
 * Input: 2
 * Output: true
 * Explanation: Alice chooses 1, and Bob has no more moves.
 *
 * Example 2:
 * Input: 3
 * Output: false
 * Explanation: Alice chooses 1, Bob chooses 1, and Alice has no more moves.
 *
 * Note:
 * 1 <= N <= 1000
 */

fn main() {
    assert!(Solution::divisor_game(10));
}

struct Solution {}

impl Solution {
    pub fn divisor_game(n: i32) -> bool {
        return n % 2 == 0;
    }

    fn get_dp_state() -> [bool; 1001] {
        // Once the dp state is printed out, you'd know the trick.
        let mut dp: [bool; 1001] = [false; 1001];
        dp[1] = false;
        dp[2] = true;
        for i in 3..=1000 {
            for j in 1..i {
                if i % j == 0 && !dp[(i - j) as usize] {
                    dp[i as usize] = true;
                    break;
                }
            }
        }
        for i in 1..=1000 {
            println!("{}: {}", i, dp[i]);
        }
        return dp;
    }
}

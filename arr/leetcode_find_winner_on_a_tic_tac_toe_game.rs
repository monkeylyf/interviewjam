/**
 * Tic-tac-toe is played by two players A and B on a 3 x 3 grid.
 *
 * Here are the rules of Tic-Tac-Toe:
 * Players take turns placing characters into empty squares (" ").
 * The first player A always places "X" characters, while the second player B
 * always places "O" characters.
 * "X" and "O" characters are always placed into empty squares, never on filled
 * ones.
 * The game ends when there are 3 of the same (non-empty) character filling any
 * row, column, or diagonal.
 * The game also ends if all squares are non-empty.
 * No more moves can be played if the game is over.
 * Given an array moves where each element is another array of size 2
 * corresponding to the row and column of the grid where they mark their
 * respective character in the order in which A and B play.
 *
 * Return the winner of the game if it exists (A or B), in case the game ends in
 * a draw return "Draw", if there are still movements to play return "Pending".
 *
 * You can assume that moves is valid (It follows the rules of Tic-Tac-Toe), the
 * grid is initially empty and A will play first.
 *
 * Example 1:
 * Input: moves = [[0,0],[2,0],[1,1],[2,1],[2,2]]
 * Output: "A"
 * Explanation: "A" wins, he always plays first.
 * "X  "    "X  "    "X  "    "X  "    "X  "
 * "   " -> "   " -> " X " -> " X " -> " X "
 * "   "    "O  "    "O  "    "OO "    "OOX"
 *
 * Example 2:
 * Input: moves = [[0,0],[1,1],[0,1],[0,2],[1,0],[2,0]]
 * Output: "B"
 * Explanation: "B" wins.
 * "X  "    "X  "    "XX "    "XXO"    "XXO"    "XXO"
 * "   " -> " O " -> " O " -> " O " -> "XO " -> "XO "
 * "   "    "   "    "   "    "   "    "   "    "O  "
 *
 * Example 3:
 * Input: moves = [[0,0],[1,1],[2,0],[1,0],[1,2],[2,1],[0,1],[0,2],[2,2]]
 * Output: "Draw"
 * Explanation: The game ends in a draw since there are no moves to make.
 * "XXO"
 * "OOX"
 * "XOX"
 *
 * Example 4:
 * Input: moves = [[0,0],[1,1]]
 * Output: "Pending"
 * Explanation: The game has not finished yet.
 * "X  "
 * " O "
 * "   "
 *
 * Constraints:
 * 1 <= moves.length <= 9
 * moves[i].length == 2
 * 0 <= moves[i][j] <= 2
 * There are no repeated elements on moves.
 * moves follow the rules of tic tac toe.
 */

use std::collections::HashSet;

fn main() {
    let moves: Vec<Vec<i32>> = vec![
        vec![0,0],vec![2,0],vec![1,1],vec![2,1],vec![2,2]];
    assert_eq!("A", Solution::tictactoe(moves));
}

struct Solution {}

impl Solution {
    pub fn tictactoe(moves: Vec<Vec<i32>>) -> String {
        if Solution::win(&moves, 0) {
            return "A".to_string();
        } else if Solution::win(&moves, 1) {
            return "B".to_string();
        } else if moves.len() == 9 {
            return "Draw".to_string();
        } else {
            return "Pending".to_string();
        }
    }

    fn win(moves: &Vec<Vec<i32>>, start_index: usize) -> bool {
        let mut signature: HashSet<i32> = HashSet::new();
        for i in (start_index..moves.len()).step_by(2) {
            let x: &Vec<i32> = moves.get(i).unwrap();
            let i: &i32 = x.get(0).unwrap();
            let j: &i32 = x.get(1).unwrap();
            let sig: i32 =  3 * i + j;
            signature.insert(sig);
        }
        if signature.contains(&0) && signature.contains(&1) && signature.contains(&2) {
            return true;
        } else if signature.contains(&3) && signature.contains(&4) && signature.contains(&5) {
            return true;
        } else if signature.contains(&6) && signature.contains(&7) && signature.contains(&8) {
            return true;
        } else if signature.contains(&0) && signature.contains(&3) && signature.contains(&6) {
            return true;
        } else if signature.contains(&1) && signature.contains(&4) && signature.contains(&7) {
            return true;
        } else if signature.contains(&2) && signature.contains(&5) && signature.contains(&8) {
            return true;
        } else if signature.contains(&0) && signature.contains(&4) && signature.contains(&8) {
            return true;
        } else if signature.contains(&2) && signature.contains(&4) && signature.contains(&6) {
            return true;
        } else {
            return false;
        }
    }
}


/*
class Solution:
    def tictactoe(self, moves: List[List[int]]) -> str:
        if self.win(moves[::2]):
            return "A"
        elif self.win(moves[1::2]):
            return "B"
        elif len(moves) == 9:
            return "Draw"
        else:
            return "Pending"

    def win(self, moves):
        moves = set(i * 3 + j for i, j in moves)
        if 0 in moves and 1 in moves and 2 in moves:
            return True
        elif 3 in moves and 4 in moves and 5 in moves:
            return True
        elif 6 in moves and 7 in moves and 8 in moves:
            return True
        elif 0 in moves and 3 in moves and 6 in moves:
            return True
        elif 1 in moves and 4 in moves and 7 in moves:
            return True
        elif 2 in moves and 5 in moves and 8 in moves:
            return True
        elif 0 in moves and 4 in moves and 8 in moves:
            return True
        elif 2 in moves and 4 in moves and 6 in moves:
            return True
        else:
            return False
 */

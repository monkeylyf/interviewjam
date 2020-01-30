/**
 * On an 8 x 8 chessboard, there is one white rook.  There also may be empty
 * squares, white bishops, and black pawns.  These are given as characters 'R',
 * '.', 'B', and 'p' respectively. Uppercase characters represent white pieces,
 * and lowercase characters represent black pieces.
 *
 * The rook moves as in the rules of Chess: it chooses one of four cardinal
 * directions (north, east, west, and south), then moves in that direction until
 * it chooses to stop, reaches the edge of the board, or captures an opposite
 * colored pawn by moving to the same square it occupies.  Also, rooks cannot
 * move into the same square as other friendly bishops.
 *
 * Return the number of pawns the rook can capture in one move.
 *
 * Example 1:
 * Input: [[".",".",".",".",".",".",".","."],
 *         [".",".",".","p",".",".",".","."],
 *         [".",".",".","R",".",".",".","p"],
 *         [".",".",".",".",".",".",".","."],
 *         [".",".",".",".",".",".",".","."],
 *         [".",".",".","p",".",".",".","."],
 *         [".",".",".",".",".",".",".","."],
 *         [".",".",".",".",".",".",".","."]]
 * Output: 3
 * Explanation:
 * In this example the rook is able to capture all the pawns.
 *
 * Example 2:
 * Input: [[".",".",".",".",".",".",".","."],
 *         [".","p","p","p","p","p",".","."],
 *         [".","p","p","B","p","p",".","."],
 *         [".","p","B","R","B","p",".","."],
 *         [".","p","p","B","p","p",".","."],
 *         [".","p","p","p","p","p",".","."],
 *         [".",".",".",".",".",".",".","."],
 *         [".",".",".",".",".",".",".","."]]
 * Output: 0
 * Explanation:
 * Bishops are blocking the rook to capture any pawn.
 *
 * Example 3:
 * Input: [[".",".",".",".",".",".",".","."],
 *         [".",".",".","p",".",".",".","."],
 *         [".",".",".","p",".",".",".","."],
 *         ["p","p",".","R",".","p","B","."],
 *         [".",".",".",".",".",".",".","."],
 *         [".",".",".","B",".",".",".","."],
 *         [".",".",".","p",".",".",".","."],
 *         [".",".",".",".",".",".",".","."]]
 * Output: 3
 * Explanation:
 * The rook can capture the pawns at positions b5, d6 and f5.
 *
 * Note:
 * board.length == board[i].length == 8
 * board[i][j] is either 'R', '.', 'B', or 'p'
 * There is exactly one cell with board[i][j] == 'R'
 */

fn main() {
}

struct Solution {}

impl Solution {
    pub fn num_rook_captures(board: Vec<Vec<char>>) -> i32 {
        let row_length: usize = board.len();
        let column_length: usize = board[0].len();
        let mut i: usize = 0;
        let mut j: usize = 0;
        for (ii, row) in board.iter().enumerate() {
            let index: Option<usize> = row.iter().position(|x| *x == 'R');
            if index.is_some() {
                i = ii;
                j = index.unwrap();
                break;
            }
        }
        let mut count: i32 = 0;
        // Upwards.
        for ii in (0..i).rev() {
            let c: char = board[ii][j];
            if c == 'p' {
                count += 1;
                break;
            } else if c == '.' {
                continue;
            } else {
                break;
            }
        }
        // Downwards.
        for ii in i + 1..row_length {
            let c: char = board[ii][j];
            if c == 'p' {
                count += 1;
                break;
            } else if c == '.' {
                continue;
            } else {
                break;
            }
        }
        // Leftwards.
        for jj in (0..j).rev() {
            let c: char = board[i][jj];
            if c == 'p' {
                count += 1;
                break;
            } else if c == '.' {
                continue;
            } else {
                break;
            }
        }
        // Rightwards.
        for jj in j + 1..column_length {
            let c: char = board[i][jj];
            if c == 'p' {
                count += 1;
                break;
            } else if c == '.' {
                continue;
            } else {
                break;
            }
        }

        return count;
    }
}

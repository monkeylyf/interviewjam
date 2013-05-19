/*Maximum_Subsquare_with_Border
careercup

Imagine you have a square matrix, where each cell is filled with either black
or white. Design an algorithm to find the maximum subsquare such that all four
borders are filled with black pixels

Followup: what if matrix is rectangle instead of square? and maximum subrectangle
is asked for?
*/

class cap_Maximum_Subsquare_with_Border {
	public static void main(String[] args) {
		int[][] input = {
                         {1, 1, 0, 1, 1},
        				 {1, 1, 1, 1, 1},
				         {0, 1, 0, 0, 1},
				         {0, 1, 1, 0, 1},
				         {0, 1, 1, 1, 1}
                        };
        Subsquare solution = new Subsquare(input);
        solution.findMaximumSubsquare();
	}
}


class Subsquare {
    public int[][] square;
    public int n;

    Subsquare(int[][] square) {
        this.square = square;
        this.n = square.length;
        for (int row = 0; row < n; ++row) {
            assert(square[row].length == n);
        }
    }

    public int[] findMaximumSubsquare() {
        // Brutal force O(n^2)
        int[] ret = new int[3];
        int col = 0;
        int maxSize = 0;
        while (this.n - col > maxSize) {
            // Iterator from left column to right. Potenial maxSize is size - col.
            for (int row = 0; row < this.n - 1; ++row) {
                int size = this.n - Math.max(row, col);
                while (size > maxSize && size > 1) {
                    // Ask interviewer the definition of square. Does size 1 counts for a square?
                    if (isValidSquare(row, col, size)) {
                        ret =  new int[] {row, col, size};
                        maxSize = size;
                        break; // Done with current left border.
                    }
                    --size;
                }
            }
            ++col; // Next col as left border.
        }
        System.out.println("row " + ret[0] + " col " +  ret[1] + " size " + ret[2]);
        return ret;
    }
    public boolean isValidSquare(int col, int row, int size) {
        // Check for upper and lower border.
        for (int i = row; i < row + size; ++i) {
            if (this.square[col][i] != 1 || this.square[col + size - 1][i] != 1) {
                return false;
            }
        }
        // Check for left and right border.
        for (int i = col + 1; i < col + size - 1; ++i) {
            if (this.square[i][row] != 1 || this.square[i][row + size - 1] != 1) {
                return false;
            }
        }
        return true;
    }
}

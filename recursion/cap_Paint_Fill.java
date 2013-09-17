/*Paint_Fill
careercup

Implement the "paint fill" function that one might see on many image editing
programs.That is, given a screen (represented by a 2-dimensional array of
Colors), a point, and a new color, fill in the surrounding area until you hit a
border of that color.*/


public class cap_Paint_Fill {

	public static void main(String[] args) {
        int[][] screen = new int[][] {{0, 0, 0, 0, 0, 0}, 
                                      {0, 0, 0, 0, 0, 0},
                                      {0, 0, 0, 0, 0, 0},
                                      {0, 0, 1, 1, 0, 0},
                                      {0, 0, 0, 0, 0, 0},
                                      {0, 0, 0, 0, 0, 0}
                                     };
        paintFill(screen, 2, 2, 1);
	}

    public static void paintFill(int[][] screen, int x, int y, int tcolor) {
        int row = screen[0].length;
        int col = screen.length;
        int ocolor = screen[x][y];
        paintNext(screen, x, y, tcolor, ocolor, row, col);
    }

    public static void paintNext(int[][] screen, int x, int y, int tcolor, int ocolor, int row, int col) {
        if ( x < 0 || x >= col || y < 0 || y >= row || screen[x][y] != ocolor) {
            System.out.println("Reaching border of color " + ocolor + " @(" + x + ", " + y + ")");
            return;
        } else {
			screen[x][y] = tcolor;
			System.out.println("Painting (" + x + ", " + y + ") color " + tcolor);
			paintNext(screen, x - 1, y, tcolor, ocolor, row, col);
			paintNext(screen, x, y + 1, tcolor, ocolor, row, col);
			paintNext(screen, x + 1, y, tcolor, ocolor, row, col);
			paintNext(screen, x, y - 1, tcolor, ocolor, row, col);
		}
    }
}

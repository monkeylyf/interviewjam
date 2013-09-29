/*Quadtree
google

Given a two-dimension image, each pixel is either black or white. If all pixels
are black, then this image is black; if all pixels are white, when this image
is white. If this image contains both white pixels and black pixels, divide it
into four parts.
__________                         __________
|        |   divided into 4 parts  |    |   |   
|        |                         |____|___|   
|        |                         |    |   |
|________|                         |____|___|

Each small part is a sub-quadtree

Q1: Design the data strcuture for each node of quadtree.
Q2: Describe intersection of two quadtree.
Q3: Write a function to return the intersection of two quadtree.


http://en.wikipedia.org/wiki/Quadtree
intersection of black and white is 1 && 0 = 0
*/


public class google_Quadtree{

	final int WHITE = 0;
	final int BLACK = 1;
	final int GREY = 2;

    public static void main(String[] args) {
		// Test case.
    }

    public static QTNode cloneQT(QTNode root) {
        if (root == null)  {
            return null;
        }
        QTNode newNode = new QTNode(root.color);
        for (int i = 0; i < 4; ++i) {
            newNode.kids[i] = cloneQT(root.kids[i]);
        }
        return newNode;
    }

    public static QTNode intersection(QTNode rootOne, QTNode rootTwo) {
		if (rootOne == null || rooTwo == null) {
			return null; // Edge case.
		} else if (rootOne.color == GREY && rootTwo.color == GREY) {
            // Both contain black & white.
            QTNode newNode = new QTNode(GREY);
            for (int i = 0; i < 4; ++i) {
                newNode.kids[i] = intersection(rootOne.kids[i], rootTwo.kids[i]);
            }
			// Trick here:
            if (newNode.isAllKidsWhite()) {
                // If Intersection of two grey area is white, it should have no kids and
                // its color should be set to 0(white).
                return new QTNode(WHITE);
            } else {
                return newNode;
            }
        } else if (rootOne.color == WHITE || rootTwo.color == WHITE) {
            // Either is white.
            return new QTNode(WHITE);
        } else if (rootOne.color == BLACK) {
            // allBlack && pixels = pixels
            return cloneQT(rootTwo);
        } else  {
            // rootTwo.color == 1
            return cloneQT(rootOne);
        } 
    }

    static class QTNode {
        private int color;

		private final int WHITE = 0;
		private final int BLACK = 1;
		private final int GREY = 2;

        // Children.
        QTNode[] kids = new QTNode[4];
        QTNode(int x) {
			if (!(x == this.BLACK || x == this.WHITE || x == this.GREY)) {
				throw new IllegalArgumentException("Invalid color.");	
			}
            color = x;
            for (QTNode kid : kids) {
                kid = null;
            }
        }
        public boolean isAllKidsWhite() {
            for (QTNode kid : kids) {
                if (kid == null) {
                    return false;
                } else if (kid.color != this.WHITE) {
                    return false;
                }
            }
            return true;
        }
    }
}

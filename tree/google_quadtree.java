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
Q2: The intersection of two quadtree, ...
Q3: Write a function to return the intersection of two quadtree.


http://en.wikipedia.org/wiki/Quadtree
Hint: 1 stands for black, 0 stands for white, 2 stands for grey(black & white).
intersection of black and white is 1 && 0 = 0
*/


class google_Quadtree{
    public static void main(String[] args) {
    }
    public static QuadTreeNode cloneQuadTree(QuadTreeNode root) {
        if (root == null)  {
            return null;
        }
        QuadTreeNode newNode = new QuadTreeNode(root.color);
        for (int i = 0; i < 4; ++i) {
            newNode.kids[i] = cloneQuadTree(root.kids[i]);
        }
        return newNode;
    }
    public static QuadTreeNode intersection(QuadTreeNode rootOne, QuadTreeNode rootTwo) {
        if (rootOne.color == 2 && rootTwo.color == 2) {
            // Both contain black & white.
            QuadTreeNode newNode = new QuadTreeNode(2);
            for (int i = 0; i < 4; ++i) {
                newNode.kids[i] = intersection(rootOne.kids[i], rootTwo.kids[i]);
            }
            if (newNode.isAllKidsWhite()) {
                // If Intersection of two grey area is white, it should have no kids and
                // its color should be set to 0(white).
                return new QuadTreeNode(0);
            } else {
                return newNode;
            }
        } else if (rootOne.color == 0 && rootTwo.color == 0) {
            // Both are white.
            return new QuadTreeNode(0);
        } else if (rootOne.color == 1) {
            // allBlack && pixels = pixels
            return cloneQuadTree(rootTwo);
        } else  {
            // rootTwo.color == 1
            return cloneQuadTree(rootOne);
        } 
    }
    public static class QuadTreeNode {
        int color;
        // Children.
        QuadTreeNode[] kids = new QuadTreeNode[4];
        QuadTreeNode(int x) {
            color = x;
            for (QuadTreeNode kid : kids) {
                kid = null;
            }
        }
        public boolean isAllKidsWhite() {
            for (QuadTreeNode kid : kids) {
                if (kid == null) {
                    return false;
                } else if (kid.color != 0) {
                    return false;
                }
            }
            return true;
        }
    }
}

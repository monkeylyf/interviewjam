/*Triangle

Given a triangle, find the minimum path sum from top to bottom. Each step you
may move to adjacent numbers on the row below.
For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
Note:
Bonus point if you are able to do this using only O(n) extra space, where n is
the total number of rows in the triangle.
*/


import java.util.ArrayList;


class leetcode_Triangle {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> tmp1 = new ArrayList<Integer>();
        tmp1.add(1);
        triangle.add(tmp1);
        ArrayList<Integer> tmp2 = new ArrayList<Integer>();
        tmp2.add(2);
        tmp2.add(3);
        triangle.add(tmp2);
        minimumTotal(triangle);
    }
    public static int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        ArrayList<Integer> prevLayerCost = new ArrayList<Integer>();
        ArrayList<Integer> nextLayerCost = new ArrayList<Integer>();
        prevLayerCost.add(triangle.get(0).get(0));
        for (int i = 1; i <triangle.size(); ++i) {
            ArrayList<Integer> layer = triangle.get(i);
            for (int j = 0; j < layer.size(); ++j) {
                if (j == 0) {
                    nextLayerCost.add(prevLayerCost.get(0) + layer.get(0)); 
                } else if (j == layer.size() - 1) {
                    nextLayerCost.add(prevLayerCost.get(j - 1) + layer.get(j)); 
                } else {
                    int minCost = Math.min(prevLayerCost.get(j - 1), prevLayerCost.get(j));
                    nextLayerCost.add(minCost + layer.get(j)); 
                }
            }
            prevLayerCost = nextLayerCost;
            nextLayerCost = new ArrayList<Integer>();
        }
        int res = Integer.MAX_VALUE;
        for (int i : prevLayerCost) {
            if (i < res) {
                res = i;
            }
        }
        return res;
    }
}

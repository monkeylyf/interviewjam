/*Pascal_Triangle

Given numRows, generate the first numRows of Pascal's triangle.
For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
*/


import java.util.ArrayList;

class leetcode_Pascal_Triangle {
    public static void main(String[] args) {
    }
    public static ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < numRows; ++i) {
            ArrayList<Integer> layer = new ArrayList<Integer>();
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || i == j) {
                    layer.add(1);
                } else {
                    layer.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }
            }
            res.add(layer);
        }
        return res;
    }
}

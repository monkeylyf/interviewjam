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

/* Python Version
def generate(self, numRows):
    ret = [ ]
    for i in xrange(numRows):
        cur = []
        if i == 0:
            cur.append(1)
        else:
            prev = ret[i - 1]
            for j in xrange(i + 1):
                item = 1 if j == 0 or j == i else prev[j - 1] + prev[j]
                cur.append(item)
        ret.append(cur)
            
    return ret
*/

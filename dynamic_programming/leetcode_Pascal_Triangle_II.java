/*Pascal_Triangle_II

Given an index k, return the kth row of the Pascal's triangle.
For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?
*/

class leetcode_Pascal_Triangle_II {
    public static void main(String[] args) {
    }
    public static ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        ArrayList<Integer> nextLayer = new ArrayList<Integer>();
        for (int i = 0; i <= rowIndex; ++i) {
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || i == j) {
                    nextLayer.add(1);
                } else {
                    nextLayer.add(res.get(j - 1) + res.get(j));
                }
            }
            res = nextlayer;
            nextLayer = new ArrayList<Integer>();
        }
        return res;
    }
}


/* Python Version
def getRow(self, rowIndex):
    ret = []
    for i in xrange(rowIndex + 1):
        cur = []
        if i == 0:
            cur.append(1)
        else:
            for j in xrange(i + 1):
                item = 1 if j == 0 or j == i else ret[j - 1] + ret[j]
                cur.append(item)
        ret = cur
    
    return ret
*/

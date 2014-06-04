/*Unique_Binary_Search_Trees

Given n, how many structurally unique BST's (binary search trees) that store
values 1...n?
For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

*/



public class leetcode_Unique_Binary_Search_Trees {

    public static void main(String[] args) {
        System.out.println(numTrees(10));
    }

    public static int numTrees(int n) {
        // The idea behind this is dp-based.
        // numTrees(i+1) = append node i+1 to node i's right + append tree(0,i) as node i+1 left child.
        //                 insert the last node as non-leaf node sum(k=1...i)(dp(k-1)*dp(i-k)
        if(n == 0 || n == 1 || n == 2) {
            return n;
        }
        int dp[] = new int[n + 1];
		dp[1] = 1;
		dp[2] = 2;
        //   1  2
        //  /    \
        // 2      1
        for (int i = 3; i <= n; ++i) {
			for (int j = 1; j <= i - 2; ++j) {
				// Consider node i as the intermediate node as a right child of some subtree.
				// Then create another substree and append its root to node i.
				// There is dp[j] different ways to construct first substree and dp[i - 1 - j] 
				// different ways to construct the second substree. Sum the num up.
				dp[i] += dp[j] * dp[i - 1 - j];
			}
			dp[i] += 2 * dp[i - 1];
        }

        return dp[n];
    }
}


/* Python Version
def numTrees(self, n):
    if n == 0 or n == 1 or n == 2:
        return n
    
    dp = [ 0 for _ in xrange(n + 1) ]
    dp[1] = 1
    dp[2] = 2
    for i in xrange(3, n + 1):
        for j in xrange(1, i - 1):
            dp[i] += dp[j] * dp[i - j - 1]
        dp[i] += 2 * dp[i - 1]

    return dp[-1]
*/

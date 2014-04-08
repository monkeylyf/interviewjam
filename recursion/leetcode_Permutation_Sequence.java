/*Permutation_Sequence

The set [1,2,3,…,n] contains a total of n! unique permutations.
By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):
"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.
Note: Given n will be between 1 and 9 inclusive.
*/


public class leetcode_Permutation_Sequence {

    public static void main(String[] args) {
        System.out.println(getPermutation(4, 16));
    }

    public static String getPermutation(int n, int k) {
        String str = "";
        for (int i = 1; i <= n; ++i) {
            str = str + Integer.toString(i);
        }
        return nextNum(str, n, k - 1); // kth --> index k - 1
    }

    public static String nextNum(String str, int n, int k) {
        // str.length() == 0 works too but set it to 1 mean one less recursion.
        if (str.length() == 1) {
            return str;
        }
        int fctrl = factorial(n - 1); // how many combinations when the first char is deterministic.
        int index = k / fctrl; // index of current char.
        return str.charAt(index) + "" + nextNum(str.substring(0, index) + str.substring(index + 1, str.length()), n - 1, k - fctrl * index);
    }

    public static int factorial(int n) {
        int res = 1; 
        for (int i = n; i >=1; --i) {
            res *= i;
        }
        return res;        
    }
}

/* Python Version
class Solution:
    # @return a string
    def getPermutation(self, n, k):
        #print self.factorial(n)
        #print self.factorial(k)
        tokens = range(1, n + 1)
        k -= 1 # 0-based index.
        num_comb = self.factorial(n)
        ret = []
        for i in reversed(xrange(1, n + 1)):
            repeat = num_comb / i
            idx = k / repeat
            ret.append(tokens.pop(idx))

            num_comb = repeat
            k = k % repeat
        return ''.join(map(str, ret))

    def factorial(self, n):
        if n == 0:
            return 1

        ret = 1

        for i in xrange(1, n + 1):
            ret *= i

        return ret
*/

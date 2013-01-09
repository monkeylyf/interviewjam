/*Permutation Sequence

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

import java.util.ArrayList;

class leetcode_68 {
    public static void main(String[] args) {
        System.out.println(getPermutation(4, 16));
    }
    public static String getPermutation(int n, int k) {
        ArrayList<String> arr = new ArrayList<String>();
        for (int i = 1; i <= n; ++i) arr.add(Integer.toString(i));
        return nextNum(arr, n, k - 1);
    }
    public static String nextNum(ArrayList<String> arr, int n, int k) {
        if (arr.size() == 1) return arr.remove(0);
        int fctrl = factorial(n - 1);
        int index = k / fctrl;
        String str = arr.remove(index);
        return str + nextNum(arr, n - 1, k - fctrl * index);
    }
    public static int factorial(int n) {
        int res = 1;
        for (int i = n; i >=1; --i) res *= i;
        return res;
    }
}

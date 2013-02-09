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


import java.util.ArrayList;
import java.util.HashSet;


class leetcode_Unique_Binary_Search_Trees {
    public static void main(String[] args) {
        System.out.println(numTrees(4));
    }
    public static int numTrees(int n) {
        // The idea behind this is dp-based.
        // numTrees(i+1) = append the last node to the rightmost leaf of bst(i)[numTrees(i)] +
        //                 append the last node as the root of bst(i)[numTrees(i)] +
        //                 insert the last node as non-leaf node sum(k=1...i)(bst(k-1)*bst(i-k)
        if(n == 0 || n == 1 || n == 2) {
            return n;
        }
        int bst[] = new int[n + 1];
        bst[0] = 1;
        bst[1] = 1;
        //   1  2
        //  /    \
        // 2      1
        bst[2] = 2;
        for (int i = 3; i <= n; ++i) {
            for (int j = 1; j < i - 1; ++j) {
                bst[i] += bst[j] * bst[i - 1 - j];
            }
            bst[i] += 2 * bst[i - 1];
        }
        return bst[n];
    }
}

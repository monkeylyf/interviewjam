/*Pairs

Hackerrank
Given N numbers [N<=10^5], count the total pairs of numbers that have a
difference of K. [K>0 and K<1e9]

Input Format:
1st line contains N & K (integers).
2nd line contains N numbers of the set. All the N numbers are assured to be distinct.

Output Format:

One integer saying the no of pairs of numbers that have a diff K.

Sample Input #00:

5 2
1 5 3 4 2

Sample Output #00:

3

Sample Input #01:

10 1
363374326 364147530 61825163 1073065718 1281246024 1399469912 428047635 491595254 879792181 1069262793 

Sample Output #01:

0
*/


import java.util.*;


class hackerrank_Pairs {
    public static void main(String[] args) {
        kDiffPair(new int[] {1, 5, 3, 4, 2}, 2);
        kDiffPair(new int[] {363374326, 364147530, 61825163, 1073065718, 1281246024, 1399469912, 428047635, 491595254, 879792181, 1069262793}, 1);
    }
    public static void kDiffPair(int[] arr, int diff) {
        HashSet<Integer> set = new HashSet<Integer>();
        int count = 0;
        for (int i : arr) {
            if (set.contains(i + diff)) {
                ++count;
            }
            if (set.contains(i - diff)) {
                ++count;
            }
            set.add(i);
        }
        System.out.println(count);
    }
}

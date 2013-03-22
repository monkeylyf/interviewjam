/*Candies
hackerrank

Alice is a kindergarden teacher. She wants to give some candies to the children
in her class.  All the children sit in a line and each  of them  has a rating
score according to his or her usual performance.  Alice wants to give at least
1 candy for each child.Children get jealous of their immediate neighbors, so if
two children sit next to each other then the one with the higher rating must get
more candies. Alice wants to save money, so she wants to minimize the total
number of candies.

Input

She first line of the input is an integer N, the number of children in Alice’s
class. Each of the following N lines contains an integer indicates the rating
of each child.

Ouput

Output a single line containing the minimum number of candies Alice must give.

Sample Input

3
1
2
2

Sample Ouput

4
*/


public class Candies {
    public static void main(String[] args) {

    }
    public static void candies(int[] arr, int n) {
        // Elegant Solution of Cong Li.
        // The idea behind this is using two array to track increasing array and decreasing array seperately.
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 1; i < n; ++i) {
            left[i] = (arr[i] > arr[i - 1]) ? left[i - 1] + 1 : 0;
        }
        for (int i = n - 2; i >= 0; --i) {
            right[i] = (arr[i] > arr[i + 1]) ? right[i + 1] + 1 : 0;
        }
        int ret = 0;
        for (int i = 0; i < n; ++i) {
            ret += Math.max(left[i], right[i]);
        }
        System.out.println(ret + n);
    }
}

/*Candies
hackerrank/leetcode

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
        int[] ascend = new int[n], descend = new int[n];
		int sum = 0, i;
        for (i = 1; i < n; ++i) {
            ascend[i] = (arr[i] > arr[i - 1]) ? ascend[i - 1] + 1 : 0;
        }
        for (i = n - 2; i >= 0; --i) {
            descend[i] = (arr[i] > arr[i + 1]) ? descend[i + 1] + 1 : 0;
        }
        for (i = 0; i < n; ++i) {
            ret += Math.max(ascend[i], descend[i]);
        }
        System.out.println(ret + n);
    }
}

/*Python Version

def candy(self, ratings):
    left_to_right = [ 1 for _ in xrange(len(ratings)) ]
    for i in xrange(len(ratings) - 1):
        if ratings[i] < ratings[i + 1]:
            left_to_right[i + 1] = left_to_right[i] + 1
    
    right_to_left = [ 1 for _ in xrange(len(ratings)) ]
    for i in reversed(xrange(1, len(ratings))):
        if ratings[i - 1] > ratings[i]:
            right_to_left[i - 1] = right_to_left[i] + 1
            
    return sum([ max(left_to_right[i], right_to_left[i]) for i in xrange(len(ratings)) ])
*/

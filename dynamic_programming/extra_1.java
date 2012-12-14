/*Given a one-dimension array and a robot sitting at 0 wants to move to N. The
robot can only move forwards two units or on unit at one time. Given the cost
function of taking two and taking one. What is the least cost moving from 0 to
N.

FOLLOWUP:
What is the path of min cost?

C(x) = min(C(x-1)+F(x-1 to x), C(x-2)+F(x-2 to x))
*/

import java.util.*;

class extra_1 {
    public static void main(String args[]) {
        int[] two = new int[] {0,0,1,0,2,3,1,3,2,0,3}; // two[0]=two[1]=0;two[2]:0-2;
        int[] one = new int[] {0,1,2,2,1,2,2,1,2,2,1}; // one[0]=0; one[1]:0-1;one[2]:1-2;
        //myPath(two, one);
        myCost(two, one);
    }
    // Get the path of min cost.
    public static void myPath(int[] two, int[] one) {
        ArrayList<Integer> path = new ArrayList<Integer>();
        nextStep(two, one, two.length - 1, path);
        for (int i : path) System.out.print(i);
        System.out.println("");
    }
    public static int nextStep(int[] two, int[] one, int x, ArrayList<Integer> path) {
        if (x == 0) {
            System.out.println("Reaching the origin!");
            return 0;
        }
        if (x == 1) {
            System.out.println("To point " + x + " take 1 step");
            path.add(one[x]);
            return one[x];
        } else {
            int take_two = nextStep(two, one, x - 2, path);
            int take_one = nextStep(two, one, x - 1, path);
            if ((take_one + one[x]) > (take_two + two[x])) {
                System.out.println("To point " + x + " take 2 steps");
                path.add(two[x]);
                return take_two;
            } else {
                System.out.println("To point " + x + " take 1 step");
                path.add(one[x]);
                return take_one;
            }
        }
    }
    // Get the min Cost.
    public static void myCost(int[] two, int[] one) {
        System.out.println("The min cost is: " + nextCost(two, one, two.length - 1));
    }
    public static int nextCost(int[] two, int[] one, int x) {
        if (x < 2) return one[x];
        return Math.min(nextCost(two, one, x - 1) + one[x], nextCost(two, one, x - 2) + two[x]);
    }
}

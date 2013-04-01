/*Robot_Moving

Given a one-dimension array and a robot sitting at 0 wants to move to N. The
robot can only move forwards two units or on unit at one time. Given the cost
function of taking two and taking one. What is the least cost moving from 0 to
N.

FOLLOWUP:
What is the path of min cost?

C(x) = min(C(x-1)+F(x-1 to x), C(x-2)+F(x-2 to x))
*/

import java.util.*;


class Robot_Moving {
    public static void main(String args[]) {
        int[] two = new int[] {0,0,0,1,1,1};
        int[] one = new int[] {0,1,1,0,0,0};
        myPath(new int[] {0,0,1,0,2,3,1,3,2,0,3}, new int[] {0,1,2,2,1,2,2,1,2,2,1});
        my(new int[] {0,0,1,0,2,3,1,3,2,0,3}, new int[] {0,1,2,2,1,2,2,1,2,2,1});
    }

    // Get path with min cost.
    public static void myPath(int[]two, int[] one) {
        ArrayList<Integer> path = new ArrayList<Integer>();
        int[] cost = new int[two.length];
        cost[0] = 0;
        cost[1] = one[1];
        int index = 2;
        while (index < one.length) {
            cost[index] = Math.min(cost[index - 1] + one[index], cost[index - 2] + two[index]);
            ++index;
        }
        index = cost.length - 1;
        path.add(index);
        while (index > 1) {
            if (cost[index] == two[index] + cost[index - 2]) {
                index -= 2;
            } else {
                index -= 1;
            }
            path.add(index);
        }  
        if (path.get(path.size() - 1) == 1) {
            path.add(0);
        }
        for (int i = path.size() - 1; i >= 0; --i) System.out.print(path.get(i) + " ");
    }

    // Get the min Cost.
    public static void myCost(int[] two, int[] one) {
        System.out.println("The min cost is: " + nextCost(two, one, two.length - 1));
    }
    public static int nextCost(int[] two, int[] one, int x) {
        if (x < 2) {
            return one[x];
        }
        return Math.min(nextCost(two, one, x - 1) + one[x], nextCost(two, one, x - 2) + two[x]);
    }

    // Get the min Cost with less time and space complex.
    public static void my(int[]two, int[] one) {
        int two_before = 0;
        int one_before = one[1];
        int index = 2;
        while (index < one.length) {
            int tmp = Math.min(one_before + one[index], two_before + two[index]);
            two_before = one_before;
            one_before = tmp;
            ++index;
        }
        System.out.println("The min cost is: " + one_before);
    }
}

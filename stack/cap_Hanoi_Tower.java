/*Hanoi_Tower
careercup

In the classic problem of the Towers of Hanoi, you have 3 rods and N disks of
different sizes which can slide on to any tower. The puzzle starts with disks sorted
in ascending order of size from top to bottom (e g ,each disk sits on top of an
even larger one) You have the following constraints:
pg 52
SOLUTION
(A) Only one disk can be moved at a time
(B) A disk is slid off the top of one rod onto the next rod
(C) A disk can only be placed on top of a larger disk Write a program to move the
disks from the first rod to the last using Stacks
*/

import java.util.Stack;


class cap_Hanoi_Tower {
	public static void main(String[] args) {
	    hanoi(4, 'A', 'B', 'C');
	}
    public static void hanoi(int n, char A, char B, char C) {
        if (n == 1) {
            System.out.println("Move disk " + n + " from " + A + " to " + C);
        } else {
            // Breaking the question into three steps
            // 1. Moving n - 1 discs from A to B.
            // 2. Moving n dic from A to C.
            // 3. Moving n - 1 dics from B to C.
            hanoi(n - 1, A, C, B);
            System.out.println("Move disk " + n + " from " + A + " to " + C);
            hanoi(n - 1, B, A, C);
        }
    }
}

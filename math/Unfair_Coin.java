/*Unfair_Coin
Groupon

You are given a unfair coin with 1/4 probability showing head and 3/4 showing
tail.
Design a function that return false with 1/2 probability and true 1/2.
*/

import java.util.Random;

public class Unfair_Coin {

    public static void main(String[] args) {
		// Test case.
        int f = 0, t = 0;
        for (int i = 0; i < 1000; ++i) {
            if (Generator(0.25, 0.5, true) == true) {
                ++t; 
            } else {
                ++f;
            }
        }
        System.out.println("false " + f + " true " + t);
    }

    public static char toss() {
        int i = new Random().nextInt(4);
		return (i == 3) ? 'h' : 't';
    }

    public static boolean unfairGenerator() {
		return toss() == 'h';
    }

	// Solution 1.
	// Given a generator yielding bool with given probability, design
	// a generator yields bool with target probability.
    public static boolean Generator(double given, double target, boolean bool) {
		// Reverse prob if target is less than given prob.
		// target must be large than given, so we can do rejects.
        if (target < given) {
            target = 1 - target;
            given = 1 - given;
            bool = !bool;
        }
        if (unfairGenerator() == bool) {
            return bool;
        } else {
			// Rejects and update target to conditional probability.
            return Generator(given, (target - given) / (1 - given), bool);
        }
    }

	// Solution 2. 
    public static boolean fairGenerator() {
        // Special case for 50/50
        while (true) {
            char case1 = toss();
            char case2 = toss();
            if (case1 == 'h' && case2 == 't') {
                // 3/16 ht return true
                return true;
            } else if (case1 == 't' && case2 == 'h') {
                // 3/16 th return false
                return false;
            } // case hh(1/16) && tt(9/16) rejects and redo.
        }
    }

	// Solution 3.
	// It's about manipulating numbers with this specific case. I prefer a more general solution.
    public static boolean fairGen() {
        if (toss() == 'h') {
            return true; // 1/4
        } else if (toss() == 'h') {
            return true; // 1/4 * 3/4
        } else if (toss() == 'h' && toss() == 'h') {
            return true;
        } else {
            return false;
        }
    }
}

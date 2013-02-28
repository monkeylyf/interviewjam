/*Unfair_Coin
Groupon

You are given a unfair coin with 1/4 probability showing head and 3/4 showing
tail.
Design a function that return false with 1/2 probability and true 1/2.
*/

import java.util.Random;

class Unfair_Coin {
    public static void main(String[] args) {
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
        if (i == 3) {
            return 'h';
        } else {
            return 't';
        }
    }
    public static boolean unfairGenerator() {
        if (toss() == 'h') {
            return true;
        } else {
            return false;
        }
    }
    public static boolean Generator(double given, double target, boolean bool) {
        // Given a generator yielding bool with given probability, design
        // a generator yields bool with target probability.
        if (target < given) {
            target = 1 - target;
            given = 1 - given;
            bool = !bool;
        }
        if (unfairGenerator() == bool) {
            return bool;
        } else {
            return Generator(given, (target - given) / (1 - given), bool);
        }
    }
    public static boolean fairGenerator() {
        // Special case for 50/50
        while (true) {
            char case1 = toss();
            char case2 = toss();
            if (case1 == 'h' && case2 == 't') {
                // 9/16 ht return true
                return true;
            } else if (case1 == 't' && case2 == 't') {
                // 9/16 th return false
                return false;
            } // case hh && tt, keep looping
        }
    }
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

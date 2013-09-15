/*True_False_Generator

Given a Prob function which return true with 50% probability and false with 50%
Design a function that return true with 70% probability and false with 30%
*/

import java.util.Random;


public class facebook_True_False_Generator {

    public static void main(String[] args) {
        int trueCounter = 0;
        int falseCounter = 0;
        for (int i = 0; i < 100; ++i) {
            if (trueKValue(0.7, false)) {
                ++trueCounter;
            } else {
                ++falseCounter;
            }
        }
        System.out.println("true " + trueCounter + " false " + falseCounter);
    }

    public static boolean true50() {
        return new Random().nextInt(2) == 1;
    }

    public static boolean trueKValue(double k, boolean bool) {
        // The idea behind this is
        // e.g., 0.8(DEC) = 0.1101....(Binary)
        // 0.8 = 2^(-1) + 2^(02) + 2^(-4) + ...
        // These function describes an event A that Nth digit equals to '1'.
        // The Prob(A) = trueKValue(0.8)
        if (k < 0.5) {
            // e.g., 40% of false equals 60% of true.
            // Make sure k >= 0.5.
            k = 1 - k;
            bool = !bool;
        }
        // This part is kind of tricky. Here is my thought.
        // You are given a 0-9 random generator.
        // If you toss 0-4, return true otherwise return false.
        // Now you want to toss 0-5 return true otherwise return false.
        //
        if (true50() == bool) {
            // You want 60% true and there are 50% chance true50() return true.
            return bool;
        } else {
            // Oops, true50() return false.
            // We need 10% true from this false.
            // Conditional probability: (60% - 50%) = trueKValue() / Given 50%
            // trueKValue = 10% * 2
            return trueKValue((k - 0.5) * 2, bool);
        }
    }
}

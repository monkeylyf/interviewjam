/*Binary_Generator
google

Given a binary generator which can generate 0 or 1 with both 50% chance.
Design a generator which can generator numbers from [0, n] with uniform
distribution.
*/

import java.util.*;


public class google_Binary_Generator {
    // Open issue:
    // If you can this script you will see that the results have huge difference
    // with different binaryGenerator/myrand.
    // But the unit test all passed for these two generator which generates 1/0
    // with uniform distribution.
    // Why?
  
    public static void main(String[] args) {
        testSuite(100000, 5, true);
        testSuite(100000, 5, false);
        //testSuite1(100000);
    }

    public static void testSuite1(int sample) {
        int res;
        HashMap<Integer, Integer> container = new HashMap<Integer, Integer>();
        for (; sample >= 0; --sample) {
            res = binaryGenerator();
            if (container.containsKey(res)) {
                container.put(res, container.get(res) + 1);  
            } else {
                container.put(res, 1);
            }
        }
        System.out.println(container);
    }

    public static void testSuite(int sample, int n, boolean myrand) {
        int res;
        HashMap<Integer, Integer> container = new HashMap<Integer, Integer>();
        for (; sample >= 0; --sample) {
            res = generator(n, myrand);
            if (container.containsKey(res)) {
                container.put(res, container.get(res) + 1);  
            } else {
                container.put(res, 1);
            }
        }
        System.out.println(container);
    }

    public static int generator(int n, boolean myrand) {
        if (n <= 0) {
            return -1; // throws new InvalidValueFormat("Invalid input");
        } else if (n == 1) {
            return 0;  
        } else if (n == 2) {
            int ret = (myrand) ? myrand() : binaryGenerator();
            return ret;
        }

		// n >= 3.
        int ret, nn, len = binaryFormatLength(n) + 1;
        while (true) {
            ret = 0;
            nn = len;
            while (nn > 0) {
                if (myrand) {
                    ret = (ret << 1) + myrand();
                } else {
                    ret = (ret << 1) + binaryGenerator();
                }
                nn = nn >> 1;
            }
            if (ret < n) {
                return ret;
            } // else rejects.
        }
    }

	public static int binaryFormatLength(int n) {
		return Integer.toBinaryString(n).length();	
	}

    public static int binaryGenerator() {
        return new Random().nextInt(2); 
    }

    public static int myrand() {
        return Math.random() > 0.5 ? 1 : 0;
    }
}

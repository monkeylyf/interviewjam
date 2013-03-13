/*Fibbonacci_Words

Recall that Fibbonacci words are defined recursively as: w(0)=a, w(1)=b, and
w(i)=w(i-1)w(i-2), for any integer i>1. The input to your procedure is formed
of a Fibonacci word w(n), where the index n is known in advance. Let S(k,n) be
the set of all distinct subwords of w(n) of a fixed length k, where k is also
known. The frequency of a subword s from S(k,n) refers to the total number of
full occurrences of s in w(n).

Given positive integers n<30 and k<4, find the frequency of the most frequent
subword in S(k,n). Important In your algorithmic solution tabling precomputed
values is not allowed!
*/

import java.util.*;


public class Fibbonacci_Word {
    public static void main(String[] args) {
        // Unit test for substringFreq.
        //System.out.println(substringFreq("abcd", 2));
        //System.out.println(substringFreq("babba", 2));
        //System.out.println(substringFreq("babbabab", 1));
        //System.out.println(substringFreq("babbabab", 2));
        //System.out.println(substringFreq("babbabab", 3));
        //System.out.println(substringFreq("babbabab", 4));
        // Unit test for k = 1
        //System.out.println(fibbonacciWordCount(5, 1));
        // General test case;
        long time1 = System.nanoTime();
        for (int n = 0; n < 33; ++n) {
            for (int k = 1; k < 10; ++k) {
                brutalForce(n, k);
            }
        }
        long time2 = System.nanoTime();
        System.out.println((time2 - time1) / 1000000000.0);
        time1 = System.nanoTime();
        for (int n = 0; n < 33; ++n) {
            for (int k = 1; k < 10; ++k) {
                fibbonacciWordCount(n, k);
            }
        }
        time2 = System.nanoTime();
        System.out.println((time2 - time1) / 1000000000.0);
        
        //for (int n = 0; n < 30; ++n) {
        //  for (int k = 1; k < 10; ++k) {
        //      System.out.println("n: " + n + " k: " + k + " brutal force: " + brutalForce(n, k) + " else: " + fibbonacciWordCount(n, k));
        //  }
        //}
    }
    public static int fibbonacciWordCount(int n, int k) {
        int base = 0;
        int shift = k - 1;
        String baseCase = "";
        String oddPattern = "";
        String evenPattern = "";
        int[] count = new int[3]; // count[0]: base case count; count[1]: oddPattern count; count[2]: evenPattern count;
        // Find the i Fibbonaci word W(i) that can not break into long enough W(i - 1) & w(i - 2)
        while (true) {
            baseCase = fibbonacciWord(base);
            if (baseCase.length() >= k) {
                break;
            }
            ++base;
        }
        String baseNext = fibbonacciWord(base + 1);
        // Find repeating patterns of concatenation part when n is odd and n is even.
        if (base % 2 == 0) {
            oddPattern = baseCase.substring(baseCase.length() - shift, baseCase.length()) + baseNext.substring(0, shift);
            evenPattern = baseNext.substring(baseNext.length() - shift, baseNext.length()) + baseCase.substring(0, shift);
        } else {
            oddPattern = baseNext.substring(baseNext.length() - shift, baseNext.length()) + baseCase.substring(0, shift);
            evenPattern = baseCase.substring(baseCase.length() - shift, baseCase.length()) + baseNext.substring(0, shift);
        }
        if (k == 1) {
            base = 1; // ad-hoc..
        }
        fibbonacciFreq(n, base, count);
        //print(count);
        //System.out.println("baseCase: " + baseCase);
        //System.out.println("baseNext: " + baseNext);
        //System.out.println("base case index " + base + " " + baseCase + " pattern " + oddPattern + " " + evenPattern);
        HashMap<String, Integer> baseFreq = substringFreq(baseCase, k);
        HashMap<String, Integer> oddFreq = substringFreq(oddPattern, k);
        HashMap<String, Integer> evenFreq = substringFreq(evenPattern, k);
        HashMap<String, Integer> globalFreq = new HashMap<String, Integer>();
        // Sum up base case frequency.
        sumFreq(globalFreq, baseFreq, count[0]);
        sumFreq(globalFreq, oddFreq, count[1]);
        sumFreq(globalFreq, evenFreq, count[2]);
        int ret = 0;
        for (int i : globalFreq.values()) {
            ret = Math.max(ret, i);
        }
        //System.out.println(baseFreq);
        //System.out.println(oddFreq);
        //System.out.println(evenFreq);
        //System.out.println(globalFreq);
        return ret;
    }
    public static void print(int[] A) {
        for (int i : A) System.out.print(i + " ");
        System.out.println();
    }
    public static void sumFreq(HashMap<String, Integer> global, HashMap<String, Integer> target, int freq) {
        for (String str : target.keySet()) {
            if (global.containsKey(str)) {
                global.put(str, global.get(str) + target.get(str) * freq);
            } else {
                global.put(str, target.get(str) * freq);
            }
        }
    }
    public static HashMap<String, Integer> substringFreq(String A, int k) {
        // Given string A and length k, return the frequency of substring with length k.
        HashMap<String, Integer> ret = new HashMap<String, Integer>();
        for (int i = 0; i <= A.length() - k; ++i) {
            String substr = A.substring(i, i + k);
            if (ret.containsKey(substr)) {
                int count = ret.get(substr);
                ret.put(substr, count + 1);
            } else {
                ret.put(substr, 1);
            }
        }
        return ret;
    }
    public static void fibbonacciFreq(int n, int base, int[] count) {
        // Fibbonaci recursion. Counting the appearance of base cases, odd cases and even cases.
        if (n < base) {
            return;
        }
        if (n == base) {
            ++count[0];
        } else {
            if (n % 2 == 0) {
                ++count[2];
            } else {
                ++count[1];
            }
            fibbonacciFreq(n - 1, base, count);
            fibbonacciFreq(n - 2, base, count);
        }
    }
    public static String fibbonacciWord(int n) {
        // Fibbonaci words generator.
        if (n == 0) {
            return "a";
        } else if (n == 1) {
            return "b";
        } else {
            return fibbonacciWord(n - 1) + fibbonacciWord(n - 2);
        }
    }
    public static int brutalForce(int n, int k) {
        // BF to generate test cases.
        String word = fibbonacciWord(n);
        HashMap<String, Integer> dict = substringFreq(word, k);
        int ret = 0;
        for (int i : dict.values()) {
            ret = Math.max(ret, i);
        }
        return ret;
    }
}

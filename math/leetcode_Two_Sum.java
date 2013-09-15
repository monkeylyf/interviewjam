/*Two_Sum

Given an array of integers, find two numbers such that they add up to a
specific target number.
The function twoSum should return indices of the two numbers such that they add
up to the target, where index1 must be less than index2. Please note that your
returned answers (both index1 and index2) are not zero-based.
You may assume that each input would have exactly one solution.
Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
*/


import java.util.HashMap;


public class leetcode_Two_Sum {

    public static void main(String[] args) {

    }

    public static int[] twoSum(int[] numbers, int target) {
        // Using hashmap to cache value/index pair.
        // Iterate through arr once. For each value check if target - value is cached.
        // If yes, return map.get(target - curValue) + 1, curIndex + 1. If no, cache
        // current value and index.
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int i;
        int[] ret = new int[2];
        for (i = 0; i < arr.length; ++i) {
            if (map.containsKey(target - arr[i])) {
                ret = new int[] {map.get(target - arr[i]) + 1, i + 1};
                break;        
            } else {
                map.put(arr[i], i);
            }
        }
        return ret;
    }
}

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


class leetcode_Two_Sum {
    public static void main(String[] args) {
    }
    public static int[] twoSum(int[] numbers, int target) {
        // The idea behind this is if you sort the array, you can easily find two
        // numbers sumed up to target but the indexes are unknown because of sorting.
        // Used a HashMap to set val/index pair.
        HashMap<Integer, Integer> indexes = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; ++i) {
            if (!indexes.containsKey(numbers[i])) {
                indexes.put(numbers[i], i + 1);
            }
            // Duplicates cannot be solutions unless they sum up to target.
            else if (numbers[i] * 2 == target) {
                return new int[] {indexes.get(numbers[i]), i + 1};
            }
        }
        Arrays.sort(numbers);
        int small = 0;
        int large = 0;
        int head = 0;
        int tail = numbers.length - 1;
        while (head < tail) {
            int sum = numbers[head] + numbers[tail];
            if (sum == target) {
                small = numbers[head];
                large = numbers[tail];
                break;
            } else if (sum < target) {
                ++head;
            } else {
                --tail;
            }
        }
        int index1 = indexes.get(small);
        int index2 = indexes.get(large);
        if (index1 < index2) {
            return new int[] {index1, index2};
        } else {
            return new int[] {index2, index1};
        }
    }
}

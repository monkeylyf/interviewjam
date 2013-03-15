/*Shortest_Distance_Between_Two_Words
careercup

You have a large text file containing words. Given any two words, find the
shortest distance (in terms of number of words) between them in the file. Can
you make the searching operation in O(1) time? What about the space complexity
for your solution?
*/


import java.util.*;


public class cap_Shortest_Distance_Between_Two_Words {
    public static void main(String[] args) {
        String[] input = {"b","c","b","d","d","e","e","b", "f", "f", "f", "d"};
        System.out.println(findShortest(input, "b", "d") == 1);
        // Unit tests for binarySearch.
        for (int i = 0;i < 10; ++i) {
            System.out.println(binarySearch(new Integer[] {0,1,2,3,4,5,6,7,8,9}, i, 0, 9) == 0);
        }
        System.out.println(binarySearch(new Integer[] {0,1,2,3,4,5,6,7,8,9}, 10, 0, 9) == 1);
        System.out.println(binarySearch(new Integer[] {0,1,2,3,4,5,6,7,8,9}, -1, 0, 9) == 1);
        System.out.println(binarySearch(new Integer[] {0,1,2,3,4,6,7,8,9}, 5, 0, 8) == 1);
        System.out.println(binarySearch(new Integer[] {0,1,2,3,6,7,8,9}, 5, 0, 7) == 1);
        System.out.println(binarySearch(new Integer[] {0,9}, 0, 0, 1) == 0);
        System.out.println(binarySearch(new Integer[] {0,9}, 1, 0, 1) == 1);
        System.out.println(binarySearch(new Integer[] {0,9}, 2, 0, 1) == 2);
        System.out.println(binarySearch(new Integer[] {0,9}, 3, 0, 1) == 3);
        System.out.println(binarySearch(new Integer[] {0,9}, 4, 0, 1) == 4);
        System.out.println(binarySearch(new Integer[] {0,9}, 5, 0, 1) == 4);
        System.out.println(binarySearch(new Integer[] {0,9}, 6, 0, 1) == 3);
        System.out.println(binarySearch(new Integer[] {0,9}, 7, 0, 1) == 2);
        System.out.println(binarySearch(new Integer[] {0,9}, 8, 0, 1) == 1);
        System.out.println(binarySearch(new Integer[] {0,9}, 9, 0, 1) == 0);
        for (int i = 0;i < 10; ++i) {
            System.out.println(binarySearch(new Integer[] {0}, i, 0, 0) == i);
        }
        for (int i = 0;i < 10; ++i) {
            System.out.println(binarySearch(new Integer[] {0,1,2,3,4,5,6,7,8,9}, i, 0, 9) == 0);
        }
        // Unit tests for shortest
        System.out.println(shortest(new String[] {"b","c","b","d","d","e","e","b", "f", "f", "f", "d"}, "b", "d"));
    }   
    public static int shortest(String[] arr, String a, String b) {
        // Time complexity O(n). Space complexity O(1).
        int shortest = Integer.MAX_VALUE;
        int aPos = Integer.MAX_VALUE;
        int bPos = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; ++i) {
            String cur = arr[i];
            if (cur.equals(a)) {
                aPos = i;
                if (bPos != Integer.MAX_VALUE) {
                    shortest = Math.min(shortest, aPos - bPos);
                }
            } else if (cur.equals(b)) {
                bPos = i;
                if (aPos != Integer.MAX_VALUE) {
                    shortest = Math.min(shortest, bPos - aPos);
                }
            }
        }
        return shortest;
    }
    public static int findShortest(String[] arr, String a, String b) {
        // Time complexity O(nlogn). Space complexity O(n).
        ArrayList<Integer> word1 = new ArrayList<Integer>();
        ArrayList<Integer> word2 = new ArrayList<Integer>();
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i].equals(a)) {
                word1.add(i);
            } else if (arr[i].equals(b)) {
                word2.add(i);
            }
        }
        if (word1.isEmpty() || word2.isEmpty()) {
            return Integer.MIN_VALUE;
        }
        Integer[] array1 = word1.toArray(new Integer[word1.size()]);
        Integer[] array2 = word2.toArray(new Integer[word2.size()]);
        int minDistance = Integer.MAX_VALUE;
        for (int i : array1) {
            minDistance = Math.min(binarySearch(array2, i, 0, array2.length - 1), minDistance);
        }
        return minDistance;
    }
    public static int binarySearch(Integer[] arr, int target, int head, int tail) {
        // Binary Search based to find the min difference.
        if (head > tail) {
            return Integer.MAX_VALUE;
        }
        int middle = (head + tail) / 2;
        int mid = arr[middle];
        if (mid == target) {
            return 0;
        } else if (mid > target) {
            return Math.min(mid - target, binarySearch(arr, target, 0, middle - 1));
        } else { // mid < target
            return Math.min(target - mid, binarySearch(arr, target, middle + 1, tail));
        }
    }
}

/*Longest_Consecutive_Sequence

Given an unsorted array of integers, find the length of the longest consecutive
elements sequence.
For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
Your algorithm should run in O(n) complexity.
*/


import java.util.HashMap;


class leetcode_Longest_Consecutive_Sequence{
    public static void main(String[] args) {
        //System.out.println(longestConsecutive(new int[] {0,3,7,2,5,8,4,6,0,1}));
        //System.out.println(longestConsecutive(new int[] {9,1,4,7,3,-1,0,5,8,-1,6}));
        System.out.println(longestConsecutive(new int[] {-6,6,-9,-7,0,3,4,-2,2,-1,9,-9,5,-3,6,1,5,-1,-2,9,-9,-4,-6,-5,6,-1,3}));
    }
    public static int longestConsecutive(int[] num) {
        int ans=0;
        HashSet<Integer> set = new HashSet<Integer>();
        for (int v : num) {
            set.add(v);
        }
        for(int v : num) {
            // Remove by sequence. Find the longest sequence containing point v and remove them
            // after recording its length.
            if (set.contains(v)) {
                ans = Math.max(ans, getCount(set, v, false) + getCount(set, v + 1, true));
            }
        }
        return ans;      
    }
    public static int getCount(HashSet<Integer> set, int v, boolean asc){
        int count = 0;
        while (set.contains(v)){
            set.remove(v);
            ++count;
            if (asc) {
                ++v;
            } else {
                --v;
            }
        }
        return count;
    }
    public static int longestConsecutive1(int[] num) {
        // You can sort the array first but it's gonna take nlogn. We can do better than that.
        // The idea behind this is using int[2] to represent the interval.
        // Loop over the given int array and for each integer i, check if i+1 and i-1 are in the table.
        final int leftEnd = 0;
        final int rightEnd = 1;
        HashMap<Integer, int[]> map = new HashMap<Integer, int[]>();
        int maxLength = 0;
        for (int i : num) {
            if (map.containsKey(i)) {
                continue; // Duplicate int. Has nothing to do with maxLength.
            }
            int[] largerInterval = map.get(i + 1);
            int[] smallerInterval = map.get(i - 1);
            if (largerInterval == null && smallerInterval == null) {
                // Neither i+1 nor i-1 in the table. Create new interval {i, i}.
                map.put(i, new int[] {i, i});
                maxLength = Math.max(maxLength, 1);
            } else if (largerInterval != null && smallerInterval != null) {
                // Both i+1 and i-1 are in the table.
                int[] largeEnd = map.get(largerInterval[rightEnd]);
                int[] smallEnd = map.get(smallerInterval[leftEnd]);
                largeEnd[leftEnd] = smallEnd[leftEnd]; // Extend larger's leftEnd to small's leftEnd.
                smallEnd[rightEnd] = largeEnd[rightEnd]; // Extend small's rightEnd to large's rigthEnd.
                map.put(largerInterval[rightEnd], largeEnd);
                map.put(smallerInterval[leftEnd], smallEnd);
                map.put(i, smallEnd);
                maxLength = Math.max(maxLength, largeEnd[rightEnd] - largeEnd[leftEnd] + 1);
            } else {
                if (largerInterval != null) { // new small edge found.
                    int[] largeEnd = map.get(largerInterval[rightEnd]);
                    largeEnd[leftEnd] = i;
                    largerInterval[leftEnd] = i; // updating interval's small end.
                    map.put(largerInterval[rightEnd], largeEnd);
                    map.put(i, largerInterval);
                    maxLength = Math.max(maxLength, largeEnd[rightEnd] - largeEnd[leftEnd] + 1);
                } else if (smallerInterval != null) {
                    int[] smallEnd = map.get(smallerInterval[leftEnd]);
                    smallEnd[rightEnd] = i;
                    smallerInterval[rightEnd] = i;
                    map.put(smallerInterval[leftEnd], smallEnd);
                    map.put(i, smallerInterval);
                    maxLength = Math.max(maxLength, smallEnd[rightEnd] - smallEnd[leftEnd] + 1);
                }
            }
        }
        return maxLength;
    }
}

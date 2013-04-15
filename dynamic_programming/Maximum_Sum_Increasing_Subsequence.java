class Maximum_Sum_Increasing_Subsequence {

    /**
     * Given an array of n positive integers. Write a program to find the sum of
     * maximum sum subsequence of the given array such that the integers in the
     * subsequence are sorted in increasing order. For example, if input is {1,
     * 101, 2, 3, 100, 4, 5}, then output should be 106 (1 + 2 + 3 + 100), if the
     * input array is {3, 4, 5, 10}, then output should be 22 (3 + 4 + 5 + 10)
     * and if the input array is {10, 5, 4, 3}, then output should be 10
     */
    public static void main(String[] args) {
        solve(new int[] {1, 101, 2, 3, 100, 4, 5});
        solve(new int[] {3, 4, 5, 10});
        solve(new int[] {10, 5, 4, 3});
    }
    
    public static void solve(int[] arr) {
        // It's almost as same as Longest_Increasing_Subsequence problem.
        int n = arr.length, max = 0, i, j;
        int[] dp = new int[n];
        for (i = 0; i < n; ++i) {
            for(j = 0; j < i; ++j) {
                dp[i] = (arr[i] > arr[j]) ? Math.max(dp[i], dp[j]) : dp[i];
            }
            dp[i] += arr[i];
            max = Math.max(max, dp[i]);
        }
        printArray(dp);
        System.out.println(max);
    }
    
    public static void printArray(int[] arr) {
        for (int i : arr) System.out.print(i + " ");
        System.out.println();
    }
}

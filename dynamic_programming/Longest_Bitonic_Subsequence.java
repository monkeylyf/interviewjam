class Longest_Bitonic_Subsequence {

    /**
     * Given an array arr[0 ... n-1] containing n positive integers, a
     * subsequence of arr[] is called Bitonic if it is first increasing, then
     * decreasing. Write a function that takes an array as argument and returns
     * the length of the longest bitonic subsequence. A sequence, sorted in
     * increasing order is considered Bitonic with the decreasing part as empty.
     * Similarly, decreasing order sequence is considered Bitonic with the
     * increasing part as empty.
     */
    public static void main(String[] args) {
        solve(new int[] {1, 11, 2, 10, 4, 5, 2, 1});
        solve(new int[] {12, 11, 40, 5, 3, 1});
        solve(new int[] {80, 60, 30, 40, 20, 10});
    }
    
    public static void solve(int[] arr) {
        // Variation of LIS
        int n = arr.length, max = 0, i, j;
        int[] incre = new int[n], decre = new int[n];
        for (i = 0; i < n ; ++i) {
            // LIS
            for (j = 0; j < i; ++j) {
                incre[i] = (arr[i] > arr[j]) ? Math.max(incre[i], incre[j]) : incre[i];
            }
            incre[i] += 1;
        }
        printArray(incre);
        for (i = n - 1; i >= 0; --i) {
            // LDS
            for (j = n - 1; j > i; --j) {
                decre[i] = (arr[i] > arr[j]) ? Math.max(decre[i], decre[j]) : decre[i];
            }
            decre[i] += 1;
        }
        printArray(decre);
        for (i = 0;i < n; ++i) {
            max = Math.max(max, incre[i] + decre[i] - 1);
        }
        System.out.println(max);
    }

    public static void printArray(int[] arr) {
        for (int i : arr) System.out.print(i + " ");
        System.out.println();
    }
}

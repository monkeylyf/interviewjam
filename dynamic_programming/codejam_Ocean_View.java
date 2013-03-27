/*Oceans_View
codejam

https://code.google.com/codejam/contest/2334486/dashboard#s=p2
*/

import java.util.*;


class codejam_Ocean_View {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T, N, i, j;
        int[] arr;
        T = sc.nextInt();
        for (i = 1; i <= T; ++i) {
            N = sc.nextInt();
            arr = new int[N];
            for (j = 0; j < N; ++j) {
                arr[j] = sc.nextInt();
            }
            solve(arr, N, i);
        }
    }
    public static void solve(int[] arr, int n, int T) {
        int[] status = new int[n];
        int i, j, localMax, max;
        max = -1;
        for (i = 0; i < n; ++i) {
            localMax = 0;
            for (j = 0; j < i; ++j) {
                if (arr[i] > arr[j]) {
                    localMax = Math.max(localMax, status[j]);
                }
            }
            status[i] = localMax + 1;
            max = Math.max(max, status[j]);
        }
        System.out.println("Case #" + T + ": " + (n - max));
    }
    public static void printArray(int[] arr) {
        for (int i : arr) System.out.print(i + " ");
        System.out.println();
    }
}

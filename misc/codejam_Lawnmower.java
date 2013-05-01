/*Lawnmower
codejam_2013_Qualification
https://code.google.com/codejam/contest/2270488/dashboard#s=p1
*/

import java.util.*;

class codejam_Lawnmower {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T, n, m, t, i, j;
        int[][] arr;
        T = sc.nextInt();
        for (t = 1; t <= T; ++t) {
            n = sc.nextInt();
            m = sc.nextInt();
            arr = new int[n][m];
            for (i = 0; i < n; ++i) {
                for (j = 0; j < m; ++j) {
                    arr[i][j] = sc.nextInt();  
                }  
            }
            if (n == 1 || m == 1) {
                System.out.println("Case #" + t + ": YES");  
            } else {
                solve(arr, n, m, t);  
            }
        }
    } 

    public static void solve(int[][] lawn, int n, int m, int t) {
        System.out.print("Case #" + t + ": ");
        int i, j, localMax;
        int[] col = new int[n], row = new int[m];
        for (i = 0; i < n; ++i) {
            localMax = Integer.MIN_VALUE;
            for (j = 0; j < m; ++j) {
                localMax = Math.max(localMax, lawn[i][j]);
            }
            col[i] = localMax;
        }
        for (i = 0; i < m; ++i) {
            localMax = Integer.MIN_VALUE;
            for (j = 0; j < n; ++j) {
                localMax = Math.max(localMax, lawn[j][i]);
            }
            row[i] = localMax;
        }
        for (i = 0; i < n; ++i) {
            for (j = 0; j < m; ++j) {
                if (lawn[i][j] != col[i] && lawn[i][j] != row[j]) {
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println("YES");
    }
}

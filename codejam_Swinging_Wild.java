/*Swinging_Wild
codejam

https://code.google.com/codejam/contest/1842485/dashboard#s=p0&a=0
*/

import java.util.*;


class codejam_Swinging_Wild {
    public static void main(String[] args) {
        int t, n, d, i, j;
        int[] vines, length;
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        for (i = 1; i <= t; ++i) {
            n = sc.nextInt();
            vines = new int[n];
            length = new int[n];
            for (j = 0; j < n; ++j) {
                vines[j] = sc.nextInt();
                length[j] = sc.nextInt();
            }
            d = sc.nextInt();
            solve(vines, length, n, d, i);
        }
    }

    public static void solve(int[] vines, int[] length, int n, int d, int testNum) {
        int i, j;
        int[] status = new int[n];
        status[0] = vines[0] + Math.min(vines[0], length[0]);
        if (status[0] >= d) {
            System.out.println("Case #" + testNum + ": YES");
            return;
        }
        for (i = 0; i < n; ++i) {
            for (j = i + 1; (j < n) && (vines[j] <= status[i]); ++j) {
                // For vine i, only consider the farest vine j (j < i) which
                // can reach vine i, so that from vine i the longest reachable
                // distance is maximized.
                status[j] = (status[j] != 0) ? status[j] : vines[j]
                        + Math.min(length[j], vines[j] - vines[i]);
                if (status[j] >= d) {
                    System.out.println("Case #" + testNum + ": YES");
                    return;
                }
            }
        }
        System.out.println("Case #" + testNum + ": NO");
    }
}

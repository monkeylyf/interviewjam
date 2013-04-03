/*Swinging_Wild
codejam
*/

import java.util.*;


public class codejam_Swinging_Wild {

    /**
     * https://code.google.com/codejam/contest/1842485/dashboard#s=p0
     */
    public static void main(String[] args) {
    }

    public static void solve(int[] vines, int[] length, int d) {
        int n = vines.length, i, j;
        int[] status = new int[n];
        status[0] = vines[0] + Math.min(vines[0], length[0]);
        for (i = 0; i < n; ++i) {
            print(status);
            for (j = i + 1; (j < n) && (vines[j] <= status[i]); ++j) {
                status[j] = (status[j] != 0) ? status[j] : vines[j]
                        + Math.min(length[j], vines[j] - vines[i]);
                if (status[j] >= d) {
                    System.out.println("True");
                    return;
                }
            }
        }
        System.out.println("False");
        print(status);
    }

    public static void print(int[] status) {
        for (int i : status) System.out.print(i + " ");
        System.out.println();
    }
}

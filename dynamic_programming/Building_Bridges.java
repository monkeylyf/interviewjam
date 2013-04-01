/*Build_Bridge
*/

import java.util.*;


public class Building_Bridges {

    /**
     * Consider a 2-D map with a horizontal river passing through its center.
     * There are n cities on the southern bank with x-coordinates a(1) ... a(n)
     * and n cities on the northern bank with x-coordinates b(1) ... b(n). You
     * want to connect as many north-south pairs of cities as possible with
     * bridges such that no two bridges cross. When connecting cities, you can
     * only connect city i on the northern bank to city i on the southern bank.
     * 
     * @param args
     */
    public static void main(String[] args) {
        solve(new int[] { 2, 1, 3 }, new int[] { 1, 2, 3 });
    }

    public static void solve(int[] south, int[] north) {
        assert (south.length == north.length);
        int n = south.length, i, j, max, localMax;
        CityPair[] pair = new CityPair[n];
        for (i = 0; i < n; ++i) {
            pair[i] = new CityPair(north[i], south[i]);
        }
        Arrays.sort(pair);
        // LIS of south x-coordinates.
        int[] status = new int[n];
        max = 0;
        for (i = 0; i < n; ++i) {
            localMax = 0;
            for (j = 0; j < i; ++j) {
                if (pair[i].s > pair[j].s) {
                    localMax = Math.max(localMax, status[j]);
                }
            }
            status[i] = localMax + 1;
            max = Math.max(max, status[i]);
        }
        System.out.println(status[n - 1]);
    }
}


class CityPair implements Comparable<CityPair> {
    public int n;
    public int s;

    CityPair(int n, int s) {
        this.n = n;
        this.s = s;
    }

    public int compareTo(CityPair pair) {
        return this.n - pair.n; // Sort based on north x-coordinates.
    }

    public String toString() {
        return "n: " + this.n + " s: " + this.s;
    }
}

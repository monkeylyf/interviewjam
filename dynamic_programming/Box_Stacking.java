import java.util.*;


public class Box_Stacking {

    /**
     * You are given a set of n types of rectangular 3-D boxes, where the i^th
     * box has height h(i), width w(i) and depth d(i) (all real numbers). You
     * want to create a stack of boxes which is as tall as possible, but you can
     * only stack a box on top of another box if the dimensions of the 2-D base
     * of the lower box are each strictly larger than those of the 2-D base of
     * the higher box. Of course, you can rotate a box so that any side
     * functions as its base. It is also allowable to use multiple instances of
     * the same type of box.
     * 
     * @param args
     */
    public static void main(String[] args) {
        solve(new int[][] {{5, 2, 4}, {1, 4, 2}, {4, 4, 2}});
    }

    public static void solve(int[][] boxes) {
        int n = boxes.length, i, j, max, localMax;
        Box[] arr = new Box[n * 3];
        for (i = 0; i < n; ++i) {
            arr[i * 3] = new Box(boxes[i][1], boxes[i][2], boxes[i][0]);
            arr[i * 3 + 1] = new Box(boxes[i][0], boxes[i][2], boxes[i][1]);
            arr[i * 3 + 2] = new Box(boxes[i][2], boxes[i][0], boxes[i][1]);
        }
        print(arr);
        Arrays.sort(arr);
        print(arr);
        // DP based. Very similar to LIS.
        n *= 3;
        int[] status = new int[n];
        max = -1;
        for (i = 0; i < n; ++i) {
            localMax = 0;
            for (j = 0; j < i; ++j) {
                if ((arr[j].d < arr[i].d) && (arr[j].w < arr[i].w)) {
                    localMax = Math.max(localMax, status[j]);
                }
            }
            status[i] = localMax + arr[i].h;
            max = Math.max(max, status[i]);
        }
        System.out.println(max);
    }
    public static void print(Box[] arr) {
        for (Box i : arr) System.out.println(i);
        System.out.println();
    }
}


class Box implements Comparable<Box> {
    public int h; // height
    public int w; // width
    public int d; // depth

    Box(int x, int y, int z) {
        this.h = x;
        this.w = (y >= z) ? y : z;
        this.d = (y >= z) ? z : y;
    }
    
    public int compareTo(Box box) {
        if ((this.w > box.w) && (this.d > box.d)) {
            return 1; // Increasing order.
        } else if ((this.w == box.w) && (this.d == box.d)) {
            return 0;
        } else {
            return -1;
        }
    }
    
    public String toString() {
        return "h: " + this.h + " w: " + this.w + " d: " + this.d;
    }
}

/*Trapping_Rain_Water_2D

2D version of Trapping_Rain_Water.

Example:
3 3 3
3 0 3
3 3 3

Output: 3
*/

import java.util.*;


class Trapping_Rain_Water {
    public static void main(String[] args) {
        int[][] input = new int[][] {{3, 3, 3, 3, 3},
                                     {3, 2, 2, 2, 3},
                                     {3, 2, 0, 2, 3},
                                     {3, 2, 2, 2, 3},
                                     {3, 3, 3, 3, 3}};
        waterContainer test = new waterContainer(input);
        System.out.println(test.solve());
        trappedWater2D test1 = new trappedWater2D(input);
        System.out.println(test1.waterVol());
    }
}


class trappedWater2D {
    private int m;
    private int n;
    private int[][] container;
    private int count;
    private int lowest;
    public trappedWater2D(int[][] input) {
        this.container = input;
        this.m = input.length;
        this.n = input[0].length;
        this.count = 0;
        this.lowest = Integer.MAX_VALUE;
    }
    public int waterVol() {
        if (this.m < 2 || this.n < 2) {
            return Integer.MAX_VALUE; // Invalid input matrix.
        }
        // Get the lowest of outline.
        for (int i = 0; i < m; i++){
            // left border.
            this.lowest = Math.min(this.lowest, container[i][0]);
            // right border.
            this.lowest = Math.min(this.lowest, container[i][n - 1]);
        }
        for (int j = 1; j < n - 1; j++){
            // upper border.
            this.lowest = Math.min(this.lowest, container[0][j]);
            // down border.
            this.lowest = Math.min(this.lowest, container[m - 1][j]);
        }
        nextLayer(1, 1, m - 2, n - 2);
        return count;
    }
    private void nextLayer(int x1, int y1, int x2, int y2) {
        if (x1 > x2 || y1 > y2) {
            return;
        } else if (x1 == x2) {
            for (int i = y1; i <= y2; ++i) {
                trap(x1, i);
            }
        } else if (y1 == y2) {
            for (int i = x1; i <= x2; ++i) {
                trap(i, y1);
            }
        } else {
            int layerMin = Integer.MAX_VALUE;
            for (int i = x1; i <= x2; i++){
                // left border.
                layerMin = Math.min(layerMin, container[i][y1]);
                trap(i, y1);
                // right border.
                layerMin = Math.min(layerMin, container[i][y2]);
                trap(i, y2);
            }
            for (int j = y1 + 1; j < y2; j++){
                // upper border.
                layerMin = Math.min(layerMin, container[x1][j]);
                trap(x1, j);
                // down border.
                layerMin = Math.min(layerMin, container[x2][j]);
                trap(x2, j);
            }
            // Update this.lowest
            this.lowest = Math.max(this.lowest, layerMin);
            // Recursive.
            nextLayer(x1 + 1, y1 + 1, x2 - 1, y2 - 1);
        }
    }
    private void trap(int x, int y) {
        if (this.container[x][y] < this.lowest) {
            this.count += this.lowest - this.container[x][y];
        }
    }
}


// Peking2's awesome solution.
class waterContainer {
    private int m; // length
    private int n; // width
    private int[][] mat;
    private boolean[][] visited;
    private PriorityQueue<Cell> pq;
    private int count;
    public waterContainer(int[][] input) {
        mat = input;
        m = mat.length;
        n = mat[0].length;
        visited = new boolean[m][n];
        pq = new PriorityQueue<Cell>();
        count=0;
    }
    class Cell implements Comparable<Cell> {
        int x;
        int y;
        int height;
        public Cell(int x,int y,int height) {
            this.x = x;
            this.y = y;
            this.height = height;
        }
        public int compareTo(Cell o) {
            return height - o.height;
        }
    }
    private void check(int x, int y, int lowest) {
        if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y]) {
            return;
        }
        if (mat[x][y] < lowest) {
            count += lowest - mat[x][y];
        }
        visited[x][y] = true;
        pq.offer(new Cell(x, y, Math.max(lowest, mat[x][y])));
    }
    public int solve() {
        // Pushing the outline into priority queue.
        for (int i = 0; i < m; i++){
            // left border.
            visited[i][0] = true;
            pq.offer(new Cell(i, 0, mat[i][0]));
            // right border.
            visited[i][n-1] = true;
            pq.offer(new Cell(i, n-1, mat[i][n-1]));
        }
        for (int j = 1; j < n - 1; j++){
            // upper border.
            visited[0][j] = true;
            pq.offer(new Cell(0, j, mat[0][j]));
            // down border.
            visited[m-1][j]=true;
            pq.offer(new Cell(m-1, j, mat[m-1][j]));
        }
        while (!pq.isEmpty()){
            Cell curr = pq.poll();
            check(curr.x - 1, curr.y, curr.height);
            check(curr.x + 1, curr.y, curr.height);
            check(curr.x, curr.y - 1, curr.height);
            check(curr.x, curr.y + 1, curr.height);
        }      
        return count;
    }
}

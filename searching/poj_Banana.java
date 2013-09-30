/*Banana
poj

A good practice of disjoint set. Union-find rocks!
http://en.wikipedia.org/wiki/Disjoint-set_data_structure
*/

import java.util.*;

public class Banana {

    /**
     * http://poj.org/problem?id=1838
     */

    public static void main(String[] args) {
        testSuite1();
    }

    public static void testSuite1() {
        int n = 10;
        int k = 3;
        int[][] trees = new int[][] { { 7, 10 }, { 1, 1 }, { 101, 1 },
                { 2, 2 }, { 102, 1 }, { 7, 11 }, { 200, 202 }, { 2, 1 },
                { 3, 2 }, { 103, 1 } };
        solve(trees, n, k);
    }
    
    public static void solve(int[][] trees, int n, int k) {
        Cell[] cells = new Cell[n];
        int[] parents = new int[n];
        int[] size = new int[n];
        int i, j;
        Arrays.fill(size, 1);
        printArray(size);
        for (i = 0; i < trees.length; ++i) {
            cells[i] = new Cell(trees[i][0], trees[i][1], i);
            parents[i] = i;
        }
        HorizontalCompr HC = new HorizontalCompr();
        Arrays.sort(cells, HC);
        print(cells);
        for (i = 1; i < n; ++i) {
            if (cells[i].x == cells[i - 1].x && cells[i].y - cells[i - 1].y == 1) {
                union(parents, size, cells[i].index, cells[i - 1].index);
            }
        }
        VerticalCompr VC = new VerticalCompr();
        Arrays.sort(size);
        print(cells);
        for (i = 1; i < n; ++i) {
            if (cells[i].y == cells[i - 1].y && cells[i].x - cells[i - 1].x == 1) {
                union(parents, size, cells[i].index, cells[i - 1].index);
            }
        }
        int res = 0;
        for (i = 0; i < k; ++i) {
            res += size[n - 1 - i];
        }
        System.out.println(res);
    }
    
    public static void union(int[] parents, int[] size, int a, int b) {
        int i = find(parents, a);
        int j = find(parents, b);
        if (i == j) {
            return;
        }
        if (size[i] < size[j]) {
            parents[i] = j;
            size[j] += size[i];
        } else {
            parents[j] = i;
            size[i] += size[j];
        }
    }
    
    public static int find(int[] parents, int i) {
        if (parents[i] != i) {
        //while (i != parents[i]) {
            //i = parents[i];
            parents[i] = find(parents, parents[i]);
        }
        return parents[i];
    }
    
    // Helper function
    public static void printArray(int[] arr) {
        for (int i : arr) System.out.print(i + " ");
        System.out.println();
    }
    public static void print(Cell[] arr) {
        for (Cell i : arr) System.out.print(i + " ");
        System.out.println();
    }
}


class Cell {
    int x;
    int y;
    int index;

    Cell(int x, int y, int index) {
        this.x = x;
        this.y = y;
        this.index = index;
    }
    
    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }
}


class HorizontalCompr implements Comparator<Cell> {
    @Override
    public int compare(Cell a, Cell b) {
        return (a.x != b.x) ? a.x - b.x : a.y - b.y;
    }
}


class VerticalCompr implements Comparator<Cell> {
    @Override
    public int compare(Cell a, Cell b) {
        return (a.y != b.y) ? a.y - b.y : a.x - b.x;
    }
}

import java.util.Arrays;

class Optimal_BST {
    /**
     * Given a sorted array keys[0.. n-1] of search keys and an array freq[0..
     * n-1] of frequency counts, where freq[i] is the number of searches to
     * keys[i]. Construct a binary search tree of all keys such that the total
     * cost of all the searches is as small as possible.
     * 
     * Let us first define the cost of a BST. The cost of a BST node is level of
     * that node multiplied by its frequency. Level of root is 1.
     */
    public static void main(String[] args) {
        solve(new int[] {10, 12, 20}, new int[] {34, 8, 50});
    }

    public static void solve(int[] node, int[] freq) {
        int n = node.length, i, j, r, L;
        // Create Node array.
        Node[] arr = new Node[n];
        for (i = 0; i < n; ++i) {
            arr[i] = new Node(node[i], freq[i]);
        }
        // Sort array according to node.val.
        Arrays.sort(arr);
        printNode(arr);
        // Init dp state.
        int[][] dp = new int[n][n];
        for (i = 0; i < n; ++i) {
            dp[i][i] = arr[i].freq;
        }
        printMatrix(dp);
        for (L = 2 ; L <= n; ++L) { // L is the chain length.
            for (i = 0; i <= n - L; ++i) { // row index
                j = i + L - 1; // col index
                System.out.println("i: " + i + " j: " + j);
                dp[i][j] = Integer.MAX_VALUE;
                for (r = i ; r <= j; ++r) { // make a BST out of arr[i:j] with root arr[r].
                    // if r == i, left child is empty and right child is dp[i][r - 1]
                    // if r == j, right child is empty and left child is dp[r + 1][j]
                    int c = ((r > i) ? dp[i][r - 1] : 0) + ((r < j) ? dp[r + 1][j] : 0) + sum(arr, i, j);
                    dp[i][j] = Math.min(dp[i][j], c);
                }
            }
        }
        printMatrix(dp);
        System.out.println(dp[0][n - 1]);
    }
   
    // Helper function. 
    public static int sum(Node[] arr, int i, int j) {
        int ret = 0;
        for (int k = i; k <= j; ++k) {
            ret = ret + arr[k].freq;
        }
        return ret;
    }
    
    public static void printNode(Node[] arr) {
        for (Node i : arr) System.out.print(i + " ");
        System.out.println();
    }
    
    public static void print(int[] arr) {
        for (int i : arr) System.out.print(i + " ");
        System.out.println();
    }
    
    public static void printMatrix(int[][] m) {
        for (int[] i : m) print(i);
        System.out.println();
    }
}

class Node implements Comparable<Node>{
    int freq;
    int val;
    Node (int val, int freq) {
        this.freq = freq;
        this.val = val;
    }
    
    @Override
    public int compareTo(Node that) {
        return this.val - that.val;
    }
    
    public String toString() {
        return "freq: " + this.freq + " val: " + this.val;
    }
}

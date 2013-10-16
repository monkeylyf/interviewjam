class Largest_Independent_Tree_Set {
    /**
     * Given a Binary Tree, find size of the Largest Independent Set(LIS) in it.
     * A subset of all tree nodes is an independent set if there is no edge
     * between any two nodes of the subset. For example, consider the following
     * binary tree. The largest independent set(LIS) is {10, 40, 60, 70, 80} and
     * size of the LIS is 5.
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(20);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(40);
        root.left.right = new TreeNode(50);
        root.left.right.left = new TreeNode(70);
        root.left.right.right = new TreeNode(80);
        root.right.right = new TreeNode(60);
        solve(root);
    }
    
    public static void solve(TreeNode root) {
        int[] max = new int[1];
        nextNode(root, max);
        System.out.println(max[0]);
    }
    
    public static int[] nextNode(TreeNode root, int[] max) {
        if  (root == null) {
            System.out.print("Cur node " + root);
            System.out.println(" Empty");
            return new int[2];
        } else {
            int[] left = nextNode(root.left, max);
            int[] right = nextNode(root.right, max);
            // Count cur node.
            int count = 1 + left[1] + right[1];
            // Dont count cur node.
            int nocount = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
            max[0] = Math.max(Math.max(max[0], count), nocount);
            System.out.print("Cur node " + root);
            System.out.println(" " + count + "/" + nocount);
            return new int[] {count, nocount};
        }
        
    }
}


class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;
    TreeNode(int x) {
        this.val = x;
        this.left = null;
        this.right = null;
    }
    public String toString() {
        return "" + this.val;
    }
}

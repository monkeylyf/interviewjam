/*Binary_Search_Tree_Iterater
LinkedIn

Design a BST iterater with method hasNext() and next()
*/


class linkedin_Binary_Search_Tree_Iterater {
    public static void main(String[] args) {
    }
    public static Iterator inorder(TreeNode root) {
        ArrayList<Integer> all = new ArrayList<Integer>();
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode node = root; // Don't want to mess up root.
        while (node != null || !s.isEmpty()) {
            if (node != null) {
                s.add(node);
                node = node.left;
            } else {
                node = s.pop();
                all.add(node.val);
                node = node.right;
            }   
        }   
        return new Iterator(all);
    }
    public static Iterator preorder(TreeNode root) {
        ArrayList<Integer> all = new ArrayList<Integer>();
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode node = root; // Don't want to mess up root.
        while (node != null || !s.isEmpty()) {
            if (node != null) {
                all.add(node.val);
                s.push(node);
                node = node.left;
            } else {
                node = s.pop();
                node = node.right;
            }
        }
        return new Iterator(all);
    }
    public static Iterator postorder(TreeNode root) {
        ArrayList<Integer> all = new ArrayList<Integer>();
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode prev = null;
        if (root != null) {
            s.push(root);
        }   
        while (!s.isEmpty()) {
            TreeNode cur = s.peek();
            if (prev == null || prev.left == cur || prev.right == cur) {
                if (cur.left != null) {
                    s.push(cur.left);
                } else if (cur.right != null) {
                    s.push(cur.right);
                }
            } else if (cur.left == prev) {
                if (cur.right != null) {
                    s.push(cur.right);
                }
            } else {
                all.add(cur.val);
                s.pop();
            }
            pre = cur;
        }
        return new Iterator(all);
    }
    public static dfs(TreeNode root) {
        ArrayList<Integer> all = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            all.add(node.val);
            if (node.left != null) {
                queue.add(node.left)
            }
            if (node.right != null) {
                queue.add(node.right)
            }
        }
        return new Iterator(all);
    }
    public static Iterator {
        private ArrayList<Integer> arr;
        private int index;
        Iterator(ArrayList<Integer> arr) {
            this.arr = arr;
            index = -1;
        }
        public boolean hasNext() {
            return index < arr.size() - 1;
        }
        public int next() {
            return arr.get(++index);
        }
    }
    public static TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) {
            val = x;
            left = null;
            right = null;
        }
    }
}

/*Given the in-order traverse and pre-order traverse of a BINARY TREE, write an
algorithm to print post-order traverse.

FOLLOWUP:
Given in-order and post-order, can you get pre-order? Or given pre-order and
post-order, can you get in-order?

What if it is binary search tree instead of binary tree?*/

class extra_1 {
    public static void main(String[] args) {
        int[] pre = new int[] {1,2,4,8,9,10,11,5,3,6,7};
        int[] in= new int[] {8,4,10,9,11,2,5,1,6,3,7};
        Tree t = reconstruct(pre, in);
        t.preOrder();
        t.inOrder();
        t.postOrder();
    }
    public static Tree reconstruct(int[] pre, int[] in) {
        Tree t = new Tree();
        t.root = nextNode(pre, in, t.root);
        return t;
    }
    public static Node nextNode(int[] pre, int[] in, Node entry) {
        Node node = new Node();
        if (pre.length != 0 && in.length != 0) {
            node.data = pre[0];
            // Get the root index of current subtree.
            int index = 0;
            for (int i = 0; i < in.length; ++i) if (in[i] == pre[0]) index = i;
            // Create inorder & preorder for right child node.
            int[] right_in = new int[in.length - index - 1];
            int[] right_pre = new int[in.length - index - 1];
            for (int i = index + 1; i < in.length; ++i) {
                right_in[i - index - 1] = in[i];
                right_pre[i - index - 1] = pre[i];
            }
            // Create inorder & preorder for left child node.
            int[] left_in = new int[index];
            int[] left_pre = new int[index];
            for (int i = 0; i < index; ++i) {
                left_in[i] = in[i];
                left_pre[i] = pre[i + 1];
            }
            node.r = nextNode(right_pre, right_in, node.r);
            node.l = nextNode(left_pre, left_in, node.l);
            }
        else node = null;
        return node;
    }
}


class Tree {
    public Node root;
    public void inOrder() {
        inorder(root);
        System.out.println("");
    }
    private void inorder(Node n) {
        if (n != null) {
            inorder(n.l);
            System.out.print(n.data + " ");
            inorder(n.r);
        } 
    }
    public void preOrder() {
        preorder(root);
        System.out.println("");
    }
    private static void preorder(Node n) {
        if (n != null) {
            System.out.print(n.data + " ");
            preorder(n.l);
            preorder(n.r);
        }
    }
    public void postOrder() {
        postorder(root);
        System.out.println("");
    }
    private void postorder(Node n) {
        if (n != null) {
            postorder(n.l);
            postorder(n.r);
            System.out.print(n.data + " ");
        }
    }
}


class Node {
    Node r;
    Node l;
    int data;
    public Node() {
        r = null;
        l = null;
        data = 0;
    }
}

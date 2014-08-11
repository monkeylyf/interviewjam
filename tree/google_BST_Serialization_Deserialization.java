/*google_BST_Serialization_Deserialization
google

*NOTE*: It has not to be a BST. Binary Tree is a more general case.

     30
	/  \
   10   20
  /    /  \
 50   45   35

Serialization: 30 10 50 # # # 20 45 # # 35 # #
*/


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;


public class google_BST_Serialization_Deserialization {

  /**
   * Assuming the order of serial is preorder.
   *
   * And it's not neccessary to be binary search tree. It applies to binary tree.
   */

  public static void main(String[] args) {
    test();
  }

  /**
   * Test case for serialize.
   */
  private static void test() {
	TreeNode root = new TreeNode(30);
	root.left = new TreeNode(10);
	root.right = new TreeNode(20);
	root.left.left = new TreeNode(50);
	root.right.left = new TreeNode(45);
	root.right.right = new TreeNode(35);
	System.out.println(serialize(root));
	// Test case for deserialize.
    List<String> nodes = new ArrayList<String>();
    Collections.addAll(nodes, "30", "10", "50", "#", "#", "#", "20",
	  "45", "#", "#", "35", "#", "#");
	System.out.println(serialize(deserialize(nodes)));
  }

  /**
   * Deserialization.
   */
  public static TreeNode deserialize(List<String> nodes) {
	Queue<String> q = new LinkedList<String>();
	for (String node : nodes) {
	  q.add(node);
	}

	return deserializeUtil(q);
  }

  private static TreeNode deserializeUtil(Queue<String> q) {
	String str = q.poll();
	if (str.equals("#")) {
	  return null;
	} else {
	  int val = Integer.parseInt(str);
	  TreeNode newNode = new TreeNode(val);
	  if (!q.isEmpty()) {
		newNode.left = deserializeUtil(q);
	  }
	  if (!q.isEmpty()) {
		newNode.right = deserializeUtil(q);
	  }

	  return newNode;
	}
  }

  /**
   * Serialization.
   *
   * Can be in-order, can be pre-order or post-order as long as it is consistent with
   * deserialization.
   */
  public static List<String> serialize(TreeNode root) {
	List<String> serial = new ArrayList<String>();
	serializeUtil(root, serial);

    return serial;
  }

  private static void serializeUtil(TreeNode root, List<String> serial) {
	if (root == null) {
	  serial.add("#");
	} else {
	  serial.add("" + root.val);
	  serializeUtil(root.left, serial);
	  serializeUtil(root.right, serial);
	}
  }

  private static class TreeNode {
	public TreeNode left;
	public TreeNode right;
	public final int val;

	TreeNode(final int val) {
	  this.left = null;
	  this.right = null;
	  this.val = val;
	}
  }
}

/*Sum_Path_III

You are given a binary tree in which each node contains a value. Design an
algorithm to print all paths which sum up to that value. Note that it can be
any path in the tree - it does not have to start at the root
*/


import java.util.*;

public class Sum_Path_III {
	
	/* The idea is dfs to traverse all nodes and return all possible paths.*/

	public static void main(String[] args) {
		// Test case 1.
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.right = new TreeNode(-1);
		root.right.left = new TreeNode(2);
		root.right.right = new TreeNode(4);
		dfs(root, 3);
	}
    
    public static HashMap<Integer, ArrayList<ArrayList<Integer>>> dfs(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
		// Ok, HashMap Key represents: the sum of path, Value: int[], elements.
        HashMap<Integer, ArrayList<ArrayList<Integer>>> left, right, ret;
		left = dfs(root.left, target);
        right = dfs(root.right, target);
        ret = new HashMap<Integer, ArrayList<ArrayList<Integer>>>();
        ArrayList<ArrayList<Integer>> subroutes;
        ArrayList<Integer> subroute;
        // If check root.val matches target, then itself forms a path. 
        if (target == root.val) {
        	System.out.println(String.format("root itself matches target: %d\n", root.val));
        }
        if (left == null && right == null) {
			// If cur node is leaf, cook the return path status.
        	subroutes = new ArrayList<ArrayList<Integer>>(); 
        	subroute = new ArrayList<Integer>();
        	subroute.add(root.val);
        	subroutes.add(subroute);
        	ret.put(root.val, subroutes);
        	return ret;
        }
        //System.out.println("left: " + left);
        //System.out.println("right: " + right);
        int rest = target - root.val;
        // Check if left subtree + root matches target
        stdoutOneSide(left.get(rest), root.val, true);
        // Check if right subtree + root matches target
        stdoutOneSide(right.get(rest), root.val, false);
       
	    // Check if left + cur node + right matches target.
		// Two sum search.
        int[] left_key = setToArray(left.keySet());
        int[] right_key = setToArray(right.keySet());

        Arrays.sort(left_key);
        Arrays.sort(right_key);
        
        int head = 0, tail = right_key.length - 1, l, r;
        while (head < left_key.length && tail >= 0) {
        	l = left_key[head];
        	r = right_key[tail];
        	if (l + r == rest) {
        		// Find sum match.
        		stdout(left.get(l), right.get(r), root.val);
        		head = head + 1;
        		tail = tail - 1;
        	} else if (l + r > rest) {
        		tail = tail - 1;
        	} else {
        		head = head + 1;
        	}
        }
        // Cooking return HashMap to root's parent, if it exists.
        cookNewSubroute(ret, left, root.val);
        cookNewSubroute(ret, right, root.val);
        // add root node as a simple path.
        subroutes = ret.get(root.val);
        if (subroutes == null) {
        	subroutes = new ArrayList<ArrayList<Integer>>();
        }
    	subroute = new ArrayList<Integer>();
    	subroute.add(root.val);
    	subroutes.add(subroute);
    	ret.put(root.val, subroutes);
        return ret;
    }

    public static int[] setToArray(Set<Integer> set) {
    	int[] ret = new int[set.size()];
    	int idx = 0;
    	for (int i : set) {
    		ret[idx++] = i;
    	}
    	return ret;
    }
    
    public static void cookNewSubroute(HashMap<Integer, ArrayList<ArrayList<Integer>>> ret, HashMap<Integer, ArrayList<ArrayList<Integer>>> side, int root) {
        ArrayList<ArrayList<Integer>> new_subroutes, subroutes;
        for (int key : side.keySet()) {
        	new_subroutes = new ArrayList<ArrayList<Integer>>();
        	subroutes = side.get(key);
        	for (ArrayList<Integer> sub : subroutes) {
        		sub.add(root);
        		new_subroutes.add(sub);
        	}
        	ret.put(key + root, new_subroutes);
        }    	
    }

	// Helper function.
    public static void print(int[] arr) {
    	for (int i : arr) System.out.print(i + " ");
    	System.out.println();
    }

    public static void stdoutOneSide(ArrayList<ArrayList<Integer>> side, int root, boolean isLeftSubtree) {
    	if (side == null) {
    		return;
    	}
    	for (ArrayList<Integer> i : side) {
    		if (isLeftSubtree) {
    			System.out.println("left subtree: " + i);
    			System.out.println("root node: " + root + "\n");
    		} else {
    			System.out.println("root node: " + root);
    			System.out.println("right subtree: " + i + "\n");
    		}
    	}
    }
    
    public static void stdout(ArrayList<ArrayList<Integer>> left, ArrayList<ArrayList<Integer>> right, int root) {
    	for (ArrayList<Integer> i : left) {
    		for (ArrayList<Integer> j : right) {
    			System.out.println("left subtree: " + i);
    			System.out.println("root node: " + root);
    			System.out.println("right subtree: " + j + "\n");
    		}
    	}
    }

	static class TreeNode {
		TreeNode left;
		TreeNode right;
		int val;

		TreeNode(int val) {
			this.left = null;
			this.right = null;
			this.val = val;
		}
	}
}

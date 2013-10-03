/*leetcode_Clone_Graph
leetcode

Clone an undirected graph. Each node in the graph contains a label and a list
of its neighbors.

OJ's undirected graph serialization:
Nodes are labeled uniquely.

We use # as a separator for each node, and , as a separator for node label and
each neighbor of the node.
As an example, consider the serialized graph {0,1,2#1,2#2,2}.

The graph has a total of three nodes, and therefore contains three parts as
separated by #.

1. First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
2. Second node is labeled as 1. Connect node 1 to node 2.
3. Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.

Visually, the graph looks like the following:

       1
      / \
     /   \
    0 --- 2
         / \
         \_/
*/


import java.util.*;


public class leetcode_Clone_Graph {
	
	public static void main(String[] args) {
			
	}
	// DFS. Passed.
	public static UndirectedGraphNode clone(UndirectedGraphNode node) {
		if (node == null) {
			return null;	
		}
		HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode,
																 			UndirectedGraphNode>();
		return cloneUtil(node, map);
	}

	private static UndirectedGraphNode cloneUtil(UndirectedGraphNode node,
												 HashMap<UndirectedGraphNode, UndirectedGraphNode> map) {
		if (map.containsKey(node)) {
			return map.get(node);	
		} else {
			UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
			map.put(node, newNode);
			for (UndirectedGraphNode neighbor : node.neighbors) {
				newNode.neighbors.add(cloneUtil(neighbor, map));
			}
			return newNode;
		}
	
	}

	// BFS. Passed.
	public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null) {
			return null;	
		}
		Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();

		HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode,
		                                                                    UndirectedGraphNode>();

		map.put(node, new UndirectedGraphNode(node.label));
		UndirectedGraphNode cur, neighborClone, cloned;
		q.add(node);

		while (!q.isEmpty()) {
			cur = q.poll();
			cloned = map.get(cur);	
			if (cloned == null) {
				cloned = new UndirectedGraphNode(cur.label);
			}

			for (UndirectedGraphNode neighbor : cur.neighbors) {
				neighborClone = map.get(neighbor);
				if (neighborClone == null) {
					neighborClone = new UndirectedGraphNode(neighbor.label);
					map.put(neighbor, neighborClone);
					// Added to queue.
					q.add(neighbor);
				}
				cloned.neighbors.add(neighborClone);
			}
		}

		return map.get(node);
	}
}



class UndirectedGraphNode {

    int label;
    ArrayList<UndirectedGraphNode> neighbors;

    UndirectedGraphNode(int x) {
		this.label = x;
		this.neighbors = new ArrayList<UndirectedGraphNode>();
	}
};

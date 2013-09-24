/*Hamiltonian_Cycle

http://en.wikipedia.org/wiki/Hamiltonian_path

Given a graph matrix: matrix[i][j] == 1, means point i is connected directly to
point j. 0 otherwise.

Print out all possible hamiltonian cycle.
*/



class Hamiltonian_Cycle {

	/**
	 * The question is printing out all possible paths and dfs will serve.
	 * You should check if this graph has hamiltonian path first.
	 */

	public static void main(String[] args) {
		int[][] graph = new int[][] {
									 { 1, 1, 0, 1, 0 },
									 { 1, 1, 1, 1, 1 },
									 { 0, 1, 1, 0, 1 },
									 { 1, 1, 0, 1, 1 },
									 { 0, 1, 1, 1, 1 },
									};
		solve(graph);
	}

	public static void solve(int[][] graph) {
		int n = graph.length;
		int[] path = new int[n];
		boolean[] used = new boolean[n];
		walk(graph, path, used, 0);
	}

	public static void walk(int[][] graph, int[] path, boolean[] used, int ptr) {
		if (ptr == path.length) {
			// Last check for if path[last] is connected bo path[first] to form
			// a cycle.
			if (graph[path[path.length - 1]][path[0]] == 1) {
				print(path);
			}
		} else {
			for (int i = 0; i < path.length; ++i) {
				if (ptr == 0 || (!used[i] && graph[path[ptr - 1]][i] == 1)) {
					// if ptr == 0, find starting point.
					// or looking for unused point which is connected to previous point.
					path[ptr] = i;
					used[i] = true;
					walk(graph, path, used, ptr + 1);
					used[i] = false; // Backtracking and reset the visited status.
				}
			}
		}
	}

	public static void print(int[] arr) {
		for (int i : arr) System.out.print(i + " ");
		System.out.println();
	}
}

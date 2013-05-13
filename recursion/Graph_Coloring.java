import java.util.*;

public class Graph_Coloring {

	public static void main(String[] args) {
		/*Create following graph and test whether it is 3 colorable
       	  (3)---(2)
       	   |   / |
       	   |  /  |
       	   | /   |
      	  (0)---(1)
		*/
		int[][] graph = new int[][] { { 1, 1, 1, 1 }, { 1, 1, 1, 0 },
				{ 1, 1, 1, 1 }, { 1, 0, 1, 1 } };
		solve(graph);
	}

	public static void solve(int[][] graph) {
		int n = graph.length;
		int[] color = new int[n];
		paint(graph, color, 0);
	}

	public static void paint(int[][] graph, int[] color, int ptr) {
		if (color.length == ptr) {
			if (isValidColor(graph, color, 0, color[0])) {
				printColor(color);
			}
		} else {
			for (int c = 1; c <= color.length; ++c) {
				if (ptr == 0 || isValidColor(graph, color, ptr, c)) {
					// if ptr == 0, assign any color.
					// else, check if it conflics with its neighbor with color c assigned.
					color[ptr] = c;
					paint(graph, color, ptr + 1);
				}
			}
		}
	}

	public static boolean isValidColor(int[][] graph, int[] color, int cur,
			int cur_color) {
		for (int i = 0; i < color.length; ++i) {
			if (i != cur && graph[cur][i] == 1 && color[i] == cur_color) {
				// iterate all point EXCEPT itself. Check if their color is same
				// with color assinged to cur point
				return false;
			}
		}
		return true;
	}

	public static void print(int[] arr) {
		for (int i : arr)
			System.out.print(i + " ");
		System.out.println();
	}

	public static void printColor(int[] color) {
		for (int i : color) {
			switch (i) {
			case 1:
				System.out.print("r ");
				break;
			case 2:
				System.out.print("g ");
				break;
			case 3:
				System.out.print("b ");
				break;
			case 4:
				System.out.print("y ");
				break;
			}
		}
		System.out.println();
	}
}

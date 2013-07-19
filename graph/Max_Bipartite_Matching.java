/*Max_Bipartite_Matching
geeksforgeeks

M applicants are applying for N jobs. Each applicant is interested in at least
one job. Assume all of them got the offer. For each job there is only one
available position.

What's the maximum matching number is?
*/

import java.util.*;

public class Max_Bipartite_Matching {
	
	final static int UNASSINGED = -1;

	public static void main(String[] args) {
		// Tese case 1
		int[][] graph = new int[][] { { 0, 1, 1, 0, 0, 0 },
				{ 1, 0, 0, 1, 0, 0 }, { 0, 0, 1, 0, 0, 0 },
				{ 0, 0, 1, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 1 } };
		System.out.println(maxBPM(graph));
	}

	// Input is a m x n int matrix. M: # of job applicants and N: # of jobs.
	// [i][j] is 1 if i’th applicant is interested in j’th job, otherwise 0.
	// Output is (int) number maximum number of people that can get jobs (if
	// they pass the interview).
	public static int maxBPM(int[][] graph) {
		int m = graph.length;
		int n = graph[0].length;
		// matchR[i] represents the applicant assigned to job i.
		// -1 means this job hasn't been assigned yet.
		int[] matchR = new int[n];
		Arrays.fill(matchR, UNASSINGED);
		int acc = 0, u;
		boolean[] visited;
		// Iterate through all applicants.
		for (u = 0; u < m; ++u) {
			visited = new boolean[n];
			acc = (bpm(graph, u, visited, matchR)) ? acc + 1 : acc;
		}
		return acc;
	}

	// DFS for bipartite perfect matching.
	// Return true if applicant u can be matched.
	public static boolean bpm(int[][] graph, int u, boolean[] visited, int[] matchR) {
		int n = graph[0].length, v;
		for (v = 0; v < n; ++v) {
			// If applicant u is interested in job v and v is
			// not visited.
			if (graph[u][v] > 0 && !visited[v]) {
				visited[v] = true; // Mark job v as visited.

				// If job 'v' is not assigned to an applicant OR
				// previously assigned applicant for job v (which is matchR[v]) 
				// has an alternate job available. 
				// Since v is marked as visited in the above line, matchR[v] 
				// in the following recursive call will not get job 'v' again
				if (matchR[v] == UNASSINGED || bpm(graph, matchR[v], visited, matchR)) {
					matchR[v] = u;
					return true;
				}
			}
		}
		return false;
	}
}

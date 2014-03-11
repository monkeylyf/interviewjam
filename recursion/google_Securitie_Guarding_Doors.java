/**google_Securitie_Guarding_Doors.
 *
 * 
 * No-brainer: Iterate through all element and if it is a '0', start dfs and
 * maintain a min value of distance when you meet a guard.
 * Time complexity: O(n^3)
 *
 *
 */

import java.util.ArrayList;
import java.util.Arrays;


public class google_Securitie_Guarding_Doors {
  
  public static void main(String[] args) {
	// Test cases.
	char[][] map = new char[][] {
		{'0', '0', '0'},
		{'B', 'G', 'G'},
		{'B', '0', '0'},
	  };
	solve(map);
  } 

  /* A solution with time complexity O(n^2)
   * Using bfs with all guards as starting points.
   * *Warning* Haven't tested yet.
   */
  public static void solve(char[][] map) {
	int N = map.length;
	int M = map[0].length;
	printMap(map);
	System.out.println(N + "x" + M);

	ArrayList<coordinates> all = getAllGuardsCoords(map);

	System.out.println("All guards found " + all);
	bfs(all, map, N, M);
  }

  public static ArrayList<coordinates> getAllGuardsCoords(char[][] map) {
	ArrayList<coordinates> ret = new ArrayList<coordinates>();
	for (int i = 0; i < map.length; ++i) {
	  for (int j = 0; j < map[i].length; ++j) {
		if (map[i][j] == 'G') {
		  ret.add(new coordinates(i, j));
		}	
	  }  
	}

	return ret;
  }

  public static void bfs(ArrayList<coordinates> all, char[][] map, int N, int M) {
	boolean[][] visited = new boolean[N][M];
	for (int i = 0; i < N; ++i) {
	  Arrays.fill(visited[i], Boolean.FALSE);
	}

	ArrayList<coordinates> next = new ArrayList<coordinates>();
	int dis = 1;

	while (!all.isEmpty()) {
	  for (coordinates cur : all) {
		if (visited[cur.i][cur.j]) {
		  continue;  
		}
		// Check up.
		if (cur.i > 0 && map[cur.i - 1][cur.j] == '0') {
		  next.add(new coordinates(cur.i - 1, cur.j)); 
		  map[cur.i - 1][cur.j] = Character.forDigit(dis, 10);
		}
		// Check down.
		if (cur.i < N - 1 && map[cur.i + 1][cur.j] == '0') {
		  next.add(new coordinates(cur.i + 1, cur.j));  
		  map[cur.i + 1][cur.j] = Character.forDigit(dis, 10);
		}
		// Check left.
		if (cur.j > 0 && map[cur.i][cur.j - 1] == '0') {
		  next.add(new coordinates(cur.i, cur.j - 1));
		  map[cur.i][cur.j - 1] = Character.forDigit(dis, 10);
		}
		// Check right.
		if (cur.j < M - 1 && map[cur.i][cur.j + 1] == '0') {
		  next.add(new coordinates(cur.i, cur.j - 1));
		  map[cur.i][cur.j - 1] = Character.forDigit(dis, 10);
		}
	  }
	  ++dis; // Finishing current level of bfs and distance increased.

	  all = next;
	  next = new ArrayList<coordinates>();
	}

	printMap(map);
  }

  static class coordinates {
	int i;
	int j;

	coordinates(int x, int y) {
	  this.i = x;
	  this.j = y;
	}

	public String toString() {
	  return "(" + this.i + "," + this.j + ")";
	}
  }

  public static void printMap(char[][] map) {
	for (int i = 0; i < map.length; ++i) {
	  for (int j = 0; j < map[i].length; ++j) {
		System.out.print(map[i][j] + " ");
	  }
	  System.out.println();
	}	
  }
}

/** leetcode_Permutations_II.
 *
 * Given a collection of numbers that might contain duplicates, return all
 * possible unique permutations.
 * For example,
 * [1,1,2] have the following unique permutations:
 * [1,1,2], [1,2,1], and [2,1,1].
 */

import java.util.Arrays;
import java.util.ArrayList;


public class leetcode_Permutations_II {
  
  public static void main(String[] args) {
	leetcode_Permutations_II instance = new leetcode_Permutations_II();
	instance.solve();
  }

  public void solve() {
    // Test case 1.
    for (ArrayList<Integer> i : perm(new int[] {0, 1})) {
      System.out.println(i);
    }
    // Test case 2.
    for (ArrayList<Integer> i : perm(new int[] {0, -1, 1})) {
      System.out.println(i);
    }
  }

  public static ArrayList<ArrayList<Integer>> perm(int[] num) {
	if (num == null || num.length == 0) {
	  return null;
	}

	// Sort the array first so the dups can be skpped later in dfs.
	Arrays.sort(num);

	ArrayList<ArrayList<Integer>> container = new ArrayList<ArrayList<Integer>>();
	boolean[] visited = new boolean[num.length];
	int[] tokens = new int[num.length];

	dfs(0, num, visited, tokens, container);
	return container;
  }

  public static void dfs(int idx, int[] num, boolean[] visited, int[] tokens, ArrayList<ArrayList<Integer>> container) {
	if (idx == num.length) {
	  ArrayList<Integer> doh = new ArrayList<Integer>();
	  for (int i = 0; i < tokens.length; ++i) {
		doh.add(tokens[i]);
	  }
	  container.add(doh);
	} else {
	  int i = 0;
	  while (i < num.length) {
		if (visited[i]) {
		  i += 1;
		} else {
		  tokens[idx] = num[i];
		  visited[i] = true;
		  dfs(idx + 1, num, visited, tokens, container);
		  visited[i] = false;
		  i += 1;
		  // It is normal dfs until here.
		  // After jump out of the dfs recursion above, if next val in num is same as current one,
		  // there is no need to consider any of the elements with the same value in current idx.
		  while (i < num.length && num[i - 1] == num[i]) {
			i += 1;
		  }
		}
	  }
	}
  }
}


/* Python Version

def permuteUnique(self, num):
    def dfs(idx, num, tokens, visited, container):
        if idx == len(num):
            container.append(tokens[::])
        else:
            i = 0
            while i < len(num):
                if visited[i]:
                    i += 1
                else:
                    tokens[idx] = num[i]
                    visited[i] = True
                    dfs(idx + 1, num, tokens, visited, container)
                    visited[i] = False
                    i += 1
                    while i < len(num) and num[i] == num[i - 1]:
                        i += 1
    
    
    if not num or len(num) == 0:
        return []
        
    num = sorted(num)
    container = []
    tokens = [ 0 ] * len(num)
    visited = [ False ] * len(num)
    
    dfs(0, num, tokens, visited, container)
    
    return container
*/

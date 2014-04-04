/*Permutations

Given a collection of numbers, return all possible permutations.
For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
*/

import java.util.ArrayList;


public class leetcode_Permutations {

  public static void main(String[] args) {
	// Test case 1.
	for (ArrayList<Integer> i : permute(new int[] {0, 1})) {
	  System.out.println(i);
	}
	// Test case 2.
	for (ArrayList<Integer> i : permute(new int[] {0, -1, 1})) {
	  System.out.println(i);
	}
  }

  public static ArrayList<ArrayList<Integer>> permute(int[] num) {
	ArrayList<ArrayList<Integer>> all = new ArrayList<ArrayList<Integer>>();
	ArrayList<Integer> tmp = new ArrayList<Integer>();
	boolean[] used = new boolean[num.length]; // boolean[] to track used int.
	nextNum(num, used, tmp, all);
	return all;
  }

  public static void nextNum(int[] num, boolean[] used, ArrayList<Integer> tmp, ArrayList<ArrayList<Integer>> all) {
	if (tmp.size() == num.length) {
	  ArrayList<Integer> res = new ArrayList<Integer>();
	  for (int i : tmp) {
		res.add(num[i]);
	  }
	  all.add(res);
	} else {
	  for (int i = 0; i < num.length; ++i) {
		if (!used[i]) {
		  tmp.add(i);
		  used[i] = true;
		  nextNum(num, used, tmp, all);
		  // Backtracking reset.
		  tmp.remove(tmp.size() - 1);
		  used[i] = false;
		}
	  }
	}
  }
}

/* Python Version
def permute(self, num):
    def dfs(num, container, acc, visited):
        if len(acc) == len(num):
            container.append(acc[::])
        else:
            for i, val in enumerate(num):
                if not visited[i]:
                    visited[i] = True
                    acc.append(val)
                    dfs(num, container, acc, visited)
                    visited[i] = False
                    acc.pop()
        
    visited = [ False ] * len(num)
    container = []
    dfs(num, container, [], visited)
    return container
*/

/** facebook_Group_Users_With_Same_Email_Address.
 *  facebook
 *
 *  Given a lot of accounts registered under facebook, each user can have multiple 
 *  email addresses registered under the same account.
 *  Example, John has john@gmail.com and john@yahoo.com registered under user john.
 *  Somehow people tend to have multiple accounts with different username but same 
 *  email addresses. 
 *  Find a way to group those accounts.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class facebook_Group_Users_With_Same_Email_Address {

  public static void main(String[] args) {
	// TODO Auto-generated method stub
	facebook_Group_Users_With_Same_Email_Address instance = new facebook_Group_Users_With_Same_Email_Address();
	instance.solve();
  }

  public void solve() {
	User a = new User("a", new String[] { "a@a.com" });
	User b = new User("b", new String[] { "a@a.com", "b@b.com" });
	User c = new User("c", new String[] { "b@b.com" });
	ArrayList<User> input = new ArrayList<User>();
	input.add(a);
	input.add(b);
	input.add(c);
	for (ArrayList<User> line : groupUserWithSameEmail(input)) {
	  System.out.println(line);
	}

	input = new ArrayList<User>();
	input.add(new User("Johnathon", new String[] { "john@gmail.com" }));
	input.add(new User("Mary", new String[] { "mary@gmail.com" }));
	input.add(new User("John", new String[] { "john@yahoo.com" }));
	input.add(new User("Johnny", new String[] { "john@gmail.com", "john@yahoo.com", "john@hotmail.com" }));
	input.add(new User("Bob", new String[] { "bob@gmail.com" }));
	for (ArrayList<User> line : groupUserWithSameEmail(input)) {
	  System.out.println(line);
	}
  }

  public ArrayList<ArrayList<User>> groupUserWithSameEmail(ArrayList<User> input) {
	ArrayList<ArrayList<User>> groupedUser = new ArrayList<ArrayList<User>>();
	System.out.println(input);
	// Create node with one name and one email address.
	ArrayList<User> nodes = new ArrayList<User>();

	int index = 0;

	// Map index of nodes to original input.
	HashMap<Integer, Integer> nodeIdxToOriginal = new HashMap<Integer, Integer>();
	for (int i = 0; i < input.size(); ++i) {
	  User user = input.get(i);
	  for (String email : user.emails) {
		nodes.add(new User(user.name, new String[] { email }));
		nodeIdxToOriginal.put(index++, i);
	  }
	}

	int n = nodes.size();
	boolean[][] adjacencyMatrix = new boolean[n][n];
	HashMap<String, Integer> emailToNodeIdx = new HashMap<String, Integer>();

	int i = 0;

	// Create adjacency matrix to represent the graph.
	for (User user : input) {
	  int startIdx = i;
	  int endIdx = i + user.emails.length - 1;

	  // Connecting nodes with the email address seen before.
	  for (String email : user.emails) {
		if (emailToNodeIdx.containsKey(email)) {
		  int idx = emailToNodeIdx.get(email);
		  adjacencyMatrix[idx][i] = true;
		  adjacencyMatrix[i][idx] = true;
		} else {
		  emailToNodeIdx.put(email, i);
		}
		++i;
	  }

	  // Connecting all email registered under same user name.
	  for (int j = startIdx + 1; j <= endIdx; ++j) {
		// System.out.println("Connecting " + startIdx + " " + j);
		adjacencyMatrix[startIdx][j] = true;
		adjacencyMatrix[j][startIdx] = true;
	  }
	  i = endIdx + 1;
	}

	// printMatrix(adjacencyMatrix);

	// Mapping groupId to user in original input.
	HashSet<Integer> used = new HashSet<Integer>();

	for (ArrayList<Integer> arr :  dfs(adjacencyMatrix, n, nodes)) {
	  ArrayList<User> group = new ArrayList<User>();
	  for (int idx : arr) {
		int originalId = nodeIdxToOriginal.get(idx);
		if (!used.contains(originalId)) {
		  // If a user has not been added to the group, add it.
		  group.add(input.get(originalId));
		  used.add(originalId);
		}
	  }
	  groupedUser.add(group);
	}

	return groupedUser;
  }

  /* DFS logic.*/
  public ArrayList<ArrayList<Integer>> dfs(boolean[][] adjacencyMatrix, int n,
	  ArrayList<User> nodes) {
	ArrayList<ArrayList<Integer>> groupedUserID = new ArrayList<ArrayList<Integer>>();

	boolean[] visited = new boolean[n];


	for (int i = 0; i < n; ++i) {
	  if (!visited[i]) {
		ArrayList<Integer> acc = new ArrayList<Integer>();
		dfsUtil(i, adjacencyMatrix, visited, nodes, acc);
		groupedUserID.add(acc);
	  }
	}

	return groupedUserID;
  }

  private void dfsUtil(int i, boolean[][] adjacencyMatrix, boolean[] visited,
	  ArrayList<User> nodes, ArrayList<Integer> acc) {
	visited[i] = true;
	acc.add(i);
	for (int next = 0; next < visited.length; ++next) {
	  if (next != i && !visited[next] && adjacencyMatrix[i][next]) {
		dfsUtil(next, adjacencyMatrix, visited, nodes, acc);
	  }
	}
  }

  class User {

	String name;
	String[] emails;

	User(String name, String[] emails) {
	  this.name = name;
	  this.emails = emails;
	}

	public String toString() {
	  StringBuilder sb = new StringBuilder(this.name);
	  sb.append(":");
	  for (String email : this.emails) {
		sb.append(" ");
		sb.append(email);
	  }

	  return sb.toString();
	}
  }

  public void printArray(boolean[] arr) {
	for (boolean bool : arr) {
	  System.out.print((bool) ? "T " : "F ");
	}
	System.out.println();
  }

  public void printMatrix(boolean[][] matrix) {
	for (boolean[] arr : matrix) {
	  printArray(arr);
	}
	System.out.println();
  }
}

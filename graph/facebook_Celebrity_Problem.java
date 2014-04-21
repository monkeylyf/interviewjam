/** facebook_Celebrity_Problem.
 *  facebook
 *
 *  http://www.geeksforgeeks.org/the-celebrity-problem/
 */

import java.util.Stack;


public class facebook_Celebrity_Problem {

  public static void main(String[] args) {
	facebook_Celebrity_Problem instance = new facebook_Celebrity_Problem();
	instance.solve();
  }

  public void solve() {
	int[][] acquiantance = new int[][] { {0, 0, 1, 0},
	  {0, 0, 1, 0},
	  {0, 0, 0, 0},
	  {0, 0, 1, 0}
	};
	System.out.println(howIsCelebrity(acquiantance, acquiantance.length));

  }

  public int howIsCelebrity(int[][] acquiantance, int n) {
	Stack<Integer> s = new Stack<Integer>();

	int id = 0;

	while (id < n) {
	  s.push(id);
	  ++id;
	}

	int a = s.pop();
	int b = s.pop();

	while (s.size() != 1) {
	  if (haveAcquiantance(acquiantance, a, b)) {
		// a knows b and a is not the celebrity. Update a.
		a = s.pop();
	  } else {
		// a does not know b so b cannot be the celebrity. Update b
		b = s.pop();
	  }
	}

	// With one element in stack, check if that is the celebrity.
	int candidate = s.pop();

	if (haveAcquiantance(acquiantance, candidate, a)) {
	  candidate = a;
	}

	if (haveAcquiantance(acquiantance, candidate, b)) {
	  candidate = b;
	}


	for (int i = 0; i < n; ++i) {
	  if (i == candidate) {
		continue;
	  }
	  if (haveAcquiantance(acquiantance, candidate, i) || !haveAcquiantance(acquiantance, i, candidate)) {
		return -1;
	  }
	}

	return candidate;
  }

  public boolean haveAcquiantance(int[][] acquiantance, int a, int b) {
	return acquiantance[a][b] == 1;
  }
}

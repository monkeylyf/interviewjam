/** facebook_Two_String_With_One_Deletion_Insertion_Replacement.
 *  facebook.
 *
 * Given Two String, write a fucntion that return true if one of the string
 * can be converted to another by one deletion/insertion/replacement operation.
 * Return false otherwise.
 */

public class facebook_Two_String_With_One_Deletion_Insertion_Replacement {

  public static void main(String[] args) {
	facebook_Two_String_With_One_Deletion_Insertion_Replacement instance = new facebook_Two_String_With_One_Deletion_Insertion_Replacement();
	instance.solve();
  }

  public void solve() {
	// Pos test cases
	p(oneCharDiff("cat", "cot"));
	p(oneCharDiff("cat", "cast"));
	p(oneCharDiff("cat", "at"));
	p(oneCharDiff("", "c"));
	p(oneCharDiff("c", ""));
	p(oneCharDiff("hit", "shit"));
	p(oneCharDiff("what", "wha"));
	p(oneCharDiff("what", "wha"));
	// Neg
	p(oneCharDiff("", ""));
	p(oneCharDiff("", "cc"));
	p(oneCharDiff("cat", "dog"));
	p(oneCharDiff("cat", "cat"));
  }

  public boolean oneCharDiff(String s1, String s2) {
	if (s1 == null || s2 == null) {
	  return false;
	} else if (Math.abs(s1.length() - s2.length()) == 1) {
	  // Insertion or deletion.
	  boolean insertion = false;
	  int i = 0;
	  int j = 0;

	  while (i < s1.length() && j < s2.length()) {
		if (s1.charAt(i) == s2.charAt(j)) {
		  ++i;
		  ++j;
		} else {
		  if (insertion) {
			return false; 
		  } else {
			if (s1.length() > s2.length()) {
			  ++j;
			} else {
			  ++i;
			}
		  }
		}
	  }

	  return true;
	} else if (s1.length() == s2.length()) {
	  int i = 0;

	  boolean seenDiff = false;
	  while (i < s1.length()) {
		if (s1.charAt(i) == s2.charAt(i)) {
		  ++i;
		} else {
		  if (seenDiff) {
			return false;
		  } else {
			seenDiff = true;
			++i;
		  }
		}
	  }
	  return seenDiff;
	} else {
	  return false;
	}
  }

  public void p(Object o) {
	System.out.println(o);
  }
}


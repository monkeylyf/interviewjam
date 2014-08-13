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

  private void solve() {
	// Pos test cases
	p("Pos test cases:");
	p(oneCharDiff("cat", "cot"));
	p(oneCharDiff("cat", "cast"));
	p(oneCharDiff("cat", "at"));
	p(oneCharDiff("", "c"));
	p(oneCharDiff("c", ""));
	p(oneCharDiff("hit", "shit"));
	p(oneCharDiff("what", "wha"));
	p(oneCharDiff("what", "wha"));
	// Neg
	p("Neg test cases:");
	p(oneCharDiff("", ""));
	p(oneCharDiff("", "cc"));
	p(oneCharDiff("cat", "dog"));
	p(oneCharDiff("cat", "cat"));
	p(oneCharDiff("aa", "bb"));
  }

  /**
   * return true if neither of the strings is null.
   */
  private boolean checkNull(String s1, String s2) {
    return s1 != null && s2 != null;
  }

  /**
   * return true if two strings lengths diff by one and there is one and only one diff.
   */
  private boolean checkIfLengthDiffByOne(String s1, String s2) {
    if (Math.abs(s1.length() - s2.length()) != 1) {
      return false;
    }
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
	  	    ++i;
	  	  } else {
	  	    ++j;
	  	  }
	    }
	  }
	}

	return true;
  }

  /**
   * return true if two strings have same lengths and there is one and only one replacement.
   */
  private boolean checkIfSameLength(String s1, String s2) {
    if (s1.length() != s2.length()) {
      return false;
    }

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
  }

  /**
   * return true if two strings are convertible by one deletion/insertion/replacement.
   *
   * return yes if neither of strings is null and if length diff by one there is only
   * insertion/deletion, or, if lengths are same then there is only one replacement.
   */
  private boolean oneCharDiff(String s1, String s2) {
    return checkNull(s1, s2) &&
           checkIfLengthDiffByOne(s1, s2) ||
           checkIfSameLength(s1, s2);
  }

  public void p(Object o) { System.out.println(o); }
}

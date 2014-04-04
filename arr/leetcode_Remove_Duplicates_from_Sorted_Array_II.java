/*Remove_Duplicates_from_Sorted_Array_II

Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?
For example,
Given sorted array A = [1,1,1,2,2,3],
Your function should return length = 5, and A is now [1,1,2,2,3].
*/

import java.util.HashSet;


class leetcode_Remove_Duplicates_from_Sorted_Array_II {

  public static void main(String[] args) {
	removeDuplicates(new int[] {1, 2, 2, 2, 3, 3});
  }

  public int removeDuplicates(int[] A) {
	if (A == null || A.length == 0) {
	  return 0;
	}

	boolean seenDup = false;
	int processed = 1;

	for (int i = 1; i < A.length; ++i) {
	  // Copy the value back when
	  // 1. val changed 2. val not changed but the first dup seen.
	  if (A[i] != A[i - 1] || !seenDup) {
		// Update seenDup flag before you copy the current value to what processed points to.
		seenDup = A[i] == A[i - 1];
		A[processed++] = A[i];
	  }
	  // If val not changed and seen dup before then simply let i incre
	}

	return processed;
  }

  /* The solution below is obsolete. Using HashSet is overkill even change the requirement to three times or more*/
  public static int removeDuplicates(int[] A) {
	if (A.length == 0) {
	  return 0;
	}
	int len = A.length;
	int processed = 1;
	for (int cur = 1; cur < len; ++cur) {
	  // In this question, duplicates are allowed at most twice so HashSet works.
	  // If they are allowed more than three times, use Hashtable instead to set
	  // the key value pair.
	  HashSet<Integer> counter = new HashSet<Integer>();
	  int j = 0; 
	  for (;j < processed; ++j) {
		if (A[cur] == A[j]) {
		  if (!counter.contains(A[cur])) {
			counter.push(A[cur]);
		  } else {
			break;
		  }
		}
	  }   
	  if (j == processed) {
		A[processed] = A[cur];
		++processed; 
	  }   
	}   
	return processed;
  }
}

/* Python Version
def removeDuplicates(self, A):
    if not A:
        return 0
        
    processed = 1
    dup = False
    
    for i in xrange(1, len(A)):
        if A[i] != A[i - 1] or not dup:
            dup = A[i] == A[i - 1]
            A[processed] = A[i]
            processed += 1
        
    return processed
*/

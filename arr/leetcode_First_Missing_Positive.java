/* First_Missing_Positive
 *
 * Given an unsorted integer array, find the first missing positive integer.
 * For example,
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.
 * Your algorithm should run in O(n) time and uses constant space.
  */

class leetcode_First_Missing_Positive {

  public static void main(String[] args) {
    firstMissingPositive(new int[] {1});
  }

  public static int firstMissingPositive(int[] A) {
    for (int i = 0; i < A.length; ++i) {
      int belonging_idx = A[i] - 1;
      while (0 <= belonging_idx &&
             belonging_idx < A.length &&
             A[i] != A[belonging_idx]) {
        int tmp = A[i];
        A[i] = A[belonging_idx];
        A[belonging_idx] = tmp;
        belonging_idx = A[i] - 1;
      }
    }

    int idx = 0;
    while (idx < A.length && idx == A[idx] - 1) {
      ++idx;
    }
    return idx + 1;
  }
}


/* Python Version
def firstMissingPositive(self, A):
    s = set([ i for i in xrange(1, len(A) + 1)])
    for val in A:
        if val in s:
            s.remove(val)

    return min(list(s)) if s else len(A) + 1
*/

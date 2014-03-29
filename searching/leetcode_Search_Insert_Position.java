/*Search_Insert_Position

Given a sorted array and a target value, return the index if the target is
found. If not, return the index where it would be if it were inserted in
order.
You may assume no duplicates in the array.
Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0
*/


public class leetcode_Search_Insert_Position {

  public static void main(String[] args) {

  }

  public static int searchInsert(int[] A, int target) {
	if (target <= A[0]) {
	  return 0;
	}
	for (int i = 1; i < A.length; ++i) {
	  if (A[i] >= target && A[i - 1] < target) {
		// A[i] == target (target found)
		// A[i - 1] < target && target < A[i] (index where it would be inserted).
		// And combine two of conditions above.
		return i;
	  }
	}
	return A.length;
  }

  public static int searchInsertBS(int[] A, int target) {
	if (A.length == 0) {
		return 0;
	}

	int start = 0;
	int end = A.length - 1;
	int mid = 0;
	while (start <= end) {
	  mid = start + (end-start) / 2;
	  if(A[mid] == target) {
		return mid;
	  } else if (A[mid] < target) {
		start = mid + 1;
	  } else {
		end = mid - 1;
	  }
	}
	return end + 1;
  }
}

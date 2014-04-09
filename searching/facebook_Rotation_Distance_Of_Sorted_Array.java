/** facebook_Rotation_Distance_Of_Sorted_Array.
 *
 */


public class facebook_Rotation_Distance_Of_Sorted_Array {

	public static void main(String[] args) {
		facebook_Rotation_Distance_Of_Sorted_Array instance = new facebook_Rotation_Distance_Of_Sorted_Array();
		instance.solve();
	}
	
	public void solve() {
		// Test case.
		System.out.println(rotateDistance(new int[] {2,3,4,5,6,1}) == 5);
		System.out.println(rotateDistance(new int[] {3,4,5,6,1,2}) == 4);
		System.out.println(rotateDistance(new int[] {4,5,6,1,2,3}) == 3);
		System.out.println(rotateDistance(new int[] {5,6,1,2,3,4}) == 2);
		System.out.println(rotateDistance(new int[] {6,1,2,3,4,5}) == 1);
		System.out.println(rotateDistance(new int[] {1,2,3,4,5,6}) == 0);
		
		// Test case.
		System.out.println(rotateDistanceWithDups(new int[] {2,3,4,5,6,1}) == 5);
		System.out.println(rotateDistanceWithDups(new int[] {3,4,5,6,1,2}) == 4);
		System.out.println(rotateDistanceWithDups(new int[] {4,5,6,1,2,3}) == 3);
		System.out.println(rotateDistanceWithDups(new int[] {5,6,1,2,3,4}) == 2);
		System.out.println(rotateDistanceWithDups(new int[] {6,1,2,3,4,5}) == 1);
		System.out.println(rotateDistanceWithDups(new int[] {1,2,3,4,5,6}) == 0);

		System.out.println(rotateDistanceWithDups(new int[] {1,1,1,3,1}) == 4);
		System.out.println(rotateDistanceWithDups(new int[] {1,1,3,1,1}) == 3);
		System.out.println(rotateDistanceWithDups(new int[] {1,3,1,1,1}) == 2);
		System.out.println(rotateDistanceWithDups(new int[] {3,1,1,1,1}) == 1);
		System.out.println(rotateDistanceWithDups(new int[] {1,1,1,3}) == 0);
	}

	/* The idea is very similar to leetcode_Search_in_Rotated_Sorted_Array_II.java
	 * Find the offset position that A[i] > A[i - 1] or A[i - 1] > A[i]. Watch
	 * out for indexOfBoundary error.
	 */
	public int rotateDistanceWithDups(int[] arr) {
		return (arr == null || arr.length == 0) ? -1 : bs(arr, 0, arr.length - 1);
	}
	
	public int bs(int[] arr, int head, int tail) {
		while (head <= tail) {
			int mid = head + (tail - head) / 2;
			//System.out.println(head + " " + mid + " " + tail);
			if (mid > 0 && arr[mid - 1] > arr[mid]) {
				return mid;
			} else if (mid + 1 < arr.length && arr[mid] > arr[mid + 1]) {
				return mid + 1;
			}else if (arr[head] == arr[mid]) {
				int left = bs(arr, head, mid - 1);
				if (left != 0) {
					return left;
				}
				int right = bs(arr, mid + 1, tail);
				if (right != 0) {
					return right;
				}
				
				return 0;
			} else if (arr[head] < arr[mid]) {
				head = mid + 1;
			} else {
				tail = mid - 1;
			}
		}
		return 0;
	}
	
	/* The idea is very similar to leetcode_Search_in_Rotated_Sorted_Array.java
	 * Find the offset position that A[i] > A[i - 1] or A[i - 1] > A[i]. Watch
	 * out for indexOfBoundary error.
	 */
	public int rotateDistance(int[] arr) {
		if (arr == null || arr.length == 0) {
			return -1;
		}
		
		int head = 0;
		int tail = arr.length - 1;
		
		while (head <= tail) {
			int mid = head + (tail - head) / 2;
			//System.out.println(head + " " + mid + " " + tail);
			if (mid > 0 && arr[mid - 1] > arr[mid]) {
				return mid;
			} else if (mid + 1 < arr.length && arr[mid] > arr[mid + 1]) {
				return mid + 1;
			} else if (arr[head] < arr[mid]) {
				head = mid + 1;
			} else {
				tail = mid - 1;
			}
		}
		return 0;
	}
}

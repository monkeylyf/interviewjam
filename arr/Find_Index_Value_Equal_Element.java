/*Find_Index_Value_Equal_Element
ZocDoc

Given a int array, all elemtns are distinct, non-continuing and increasing.	
Find all elements whose index is equal to its value
*/


class Find_Index_Value_Equal_Element {
	public static void main(String[] args) {
		solve(new int[] {-3, -1, 1, 3, 5, 7});	
	}

	public static void solve(int[] arr) {
		System.out.println(binarySearch(0, arr.length - 1, arr));
	}

	public static int binarySearch(int head, int tail, int[] arr) {
		if (head > tail) {
			return -1; // Find nothing.	
		}
		int mid = (tail - head) / 2 + head;
		if (arr[mid] == mid) {
			return mid;	
		} else if (arr[mid] < mid) {
			return binarySearch(mid + 1, tail, arr);	
		} else {
			return binarySearch(head, mid - 1, arr);	
		}
	}
}

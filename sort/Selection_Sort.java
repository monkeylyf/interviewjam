/*Selection_Sort

http://en.wikipedia.org/wiki/Selection_sort
*/


public class Selection_Sort{
	
	public static void main(String[] args) {
		// Test case 1.
		int[] arr = new int[] {5,4,3,2,1};
		print(arr);
		selectSort(arr);
		print(arr);
		// Test case 2.
		arr = new int[] {64, 25, 12, 22, 11};
		print(arr);
		selectSort(arr);
		print(arr);
	}

	public static void selectSort(int[] arr) {
		int i, j, minIndex;
		for (i = 0; i < arr.length - 1; ++i) {
			minIndex = i;
			for (j = i + 1; j < arr.length; ++j) {
				minIndex = (arr[j] < arr[minIndex]) ? j : minIndex;	
			}
			System.out.println(String.format("%d: %d", i, minIndex));
			if (minIndex != i) {
				swap(arr, i, minIndex);
			}
		}	
	}

	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	public static void print(int[] arr) {
		for(int i : arr) System.out.print(i + " ");
		System.out.println();
	}
}

/*Find_Largest_k_numbers_in_n_Numbers
careercup

Describe an algorithm to find the largest 1 million numbers in 1 billion
numbers. Assume that the computer memory can hold all one billion numbers
*/

public class cap_Find_Largest_k_numbers_in_n_Numbers {

	public static void main(String[] args) {
		int[] test = {16, 4, 10, 14, 7, 9, 3, 2, 8, 1, 0, 0};
		maxHeapify(test, 10, 1);
		for (int i : test) System.out.print(i + " ");
		System.out.println("");

		int[] test1 = {2, 4, 5, 3, 8, 9, 7, 11, 1, 0, 0};
		minHeapify(test1, 9, 1);
		for (int i : test1) System.out.print(i + " ");
		System.out.println("");

		int[] test2 = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
		buildMaxHeap(test2, 10);
		for (int i : test2) System.out.print(i + " ");
		System.out.println("");

		System.out.println("-------------------");
		int[] test3 = new int[11];
		for (int i = 1; i < 10; ++i) insertMax(test3, i - 1, i);
		for (int i : test3) System.out.print(i + " ");
		System.out.println("");

		for (int i = 1; i < 10; ++i) {
			System.out.println(removeMax(test3, 10 - i));
			for (int j : test3) System.out.print(j + " ");
			System.out.println("");
		}
	}

	public static void maxHeapify(int[] arr, int heapsize, int i) {
		int l = 2 * i + 1;
		int r = 2 * i + 2;
		int largest = 0;
		if (l + 1 <= heapsize && arr[l] > arr[i]) {
            largest = l;
        } else {
            largest = i;
        }
		if (r + 1 <= heapsize && arr[r] > arr[largest]) {
            largest = r;
        }
		if (largest != i) {
			int tmp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = tmp;
			maxHeapify(arr, heapsize, largest);
		}
	}

	public static void buildMaxHeap(int[] arr, int size) {
		for (int i = (size-1)/2; i>=0; --i) {
            maxHeapify(arr,size,i);
        }
	}

	public static void minHeapify(int[] arr, int heapsize, int i) {
		int l = 2 * i + 1;
		int r = 2 * i + 2;
		int min = 0;
		if (l + 1 <= heapsize && arr[l] < arr[i]) {
            min = l;
        } else min = i;
		if (r + 1 <= heapsize && arr[r] < arr[min]) {
            min = r;
        }
		if (min != i) {
			int tmp = arr[i];
			arr[i] = arr[min];
			arr[min] = tmp;
			minHeapify(arr, heapsize, min);
		}
	}

	public static void buildMinHeap(int[] arr, int size) {
		for (int i = (size - 1 ) / 2; i >= 0; --i) {
            minHeapify(arr,size,i);
        }
	}

	public static void insertMax(int[] arr, int size, int i) {
		arr[size] = i;
		while (true) {
			int parent = (size - 1) / 2;
			if (size == 0 || arr[parent] > arr[size]) {
                break;
            }
			int tmp = arr[size];
			arr[size] = arr[parent];
			arr[parent] = tmp;
			size = parent;
		}
	}

	public static int removeMax(int[] arr, int size) {
		int retval = arr[0];
		arr[0] = arr[size - 1];
		arr[size - 1] = 0;
		maxHeapify(arr, size - 1, 0);
		return retval;
	} 

	public static void insertMin(int[] arr, int size, int i) {
		arr[size] = i;
		while (true) {
			int parent = (size - 1) / 2;
			if (size == 0 || arr[parent] < arr[size]) {
                break;
            }
			int tmp = arr[size];
			arr[size] = arr[parent];
			arr[parent] = tmp;
			size = parent;
		}
	}

	public static void removeMin(int[] arr, int size) {
		int retval = arr[0];
		arr[0] = arr[size - 1];
		arr[size - 1] = 0;
		minHeapify(arr, size - 1, 0);
		return retval;
	}
}

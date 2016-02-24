/*Merge_k_Sorted_Arrays
geeksforgeeks
*/


import java.util.*;

public class Merge_k_Sorted_Arrays {

	/*
	 * Given k sorted arrays of size n each, merge them and print the sorted
	 * output.
	 * Example:
	 * Input: k = 3, n = 4 arr[][] = { {1, 3, 5, 7}, {2, 4, 6, 8}, {0, 9, 10, 11}} ;
	 * Output: 0 1 2 3 4 5 6 7 8 9 10 11
	 */

	public static void main(String[] args) {
		// test case for mergeSortedArrays.
		int[][] arr = new int[][] { {1, 3, 5, 7}, {2, 4, 6, 8}, {0, 9, 10, 11}};
		print(mergeSortedArrays(arr));
		// test case for minHeapMerge.
		print(minHeapMerge(arr));
		// test case for prioirityQueueMerge.
		print(prioirityQueueMerge(arr));
	}
	
	// Scan by layers.
	// Time complexity O(n * k * k)
	// Space complexity O(n * k)
	public static int[] mergeSortedArrays(int[][] arr) {
		int k = arr.length, n = arr[0].length, i, localMin;
		int[] pointers = new int[k], ret = new int[n * k];
		
		for (i = 0; i < n * k; ++i) {
			localMin = findMin(pointers, arr);
			ret[i] = arr[localMin][pointers[localMin]++];
		}
		return ret;
	}
	
	public static int findMin(int[] pointers, int[][] arr) {
		int k = arr.length, n = arr[0].length;
		int ret = -1, localMin = Integer.MAX_VALUE, i;
		for (i = 0; i < k; ++i) {
			if (pointers[i] < n && arr[i][pointers[i]] < localMin) {
				ret = i;
				localMin = arr[i][pointers[i]];
			}
		}
		return ret;
	}
	
	public static void print(int[] arr) {
		for (int i : arr) System.out.print(i + " ");
		System.out.println();
	}

	// MinHeap Solution.
	// Time complexity O(nk * logk)
	// Space complexity O(k)
	public static int[] minHeapMerge(int[][] arr) {
		int k = arr.length, n = arr[0].length, i;
		int[] ret = new int[k * n];
		Item[] itemArray = new Item[k];
		for (i = 0; i < k; ++i) {
			itemArray[i] = new Item(arr[i][0], i, 0);
		}
		MinHeap minHeap = new MinHeap(itemArray, k);
		Item root;
		for (i = 0; i < n * k; ++i) {
			root = minHeap.getMin();
			ret[i] = root.element;
			
			if (root.colId < n - 1) {
				root.element = arr[root.rowId][root.colId + 1];
				++root.colId;
			} else {
				root.element = Integer.MAX_VALUE;
			}
			minHeap.Heapify(0);
		}
		return ret;
	}
	
	// Nested MinHeap class.	
	static class MinHeap {
		public Item[] heap;
		public int size;
		
		MinHeap(Item[] arr, int size) {
			this.heap = arr;
			this.size = size;
			// Pre-heapify.
			for (int i = (this.size - 1) / 2; i >= 0; --i) {
				Heapify(i);
			}
		}
		
		public Item getMin() {
			return this.heap[0];
		}
		
		public void Heapify(int idx) {
			int left = 2 * idx + 1, right = 2 * idx + 2, smallest = idx;
			// Find the smallest among three indexes: left, right and idx.
			// Check left and idx. Put smaller in smallest
			if (left < this.size && this.heap[left].element < this.heap[idx].element) {
				smallest = left;
			}
			// Check smallest(either left or idx) and right. Get the smallest among three.
			if (right < this.size && this.heap[right].element < this.heap[smallest].element) {
				smallest = right;
			}
			// If idx is not the smallest.
			if (smallest != idx) {
				// Swap
				Item temp = this.heap[idx];
				this.heap[idx] = this.heap[smallest];
				this.heap[smallest] = temp;
				// Recursion.
				Heapify(smallest);
			}
		}
		
		public void print() {
			for (Item i : this.heap) System.out.print(i.element + " ");
			System.out.println();
		}
	}
	
	// Nested Item class.
	static class Item {
		public int element;
		public int rowId; // Identify row id when this item is found.
		public int colId; // Identify column id when this item is found.
		
		public Item(int element, int rowId, int colId) {
			this.element = element;
			this.rowId = rowId;
			this.colId = colId;
		}
		
		public String toString() {
			return String.format("<%d><%d><%d>", this.element, this.rowId, this.colId);
		}
	}
	
	// Or we can use Java built-in PriorityQueue.
	public static int[] prioirityQueueMerge(int[][] arr) {
		int k = arr.length, n = arr[0].length, i;
		int[] ret = new int[k * n];
		PriorityQueue<Item> minHeap = new PriorityQueue<Item>(100, new minComparator());
		for (i = 0; i < k; ++i) {
			minHeap.offer(new Item(arr[i][0], i, 0));
		}
		Item root;
		for (i = 0; i < n * k; ++i) {
			root = minHeap.poll();
			ret[i] = root.element;
			
			if (root.colId < n - 1) {
				minHeap.offer(new Item(arr[root.rowId][root.colId + 1], root.rowId, root.colId + 1));
			}
		}
		return ret;
	}
	
	static class minComparator implements Comparator<Item> {
		@Override
		public int compare(Item a, Item b) {
			if (a.element > b.element) return 1;
			else if (a.element < b.element) return -1;
			else return 0;
		}
	}
}

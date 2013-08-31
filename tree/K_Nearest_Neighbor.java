/*K_Nearest_Neighbor

Given [[3,6], [8,99], [-1,5], [4,-9] ... ], Find k nearest neighbor from
point[x, y]. Euclidean distance should be used to calculate distance.

*/


import java.util.*;


public class K_Nearest_Neighbor {
	
	/*
	1. max heap. O(nlogk). When k is small, time complexity is low.
	2. selection sort. O(n).
	3. k-d tree(2-d tree in this case) (2-d tree is non-trivial...)
	*/

    public static void main(String[] args) {
    	System.out.println(heap(new int[][] {{3, 6}, {8, 99}, {-1, 5}, {4, -9}, {0, 1}}, new int[] {0, 0}, 3));
    	System.out.println(selectionSort(new int[][] {{3, 6}, {8, 99}, {-1, 5}, {4, -9}, {0, 1}}, new int[] {0, 0}, 3));
    }

    // min heap
    public static ArrayList<Point> heap(int[][] pointSet, int[] origin, int k) {
    	ArrayList<Point> ret = new ArrayList<Point>();
    	PriorityQueue<Point> queue = new PriorityQueue<Point>();
    	// Pre-processing.
    	for (int i = 0; i < pointSet.length; ++i) {
    		queue.offer(new Point(pointSet[i][0], pointSet[i][1], origin[0], origin[1]));
    	}
    	for (int i = 0; i < k; ++i) {
    		if (!queue.isEmpty()) {
    			ret.add(queue.poll());
    		}
    	}
    	return ret;
    }

    // selection sort.
    public static ArrayList<Point> selectionSort(int[][] pointSet, int[] origin, int k) {
    	Point[] arr = new Point[pointSet.length];
    	// Pre-processing.
    	for (int i = 0;i < pointSet.length; ++i) {
    		arr[i] = new Point(pointSet[i][0], pointSet[i][1], origin[0], origin[1]);
    	}
    	selectionSort(arr, k, 0, arr.length - 1);
    	ArrayList<Point> ret = new ArrayList<Point>();
    	for (int i = 0; i < k; ++i) {
    		ret.add(arr[i]);
    	}
    	return ret;
    }

    public static void selectionSort(Point[] arr, int k, int left, int right) {
    	if (left == right) {
    		return;
    	}
    	int pivot = randomPartition(arr, left, right);
    	int leftLength = pivot = left + 1;
    	if (leftLength == k) {
    		return;
    	} else if (leftLength > k) {
    		selectionSort(arr, k, left, pivot - 1);
    	} else {
    		selectionSort(arr, k, pivot + 1, right);
    	}
    }

    public static int randomPartition(Point[] arr, int left, int right) {
    	int axis = new Random().nextInt(right - left + 1) + left;
    	double pivot = arr[axis].eucDistSquare();
    	swap(arr, axis, right);
    	for (int i = left; i < right; ++i) {
    		if (arr[i].eucDistSquare() <= pivot) {
    			swap(arr, left, i);
    			++left;
    		}
    	}
    	return left;
    }

	// Hepler function. Swap two elements in an int array.
    public static void swap(Point[] arr, int a, int b) {
    	Point tmp = arr[a];
    	arr[a] = arr[b];
    	arr[b] = tmp;
    }

    // k-d tree. In this case 2-d tree.
	// https://en.wikipedia.org/wiki/K-d_tree
    public static ArrayList<Point> tree(int[][] pointSet, int[] origin, int k) {
    	ArrayList<Point> ret = new ArrayList<Point>();
		// 
		// code...
		//
    	return ret;
    }
}


class Point implements Comparable<Point>{
	public int x;
	public int y;
	private int originX;
	private int originY;

	Point(int x, int y, int ox, int oy) {
		this.x = x;
		this.y = y;
		this.originX = ox;
		this.originY = oy;
	}

	public double eucDistSquare() {
		return Math.pow(this.x - this.originX, 2.0) + Math.pow((this.y - this.originY), 2.0);
	}

	public int compareTo(Point point) {
		double ret = this.eucDistSquare() - point.eucDistSquare();
		if (ret > 0) {
			return 1;
		} else if (ret < 0) {
			return -1;
		} else {
			return 0;
		}
	}

	@Override
	public String toString() {
		return "(" + this.x + ", " + this.y + ")";
	}
}

class minComparator implements Comparator<double> {
    @Override
    public int compare(double a, double b) {
        if (a < b) return 1;
        if (a > b) return -1;
        return 0;
    }
}

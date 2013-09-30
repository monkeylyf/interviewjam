/*Searching_String_in_Sorted_Arrays_Interspersed_With_Empty_Strings
careercup

Given a sorted array of strings which is interspersed with empty strings,
write a method to find the location of a given string.
EXAMPLE: find "ball" in {"at", "","","","ball", "","","car", "","","dad", "",""} return 4
EXAMPLE: find "ballcar" in {"at", "","","","ball", "","","car", "","","dad", "",""} return -1
*/

import java.util.Arrays;

public class cap_Searching_String_in_Sorted_Arrays_Interspersed_With_Empty_Strings {

	public static void main(String[] args) {
		String[] input = {"at", "",  "", "", "ball", "", "", "car", "", "", "dad", "", ""};
        System.out.println(searchStr(input, "at"));
        System.out.println(searchStr(input, "ball"));
        System.out.println(searchStr(input, "car"));
        System.out.println(searchStr(input, "dad"));
        System.out.println(searchStr(input, "shit"));
        System.out.println(searchStr(input, ""));
	}

    public static int searchStr(String[] A, String target) {
        return search(A, target, 0, A.length - 1);
    }

	// Binary Search based solution.
    public static int search(String[] A, String target, int start, int end) {
        if (start > end) {
            return -1;
        }
		int middle = (end - start) / 2 + start;
        String mid = A[middle];
        if (mid.equals(target)) {
            return middle;
        } else if (mid.equals("")) {
			// Check both right and left.
            int left = search(A, target, start, middle - 1);
            int right = search(A, target, middle + 1, end);
            if (left == -1 && right == -1) {
                return -1;
            } else if (left != -1) {
                return left;
            } else {
                return right;
            }
        } else {
			// Check lexicographic order to determine go left or go right.
            if (target.compareTo(mid) == -1) {
                return search(A, target, start, middle -1);
            } else {
                return search(A, target, middle + 1, end);
            }
        }
    }
}

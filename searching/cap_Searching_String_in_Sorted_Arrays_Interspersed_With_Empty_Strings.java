/*Searching_String_in_Sorted_Arrays_Interspersed_With_Empty_Strings
careercup

Given a sorted array of strings which is interspersed with empty strings,
write a method to find the location of a given string.
EXAMPLE: find "ball" in {"at", "","","","ball", "","","car", "","","dad", "",""} return 4
EXAMPLE: find "ballcar" in {"at", "","","","ball", "","","car", "","","dad", "",""} return -1
*/

import java.util.Arrays;

class cap_Searching_String_in_Sorted_Arrays_Interspersed_With_Empty_Strings {
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
    public static int search(String[] A, String target, int start, int end) {
        if (start > end) {
            return -1;
        }
        int middle = (start + end) / 2;
        String mid = A[middle];
        if (mid.equals(target)) {
            return middle;
        } else if (mid.equals("")) {
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
            String[] tmp = new String[] {target, mid};
            Arrays.sort(tmp);
            if (tmp[0].equals(target)) {
                return search(A, target, start, middle -1);
            } else {
                return search(A, target, middle + 1, end);
            }
        }
    }
}

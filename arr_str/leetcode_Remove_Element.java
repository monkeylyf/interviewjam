/*Remove_Element

Given an array and a value, remove all instances of that value in place and
return the new length.
The order of elements can be changed. It doesn't matter what you leave beyond
the new length.
*/


class leetcode_Remove_Element {
    public static void main(String[] args) {
    }
    public static int removeElement(int[] A, int elem) {
        int processed = 0;
        for (int i = 0; i < A.length; ++i) {
            if (A[i] != elem) {
                A[processed] = A[i];
                ++processed;
            }
        }
        return processed; 
    }
}

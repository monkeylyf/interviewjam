/*Remove Element

Given an array and a value, remove all instances of that value in place and
return the new length.
The order of elements can be changed. It doesn't matter what you leave beyond
the new length.
*/


class leetcode_81 {
    public static void main(String[] args) {
    }
    public static int removeElement(int[] A, int elem) {
        int processed = 0;
        int count = 0;
        for (int i = 0; i < A.length; ++i) {
            if (A[i] == elem) {
               ++count; 
            } else {
                A[processed] = A[i];
                ++processed;
            }
        }
        return A.length - count;
    }
}

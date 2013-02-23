/*Interleaving_Array
careercup

Suppose we have an array a1, a2, ..., an, b1, b2, ..., bn. Implement an
algorithm to change this array to a1, b1, a2, b2, ..., an, bn
*/

class cap_Interleaving_Array {
	public static void main(String[] args) {
        Interleave(new int[] {1,2,3,4,5,6,7,8,9,10});
	}
    public static void interleaving(int[] A) {
        int len = A.length; // According to the question, len is even.
        int[] retval = new int[len];
        int i = 0;
        int j = len / 2;
        for (int k = 0; k < len; ++k) {
            if (k % 2 == 0) {
                retval[k] = A[i];
                ++i;
            } else {
                retval[k] = A[j];
                ++j;
            }
        }
        for (int h : retval) System.out.print(h + " ");
        System.out.println();
    }
    protected static void Interleave(int[] arr) {  
        int left = 1;  
        int right = arr.length / 2;  
        int temp;  
        while (left < right) {  
            for (int i = right; i > left; i--) {  
                temp = arr[i];  
                arr[i] = arr[i - 1];  
                arr[i - 1] = temp;  
                for (int h : arr) System.out.print(h + " ");
                System.out.println();
            }  
            left += 2;  
            right += 1;  
        }  
        for (int h : arr) System.out.print(h + " ");
        System.out.println();
    }    
}

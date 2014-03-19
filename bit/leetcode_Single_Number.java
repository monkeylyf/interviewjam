/*leetcode_Single_Number

Given an array of integers, every element appears twice except for one. Find
that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it
without using extra memory?
*/


public class leetcode_Single_Number {
  
  public static void main(String[] args) {
	
  }

  public static int singleNumber(int[] A) {
	int ret = 0;
	for (int i : A) {
	  ret ^= i  
	}
	return i;
  }
}


/*Python Version
One-liner
def singleNum(A):
    reducer(lambda x, y : x ^ y, A)
*/

/*Find_Integer_Occurs_with_Odd_Freq

Example:
Intput: [1, 2, 3, 4, 3, 2, 1]
Output: 4
*/


public class Find_Integer_Occurs_with_Odd_Freq {

	public static void main(String[] args) {
		solve(new int[] {1, 2, 3, 4, 3, 2, 1});	
	}	
	
	public static void solve(int[] arr) {
		int ret = 0;
		for (int i : arr) {
			ret = ret ^ i;	
		}
		System.out.println(ret);
	}
}

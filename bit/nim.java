/*Nim

See the rule of Nim Game here:
https://en.wikipedia.org/wiki/Nim

If you are the first to play, how many choice do you have to remove cards?

OJ:
http://acm.hdu.edu.cn/showproblem.php?pid=1850

*/

import java.util.*;

class nim {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N, n, j;
		int[] arr;
		while (true) {
			N = sc.nextInt();
			if (N == 0) {
				break;	
			}
			arr = new int[N];
			for (n = 0; n < N; ++n) {
				arr[n] = sc.nextInt();	
			}
			solve(arr);
		}
    } 

    public static void solve(int[] arr) {
		int acc = 0, sum = 0;
		for (int cursor : arr) {
			acc = acc ^ cursor;
		}
		for (int cursor: arr) {
			if ((acc ^ cursor) < cursor) {
				sum = sum + 1;
			}
		}
		System.out.println(sum);
    }

	public static void print(int[] arr) {
		for (int i : arr) System.out.print(i + " ");	
		System.out.println();
	}
}

/*Explain_Bits_Operation
careercup

Explain what the following code does: ((n & (n-1)) == 0)


Anwser:
if the result of AND operation is zero, which means for each pair of bits at
the same position there is at least one 0.

If the last digit is 1, then n - 1's last digit is 0. But it only meets the
requirment when there are no more other 1's(Otherwise 11 & 10 != 0) since no
carry during the minus 1 operation.
0 is one of the answers.

If the last digit is 0, then n - 1's last digit is 1 and there is a carry.
Intuitively it gives you 10, 100, 1000 ... meets the requirment.
*/



public class cap_Explain_Bits_Operation {
	
	public static void main(String[] args) {
		for (int n = 0; n < 1000; ++n) {
			if ((n & (n - 1)) == 0) {
				System.out.println(n);	
			}
		}		
	}
}

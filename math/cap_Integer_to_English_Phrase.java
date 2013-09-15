/*Integer_to_English_Phrase
careercup

Given an integer between 0 and 999,999, print an English phrase that
describes the integer (eg, “One Thousand, Two Hundred and Thirty Four”)
*/

public class cap_Integer_to_English_Phrase {

	public static void main(String[] args) {
		printNum(999999); 
		printNum(12345); 
		printNum(6789); 
		printNum(999); 
		printNum(12); 
		printNum(9);
		printNum(123456789);
	}
	
	public static void printNum(int n) {
		int million = n / 1000000;
		if (printHundred(million)) {
            System.out.print("Million ");
        }
		int thousand = (n % 1000000) / 1000;
		if (printHundred(thousand)) {
            System.out.print("Thousand ");
        }
		printHundred(n % 1000);
		System.out.println();
	}

	public static boolean printHundred(int n) {
		String[] wordarr = {"", "One ", "Two ", "Three ", "Four ",
                     		    "Five ", "Six ", "Seven ", "Eight ",
                     		    "Nine "};
		String[] wordarr1 = {"Ten ", "Eleven ", "Twelve ", "Thirteen ",
                      		     "Fourteen ", "Fifteen ", "Sixteen ",
                      		     "Seventeen ", "Eighteen ", "Nineteen "};
		String[] wordarr10 = {"", "", "Twenty ", "Thirty ", "Forty ",
                      		      "Fifty ", "Sixty ", "Seventy ", "Eighty ",
                      		      "Ninety "};
		boolean print = false;
		int hundred = n / 100;
		if (hundred > 0) {
			System.out.print(wordarr[hundred] + "Hundred ");
			print = true;
			n -= hundred * 100;
			if (n > 0) {
                System.out.print("and ");
            }
		}
		if (n > 0) {
			int two = n / 10;
			int one = n % 10;
			if (two == 0) {
                System.out.print(wordarr[one]);
			} else if (two == 1) {
                System.out.print(wordarr1[one]);
            } else {
                System.out.print(wordarr10[two] + wordarr[one]);
            }
			print = true;
		}
		return print;
	}
}

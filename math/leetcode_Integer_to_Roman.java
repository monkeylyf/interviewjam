/*Integer_to_Roman

Given an integer, convert it to a roman numeral.
Input is guaranteed to be within the range from 1 to 3999.
*/

public class leetcode_Integer_to_Roman {

    public static void main(String[] args) {
		for (int i = 1; i <= 3999; ++i) {
			System.out.println(i + " " + intToRoman(i));
		}
    }

    public static String intToRoman(int num) {
		if (num > 3999 || num <= 0) {
			throw new InvalidValueFormatException("Invalid input value!");
		}
		return pa(num / 1000 % 10, '_', '_', 'M') + pa(num / 100 % 10, 'M', 'D', 'C') + 
				pa(num / 10 % 10, 'C', 'L', 'X') + pa(num % 10, 'X', 'V', 'I');
	}
	
	public static String pa(int num, char ten, char five, char one) {
		StringBuilder res = new StringBuilder();
		switch(num) {
			case 9:
				res.append(one);
				res.append(ten); break;
			case 4:
				res.append(one);
				res.append(five); break;
			default:
				if (num >= 5) {
					res.append(five);
					num -= 5;
				}
				while (num-- > 0) {
					res.append(one);
				}
				break;
		}
		return res.toString();
	}
}


/* Python Version
1-3999 is a small range. Enumerating all basic unit of roman char is easier
and faster solution during interview.

def intToRoman(self, num):
    symbol = ("M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I")
    value =  (1000,900,500,400, 100, 90,  50, 40,  10, 9,   5,  4,   1)
    i = 0
    roman = ''
    while num > 0:
        if num >= value[i]:
            roman += symbol[i]
            num -= value[i]
        else:
            i += 1
    return roman
*/

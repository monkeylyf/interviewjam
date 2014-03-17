/*Palindrome_Number

Determine whether an integer is a palindrome. Do this without extra space.
*/

public class leetcode_Palindrome_Number {

    public static void main(String[] args) {
        System.out.println(isPalindrome(12321));
        System.out.println(isPalindrome(12334));
        System.out.println(isPalindrome(12331));
        System.out.println(isPalindrome(-2147483648));
        System.out.println(isPalindrome(2147447412));
    }

    public static boolean isPalindrome(int x) {
        // Be aware of integer overflow.
        if (x < 0) {
            // Here is the confusing part. For leetcode OJ, for negative number
            // the func returns false (-2147447412), but my understanding is a
            // negative integer can be a palindrome number if its positive
            // counterpart is a palindrome. 2147447412 is a palindrome.
            return false;
        }
        int left_dividor = 1;
        int right_dividor = 1;
        // Find the possible largest left_dividor.
        while (x / left_dividor >= 10 && left_dividor < Integer.MAX_VALUE / 10) {
            // x / left_divdor >= 10 -->
            // left_dividor < Integer.MAX_VALUE / 10 prevent integer overflow.
            left_dividor *= 10;
        }
        while (left_dividor > right_dividor) {
            if (x / left_dividor % 10 != x / right_dividor % 10) {
                return false;
            }
            left_dividor /= 10;
            right_dividor *= 10;
        }
        return true;
    }
}

/*Python Version
Cheating:
def isPalindrome(self, x):
    x = str(x)
    head = 0
    tail = len(x) - 1
    while head < tail:
        if x[head] != x[tail]:
            return False
        head += 1
        tail -= 1
    return True

Not cheating:

def isPalindrome(self, x):
    if x < 0:
        return False
        
    left = 1
    right = 1
    
    while x / left >= 10:
        left *= 10
    
    while left > right:
        if x / left % 10 != x / right % 10:
            return False
        left /= 10
        right *= 10
    
    return True
*/

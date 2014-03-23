/*Valid_Palindrome

Given a string, determine if it is a palindrome, considering only alphanumeric
characters and ignoring cases.
For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.
Note:
Have you consider that the string might be empty? This is a good question to
ask during an interview.
For the purpose of this problem, we define empty string as valid palindrome.
*/



class leetcode_Valid_Palindrome {
    public static void main(String[] args) {
        //isPalindrome("A man, a plan, a canal: Panama");
        isPalindrome("aA");
    }
    public static boolean isPalindrome(String s) {
        int head = 0;
        int tail = s.length() - 1;
        while (head < tail) {
            char h = Character.toLowerCase(s.charAt(head));
            char t = Character.toLowerCase(s.charAt(tail));
            if (isNumAlphaBeta(h) && isNumAlphaBeta(t)) {
                if (h != t) {
                    return false;
                } else {
                    ++head;
                    --tail;
                }
            } else {
                if (!isNumAlphaBeta(h)) {
                    ++head;
                }
                if (!isNumAlphaBeta(t)) {
                    --tail;
                }
            }
        }
        return true;
    }
    public static boolean isNumAlphaBeta(char h) {
        // ASCII.
        if (h > 96 && h < 123) {
            return true; // is alphabeta.
        } else if (h > 47 && h < 58) {
            return true; // is number.
        } else {
            return false;
        }
    }
}


/* Python Version
def isPalindrome(self, s):
    if not s:
        return True
    s = s.strip().lower()
    head = 0
    tail = len(s) - 1
    
    while head < tail:
        while head < tail and not self.isNumAlphaBeta(s[head]):
            head += 1
        while head < tail and not self.isNumAlphaBeta(s[tail]):
            tail -= 1
        
        if s[head] != s[tail]:
            return False
        head += 1
        tail -= 1

    return True

def isNumAlphaBeta(self, c):
    asc = ord(c)
    return (asc >= 97 and asc <= 122) or (asc >= 48 and asc <= 57)
*/

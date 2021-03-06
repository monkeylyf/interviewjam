"""Bulls and cows
leetcode

ou are playing the following Bulls and Cows game with your friend: You write
down a number and ask your friend to guess what the number is. Each time your
friend makes a guess, you provide a hint that indicates how many digits in said
guess match your secret number exactly in both digit and position (called
"bulls") and how many digits match the secret number but locate in the wrong
position (called "cows"). Your friend will use successive guesses and hints to
eventually derive the secret number.

For example:

Secret number:  "1807"
Friend's guess: "7810"
Hint: 1 bull and 3 cows. (The bull is 8, the cows are 0, 1 and 7.)
Write a function to return a hint according to the secret number and friend's
guess, use A to indicate the bulls and B to indicate the cows. In the above
example, your function should return "1A3B".

Please note that both secret number and friend's guess may contain duplicate
digits, for example:

Secret number:  "1123"
Friend's guess: "0111"
In this case, the 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow,
and your function should return "1A1B".
You may assume that the secret number and your friend's guess only contain
digits, and their lengths are always equal.
"""

from collections import defaultdict

class Solution(object):
    def getHint(self, secret, guess):
        """Return hint.

        Scan perfect match(bull) first. Keep tracking which char is used
        already. Then try to finding mismatch.

        :type secret: str
        :type guess: str
        :rtype: str
        """
        if len(secret) != len(guess):
            raise ValueError('Guess should have length {}'.format(len(secret)))

        n = len(secret)
        secret_hash = defaultdict(int)
        guess_hash = defaultdict(int)
        a = 0
        for i in xrange(n):
            if secret[i] != guess[i]:
                secret_hash[secret[i]] += 1
                guess_hash[guess[i]] += 1
            else:
                a += 1
        b = 0
        for char, freq in secret_hash.iteritems():
            b += min(freq, guess_hash[char])

        return '{}A{}B'.format(a, b)


def main():
    sol = Solution()
    assert sol.getHint('1807', '7810') == '1A3B'
    assert sol.getHint('1123', '0111') == '1A1B'
    assert sol.getHint('1122', '1222') == '3A0B'


if __name__ == '__main__':
    main()

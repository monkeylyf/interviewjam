"""google_Shuffle_Pattern.py

Given a hand of cards, and you need to shuffle it. Assume that you always shuffle
the cards exactly the same way.
Will the cards reach the original state if you keep shuffling it? And if so, given
the shuffle pattern, how many times it will take to shuffle it back to its original
state?

Pattern is given as a integer array A, with no duplicates.

Ai means you shuffle the card at index i to index Ai
"""

class Solution(object):

    """"""

    def __init__(self, ptn):
        """"""
        self._ptn = map(lambda x : x - 1, ptn) # 0-based.
        self._unvisit = set(self._ptn)
        self._group_size = []

    def solve(self):
        """"""
        while self._unvisit:
            i = self._unvisit.pop()
            cursor = i
            size = 1

            while self._ptn[cursor] != i:
                cursor = self._ptn[cursor]
                self._unvisit.remove(cursor) # mark as visited
                size += 1

            self._group_size.append(size)

        return self.lcm(*self._group_size)

    def gcd(self, a, b):
        """"""
        return self.gcd(b % a, a) if a != 0 else b

    def lcm(self, *args):
        """"""
        retval = 1

        for i in args:
            retval = (retval * i) / self.gcd(retval, i)

        return retval


def main():
    print Solution([2, 1, 4, 3]).solve()
    print Solution([5, 3, 1, 2, 4]).solve()


if __name__ == '__main__':
    main()

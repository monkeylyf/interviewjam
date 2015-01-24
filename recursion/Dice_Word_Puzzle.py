"""Dice_Word_Puzzle.

Given n dices with 6 facets. Each facet has a charecter on it. Given a
string with length n.
Is possible to use these dices to spell the given word?
"""


from collections import Counter


class Solution(object):

    """"""

    def solve(self, dices, word):
        """"""
        assert len(dices) == len(word), "Number of dices MUST be equal to the length of word."

        dices = [Counter(dice) for dice in dices]

        total = Counter()
        map(lambda x: total.update(x), dices)

        word_counter = Counter(word)

        return self._rec(dices, total, word_counter, [])

    def _rec(self, dices, total, word_counter, acc):
        """"""
        if len(dices) == 0:
            return acc

        if not self._contain(total, word_counter):
            return False

        dice, rest_of_dices = dices[0], dices[1:]

        for char in dice:
            if char in word_counter:
                res = self._rec(rest_of_dices, total - dice,
                        word_counter - Counter((char, )), acc + [char])
                if res:
                    return res

        return False

    def _contain(self, a, b):
        """Check if a is at least a subset of b."""
        for k, v in b.iteritems():
            if v > a.get(k, 0):
                return False

        return True


def main():
    dices = (
             ('a', 'b', 'c', 'd', 'e', 'f'),
             ('c', 'd', 'e', 'f', 'g', 'h'),
             ('d', 'e', 'f', 'g', 'h', 'i'),
             ('e', 'f', 'g', 'h', 'i', 'j'),
             )

    word = 'ddhe'

    print Solution().solve(dices, word)


if __name__ == '__main__':
    main()

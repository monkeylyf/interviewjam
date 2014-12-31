"""google_Abbreviation
google

Abbreviation: apple can be abbreviated to 5, a4, 4e, a3e
Given a target string (internationalization), and a set of strings,
    return the minimal length of abbreviation of this target string so that it
will not conflict with abbrs of the strings in the set.

"apple", ["blade"] -> a4 (5 is conflicted with "blade")
"apple", ["plain", "amber", "blade"] -> ???

Follow-up:
If given a string and an abbreviation, return if the string matches abbr.
For example

"internationalization", "i5a11o1" -> true
"""


import unittest


class Abbreviation(object):

    """"""

    def __init__(self):
        """"""
        pass

    def is_abbr(self, s, abbr):
        """Return if an abbr is matched to given string.

        The answer to the follow-up question.
        The idea is to scan both the abbr and string from left to right.
        """
        acc = 0

        index = 0
        for c in abbr:
            if c.isalpha():
                if acc:
                    index += acc + 1
                    acc = 0 # reset.
                if s[index] != c:
                    return False

            elif c.isdigit():
                acc = acc * 10 + int(c)
            else:
                pass

        if acc == 0:
            return True
        else:
            return index + acc + 1 == len(s)

    def abbr(self, s, xs):
        """Generate a set of shortest abbrs with no conflicts."""
        common_diffs = [None] * len(s)

        for x in xs:
            if len(x) != len(s):
                # If lengths are different, then no matter what,
                # their abbrs can not conflict.
                continue
            diff = self.same_chars(s, x)
            common_diffs = self.merge(common_diffs, diff)

        sorted_abbr = self.catergory_by_length(self.abbr_generator(s))
        for i in xrange(len(sorted_abbr)):
            if i <= 1:
                continue

            acc = []

            for candidate in sorted_abbr[i]:
                if not self.is_conflict(candidate, common_diffs):
                    acc.append(candidate)

            if acc:
                break

        return  acc

    def merge(self, base, diff):
        """Merge two list."""
        for i, c in enumerate(diff):
            if not c or base[i]:
                continue
            base[i] = c

        return base

    def same_chars(self, a, b):
        """Find the same char at same position given two strings."""
        assert len(a) == len(b)

        diff = [None] * len(a)

        for i in xrange(len(a)):
            if a[i] == b[i]:
                diff[i] = a[i]

        return diff

    def abbr_generator(self, s):
        """Brutal force generator all abbrs given a string."""
        def rec(idx, prev, acc, container):
            if idx == len(s):
                container.append(''.join(acc + [prev]))
                return

            cur_char = s[idx]
            if prev.isdigit():
                # Current char is omitted.
                rec(idx + 1, str(int(prev) + 1), acc, container)
                # Current char is not omitted.
                rec(idx + 1, cur_char, acc + [str(prev)] if prev != '0' else acc, container)
            if prev.isalpha():
                # Current char is omitted.
                rec(idx + 1, '1', acc + [prev], container)
                # Current char is not omitted.
                rec(idx + 1, cur_char, acc + [prev], container)

        container = []

        rec(0, '0', [], container)

        return  container

    def catergory_by_length(self, container):
        """"""
        sorted_data = {}

        for token in container:
            try:
                sorted_data[len(token)].append(token)
            except KeyError:
                sorted_data[len(token)] = [token]

        return sorted_data

    def is_conflict(self, s, common_diffs):
        """"""
        diff = [None] * len(common_diffs)

        i = 0
        for char in s:
            if char.isdigit():
                i += int(char)
            elif char.isalpha():
                diff[i] = char
                i += 1
            else:
                pass

        for i in xrange(len(common_diffs)):
            if diff[i] is not None and common_diffs[i] is None:
                # No conflict.
                return False

        return True


class UnitTestSuite(unittest.TestCase):

    """Test suite."""

    def setUp(self):
        """"""
        self.abbr = Abbreviation()

    def test_is_abbr_true(self):
        """"""
        self.assertTrue(self.abbr.is_abbr("internationalization", "i5a11o1"))

    def test_is_abbr_false(self):
        """"""
        self.assertFalse(self.abbr.is_abbr("internationalization", "i5a10o1"))

    def test_abbr_case_1(self):
        """"""
        expected = ['a4']
        self.assertEqual(self.abbr.abbr("apple", ["blade"]), expected)

    def test_abbr_case_2(self):
        """"""
        expected = ['3l1', '3le', '2p2', '1p3', 'ap3']
        self.assertEqual(self.abbr.abbr("apple", ["plain", "amber", "blade"]), expected)


def main():
    unittest.main()


if __name__ == '__main__':
    main()

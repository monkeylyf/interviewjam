"""decompress_data

3(a4(ab)) -> aababababaababababaabababab
"""

import unittest


class Decompressor(object):

    def decompress(self, s):
        (chars, digit, nested_data) = self._parse(s)

        # Non-compressed data.
        if chars is None and digit is None and nested_data is None:
            return s

        # Sanity check.
        if digit and not nested_data:
            raise ValueError("Invalid compressed data: {0}".format(s))

        return chars + self.decompress(nested_data) * int(digit)

    def _parse(self, s):
        """Break the string down to chars/digit/(more decompressed data."""
        digit_idx = -1
        left = -1
        right = -1

        # Mark left parantheses if any.
        for i, val in enumerate(s):
            if val == '(':
                left = i
                break
            if digit_idx == -1 and val.isdigit():
                digit_idx = i

        # Mark right parantheses if any.
        for i in reversed(xrange(len(s))):
            val = s[i]
            if val == ')':
                right = i
                break

        chars = s[:digit_idx] if digit_idx != -1 else None
        digit = s[digit_idx:left] if digit_idx != -1 and left != -1 else None
        nested_data = s[left + 1:right] if left != -1 and right != -1 else None

        return chars, digit, nested_data


class UnitTestSuite(unittest.TestCase):

    """"""

    def setUp(self):
        self.decompressor = Decompressor()

    def test_1(self):
        """"""
        s = "3(a4(ab))"
        self.assertEqual(self.decompress(s), "aababababaababababaabababab")

    def test_2(self):
        """"""
        s = "3(b2(a))"
        self.assertEqual(self.decompress(s), "baabaabaa")

    def test_non_decompressed_data_1(self):
        """"""
        s = "abc"
        self.assertEqual(self.decompress(s), s)

    def decompress(self, s):
        return self.decompressor.decompress(s)


def main():
    unittest.main()


if __name__ == '__main__':
    main()

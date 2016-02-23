"""Two Sum III data structure design
leetcode

Design and implement a TwoSum class. It should support the following
operations: add and find.

add - Add the number to an internal data structure.
find - Find if there exists any pair of numbers which sum is equal to the
value.

For example,
add(1); add(3); add(5);
find(4) -> true
find(7) -> false
"""


from collections import defaultdict


class TwoSum(object):

    def __init__(self):
        """
        initialize your data structure here
        """
        self.s = defaultdict(int)

    def add(self, number):
        """
        Add the number to an internal data structure.
        :rtype: nothing
        """
        self.s[number] += 1

    def find(self, value):
        """Find if there exists any pair of numbers which sum is equal to the
        value.

        :type value: int
        :rtype: bool
        """
        for i in self.s:
            if value - i in self.s:
                if value - i == i:
                    if self.s[i] >= 2:
                        return True
                else:
                    return True
        return False


def main():
    # Your TwoSum object will be instantiated and called as such:
    twoSum = TwoSum()
    twoSum.add(0)
    twoSum.add(-1)
    twoSum.add(1)
    assert twoSum.find(0)


if __name__ == '__main__':
    main()

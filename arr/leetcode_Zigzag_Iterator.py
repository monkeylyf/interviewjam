"""Zigzag iterator
leetcode
Given two 1d vectors, implement an iterator to return their elements alternately.

For example, given two 1d vectors:

v1 = [1, 2]
v2 = [3, 4, 5, 6]
By calling next repeatedly until hasNext returns false, the order of elements
returned by next should be: [1, 3, 2, 4, 5, 6].

Follow up: What if you are given k 1d vectors? How well can your code be
extended to such cases?

Clarification for the follow up question - Update (2015-09-18):
The "Zigzag" order is not clearly defined and is ambiguous for k > 2 cases. If
"Zigzag" does not look right to you, replace "Zigzag" with "Cyclic". For
example, given the following input:

[1,2,3]
[4,5,6,7]
[8,9]
It should return [1,4,8,2,5,9,3,6,7].
"""

class ZigzagIterator(object):

    def __init__(self, v1, v2):
        """The implementatin is more generic that handle n vectors.

        (But you need to change the args of constructor it takes.

        Initialize your data structure here.
        :type v1: List[int]
        :type v2: List[int]
        """
        self.vector = [v1, v2]
        self.max_length = max(len(v) for v in self.vector)
        self.num_of_vector = len(self.vector)
        self.i = 0
        self.j = 0

        # Move to first non-empty list.
        while self.j < self.num_of_vector and len(self.vector[self.j]) == 0:
            self.j += 1
        if self.j == self.num_of_vector:
            # All list are empty. Set i to 1 and hasNext() should return False.
            self.i = 1

    def next(self):
        """
        :rtype: int
        """
        ret = self.vector[self.j][self.i]
        self.j += 1
        found = False
        # Move to the next valid number.
        while not found and self.i < self.max_length:
            # Search at the same level to the last vector.
            while not found and self.j < self.num_of_vector:
                found = len(self.vector[self.j]) > self.i
                if not found:
                    self.j += 1
            if not found:
                # Search next level from first list.
                self.i += 1
                self.j = 0

        return ret

    def hasNext(self):
        """
        :rtype: bool
        """
        return self.i < self.max_length


def main():
    # Your ZigzagIterator object will be instantiated and called as such:
    v1 = [1, 2]
    v2 = [3, 4, 5, 6]
    iterator = ZigzagIterator(v1, v2)
    vector = []
    while iterator.hasNext():
        vector.append(iterator.next())

    assert vector == [1, 3, 2, 4, 5, 6]

    #iterator = ZigzagIterator([1, 2, 3], [4, 5, 6], [7, 8, 9, 10])
    #vector = []
    #while iterator.hasNext():
    #    vector.append(iterator.next())

    #assert vector == [1, 4, 7, 2, 5, 8, 3, 6, 9, 10]



if __name__ == '__main__':
    main()

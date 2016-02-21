"""Flatten 2D vector
leetcode

Implement an iterator to flatten a 2d vector.

For example,
Given 2d vector =

[
  [1,2],
  [3],
  [4,5,6]
]
By calling next repeatedly until hasNext returns false, the order of elements
returned by next should be: [1,2,3,4,5,6].
"""


class Vector2D(object):

    def __init__(self, vec2d):
        """
        Initialize your data structure here.
        :type vec2d: List[List[int]]
        """
        self.vec2d = vec2d
        j = 0
        while j < len(self.vec2d):
            if not self.vec2d[j]:
                j += 1
            else:
                break
        self.j = j
        self.i = 0

    def next(self):
        """
        :rtype: int
        """
        retval = self.vec2d[self.j][self.i]
        self.i += 1
        if self.i == len(self.vec2d[self.j]):
            self.i = 0
            self.j += 1
            while self.j < len(self.vec2d):
                if not self.vec2d[self.j]:
                    self.j += 1
                else:
                    break
        return retval

    def hasNext(self):
        """
        :rtype: bool
        """
        return self.j < len(self.vec2d)


def main():
    # Your Vector2D object will be instantiated and called as such:
    vec2d = [ [1,2], [3], [4,5,6] ]
    iterator = Vector2D(vec2d)
    vector = []
    while iterator.hasNext():
        vector.append(iterator.next())

    assert vector == [1, 2, 3, 4, 5, 6]


if __name__ == '__main__':
    main()

"""Peek iterator
leetcode

Given an Iterator class interface with methods: next() and hasNext(), design and
implement a PeekingIterator that support the peek() operation -- it essentially
peek() at the element that will be returned by the next call to next().

Here is an example. Assume that the iterator is initialized to the beginning of
the list: [1, 2, 3].

Call next() gets you 1, the first element in the list.
Now you call peek() and it returns 2, the next element. Calling next() after
that still return 2.
You call next() the final time and it returns 3, the last element. Calling
hasNext() after that should return false.
"""


# Below is the interface for Iterator, which is already defined for you.
class Iterator(object):
    def __init__(self, nums):
        """
        Initializes an iterator object to the beginning of a list.
        :type nums: List[int]
        """
        self._nums = nums
        self._i = 0

    def hasNext(self):
        """
        Returns true if the iteration has more elements.
        :rtype: bool
        """
        return self._i < len(self._nums)

    def next(self):
        """
        Returns the next element in the iteration.
        :rtype: int
        """
        val = self._nums[self._i]
        self._i += 1
        return val


class PeekingIterator(object):

    def __init__(self, iterator):
        """Constructor.

        The idea is to be one step ahead of given iterator. Store 'top'
        as an obj attribute.

        Initialize your data structure here.
        :type iterator: Iterator
        """
        self._iter = iterator
        # None is not a safe indicator for end of iteration because None might
        # be in the given iterator.
        self._peek = iterator.next() if iterator.hasNext() else None

    def peek(self):
        """
        Returns the next element in the iteration without advancing the iterator.
        :rtype: int
        """
        return self._peek

    def next(self):
        """
        :rtype: int
        """
        peek = self._peek
        self._peek = self._iter.next() if self._iter.hasNext() else None
        return peek

    def hasNext(self):
        """
        :rtype: bool
        """
        return self._peek is not None


def main():
    # Your PeekingIterator object will be instantiated and called as such:
    nums = [5, 3, 1, 2, 4]
    iterator = PeekingIterator(Iterator(nums))
    peeked = []
    while iterator.hasNext():
        val = iterator.peek()   # Get the next element but not advance the iterator.
        peeked.append(val)
        iterator.next()         # Should return the same value as [val].

    assert nums == peeked


if __name__ == '__main__':
    main()

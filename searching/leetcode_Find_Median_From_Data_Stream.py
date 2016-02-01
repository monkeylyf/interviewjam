"""Find median from data stream
leetcode

Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

Examples:
[2,3,4] , the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Design a data structure that supports the following two operations:

void addNum(int num) - Add a integer number from the data stream to the data structure.
double findMedian() - Return the median of all elements so far.
For example:

add(1)
add(2)
findMedian() -> 1.5
add(3)
findMedian() -> 2
"""
import heapq

class MedianFinder:
    def __init__(self):
        """Using max-heap + min-heap

        max-heap + min-heap and keep min heap size - max heap size between [0, 1]
        In Python you need a little trick to create your own max by inverting the
        value from x to -x.

        Initialize your data structure here.
        """
        self._max_heap = []
        self._min_heap = []

    @property
    def _max_heap_size(self):
        return len(self._max_heap)

    @property
    def _min_heap_size(self):
        return len(self._min_heap)

    def addNum(self, num):
        """Adds a num into the data structure.

        Try to keep a balance between min/max heap so that either they have
        the same length or min heap is larger length by one and only one.

        Init state:
        1. Both empty then push to min heap
        2. Max heap empty then pushpop to min heap then get the val push to
           max heap. It is to push the smaller one to max heap so no overlapping
           between two heaps.
        3. If num is smaller than the max of max heap, pushpop to get the val
        4. If num is larger than the min of min heap, pushpop to get the val
        5. After 3&4 follow the rule to keep it balanced.

        :type num: int
        :rtype: void
        """
        if self._min_heap_size == 0:
            heapq.heappush(self._min_heap, num)
        elif self._max_heap_size == 0:
            val = heapq.heappushpop(self._min_heap, num)
            heapq.heappush(self._max_heap, -1 * val)
        else:
            if -1 * self._max_heap[0] > num:
                val = -1 * heapq.heappushpop(self._max_heap, -1 * num)
            elif self._min_heap[0] < num:
                val = heapq.heappushpop(self._min_heap, num)
            else:
                val = num
            if self._min_heap_size == self._max_heap_size:
                heapq.heappush(self._min_heap, val)
            elif self._min_heap_size == self._max_heap_size + 1:
                heapq.heappush(self._max_heap, -1 * val)
            else:
                raise ValueError('wtf..')

    def findMedian(self):
        """
        Returns the median of current data stream
        :rtype: float
        """
        #print self._max_heap, self._min_heap
        if not self._max_heap_size and not self._min_heap_size:
            raise ValueError('Empty data stream!')
        if self._max_heap_size  + 1 == self._min_heap_size:
            return self._min_heap[0]
        if self._max_heap_size == self._min_heap_size:
            return (-1 * self._max_heap[0] + self._min_heap[0]) / 2.0
        raise ValueError('wtf')


def main():
    # Your MedianFinder object will be instantiated and called as such:
    mf = MedianFinder()
    mf.addNum(1)
    assert mf.findMedian() == 1
    mf.addNum(2)
    assert mf.findMedian() == 1.5
    mf.addNum(2)
    assert mf.findMedian() == 2

    mf = MedianFinder()
    mf.addNum(-1)
    assert mf.findMedian() == -1.0000
    mf.addNum(-2)
    assert mf.findMedian() == -1.5000
    mf.addNum(-3)
    assert mf.findMedian() == -2
    mf.addNum(-4)
    assert mf.findMedian() == -2.5000
    mf.addNum(-5)
    assert mf.findMedian() == -3


if __name__ == '__main__':
    main()

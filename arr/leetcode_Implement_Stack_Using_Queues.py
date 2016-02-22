"""Implement stack using queues
leetcode

"""


from collections import deque


class Stack(object):

    def __init__(self):
        """
        initialize your data structure here.
        """
        self._queue = deque()
        self._tmp = deque()

    def push(self, x):
        """
        :type x: int
        :rtype: nothing
        """
        self._queue.append(x)

    def pop(self):
        """
        :rtype: nothing
        """
        if not self._queue:
            raise ValueError('Empty Stack')
        # Very inefficient.
        while len(self._queue) > 1:
            self._tmp.append(self._queue.popleft())
        top = self._queue.popleft()
        self._queue, self._tmp = self._tmp, self._queue
        return top

    def top(self):
        """
        :rtype: int
        """
        return self._queue[-1]

    def empty(self):
        """
        :rtype: bool
        """
        return len(self._queue) == 0


def main():
    s = Stack()
    s.push(1)
    s.push(2)
    s.push(3)
    assert s.pop() == 3
    assert s.pop() == 2
    assert s.pop() == 1


if __name__ == '__main__':
    main()

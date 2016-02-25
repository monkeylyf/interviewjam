"""Min stack
leetcode

Design a stack that supports push, pop, top, and retrieving the minimum element
 in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
"""


class MinStack(object):

    def __init__(self):
        """
        initialize your data structure here.
        """
        self._stack = []
        self._mins = []

    def push(self, x):
        """
        :type x: int
        :rtype: nothing
        """
        if self._stack:
            self._mins.append(min(x, self._mins[-1]))
        else:
            self._mins.append(x)
        self._stack.append(x)

    def pop(self):
        """
        :rtype: nothing
        """
        self._mins.pop()
        return self._stack.pop()

    def top(self):
        """
        :rtype: int
        """
        return self._stack[-1]

    def getMin(self):
        """
        :rtype: int
        """
        return self._mins[-1]


def main():
    mstack = MinStack()
    mstack.push(-2)
    mstack.push(0)
    mstack.push(-1)

    assert mstack.getMin() == -2


if __name__ == '__main__':
    main()

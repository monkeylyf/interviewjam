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
            prev_min, count = self._mins[-1]
            if x < prev_min:
                self._mins.append([x, 1])
            else:
                self._mins[-1][1] += 1

        else:
            self._mins.append([x, 1])
        self._stack.append(x)

    def pop(self):
        """
        :rtype: nothing
        """
        if self._mins[-1][1] > 1:
            self._mins[-1][1] -= 1
        elif self._mins[-1][1] == 1:
            self._mins.pop()
        else:
            raise ValueError
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
        return self._mins[-1][0]


def main():
    mstack = MinStack()
    mstack.push(-2)
    mstack.push(0)
    mstack.push(-1)

    assert mstack.getMin() == -2

    mstack.push(-3)
    assert mstack.getMin() == -3
    mstack.push(-10)
    assert mstack.getMin() == -10

    assert mstack.pop() == -10
    assert mstack.getMin() == -3

    assert mstack.pop() == -3
    assert mstack.getMin() == -2

    assert mstack.pop() == -1
    assert mstack.getMin() == -2

    assert mstack.pop() == 0
    assert mstack.getMin() == -2

    assert mstack.pop() == -2


if __name__ == '__main__':
    main()

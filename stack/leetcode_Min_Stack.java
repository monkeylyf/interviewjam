/**
 * kleetcode_Min_Stack.
 * leetcode
 *
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 */

import java.util.ArrayList;
import java.util.List;


public class leetcode_Min_Stack {

  private final List<Integer> stack;
  private final List<Integer> min;

  private int length;

  public leetcode_Min_Stack() {
    this.stack = new ArrayList<Integer>();
    this.min = new ArrayList<Integer>();
  }

  public void push(int x) {
    this.stack.add(x);
    if (this.min.isEmpty() || this.min.get(this.min.size() - 1) >= x) {
      this.min.add(x);
    }
  }

  public void pop() {
    int elem = this.stack.remove(stack.size() - 1);
    int length = this.min.size();
    if (elem == this.min.get(length - 1)) {
      this.min.remove(length - 1);
    }
  }

  public int top() { return this.stack.get(this.stack.size()-1); }

  public int getMin() { return this.min.get(this.min.size()-1); }
}


/** Python solution.

class MinStack(object):

    def __init__(self):
        """"""
        self._s = []
        self._min = []

    def push(self, x):
        """"""
        self._s.append(x)

        if not self._min or self._min[-1] >= x:
            self._min.append(x)

    def pop(self):
        """"""
        x = self._s.pop()
        if self._min[-1] == x:
            self._min.pop()

    def top(self):
        """"""
        return self._s[-1]

    def getMin(self):
        return self._min[-1]
*/

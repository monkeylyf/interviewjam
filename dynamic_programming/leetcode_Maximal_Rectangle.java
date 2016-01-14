/**
 * Maximal_Rectangle.
 *
 * leetcode
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle
 * containing all ones and return its area.
 */

import java.util.Stack;

class leetcode_Maximal_Rectangle {

  public static void main(String[] args) {
    System.out.println(maximalRectangle(new char[][] {
      {'0', '1', '1', '1', '0', '0', '1', '1', '0'},
        {'0', '1', '0', '0', '0', '0', '1', '1','0'},
        {'0', '1', '0', '0', '0', '0', '1', '1','0'},
        {'1', '1', '0', '1', '1', '1', '1', '1','0'},
    }));
  }

  public static int maximalRectangle(char[][] matrix) {
    int[] prev = new int[matrix[0].length];
    for (int i = 0; i < matrix[0].length; ++i) {
      if (matrix[0][i] == '1') {
        prev[i] = 1;
      }
    }
    int max = largestRectangleArea(prev);
    for (int i = 1; i < matrix.length; ++i) {
      int[] next = new int[matrix[0].length];
      for (int j = 0; j < matrix[i].length; ++j) {
        if (matrix[i][j] == '0') {
          next[j] = 0;
        } else {
          next[j] = prev[j] + 1;
        }
      }
      int localMax = largestRectangleArea(next);
      max = Math.max(max, localMax);
      prev = next;
    }
    return max;
  }

  public static int largestRectangleArea(int[] height) {
    if (height.length == 0) {
      return 0;
    }
    int result = 0;
    Stack<Integer> indexes = new Stack<Integer>();
    Stack<Integer> heights = new Stack<Integer>();
    for (int i = 0; i < height.length; i++) {
      if (heights.isEmpty() || height[i] > heights.peek()) {
        heights.push(height[i]);
        indexes.push(i);
      } else if (height[i] < heights.peek()) {
        int lastIndex = 0;
        int lastHeight = 0;
        while (!heights.isEmpty() && heights.peek() > height[i]) {
          lastIndex = indexes.pop();
          lastHeight = heights.pop();
          result = Math.max(result, lastHeight * (i - lastIndex));
        }
        heights.push(height[i]);
        indexes.push(lastIndex);
      }
    }
    while (!heights.isEmpty()) {
      result = Math.max(result, heights.pop() * (height.length - indexes.pop()));
    }
    return result;
  }
}


/* Python Version

def maximalRectangle(self, matrix):
    if not matrix:
        return 0

    hist = map(int, matrix[0])
    ret = self.largestRectangleArea(hist)

	# Accumulating histogram.
    for i in xrange(1, len(matrix)):
        for j in xrange(len(matrix[i])):
            if matrix[i][j] == '1':
                hist[j] += 1
            else:
                hist[j] = 0
        ret = max(self.largestRectangleArea(hist), ret)

    return ret

def largestRectangleArea(self, height):
    if not height:
        return 0

    idx = []
    h = []
    # index and height are tracked seperately.
    ret = lastIdx = lastHeight = 0

    for i in xrange(len(height)):
        # Monotone increasing, push into stack.
        if not h or h[-1] < height[i]:
            h.append(height[i])
            idx.append(i)
        #Update ret. Backtracing.
        elif h[-1] > height[i]:
            while h and h[-1] > height[i]:
                lastIdx = idx.pop()
                lastHeight = h.pop()
                # Normally it should be min(lastHeight, lastlastHeight) * (i - lastIdx)
                # Since it is already monotone increasing then there is no need for min op
                ret = max(ret, lastHeight * (i - lastIdx))
            # All element larger than height[i] has been processed
            # Push height[i] to monotone stack and still keep its monotone increasing feature.
            h.append(height[i])
            idx.append(lastIdx)
    # Process what's left in the stacks

    while h:
        # The right border is the length of height.
        ret = max(ret, h.pop() * (len(height) - idx.pop()))

    return ret
*/

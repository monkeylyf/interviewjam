"""Sliding_Window_Maximum
leetcode

A long array A[] is given to you. There is a sliding window of size w which is
moving from the very left of the array to the very right. You can only see the
w numbers in the window. Each time the sliding window moves rightwards by one
position. Following is an example:
The array is [1 3 -1 -3 5 3 6 7], and w is 3.

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
1  [3  -1  -3] 5  3  6  7       3
1   3 [-1  -3  5] 3  6  7       5
1   3  -1 [-3  5  3] 6  7       5
1   3  -1  -3 [5  3  6] 7       6
1   3  -1  -3  5 [3  6  7]      7

Input: A long array A[], and a window width w
Output: An array ret[], ret[i] is the maximum value of from A[i] to A[i+w-1]
Requirement: Find a good optimal way to get ret[i]


Solution: you can maintain a heap to have n(logw) time complxity to get the maximum
of current sliding window but you need to find a way to pop the element that window
just passed.

There is a solution with amortized O(n) time complexity.
"""


def max_sliding_window(arr, w):
    """"""
    assert w > 0, 'Invalid window size {0}'.format(w)
    Q = []
    ret = []

    # Init sliding window queue with first w values. All elements in queue are indexes.
    # Q[0] is the index of largest element in current window.
    # Q[i] means min(window[i:w]), so we know what's the max when you pop a maximum in 
    # the current window.
    # Imagine that the sliding window starts at [-w, 0]
    
    for i, elem in enumerate(arr):
        # current element is larger that the maximum in current sliding window, pop it. 
        while Q and elem >= arr[Q[-1]]:
            Q.pop()
        # When the sliding window pass one element and this one is the , check 
        while i >= w and Q and Q[0] <= i - w:
            Q.pop(0)

        Q.append(i) # Approval of O(n). N append thus N pop.
        # Append the maximum of current sliding window.
        ret.append(arr[Q[0]])
    return ret[w - 1:]


if __name__ == '__main__':
    arr = [ 1, 3, -1, -3, 5, 3, 6, 7]
    w = 3
    assert max_sliding_window(arr, w) == [3, 3, 5, 5, 6, 7]
    arr = [7, 6, 5, 4, 3, 2, 1]
    assert max_sliding_window(arr, w) == [7, 6, 5, 4, 3]
    arr = [1, 2, 3, 4, 5, 6, 7]
    assert max_sliding_window(arr, w) == [3, 4, 5, 6, 7]
    arr = [0, 0, 0, 0, 0, 0, 0]
    assert max_sliding_window(arr, w) == [0, 0, 0, 0, 0]
    arr = [1, 3, 1, 3, 1, 3, 1, 3]
    assert max_sliding_window(arr, w) == [3, 3, 3, 3, 3, 3]

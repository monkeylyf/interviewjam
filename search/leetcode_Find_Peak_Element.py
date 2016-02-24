"""Find Peak Element
leetcode

peak element is an element that is greater than its neighbors.
Given an input array where num[i] is not equal to num[i+1], find a peak element
and return its index.
The array may contain multiple peaks, in that case return the index to any one
of the peaks is fine.

You may imagine that num[-1] = num[n] = negative infinity.
For example, in array [1, 2, 3, 1], 3 is a peak element and your function should
return the index number 2.
"""


class Solution:
    # @param num, a list of integer
    # @return an integer
    def findPeakElement(self, num):
        """Binary search. Time complexity O(lgn).

        How to justify that binary search will actually work?
        """
        head = 0
        tail = len(num) - 1

        while head <= tail:
            if head == tail:
                return head  # Edge case: [0], head = 0, tail = 0
            elif head + 1 == tail:
                # Return the index of larger element.
                return head if num[head] > num[tail] else tail
            else:
                mid = (tail - head) / 2 + head

                # Now mid can not be 0 or n - 1.
                # For mid == 0, then head = 0, tail = 0 or 1
                # For mid == n - 1, then head = n - 1 and tail = n - 1.
                if num[mid - 1] > num[mid]:
                    tail = mid - 1
                elif num[mid] < num[mid + 1]:
                    head = mid + 1
                else:
                    # Hit here then: num[mid - 1] > num[mid] < mid[mid + 1]
                    # Find peak.
                    return mid

        # I don't think the function will ever hit here but make sure
        # it does not return None.
        return head


def main():
    sol = Solution()
    array = [1, 2, 3, 1]
    print sol.findPeakElement(array)


if __name__ == '__main__':
    main()

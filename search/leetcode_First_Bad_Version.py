"""First bad version
leetcode

You are a product manager and currently leading a team to develop a new product.
Unfortunately, the latest version of your product fails the quality check. Since
each version is developed based on the previous version, all the versions after
a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first
bad one, which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which will return whether
version is bad. Implement a function to find the first bad version. You should
minimize the number of calls to the API.
"""
def isBadVersion(version):
    pass

class Solution(object):
    def firstBadVersion(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n == 0:
            raise ValueError

        head = 1
        tail = n
        while head <= tail:
            mid = (tail - head) / 2 + head
            if isBadVersion(mid):
                if mid != 0 and isBadVersion(mid - 1):
                    tail = mid - 1
                else:
                    return mid
            else:
                head = mid + 1
        raise ValueError


def main():
    sol = Solution()
    # No testing since isBadVersion is defined in OJ.


if __name__ == '__main__':
    main()

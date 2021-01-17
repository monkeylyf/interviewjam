# https://leetcode.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/

from typing import List

class Solution:
    def numOfSubarrays(self, arr: List[int], k: int, threshold: int) -> int:
        threshold_sum = threshold * k
        window = sum(arr[:k])
        count = 0 if window < threshold_sum else 1
        i = 1
        n = len(arr)
        while i < n - k + 1:
            window = window - arr[i - 1] + arr[i + k - 1]
            if window >= threshold_sum:
                count += 1
            i += 1
        return count


def main():
    sol = Solution()
    print(sol.numOfSubarrays([2, 2, 2, 2, 5, 5, 5, 8], 3, 4))
    print(sol.numOfSubarrays([1, 1, 1, 1, 1], 1, 0))
    print(sol.numOfSubarrays([11,13,17,23,29,31,7,5,2,3], 3, 5))


if __name__ == '__main__':
    main()

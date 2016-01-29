"""Create maximum number
leetcode

Given two arrays of length m and n with digits 0-9 representing two numbers.
Create the maximum number of length k <= m + n from digits of the two. The
relative order of the digits from the same array must be preserved. Return an
array of the k digits. You should try to optimize your time and space
complexity.

Example 1:
nums1 = [3, 4, 6, 5]
nums2 = [9, 1, 2, 5, 8, 3]
k = 5
return [9, 8, 6, 5, 3]

Example 2:
nums1 = [6, 7]
nums2 = [6, 0, 4]
k = 5
return [6, 7, 6, 0, 4]

Example 3:
nums1 = [3, 9]
nums2 = [8, 9]
k = 3
return [9, 8, 9]
"""


class Solution(object):
    def maxNumber(self, nums1, nums2, k):
        """Two subproblems:
        1. Given an array, find k elements to form another array with the same
           order, what's the largest sub-array?
        2. Given two array, interleave them into one, what's the possible
           largest result?

        The first one is trivial. The second is kinda tricky. I don't know how
        to do it in O(m + n) time. The tough part is when two arrays share the
        same prefix

        :type nums1: List[int]
        :type nums2: List[int]
        :type k: int
        :rtype: List[int]
        """
        def merge_arrays(arr1, arr2):
            """"""
            n = len(arr1)
            m = len(arr2)

            if n == 0:
                return arr2
            if m == 0:
                return arr1

            merged = []
            i = 0
            j = 0

            while i < n and j < m:
                if arr1[i] > arr2[j]:
                    merged.append(arr1[i])
                    i += 1
                elif arr1[i] < arr2[j]:
                    merged.append(arr2[j])
                    j += 1
                else:
                    ii = i
                    jj = j
                    while ii < n and jj < m and arr1[ii] == arr2[jj]:
                        ii += 1
                        jj += 1

                    #print ii, jj
                    if ii == n:
                        merged.append(arr2[j])
                        j += 1
                    elif jj == m:
                        merged.append(arr1[i])
                        i += 1
                    elif arr1[ii] > arr2[jj]:
                        merged.append(arr1[i])
                        i += 1
                    else:
                        merged.append(arr2[j])
                        j += 1

            if i < n:
                merged.extend(arr1[i:])
            if j < m:
                merged.extend(arr2[j:])

            return merged

        def max_k(arr, k):
            if len(arr) == k:
                return arr
            max_number = []
            start = 0
            for i in reversed(xrange(k)):
                end = len(arr) - i
                local_max = float('-inf')
                max_idx = -1
                for j in xrange(start, end):
                    if arr[j] > local_max:
                        local_max = arr[j]
                        max_idx = j
                        if arr[j] == 9:
                            break

                max_number.append(local_max)
                start = max_idx + 1

            return max_number

        max_merged = None
        for i in xrange(k + 1):
            if i <= len(nums1) and k - i <= len(nums2):
                #print self.max_k(nums1, i), self.max_k(nums2, k - i)
                arr1 = max_k(nums1, i)
                arr2 = max_k(nums2, k - i)
                merged = merge_arrays(arr1, arr2)
                if max_merged is None or merged > max_merged:
                    max_merged = merged

        return max_merged


def main():
    sol = Solution()
    nums1 = [3, 4, 6, 5]
    nums2 = [9, 1, 2, 5, 8, 3]
    k = 5
    assert sol.maxNumber(nums1, nums2, k) == [9, 8, 6, 5, 3]


if __name__ == '__main__':
    main()

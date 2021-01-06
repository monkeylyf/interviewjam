# https://leetcode.com/problems/partition-labels/

from typing import List


class Solution:
    def partitionLabels(self, S: str) -> List[int]:
        ranges = [None] * 26
        for (i, c) in enumerate(S):
            ii = ord(c) - 97
            range_of_c = ranges[ii]
            if range_of_c is None:
                ranges[ii] = [i, i]
            else:
                (min_i, max_i) = range_of_c
                if min_i > i:
                    ranges[ii] = [i, max_i]
                if max_i < i:
                    ranges[ii] = [min_i, i]

        n = len(S)
        partition = []

        i = 0
        while i < n:
            c = S[i]
            (min_i, max_i) = ranges[ord(c) - 97]
            j = min_i + 1
            while j < max_i:
                cc = S[j]
                (min_j, max_j) = ranges[ord(cc) - 97]
                if max_j > max_i:
                    max_i = max_j
                j += 1
            partition.append(max_i - min_i + 1)
            i = max_i + 1

        return partition


    def partitionLabels(self, S: str) -> List[int]:
        rightmost = [None] * 26
        for (i, c) in enumerate(S):
            rightmost[ord(c) - 97] = i
    	left = 0
        right = 0

    	result = []
    	for i, letter in enumerate(S):
            right = max(right, rightmost[ord(letter) - 97])
            if i == right:
                result.append(right - left + 1)
                left = i + 1

    	return result



def main():
    sol = Solution()
    print(sol.partitionLabels('ababcbacadefegdehijhklij'))


if __name__ == '__main__':
    main()

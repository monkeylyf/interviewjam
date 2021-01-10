# https://leetcode.com/problems/path-in-zigzag-labelled-binary-tree/

from typing import List

class Solution:
    def pathInZigZagTree(self, label: int) -> List[int]:
        nodes = []
        i = 1
        while i <= label:
            nodes.append(i)
            i *= 2
        nodes.append(i)

        path = []
        i = len(nodes) - 2
        cur = label
        while i > 0:
            path.append(cur)
            level_start = nodes[i]
            level_end = nodes[i + 1]
            is_reversed = i % 2 == 1
            position = level_end - cur - 1 if is_reversed else cur - level_start  # 0-based.
            upper_level_position = position // 2
            if is_reversed:
                # Upper level is not.
                upper_level_start = nodes[i - 1]
                cur = upper_level_start + upper_level_position
            else:
                # Upper level is reversed.
                cur = level_start - 1 - upper_level_position
            i -= 1
        path.append(1)

        return path[::-1]


def main():
    sol = Solution()
    print(sol.pathInZigZagTree(14))
    print(sol.pathInZigZagTree(26))


if __name__ == '__main__':
    main()

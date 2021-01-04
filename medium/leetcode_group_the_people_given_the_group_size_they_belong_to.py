# https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/

from typing import List


class Solution:
    def groupThePeople(self, groupSizes: List[int]) -> List[List[int]]:
        mapping = {}
        for (i, size) in enumerate(groupSizes):
            group = mapping.get(size)
            if group is None:
                mapping[size] = [i]
            else:
                group.append(i)
        groups = []

        for size, group in mapping.items():
            if len(group) == size:
                groups.append(group)
            else:
                for i in range(len(group) // size):
                    groups.append(group[i * size: i * size + size])

        groups.sort(key=len)
        return groups


def main():
    sol = Solution()
    print(sol.groupThePeople([3, 3, 3, 3, 3, 1, 3]))


if __name__ == '__main__':
    main()

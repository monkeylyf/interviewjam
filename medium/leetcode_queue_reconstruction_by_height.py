# https://leetcode.com/problems/queue-reconstruction-by-height/

from typing import List

class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        mapping = {}
        res = []
        for h, i in people:
            front = mapping.get(h)
            if front is None:
                mapping[h] = [i]
            else:
                front.append(i)
        for h in sorted(list(mapping.keys()), reverse=True):
            value = mapping[h]
            value.sort()
            if not res:
                heights = [[h, i] for i in value]
                res.extend(heights)
                continue

            for i in value:
                res.insert(i, [h, i])

        return res


def main():
    sol = Solution()
    people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
    print(sol.reconstructQueue(people))


if __name__ == '__main__':
    main()

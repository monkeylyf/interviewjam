# https://leetcode.com/problems/count-largest-group/

class Solution:
    def countLargestGroup(self, n: int) -> int:
        mapping = {}
        max_size = -float('inf')
        for i in range(1, n + 1):
            a = i
            s = 0

            while i > 0:
                s += i % 10
                i = i // 10

            li = mapping.get(s, [])
            li.append(a)
            mapping[s] = li
            if max_size < len(li):
                max_size = len(li)

        total = 0
        for val in mapping.values():
            if len(val) == max_size:
                total += 1
        return total


def main():
    sol = Solution()
    print(sol.countLargestGroup(13))


if __name__ == '__main__':
    main()

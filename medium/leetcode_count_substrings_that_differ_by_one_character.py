# https://leetcode.com/problems/count-substrings-that-differ-by-one-character/
# Need revisit.

def count_prefix(s, t, i, j, n, m):
    res = 0
    prev = 0
    cur = 0

    step = 0
    while step < n - i and step < m - j:
        cur += 1
        if s[i + step] != t[j + step]:
            # Master piece that only when two chars are different, accumulate the sum.
            prev = cur
            cur = 0
        res += prev
        step += 1
    return res


class Solution:
    def countSubstrings(self, s: str, t: str) -> int:
        n = len(s)
        m = len(t)
        res = 0

        for i in range(n):
            res += count_prefix(s, t, i, 0, n, m)
        for i in range(1, m):
            res += count_prefix(s, t, 0, i, n, m)

        return res


def main():
    sol = Solution()
    print(sol.countSubstrings('aba', 'baba'))


if __name__ == '__main__':
    main()

# https://leetcode.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/submissions/

class Solution:
    def getHappyString(self, n: int, k: int) -> str:
        def rec(acc, count, n):
            if len(acc) == n:
                if count[0] == 1:
                    return ''.join((acc))
                else:
                    count[0] -= 1
                    return ''

            prev = acc[-1] if acc else ''
            for c in 'abc':
                if c != prev:
                    acc.append(c)
                    res = rec(acc, count, n)
                    if res:
                        return res
                    acc.pop()
            return ''


        return rec([], [k], n)


def main():
    print(Solution().getHappyString())


if __name__ == '__main__':
    main()

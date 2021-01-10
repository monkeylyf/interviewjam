# https://leetcode.com/problems/bulb-switcher-iv/

class Solution:
    def minFlips(self, target: str) -> int:
        i = 0
        n = len(target)
        # Get the index of the first 1.
        while i < n and target[i] == '0':
            i += 1
        if i == n:
            # If 1 does not exist, no flip is needed.
            return 0

        prev = None
        count = 0
        j = n - 1
        # Get # of consecutive sequence.
        while j >= i:
            cur = target[j]
            if prev is None or prev != cur:
                prev = cur
                count += 1
            else:
                pass
            j -= 1

        return count


def main():
    sol = Solution()
    print(sol.minFlips('1011'))
    print(sol.minFlips('001011101'))
    print(sol.minFlips('001011100'))
    print(sol.minFlips('000'))
    print(sol.minFlips('0011'))


if __name__ == '__main__':
    main()

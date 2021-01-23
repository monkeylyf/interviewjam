# https://leetcode.com/problems/minimum-swaps-to-make-strings-equal/

class Solution:
    def minimumSwap(self, s1: str, s2: str) -> int:
        if len(s1) != len(s2):
            return -1

        s1_x = s1.count('x')
        s2_x = s2.count('x')
        if (s1_x + s2_x) % 2 == 1:
            return -1

        x = 0
        y = 0
        n = len(s1)
        for i in range(n):
            ss1 = s1[i]
            if ss1 != s2[i]:
                if ss1 == 'x':
                    x += 1
                else:
                    y += 1
        xdiv, xmod = divmod(x, 2)
        ydiv, ymod = divmod(y, 2)
        if xmod == 1 and ymod == 1:
            return xdiv + ydiv + 2
        else:
            return xdiv + ydiv




def main():
    sol = Solution()
    print(sol.minimumSwap('xxyyxyxyxx', 'xyyxyxxxyx') == 4)
    print(sol.minimumSwap('xx', 'xy') == -1)
    print(sol.minimumSwap('xy', 'yx') == 2)
    print(sol.minimumSwap('xx', 'yy') == 1)


if __name__ == '__main__':
    main()

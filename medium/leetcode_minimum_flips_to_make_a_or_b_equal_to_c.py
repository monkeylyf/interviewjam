# https://leetcode.com/problems/minimum-flips-to-make-a-or-b-equal-to-c/


class Solution:
    def minFlips(self, a: int, b: int, c: int) -> int:
        a = '{0:b}'.format(a)
        b = '{0:b}'.format(b)
        c = '{0:b}'.format(c)

        a_len = len(a)
        b_len = len(b)
        c_len = len(c)

        max_len = max(a_len, b_len, c_len)
        if max_len > a_len:
            a = '0' * (max_len - a_len) + a
        if max_len > b_len:
            b = '0' * (max_len - b_len) + b
        if max_len > c_len:
            c = '0' * (max_len - c_len) + c

        count = 0

        for i in range(max_len):
            c_a = a[i]
            c_b = b[i]
            c_c = c[i]
            if c_a == '1' and c_b == '1':
                if c_c == '0':
                    count += 2
            elif c_a == '0' and c_b == '0':
                if c_c == '1':
                    count += 1
            elif c_c == '0':
                count += 1
            else:
                pass

        return count

# https://leetcode.com/problems/latest-time-by-replacing-hidden-digits/

class Solution:
    def maximumTime(self, time: str) -> str:
        h1, h2, _, m1, m2 = time
        if h1 == '?':
            if h2 != '?' and int(h2) >= 4:
                h1 = '1'
            else:
                h1 = '2'
        if h2 == '?':
            if h1 == '2':
                h2 = '3'
            else:
                h2 = '9'
        if m1 == '?':
            m1 = '5'
        if m2 == '?':
            m2 = '9'

        return f'{h1}{h2}:{m1}{m2}'


def main():
    sol = Solution()
    print(sol.maximumTime('2?:?0') == '23:50')
    print(sol.maximumTime('0?:3?') == '09:39')
    print(sol.maximumTime('1?:22') == '19:22')


if __name__ == '__main__':
    main()

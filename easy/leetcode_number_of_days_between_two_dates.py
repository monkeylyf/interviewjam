# https://leetcode.com/problems/number-of-days-between-two-dates/

from datetime import datetime

class Solution:
    def daysBetweenDates(self, date1: str, date2: str) -> int:
        a = datetime.strptime(date1, '%Y-%m-%d').date()
        b = datetime.strptime(date2, '%Y-%m-%d').date()
        return abs((a - b).days)


def main():
    sol = Solution()
    print(sol.daysBetweenDates('2020-01-15', '2019-12-31'))
    print(sol.daysBetweenDates('2018-01-15', '2019-12-31'))


if __name__ == '__main__':
    main()

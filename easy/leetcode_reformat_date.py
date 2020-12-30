# https://leetcode.com/problems/reformat-date/

MONTH = {
        "Jan": "01",
        "Feb": "02",
        "Mar": "03",
        "Apr": "04",
        "May": "05",
        "Jun": "06",
        "Jul": "07",
        "Aug": "08",
        "Sep": "09",
        "Oct": "10",
        "Nov": "11",
        "Dec": "12"
}

class Solution:
    def reformatDate(self, date: str) -> str:
        (day, month, year) = date.split()
        day = day[:-2]
        day = day if len(day) == 2 else f'0{day}'
        return f'{year}-{MONTH[month]}-{day}'


def main():
    sol = Solution()
    print(sol.reformatDate("20th Oct 2052"))


if __name__ == '__main__':
    main()

# https://leetcode.com/problems/day-of-the-week/submissions/

import datetime

WEEKDAY = ("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday")

class Solution:
    def dayOfTheWeek(self, day: int, month: int, year: int) -> str:
	today = datetime.datetime(year, month, day)
        day_index= today.weekday()
        return WEEKDAY[(day_index + 1) % 7]

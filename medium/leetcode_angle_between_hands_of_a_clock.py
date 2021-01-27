# https://leetcode.com/problems/angle-between-hands-of-a-clock/

class Solution:
    def angleClock(self, hour: int, minutes: int) -> float:
        hour = hour % 12
        hour_angle = 360 * hour / 12 + 360 / 12 * minutes / 60
        min_angle = 360 * minutes / 60
        angle = abs(hour_angle - min_angle)
        if angle > 180:
            return 360 - angle
        else:
            return angle

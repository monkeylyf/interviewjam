# https://leetcode.com/problems/thousand-separator/

class Solution:
    def slowestKey(self, releaseTimes: List[int], keysPressed: str) -> str:
        max_duration = -1
        slowest = ''
        i = 0
        while i < len(keysPressed):
            key = keysPressed[i]
            if i == 0:
                max_duration = releaseTimes[i]
                slowest = key
            else:
                duration = releaseTimes[i] - releaseTimes[i - 1]
                if duration > max_duration:
                    max_duration = duration
                    slowest = key
                elif duration == max_duration and key > slowest:
                    slowest = key
            i += 1
        return slowest

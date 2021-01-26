# https://leetcode.com/problems/average-waiting-time/


class Solution:
    def averageWaitingTime(self, customers: List[List[int]]) -> float:
        if not customers:
            return 0

        total = 0
        prev_finish_time = 0
        for arrival, duration in customers:
            if prev_finish_time <= arrival:
                total += duration
                prev_finish_time  = arrival + duration
            else:
                total += (prev_finish_time - arrival) + duration
                prev_finish_time  += duration

        return total / len(customers)

# https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary

class Solution:
    def average(self, salary: List[int]) -> float:
        if not salary:
            return 0
        total = 0
        min_salary = float("inf")
        max_salary = -float("inf")

        for s in salary:
            total += s
            if s > max_salary:
                max_salary = s
            if s < min_salary:
                min_salary = s
        return (total - min_salary - max_salary) / (len(salary) - 2)

#https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/

from typing import List


class Solution:
    def countStudents(self, students: List[int], sandwiches: List[int]) -> int:
        one = students.count(1)
        n = len(students)
        zero = n - one

        i = 0
        while i < n:
            #  Until one type of sandwiches are all taken.
            if sandwiches[i] == 1:
                if one > 0:
                    one -= 1
                else:
                    break
            else:
                if zero > 0:
                    zero -= 1
                else:
                    break
            i += 1
        return n - i



def main():
    sol = Solution()
    print(sol.countStudents([1, 1, 1, 0, 0, 1], [1, 0, 0, 0, 1, 1]))


if __name__ == '__main__':
    main()

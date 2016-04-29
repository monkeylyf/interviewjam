"""Expression Add Operators
leetcode

Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.

Examples:
"123", 6 -> ["1+2+3", "1*2*3"]
"232", 8 -> ["2*3+2", "2+3*2"]
"105", 5 -> ["1*0+5","10-5"]
"00", 0 -> ["0+0", "0-0", "0*0"]
"3456237490", 9191 -> []
"""

class Solution(object):
    def addOperators(self, num, target):
        """
        :type num: str
        :type target: int
        :rtype: List[str]
        """
        container = []
        if num[0] == '0':
            self.solve(num[0], num[1:], [nums[0]], container, target)
        else:
            for i in xrange(1, len(num) + 1):
                self.solve(num[:i], num[i:], [nums[:i]], container, target)

        self.solve()


def main():
    sol = Solution()
    print sol.addOperators('123', 6)


if __name__ == '__main__':
    main()

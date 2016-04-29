"""Expression ad operators
leetcode

Given a string that contains only digits 0-9 and a target value, return all
possibilities to add binary operators (not unary) +, -, or * between the digits
so they evaluate to the target value.

Examples:
"123", 6 -> ["1+2+3", "1*2*3"]
"232", 8 -> ["2*3+2", "2+3*2"]
"105", 5 -> ["1*0+5","10-5"]
"00", 0 ->  ["0+0", "0-0", "0*0"]
"3456237490", 9191 -> []
"""



class Solution(object):

    def addOperators(self, num, target):
        """DP.

        :type num: str
        :type target: int
        :rtype: List[str]
        """
        def dfs(num, i, last, acc, container, target):
            if i == len(num):
                if target == 0:
                    container.append(''.join(acc))
                return

            for j in xrange(i, len(num) + 1):
                next_num = num[i:j]
                if j == 1 or num[j] != "0"): # prevent "00*" as a number
                    acc.append('+')
                    acc.append(val)
                    dfs(num[i:], i, acc, int(val), container, target - int(val))
                    acc.pop()
                    acc.pop()

                    acc.append('-')
                    acc.append(val)
                    dfs(num[i:], i, acc, -int(val), container, target + int(val))
                    acc.pop()
                    acc.pop()

                    acc.append('*')
                    acc.append(val)
                    dfs(num[i:], i, acc, last*int(val), container, target + last - last * int(val))
                    acc.pop()
                    acc.pop()

        container = []
        for i in xrange(len(num) + 1):
            dfs(num, i, num[:i], [num[:i]], container, target)
        return container


def main():
    sol = Solution()
    print sol.addOperators("1051", 6)


if __name__ == '__main__':
    main()

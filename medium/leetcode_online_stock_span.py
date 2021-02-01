# https://leetcode.com/problems/online-stock-span/


class StockSpanner:
    def __init__(self):
        self.stack = []

    def next(self, price):
        stack = self.stack
        res = 1
        while stack and stack[-1][0] <= price:
            res += stack.pop()[1]
        stack.append([price, res])
        return res

# More Good Stack Problems
# Here are some problems that impressed me.
# Good luck and have fun.
#
# 1130. Minimum Cost Tree From Leaf Values
# 907. Sum of Subarray Minimums
# 901. Online Stock Span
# 856. Score of Parentheses
# 503. Next Greater Element II
# 496. Next Greater Element I
# 84. Largest Rectangle in Histogram
# 42. Trapping Rain Water


# Your StockSpanner object will be instantiated and called as such:
# obj = StockSpanner()
# prices = [[100],[80],[60],[70],[60],[75],[85]]
# for price in prices:
#    print(price, obj.next(price))

obj = StockSpanner()
prices = [[31],[41],[48],[59],[79]]
for price in prices:
    print(price, obj.next(price))

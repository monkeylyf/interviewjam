"""Candy
leetcode

There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?
"""


class Solution(object):
    def candy(self, ratings):
        """
        :type ratings: List[int]
        :rtype: int
        """
        acc = 0
        n = len(ratings)
        candies = [0] * n
        for i in xrange(1, n):
            if ratings[i - 1] < ratings[i]:
                acc += 1
            else:
                acc = 0
            candies[i] = acc

        acc = 0
        for i in reversed(xrange(n - 1)):
            if ratings[i] > ratings[i + 1]:
                acc += 1
            else:
                acc = 0
            candies[i] = max(candies[i], acc)
        return sum(candies) + n


def main():
    sol = Solution()


if __name__ == '__main__':
    main()

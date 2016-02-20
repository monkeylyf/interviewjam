"""Find the celebrity

leetcode

Suppose you are at a party with n people (labeled from 0 to n - 1) and among
them, there may exist one celebrity. The definition of a celebrity is that all
the other n - 1 people know him/her but he/she does not know any of them.

Now you want to find out who the celebrity is or verify that there is not one.
The only thing you are allowed to do is to ask questions like: "Hi, A. Do you
know B?" to get information of whether A knows B. You need to find out the
celebrity (or verify there is not one) by asking as few questions as possible
(in the asymptotic sense).

You are given a helper function bool knows(a, b) which tells you whether A
knows B. Implement a function int findCelebrity(n), your function should
minimize the number of calls to knows.

Note: There will be exactly one celebrity if he/she is in the party. Return the
celebrity's label if there is a celebrity in the party. If there is no
celebrity, return -1.
"""


def knows(a, b):
    """The knows API is already defined for you.

    @param a, person a
    @param b, person b
    @return a boolean, whether a knows b
    """
    return True


class Solution(object):

    def findCelebrityWithExtraSpace(self, n):
        """
        :type n: int
        :rtype: int
        """
        stack = range(n)

        while len(stack) >= 2:
            a = stack[-1]
            b = stack[-2]
            a_knows_b = knows(a, b)
            b_knows_a = knows(b, a)
            if a_knows_b and not b_knows_a:
                # a is not celebrity.
                stack.pop()
            elif not a_knows_b and b_knows_a:
                # b is not celebrity.
                stack[-2] = a
                stack.pop()
            else:
                # Neither a nor b is celebrity.
                stack.pop()
                stack.pop()
        if not stack:
            return -1
        else:
            # Note that when reach here, we have a potential celebrity.
            potential_celebrity = stack[0]
            for i in xrange(n):
                if i != potential_celebrity and knows(potential_celebrity, i):
                    return -1
            return potential_celebrity

    def findCelebrity(self, n):
        """"""
        candidate = 0
        for i in xrange(1, n):
            if knows(candidate, i):
                # Disqualified and change candidate.
                i = candidate

        for i in xrange(n):
            if i != candidate and \
               (knows(candidate, i) or not knows(i, candidate)):
                # Candidate knows no one and everyone must know candiate
                return -1

        return candidate

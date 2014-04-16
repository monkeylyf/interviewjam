"""facebook_Longest_Increasing_Subsequence
facebook

Given a sequence of distinct integers, your program must remove as few 
elements as possible in order for the elements which are not removed to 
appear in ascending order.  If there is more than one way to do this, your 
program must print one solution, then print the number of all solutions.

Example.

Given   1 2 3 8 10 5 6 7 12 9 11 4 0 
Remove        8 10       12      4 0 
Remain  1 2 3      5 6 7    9 11       (ascending)
"""



class Solution:
    
    def solve(self, arr):
        n = len(arr)

        trace = [ [] ] * n
        dp = [ 0 ] * n
        dp[0] = 1

        local_max = 0
        max_index = 0

        for i in xrange(1, n):
            prev = []
            for j in xrange(i):
                if arr[i] <= arr[j]:
                    continue
                if dp[j] < dp[i]:
                    continue

                if dp[j] > dp[i]:
                    prev = [j]
                    dp[i] = dp[j]
                else :
                    prev.append(j)
                    dp[i] = dp[j]

            trace[i] = prev

            dp[i] += 1
            if local_max < dp[i]:
                local_max = dp[i]
                max_index = i
        #print dp
        #print local_max
        #print max_index
        #print trace
        container = []
        self.dfs(trace, max_index, local_max, arr, [arr[max_index]], container)
        return container

    def dfs(self, trace, prev, local_max, arr, acc, container):
        if len(acc) == local_max:
            container.append(acc[::-1])
        else:
            for idx in trace[prev]:
                self.dfs(trace, idx, local_max, arr, acc + [arr[idx]], container) 
        

    def run(self):
        print self.solve([1, 2, 3, 8, 10, 5, 6, 7, 12, 9, 11, 4, 0])
        print self.solve([0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15])
        print self.LIS([1, 2, 3, 8, 10, 5, 6, 7, 12, 9, 11, 4, 0])

    def LIS(self, arr):
        """O(nlgn)"""
        n = len(arr)
        # M[i] = k means the index of smallest last element of LIS with length i
        M = [ 0 ] * (n + 1) # None zero-based
        # P[i] = k means the idex of the predecessor of arr[k] in the LIS ending at arr[i]
        P = [ 0 ] * n

        local_max = 0

        for i in xrange(n):
            head = 1
            tail = local_max

            while head <= tail:
                mid = head + (tail - head) / 2
                if arr[M[mid]] < arr[i]:
                    head = mid + 1
                else:
                    tail = mid - 1

            new_max = head
            P[i] = M[new_max - 1]

            if new_max > local_max:
                M[new_max] = i
                local_max = new_max
            elif arr[i] < arr[M[new_max]]:
                M[new_max] = i

        S = [ None ] * local_max
        k = M[local_max]

        for i in reversed(xrange(local_max)):
            S[i] = arr[k]
            k = P[k]

        print M
        print P

        return S


def main():
    Solution().run()


if __name__ == '__main__':
    main()

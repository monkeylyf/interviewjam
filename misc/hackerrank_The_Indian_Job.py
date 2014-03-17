# hackerrank_The_Indian_Job
#
# https://www.hackerrank.com/contests/mar14/challenges/the-indian-job

def solve(G, arr):
    """Greedy does not work. Recursive way to try out all possibilities."""
    # Nested function
    def dfs(idx, primary, secondary):
        if idx == len(arr):
            return True
        else:
            if arr[idx] <= primary:
                if dfs(idx + 1, primary - arr[idx], secondary):
                    return True
            if arr[idx] <= secondary:
                if dfs(idx + 1, primary, secondary - arr[idx]):
                    return True
            return  False

    if sum(arr) > 2 * G:
        return False
    
    primary = secondary = G
    
    #arr = sorted(arr, reverse=True)

    if primary < arr[0]:
        return False

    primary -= arr[0]
    
    return dfs(1, primary, secondary)


def dp(G, arr):
    """DP"""
    s = sum(arr)

    # dp state.
    dp = [ False for _ in xrange(s + 1) ]
    dp[0] = True

    upbound = 0

    # Backpack problem.
    for i in arr:
        # Don't miss the reversed here! Otherwise some item might be used more than one
        for j in reversed(xrange(upbound + 1)):
            if dp[j]:
                dp[j + i] = True
                upbound = max(upbound, i + j)

    for i in xrange(upbound + 1):
        # union of [s - G, G] and [0, upbound + 1] should be [s - G, min(G, upbound) + 1]
        if i <= G and s - i <= G and dp[i] and dp[s - i]:
            return True

    return False
  
  
def main():
    T = int(raw_input())
    for _ in xrange(T):
        (N, G) = map(int, raw_input().split())
        arr = map(int, raw_input().split())
        if solve(G, arr):
            print 'YES'
        else:
            print 'NO'
        
        
if __name__ == '__main__':
    main()

# https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string

class Solution:
    def removeDuplicates(self, S: str) -> str:
        stack = []
        for c in S:
            if stack and c == stack[-1]:
                stack.pop()
            else:
                stack.append(c)

        return ''.join(stack)

    def removeDuplicatesNotSoGood(self, S: str) -> str:
        isRemoved = True
        n = len(S)
        index = set(range(n))
        while isRemoved and index:
            isRemoved = False
            i = 0
            while i < n - 1:
                while i <n - 1:
                    if i in index:
                        break
                    i += 1
                j = i + 1
                while j <n - 1:
                    if j in index:
                        break
                    j += 1
                if i >= n or j >= n:
                    break
                ## print(i, j)
                if S[i] == S[j]:
                    index.remove(i)
                    index.remove(j)
                    isRemoved = True
                    i = j + 1
                else:
                    i = j
        return ''.join(val for (i, val) in enumerate(S) if i in index)

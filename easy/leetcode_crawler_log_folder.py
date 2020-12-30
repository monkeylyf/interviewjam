# https://leetcode.com/problems/crawler-log-folder/


class Solution:
    def minOperations(self, logs: List[str]) -> int:
        stack = []                    
        for log in logs:
            if log == './':
                continue
            elif log == '../':
                if stack:
                    stack.pop()
            else:
                stack.append(log)
        return len(stack)

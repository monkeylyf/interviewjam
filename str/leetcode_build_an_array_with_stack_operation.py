# https://leetcode.com/problems/build-an-array-with-stack-operations

class Solution:
    def buildArray(self, target: List[int], n: int) -> List[str]:
        ops = []
        for (i, val) in enumerate(target):
            if i == 0:
                skipped = val - 1
            else:
                skipped = val - target[i - 1] - 1
            if skipped > 0:
                for _ in range(skipped):
                    ops.extend(["Push", "Pop"])
            ops.append("Push")
        return ops

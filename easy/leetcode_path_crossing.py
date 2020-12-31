# https://leetcode.com/problems/path-crossing/

class Solution:
    def isPathCrossing(self, path: str) -> bool:
        i = 0
        j = 0
        visited = {(0, 0)}
        for d in path:
            if d == 'N':
                i += 1
            elif d == 'E':
                j += 1
            elif d == 'S':
                i -= 1
            else:
                # W
                j -= 1
            p = (i, j)
            if p in visited:
                return True
            visited.add(p)
        return False


def main():
    sol = Solution()
    print(sol.isPathCrossing('NESWW'))


if __name__ == '__main__':
    main()

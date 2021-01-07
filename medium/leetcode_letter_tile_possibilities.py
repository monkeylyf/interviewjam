# https://leetcode.com/problems/letter-tile-possibilities/

class Solution:
    def numTilePossibilities(self, tiles: str) -> int:
        container = set()
        self.rec(0, list(tiles), [], container, [False] * len(tiles))
        return len(container)

    def rec(self, i, tiles, acc, container, used):
        if acc:
            container.add(''.join(acc))
        if i == len(tiles):
            return

        for (j, is_used) in enumerate(used):
            if is_used is False:
                acc.append(tiles[j])
                used[j] = True
                self.rec(i + 1, tiles, acc, container, used)
                used[j] = False
                acc.pop()


def main():
    sol = Solution()
    print(sol.numTilePossibilities('AAB'))


if __name__ == '__main__':
    main()

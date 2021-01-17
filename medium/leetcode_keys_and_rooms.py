# https://leetcode.com/problems/keys-and-rooms/

from typing import List

class Solution:
    def canVisitAllRooms(self, rooms: List[List[int]]) -> bool:
        if not rooms:
            return False

        return self.dfs(0, rooms, len(rooms), set())

    def dfs(self, cur_room, rooms, n, visited):
        # You can visited rooms more than once.
        visited.add(cur_room)
        if len(visited) == n:
            return True

        for next_room in rooms[cur_room]:
            if next_room not in visited and self.dfs(next_room, rooms, n, visited):
                return True
        visited.add(cur_room)
        return False


def main():
    sol = Solution()
    print(sol.canVisitAllRooms([[1],[2],[3],[]]))
    print(sol.canVisitAllRooms([[1,3],[3,0,1],[2],[0]]))
    print(sol.canVisitAllRooms([[2,3],[],[2],[1,3,1]]))


if __name__ == '__main__':
    main()

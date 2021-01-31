# https://leetcode.com/problems/rank-teams-by-votes/

from typing import List

class Solution:
    def rankTeams(self, votes: List[str]) -> str:
        if not votes:
            return ''
        if len(votes) == 1:
            return votes[0]
        v = votes[0]
        n = len(votes[0])
        rank = {t: [0] * n for t in v}
        for vote in votes:
            for i, team in enumerate(vote):
                rank[team][i] -= 1
        rank = [(v, team) for team, v in rank.items()]
        rank.sort()
        return ''.join(r[-1] for r in rank)


def main():
    sol = Solution()
    votes = ["ABC","ACB","ABC","ACB","ACB"]
    print(sol.rankTeams(votes))

    votes = ["WXYZ","XYZW"]
    print(sol.rankTeams(votes))

    votes = ["ZMNAGUEDSJYLBOPHRQICWFXTVK"]
    print(sol.rankTeams(votes))

    votes = ["BCA","CAB","CBA","ABC","ACB","BAC"]
    print(sol.rankTeams(votes))

if __name__ == '__main__':
    main()

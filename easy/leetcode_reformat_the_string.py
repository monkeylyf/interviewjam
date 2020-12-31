# https://leetcode.com/problems/reformat-the-string/

class Solution:
    def reformat(self, s: str) -> str:
        numeric = [c for c in s if c.isnumeric()]
        alphabet = [c for c in s if not c.isnumeric()]
        if abs(len(numeric) - len(alphabet)) > 1:
            return []

        res = []
        if len(numeric) >= len(alphabet):
            i = 0
            while i < len(alphabet):
                res.append(numeric[i])
                res.append(alphabet[i])
                i += 1
            if i < len(numeric):
                res.append(numeric[i])
        else:
            j = 0
            while j < len(alphabet):
                res.append(alphabet[j])
                res.append(numeric[j])
                j += 1


        return ''.join(res)


def main():
    sol = Solution()
    print(sol.reformat('a0b1c2'))


if __name__ == '__main__':
    main()

# https://leetcode.com/problems/find-duplicate-file-in-system/

from typing import List

class Solution:
    def findDuplicate(self, paths: List[str]) -> List[List[str]]:
        by_content = {}
        for path in paths:
            tokens = path.split()
            directory = tokens[0]
            i = 1
            n = len(tokens)
            while i < n:
                file_content = tokens[i]
                i += 1
                index = file_content.find('(')
                filename = file_content[:index]
                content = file_content[index + 1: -1]
                full_filename = f'{directory}/{filename}'

                dirs = by_content.get(content)
                if dirs is None:
                    by_content[content] = [full_filename]
                else:
                    dirs.append(full_filename)
        return [dirs for dirs in by_content.values() if len(dirs) > 1]


def main():
    sol = Solution()
    paths = ["root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"]
    print(sol.findDuplicate(paths))


if __name__ == '__main__':
    main()

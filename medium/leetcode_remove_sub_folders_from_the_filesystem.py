# https://leetcode.com/problems/remove-sub-folders-from-the-filesystem/

from typing import List

class Solution:
    def removeSubfolders(self, folder: List[str]) -> List[str]:
        # Prefix tree.
        if not folder:
            return folder

        folder.sort()
        mapping = {}
        for f in folder:
            if f == '/':
                # Root direct then all the rest are subfolders.
                return [f]

            tokens = f.split('/')
            m = mapping
            n = len(tokens)
            for i, t in enumerate(tokens):
                if i == 0:
                    continue
                child = m.get(t)
                if child is None:
                    child_mapping = {}
                    m[t] = (i == n - 1, child_mapping)
                else:
                    is_folder, child_mapping = child
                    if is_folder:
                        break
                m = child_mapping

        folders = []
        for a, (_, b) in mapping.items():
            self.collect(a, b, folders, [a])
        return folders

    def collect(self, cur, child, folders, acc):
        if not child:
            folders.append('/' + '/'.join(acc))
            return

        for a, (_, b) in child.items():
            acc.append(a)
            self.collect(a, b, folders, acc)
            acc.pop()

    def removeSubfoldersSlow(self, folder: List[str]) -> List[str]:
        if not folder:
            return folder

        folder.sort()
        res = []
        for f in folder:
            for short in res:
                if f.startswith(short) and f[len(short)] == '/':
                    break
            else:
                res.append(f)
        return res


def main():
    sol = Solution()
    folder = ["/a","/a/b","/c/d","/c/d/e","/c/f"]
    print(sol.removeSubfolders(folder))
    print(sol.removeSubfolders(["/a","/a/b/c","/a/b/d"]))
    print(sol.removeSubfolders(["/a/b/c","/a/b/ca","/a/b/d"]))


if __name__ == '__main__':
    main()

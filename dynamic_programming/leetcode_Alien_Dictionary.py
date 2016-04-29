from collections import deque

class Solution(object):
    def alienOrder(self, words):
        """
        :type words: List[str]
        :rtype: str
        """
        chars = set()
        for word in words:
            for c in word:
                chars.add(c)

        out_degree = {c: set() for c in chars}
        in_degree = {c: set() for c in chars}
        visited = {c: False for c in chars}

        i = 0
        while i < len(words) - 1:
            cur_word = words[i]
            next_word = words[i + 1]

            if cur_word and next_word and cur_word[0] != next_word[0]:
                out_degree[next_word[0]].add(cur_word[0])
                in_degree[cur_word[0]].add(next_word[0])

            min_length = min(len(cur_word), len(next_word))
            j = 0
            while j < min_length - 1:
                cur_a = cur_word[j]
                cur_b = cur_word[j + 1]
                next_a = next_word[j]
                next_b = next_word[j + 1]

                if cur_a != next_a:
                    out_degree[next_a].add(cur_a)
                    in_degree[cur_a].add(next_a)
                elif cur_b != next_b:
                    out_degree[next_b].add(cur_b)
                    in_degree[cur_b].add(next_b)
                else:
                    pass
                j += 1
            i += 1

        queue = deque()
        for node, indgr in in_degree.iteritems():
            if len(indgr) == 0:
                queue.append(node)

        order = []
        while queue:
            node = queue.popleft()
            order.append(node)
            for neighbor in out_degree[node]:
                in_degree[neighbor].remove(node)
                if len(in_degree[neighbor]) == 0:
                    queue.append(neighbor)


        print in_degree.values()
        if any(in_degree.values()):
            return ''
        else:
            return ''.join(reversed(order))


def main():
    sol = Solution()
    #assert sol.alienOrder(["wrt", "wrf", "er", "ett", "rftt"]) == 'wertf'
    #assert sol.alienOrder(['z', 'x']) == 'zx'
    #print sol.alienOrder(["zy","zx"])
    #print sol.alienOrder(["ri","xz","qxf","jhsguaw","dztqrbwbm","dhdqfb","jdv","fcgfsilnb","ooby"])
    print sol.alienOrder(["ndwkkqrba","qmewabzvqa","boau","ixxzpijax","sdsszrbi","hvqdad","opbippqgz","ft","w"])


if __name__ == '__main__':
    main()

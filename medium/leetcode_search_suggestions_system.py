# https://leetcode.com/problems/search-suggestions-system/submissions/

class Solution:
    def suggestedProducts(self, products: List[str], searchWord: str) -> List[List[str]]:
        # Or build a prefix trie.
        products.sort()
        res = []
        for i in range(1, len(searchWord) + 1):
            prefix = searchWord[:i]
            res.append([w for w in products if w.startswith(prefix)][:3])

        return res

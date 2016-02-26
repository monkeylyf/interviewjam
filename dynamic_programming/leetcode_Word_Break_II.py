"""leetcode_Word_Break_II.py
leetcode

Given a string s and a dictionary of words dict, add spaces in s to construct a
sentence where each word is a valid dictionary word.

Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].

A solution is ["cats and dog", "cat sand dog"].
"""


class Solution:

    def wordBreak(self, s, dikt):
        """trace records the start/stop index of all words in dikt.
        When it ready, this question turns to be finding all path in graph.

        1. Scan all substring s[i:] first to see if they are in dikt.
        2. Continue scan backwards. if s[i:] in dikt, check all s[j:i]
        Basically it's backwards dp to track the start/end index of substr
        in dikt.
        """
        n = len(s)
        trace = [None] * n
        for tail in reversed(xrange(n + 1)):
            if tail == n or trace[tail]:
                for head in reversed(xrange(tail)):
                    if s[head:tail] in dikt:
                        try:
                            trace[head].append(tail)
                        except AttributeError:
                            trace[head] = [tail]

        container = []
        self.dfs(0, trace, [], container, s)
        return container

    def dfs(self, idx, trace, acc, container, s):
        """Given the trace, dfs to collect all possible results."""
        if trace[idx] is None:
            return
        for tail in trace[idx]:
            substr = s[idx:tail]
            acc.append(substr)
            if tail == len(s):
                container.append(' '.join(acc))
            else:
                self.dfs(tail, trace, acc, container, s)
            acc.pop()


def main():
    sol = Solution()
    print sol.wordBreak(
        'catsanddog',
        set(['cat', 'cats', 'and', 'sand', 'dog'])
    )


if __name__ == '__main__':
    main()


""" Java Version


class Solution {
  public ArrayList<String> wordBreak(String s, Set<String> dikt) {
    List<List<Integer>> trace = new ArrayList<ArrayList<Integer>>();
    for (int i = 0; i < s.length(); ++i) {
      trace.add(new ArrayList<Integer>());
    }

    for (int tail = s.length(); tail >= 0; --tail) {
      if (tail < s.length() && trace.get(tail).isEmpty()) { continue; }
      for (int head = tail - 1; head >= 0; --head) {
        if (dikt.contains(s.substring(head, tail))) {
          trace.get(head).add(tail);
        }
      }
    }

    List<String> container = new ArrayList<String>();
    dfs(trace, "", 0, container, s);
    return container;
  }

  private void dfs(List<List<Integer>> trace, String acc, int head,
                   List<String> container, String s) {
    if (head == s.length()) {
      container.add(acc);
    } else {
      for (int tail : trace.get(head)) {
        String sub = s.substring(head, tail);
        dfs(trace, (head == 0) ? sub : acc + " " + sub, tail, container, s);
      }
    }
  }
}
"""

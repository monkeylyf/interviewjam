# leetcode_Word_Break_II


class Solution:
    # @param s, a string
    # @param dict, a set of string
    # @return a list of strings
    def wordBreak(self, s, dict):
        # Nested function
        def dfs(idx, acc):
            """Given the trace, dfs to collect all possible results."""
            for tail in trace[idx]:
                substr = s[idx : tail]
                new_acc = acc + (substr if idx == 0 else ' ' + substr)
                if tail == len(s):
                    container.append(new_acc)
                else:
                    dfs(tail, new_acc)

        # trace records the start/stop index of all words in dict.
        trace = [ [] for _ in xrange(len(s)) ]
        
        # 1. Scan all substring s[i:] first to see if they are in dict.
        # 2. Continue scan backwards. if s[i:] in dict, check all s[j:i]
        # Basically it's backwards dp to track the start/end index of substr in dict.
        for tail in reversed(xrange(len(s) + 1)):
            if tail < len(s) and not trace[tail]:
                continue
            for head in reversed(xrange(tail)):
                if s[head : tail] in dict:
                    trace[head].append(tail)

        container = []
        dfs(0, '')
        return container

    def run(self):
        print self.wordBreak('catsanddog', set(['cat', 'cats', 'and', 'sand', 'dog']))


def main():
    Solution().run()


if __name__ == '__main__':
    main()


""" Java Version


class Solution {
  public ArrayList<String> wordBreak(String s, Set<String> dict) {
    ArrayList<ArrayList<Integer>> trace = new ArrayList<ArrayList<Integer>>();
    for (int i = 0; i < s.length(); ++i) {
      trace.add(new ArrayList<Integer>());
    }
    
    for (int tail = s.length(); tail >= 0; --tail) {
      if (tail < s.length() && trace.get(tail).isEmpty()) { continue; }
      for (int head = tail - 1; head >= 0; --head) {
        if (dict.contains(s.substring(head, tail))) {
          trace.get(head).add(tail);
        }
      }
    }

    ArrayList<String> container = new ArrayList<String>();
    dfs(trace, "", 0, container, s);
    return container;
  }
    
  public void dfs(ArrayList<ArrayList<Integer>> trace, String acc, int head, ArrayList<String> container, String s) {
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



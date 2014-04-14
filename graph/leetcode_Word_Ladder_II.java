/*Word_Ladder_II

Given two words (start and end), and a dictionary, find all shortest
transformation sequence(s) from start to end, such that:
Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
For example,

Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
Return
  [
  ["hit","hot","dot","dog","cog"],
  ["hit","hot","lot","log","cog"]
  ]
 */


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Iterator;


public class leetcode_Word_Ladder_II {

  public static void main(String[] args) {
	leetcode_Word_Ladder_II instance = new leetcode_Word_Ladder_II();
	instance.solve();
  }

  public void solve() {
	HashSet<String> dict1 = new HashSet<String>();
	Collections.addAll(dict1, "ted","tex","red","tax","tad","den","rex","pee");
	System.out.println(findLadders("red", "tax", dict1));
	HashSet<String> dict2 = new HashSet<String>();
	Collections.addAll(dict2, "hot", "dot");
	System.out.println(findLadders("hot", "hot", dict2));
  }
  public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
	Queue<String> q = new LinkedList<String>();
	HashMap<String, ArrayList<String>> global = new HashMap<String, ArrayList<String>>();
	HashMap<String, ArrayList<String>> local = new HashMap<String, ArrayList<String>>();

	q.add(start);
	dict.add(end);

	boolean finished = false;

	char[] charPool = new char[26];
	for (int i = 'a'; i <= 'z'; ++i) {
	  charPool[i - 'a'] = (char) i;
	}

	int count = 1;

	while (!q.isEmpty()) {
	  String cur = q.poll();
	  for (String word : wordGen(cur, charPool, dict)) {
		if (word.equals(end) && !finished) {
		  finished = true;
		}

		// Create footprint.
		if (!global.containsKey(word)) {
		  ArrayList<String> localPath = local.get(word);
		  if (localPath == null) {
			localPath = new ArrayList<String>();
			q.add(word);
		  }
		  localPath.add(cur);
		  local.put(word, localPath);
		}
	  }

	  count -= 1;

	  if (count == 0) {
		count = q.size();
		global.putAll(local);

		if (finished) {
		  return collect(global, start, end);
		}

		local = new HashMap<String, ArrayList<String>>();
	  }
	}

	return new ArrayList<ArrayList<String>>();
  }

  private ArrayList<ArrayList<String>> collect(HashMap<String, ArrayList<String>> path, String start, String end) {
	ArrayList<ArrayList<String>> container = new ArrayList<ArrayList<String>>();
	ArrayList<String> acc = new ArrayList<String>();
	acc.add(end);
	dfs(start, end, container, acc, path);
	return container;
  }

  private void dfs(String start, String word, ArrayList<ArrayList<String>> container, ArrayList<String> acc, HashMap<String, ArrayList<String>> path) {
	if (word.equals(start)) {
	  ArrayList<String> sol = new ArrayList<String>();
	  for (int i = acc.size() - 1; i >= 0; --i) {
		sol.add(acc.get(i));
	  }
	  container.add(sol);
	} else {
	  for (String prevWord : path.get(word)) {
		acc.add(prevWord);
		dfs(start, prevWord, container, acc, path);
		acc.remove(acc.size() - 1);
	  }
	}
  }

  private ArrayList<String> wordGen(String word, char[] charPool, HashSet<String> dict) {
	ArrayList<String> container = new ArrayList<String>();
	char[] arr = word.toCharArray();
	for (int i = 0; i < arr.length; ++i) {
	  for (int j = 0; j < charPool.length; ++j) {
		if (arr[i] == charPool[j]) {
		  continue;
		}
		arr[i] = charPool[j];
		String newStr = new String(arr);
		if (dict.contains(newStr)) {
		  container.add(newStr);
		}
	  }
	  arr = word.toCharArray();
	}

	return container;
  }
}

/* Python Version (Compile Error. WTF?)

class Solution:
    # @param start, a string
    # @param end, a string
    # @param dict, a set of string
    # @return a list of lists of string
    def findLadders(self, start, end, dict):
        global_path = {}
        level_path = {}

        dict.add(end)

        pipe = [start]

        char_pool = [ chr(i) for i in xrange(97, 123) ]

        finished = False
        count = 1

        while pipe:
            w = pipe.pop(0)
            for next_word in self.nextTran(w, dict, char_pool):
                if next_word == end:
                    finished = True
                    try:
                        level_path[next_word].append(w)
                    except KeyError:
                        level_path[next_word] = [w]

                elif not next_word in global_path:
                    try:
                        level_path[next_word].append(w)
                    except KeyError:
                        level_path[next_word] = [w]
                    pipe.append(next_word)

            count -= 1
            if count == 0:
                count = len(pipe)
                for k, v in level_path.iteritems():
                    global_path[k] = v
                level_path = {}
                if finished:
                    break

        #print global_path
        if not global_path:
            return []
        else:
            return self.collect(global_path, end, start)

    def nextTran(self, word, dict, char_pool):
        """Generater."""
        for i in xrange(len(word)):
            for char in char_pool:
                if char == word[i]:
                    continue
                ns = word[:i] + char + word[i + 1:]
                if ns in dict:
                    yield ns

    def collect(self, global_path, end, start):
        def dfs(global_path, word, acc, container, start):
            if word == start:
                container.add(':'.join(acc[::-1]))
            else:
                for prev in global_path[word]:
                    acc.append(prev)
                    dfs(global_path, prev, acc, container, start)
                    acc.pop()

        container = set()
        dfs(global_path, end, [end], container, start)
        return [ token.split(':') for token in container ]
*/

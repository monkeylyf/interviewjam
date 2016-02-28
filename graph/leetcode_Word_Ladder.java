/**
 * Word_Ladder.
 *
 * Given two words (start and end), and a dictionary, find the length of shortest
 * transformation sequence from start to end, such that:
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 * For example,
 *
 * Given:
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 *
 * Note:
 * Return 0 if there is no such transformation sequence.
 */


import java.util.Collections;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;


public class leetcode_Word_Ladder {

  public static void main(String[] args) {
	HashSet<String> dict = new HashSet<String>();
	//Collections.addAll(dict, "hot","cog","dog","tot","hog","hop","pot","dot");
	Collections.addAll(dict, "hot", "dot", "dog", "lot", "log");
	//Collections.addAll(dict, "hot", "dot");
	System.out.println(ladderLength("hit", "cog", dict));
  }

  public static int ladderLength(String start, String end, HashSet<String> dict) {
	Queue<String> unvisited = new LinkedList<String>();
	HashSet<String> visited = new HashSet<String>();
	unvisited.add(start); // Init unvisited queue.
	visited.add(start);

	dict.add(end);

	int step = 2; // Unless there is no such transformation sequence at all which return 0, min step is two.
	int count = 1; // Counter for the number of unvisited node at next level.
	while (!unvisited.isEmpty()) {
	  String str = unvisited.remove();
	  for (String cur : generate(str, dict)) {
		if (cur.equals(end)) {
		  return step;
		}
		if (!visited.contains(cur)) {
		  unvisited.add(cur);
		  // Mark start as visited. If one of a string's one-char-diff strings
		  // equals it, make sure don't jump to it since we need the shortest
		  // path. no looping.
		  visited.add(cur);
		}
	  }
	  if (--count == 0) { // Done with the cur level.
		++step; // increment step.
		count = unvisited.size(); // Reset counter.
	  }
	}
	return 0;
  }

  public static Set<String> generate(String s, HashSet<String> dict) {
	Set<String> words = new HashSet<String>();
	for (int i = 0; i < s.length(); ++i){
	  for (char j = 'a'; j <= 'z'; ++j){
		char[] chs = s.toCharArray();
		if (chs[i] != j ){
		  chs[i] = j;
		  String ns = new String(chs);
		  if (dict.contains(ns))
			words.add(ns);
		}
	  }
	}

	return words;
  }
}

/* Python Version

def ladderLength(self, start, end, dict):
    pipe = [start]
    visited = set([start])

	# Pre-calc the char_pool instead of calcing it every time you call word_gen and
	# This optmization will help you pass OJ!
    char_pool = [ chr(j) for j in xrange(97, 123) ]

    dict.add(end)

    num_tran = 2
    count = 1

    while pipe:
        cur = pipe.pop(0)
        for ns in self.word_gen(cur, dict, char_pool):
            if ns == end:
                return num_tran
            elif not ns in visited:
                visited.add(ns)
                pipe.append(ns)

        count -= 1
        if count == 0:
            num_tran += 1
            count = len(pipe)

    return 0

def word_gen(self, word, dict, char_pool):
    for i in xrange(len(word)):
        for char in char_pool:
            if char == word[i]:
                continue
            ns = word[:i] + char + word[i + 1:]
            if ns in dict:
                yield ns

*/

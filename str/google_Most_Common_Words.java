/*Most_Common_Words
google

String a list of strings which are sentences.
For example,

This is a good day
This is a bad day
That was good day

Design an alogorithm which returns two sentences which has the most common words.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.HashMap;


public class google_Most_Common_Words {

  public static void main(String[] args) {
	List<String> input = new ArrayList<String>();
	Collections.addAll(input, "This is a darn good day", "This was a darn bad day", "That was darn good day", "This is not a good day");
	System.out.println(mostCommonWords(input));
  }

  public static List<String> mostCommonWords(List<String> sentences) {
	Map<String, List<Integer>> dict = new HashMap<String, List<Integer>>();

	int similarity = 0;
	int maxId1 = -1;
	int maxId2 = -1;

	for (int i = 0; i < sentences.size(); ++i) {
      String sentence = sentences.get(i);
	  // similarities[i] represent the similarities between cur sentence and ith
      // sentences.
      int[] similarities = new int[sentences.size()];
      Arrays.fill(similarities, 0);

	  int curMaxSimilarity = 0; // max similarity between cur sentence and others.
	  int curMaxId = -1; // the id of sentence which has the max similarity with cur sentence.

	  for (String word : sentence.split("\\s+")) {
		if (dict.containsKey(word)) {
		  List<Integer> indices = dict.get(word);
		  for (int indexOfSentence : indices) {
            ++similarities[indexOfSentence];
            // Update maxSimilarity stats after processed one word.
			if (similarities[indexOfSentence] > curMaxSimilarity) {
			  curMaxSimilarity = similarities[indexOfSentence];
			  curMaxId = indexOfSentence;
			}
		  }
		  indices.add(i); // Update word/index
		  dict.put(word, indices);
		} else {
          // Creating index. It's very much alike search engine indexing.
		  List<Integer> indices = new ArrayList<Integer>();
		  indices.add(i);
		  dict.put(word, indices);
		}
	  }
	  // Update global maxSimilarity after processed one sentence.
	  if (curMaxSimilarity > similarity) {
		similarity = curMaxSimilarity;
		maxId1 = curMaxId;
		maxId2 = i;
	  }
	}

	if (similarity != 0) {
      List<String> retval = new ArrayList<String>();
	  Collections.addAll(retval, sentences.get(maxId1), sentences.get(maxId2));
	  return retval;
	} else {
      return Collections.emptyList();
    }
  }
}

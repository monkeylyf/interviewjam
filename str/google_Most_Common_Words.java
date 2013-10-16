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
import java.util.Collections;
import java.util.HashSet;
import java.util.HashMap;


public class google_Most_Common_Words {

    public static void main(String[] args) {
        ArrayList<String> input = new ArrayList<String>();
        Collections.addAll(input, "This is a darn good day", "This was a darn bad day", "That was darn good day", "This is not a good day");
        System.out.println(mostCommonWords(input));
    }

    public static ArrayList<String> mostCommonWords(ArrayList<String> sentences) {
        ArrayList<String> retval = new ArrayList<String>();
        HashMap<String, ArrayList<Integer>> dict = new HashMap<String, ArrayList<Integer>>();
        int similarity = 0;
        int maxId1 = -1;
        int maxId2 = -1;
        for (int i = 0; i < sentences.size(); ++i) {
            // Key: index of sentence / Value: similarity.
            // counts represent the similarities between cur sentence and other sentences.
            HashMap<Integer, Integer> counts = new HashMap <Integer, Integer>();
            int curMaxSimilarity = 0; // max similarity between cur sentence and others.
            int curMaxId = -1; // the id of sentence which has the max similarity with cur sentence.
            for (String word : sentences.get(i).split(" ")) {
                if (dict.containsKey(word)) { // Word seen before.
                    ArrayList<Integer> indexes = dict.get(word); // Indexes of sentences cur word appeared.
                    for (int indexOfSentence : indexes) {
                        int curSimilarity = 0;
                        if (counts.containsKey(indexOfSentence)) {
                            // If some sentence is known for none-zero similarity, +1.
                            curSimilarity = counts.get(indexOfSentence);
                        }
                        counts.put(indexOfSentence, ++curSimilarity); // Hash index of that sentence and new similarity.
                        if (curSimilarity > curMaxSimilarity) { // Update maxSimilarity stats after processed one word.
                            curMaxSimilarity = curSimilarity;
                            curMaxId = indexOfSentence;
                        }
                    }
                    indexes.add(i); // Update word/index
                    dict.put(word, indexes);
                } else {
                    // Cur word is not hashed before. Create new hash entry.
                    ArrayList<Integer> tmp = new ArrayList<Integer>();
                    tmp.add(i);
                    dict.put(word, tmp);
                }
            }
            if (curMaxSimilarity > similarity) { // Update global maxSimilarity after processed one sentence.
                similarity = curMaxSimilarity;
                maxId1 = curMaxId;
                maxId2 = i;
            }
        }
        if (similarity != 0) {
            Collections.addAll(retval, sentences.get(maxId1), sentences.get(maxId2));
        }
        return retval;
    }
}

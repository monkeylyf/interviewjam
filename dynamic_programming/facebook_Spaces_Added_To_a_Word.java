/*Word breaking 
How many spaces can we add to a word such that: 
All subwords can be found within a given dictionary 

Example:
Give word "fireman" and dict = {
    a,
    an, 
    em, 
    fir, 
    fire, 
    ire, 
    ma,
    man,
}

fire man -> 2 words 
fir em an -> 3 words 
*/

import java.util.HashSet;
import java.util.Collections;


class facebook_Spaces_Added_To_a_Word{
    public static void main(String[] args) {
        HashSet<String> dict = new HashSet<String>();
        Collections.addAll(dict, "a", "an", "em", "fir", "fire", "ire", "ma", "man");
        //String[] dict = new String[] {"a", "an", "em", "fir", "fire", "ire", "ma", "man"};
        System.out.println(maxSpaces("fireman", dict));
    }
    public static int maxSpaces(String word, HashSet<String> dict) {
        // The idea behind this is bp-based.
        // First assume that all the string in dict can be found in given word.
        int[] status = new int[word.length() + 1]; // status[0] should be 0, which is default.
        for (int i = 0; i < word.length(); ++i) {
            for (int j = i; j >= 0; --j) {
                String substr = word.substring(j, i + 1);
                if (dict.contains(substr)) {
                    System.out.println(substr);
                    status[i + 1] = Math.max(status[i + 1], status[j] + 1); 
                }
            }
            for (int j = 0; j < status.length; ++j) System.out.print(status[j] + " ");
            System.out.println();
        }
        return 0;
    }
    static String segmentString(String s, Set<String> dict) {
        if (s == null || s.length() <= 1)
            return s;
        int n = s.length();
        ArrayList<String>[] arr = new ArrayList[n + 1];
        arr[0] = new ArrayList<String>();

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                String str = s.substring(j, i);
                if (dict.contains(str) &amp;&amp; arr[j] != null) {
                    if (arr[i] == null || arr[j].size() + 1 < arr[i].size()) {
                        ArrayList<String> newList = new ArrayList<String>(arr[j]);
                        newList.add(str);
                        arr[i] = newList;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        if (arr[n] != null) {
            for (String seg : arr[n]) {
                sb.append(seg + ' ');
            }

        return sb.toString();
        }
    }
}

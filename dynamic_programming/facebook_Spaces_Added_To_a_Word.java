/*Word breaking
* facebook
* 
* Some spaces can be added to a word such that: 
* All subwords can be found within a given dictionary.
* What's the min # of spaced needed to added into this word (or max)?
* 
* Example:
* Give word "fireman" and dict = {
*     a,
*     an, 
*     em, 
*     fir, 
*     fire, 
*     ire, 
*     ma,
*     man,
* }
* 
* fire man -> 2 words 
* fir em an -> 3 words 
* 
* TODO: FOLLOWUP:
* 1. What are all possible conbination of split words?
* 2. How many possible ways to split the words?
* 
* Peking2's blog: http://blog.sina.com.cn/s/blog_b9285de20101hrg7.html
*/

import java.util.*;


class facebook_Spaces_Added_To_a_Word{
    public static void main(String[] args) {
        HashSet<String> dict = new HashSet<String>();
        Collections.addAll(dict, "a", "an", "em", "fir", "fire", "ire", "ma", "man");
        //String[] dict = new String[] {"a", "an", "em", "fir", "fire", "ire", "ma", "man"};
        //System.out.println(maxSpaces("fireman", dict));
        System.out.println(minSpaces("fireman", dict));
    }

    public static int minSpaces(String word, HashSet<String> dict) {
		if (dict.contains(word)) {
			return 0;
		}
		int i, j, n = word.length();
        int[] dp = new int[n];
		Arrays.fill(dp, -1);
		for (i = 1; i <= n; ++i) {
			if (dict.contains(word.substring(0, i))) {
				dp[i - 1] = 0;
			} else {
				for (j = 1; j < i; ++j) {
					if (dict.contains(word.substring(j, i)) && dp[j - 1] != -1) {
						if (dp[i - 1] == -1) {
							dp[i - 1] = dp[j - 1] + 1;
						} else {
							dp[i - 1] = Math.min(dp[i - 1], dp[j - 1] + 1);
						}
					}
				}
			}
		}
        print(dp);
        return dp[n - 1];
    }

    public static int maxSpaces(String word, HashSet<String> dict) {
        // The idea behind this is bp-based.
        // First assume that all the string in dict can be found in given word.
		int i, j, n = word.length();
        int[] dp = new int[n + 1]; // dp[0] should be 0, which is default.
        String substr;
        for (i = 0; i < n; ++i) {
            // dp[i] represents the max spaces for substr(0,i+1)
            for (j = i; j >= 0; --j) {
                substr = word.substring(j, i + 1);
                if (dict.contains(substr)) {
                    System.out.println(substr);
                    dp[i + 1] = Math.max(dp[i + 1], dp[j] + 1); 
                }
            }
            print(dp);
        }
        return dp[n];
    }

    public static void print(int[] arr) {
        for (int j = 0; j < arr.length; ++j) System.out.print(arr[j] + " ");
        System.out.println();
    }
}

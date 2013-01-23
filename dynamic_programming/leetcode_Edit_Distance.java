/*Edit_Distance

Given two words word1 and word2, find the minimum number of steps required to
convert word1 to word2. (each operation is counted as 1 step.)
You have the following 3 operations permitted on a word:
a) Insert a character
b) Delete a character
c) Replace a character
*/


class leetcode_Edit_Distance {
    public static void main(String[] args) {
        System.out.println(computeLevenshteinDistance("horse", "ros"));
    }
    // Using int array to track the DP-based edit cost.
    public static int minDistance(String word1, String word2) {
        int[] mask = new int[word2.length() + 1];
        for (int i = 1; i <= word2.length(); ++i) mask[i] = i;
        for (int i = 1; i <= word1.length(); ++i) {
            int[] nextMask = new int[word2.length() + 1];
            nextMask[0] = i;
            for (int j = 1; j <= word2.length(); ++j) {
                int min = Math.min(Math.min(nextMask[j-1] + 1, mask[j] + 1),
                    mask[j-1] + (word1.charAt(i-1) == word2.charAt(j-1) ? 0 : 1));
                nextMask[j] = min;
            }
            mask = nextMask;
        }
        return mask[mask.length - 1];
    }
    // Using int matrix to track the DP-based edti cost.
    public static int computeLevenshteinDistance(String word1, String word2) {
        int[][] distance = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++) distance[i][0] = i;
        for (int j = 1; j <= word2.length(); j++) distance[0][j] = j;
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                distance[i][j] = minimum(distance[i-1][j] + 1,
                                         distance[i][j-1] + 1,
                                         distance[i-1][j-1] + ((word1.charAt(i-1) == word2.charAt(j-1)) ? 0 : 1));
                for (int h = 0; h <= word1.length(); ++h) {
                    for (int k = 0; k <= word2.length(); ++k) {
                        System.out.print(distance[h][k] + " ");
                    }
                    System.out.println("");
                }
                System.out.println("-----------");
            }
        }
        return distance[word1.length()][word2.length()];
    }
    public static int minimum(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }
}

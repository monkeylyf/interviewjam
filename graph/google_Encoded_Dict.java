/**
 * google_Encoded_Dict.
 * google
 *
 * All words in a dictionary are decoded by mapping one character to another.
 * It's strictly one-to-one mapping, which means no multiple characters are mapped
 * to the same char.
 * For example:
 *
 * cat
 * coffee
 * common
 *
 * After the encoding:
 *
 * dkc
 * dbhhzz
 * dbllbq
 *
 * And of course this dictionary is in lexicographical order.
 *
 * Try to decode the dictionary.
 */


import java.util.HashSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Stack;


public class google_Encoded_Dict {

  private static final int charNum = 26;

  public static void main(String[] args) {
    google_Encoded_Dict solution = new google_Encoded_Dict();
    solution.test();
  }

  public void test() {
    // Test case
    String[] dict = new String[] {"dkc", "dbhhzz", "dbllbq"};
    System.out.println("hello world");
    decode(dict);
  }

  public void decode(String[] dict) {
    int n = dict.length, index = 0, i;
    boolean printAll = true;
    char prev, cur;
    HashSet<String> relation = new HashSet<String>();
    while (printAll) {
      printAll = false;
      prev = '\0';
      for (i = 0; i < n; ++i) {
        if (index < dict[i].length()) {
          cur = dict[i].charAt(index);
          if (prev == '\0') {
            prev = cur;
          } else if (prev != cur) {
            // Build graph node
            relation.add(String.format("%s:%s", prev, cur));
            prev = cur;
          } else {
            // Keep looping.
            break;
          }
        }
        if (!printAll && dict[i].length() - 1 > index) {
          printAll = true;
        }
      }
      ++index;
    }
    int[][] graph = buildGraph(relation);
    topoSort(graph);
  }

  // Given the order relation, build graph.
  private int[][] buildGraph(Set<String> relation) {
    int[][] graph = new int[charNum][charNum];
    for (String str : relation) {
      String[] nodes = str.split(":");
      // a - 0, z - 25
      int v = nodes[0].charAt(0) - 'a';
      int t = nodes[1].charAt(0) - 'a';
      //System.out.println(String.format("%s %s", nodes[0], nodes[1]));
      graph[v][t] = 1;
    }

    System.out.println("hello world");
    printMatrix(graph);
    System.out.println("hello world");
    return graph;
  }

  // Topological Sorting.
  private void topoSort(int[][] graph) {
    Stack<Integer> s = new Stack<Integer>();
    boolean[] visited = new boolean[charNum];
    for (int i = charNum - 1; i >= 0; --i) {
      if (!visited[i]) {
        topoSortUtil(graph, i, visited, s);
      }
    }
    // stdout order.
    int i = 0;
    Map<Character, Character> encodingKey = new HashMap<Character, Character>();

    assert(s.size() == 26);

    while (!s.isEmpty()) {
      int num = s.pop();
      char encodedChar = (char) (num + 97);
      char decodedChar = (char) (i++ + 97);
      encodingKey.put(decodedChar, encodedChar);
    }

    System.out.println(encodingKey);
  }

  private static String[] decodeWithKey(String[] dict, HashMap<Character, Character> encodingKey) {
    //Given encoding mapping, decode the dicionary.
    // Decoding...
    return dict;
  }

  private void topoSortUtil(int[][] graph, int i, boolean[] visited, Stack<Integer> s) {
    visited[i] = true;

    for (int v = 0; v < charNum; ++v) {
      if (!visited[v] && graph[i][v] == 1) {
        topoSortUtil(graph, v, visited, s);
      }
    }
    s.push(i);
  }

  // Helper function to print.
  public void print(int[] arr) {
    for (int i : arr) System.out.print(i + " ");
    System.out.println();
  }

  public void printMatrix(int[][] matrix) {
    for (int[] arr : matrix) print(arr);
    System.out.println();
  }
}

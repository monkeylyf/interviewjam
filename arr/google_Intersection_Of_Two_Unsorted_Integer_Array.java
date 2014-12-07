/**
 * Intersection_Of_Two_Unsorted_Integer_Array.
 * google
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class google_Intersection_Of_Two_Unsorted_Integer_Array{

  public static void main(String[] args) {
    findIntersection(new int[] {14,56,2,78,90}, new int[] {15,10,56,36,2, 80,65});
  }

  public static List<Integer> findIntersection(int[] A, int[] B) {
    List<Integer> retval = new ArrayList<Integer>();
    Set<Integer> set = new HashSet<Integer>();
    for (int i : A) {
      set.add(i);
    }
    for (int i : B) {
      if (set.contains(i)) {
        retval.add(i);
      }
    }

    return retval;
  }
}

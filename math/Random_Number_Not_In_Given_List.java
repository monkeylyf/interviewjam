/**
 * Random_Number_Not_In_Given_List.
 *
 * Given a list of K distinct numbers in range [0, N] (inclusive, inclusive),
 * and a random generater that yields numbers in range [0, M] with uniform
 * distribution, where M is larger than N.
 *
 * Write a random geneartor that yields numbers that in range [0, N] but not
 * in given list with uniform distribution.
 *
 * Follow up: If the given list is sorted,
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;


public class Random_Number_Not_In_Given_List {

  public static void main(String[] args) {
    RandomGeneratorInterface gen = new RandomGenNotInList(new int[] {1, 2, 3, 6}, 8);
    System.out.println(sampler(10000, gen));
  }

  private static class RandomGenNotInList implements RandomGeneratorInterface {

    private final int[] list;
    private final int[] rest;
    private final int n;
    private final int threshold;
    private final int div;
    private final int size;
    private final RandomGeneratorInterface randM;

    public RandomGenNotInList(final int[] list, final int n) {
      this.list = list;
      this.rest = new int[n - list.length];
      this.n = n;
      this.randM = new RandM();

      // Calc re-toss threshold.
      this.size = this.n - list.length;
      this.div = this.randM.range() / size;
      this.threshold = this.div * size;

      populateRest();
      System.out.println(n);
      System.out.println(size);
      System.out.println(threshold);
    }

    private void populateRest() {
      Set<Integer> set = new HashSet<Integer>();
      for (int num : this.list) {
        set.add(num);
      }

      int i = 0;
      for (int j = 0; j < this.n; ++j) {
        if (!set.contains(j)) {
          this.rest[i] = j;
          i += 1;
        }
      }
    }

    @Override
    public int gen() {
      // Mapping rand M to rand N - K
      while (true) {
        int randNum = this.randM.gen(); // in range [1, M]
        if (randNum < this.threshold) {
          int index = randNum / this.div;
          return this.rest[index];
        }
      }
    }

    @Override
    public int range() { return this.n; }
  }

  /**
   * Random generater tester.
   */
  public static Map<Integer, Integer> sampler(int n, RandomGeneratorInterface rand) {
    Map<Integer, Integer> counter = new HashMap<Integer, Integer>();

    for (int i = 0; i < n; ++i) {
      int token = rand.gen();
      Integer count = counter.get(token);
      counter.put(token, (count == null) ? 1 : count + 1);
    }

    return counter;
  }

  private static class RandM implements RandomGeneratorInterface {

    private final int m;
    private final Random rand;

    public RandM() {
      this.m = 10;
      this.rand = new Random();
    }

    public int m() { return this.m; }

    @Override
    public int gen() { return this.rand.nextInt(this.m); }

    @Override
    public int range() { return this.m; }
  }

  private interface RandomGeneratorInterface {
    public int gen();

    public int range();
  }

}

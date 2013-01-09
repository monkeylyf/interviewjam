/*Permutations II

Given a collection of numbers that might contain duplicates, return all
possible unique permutations.
For example,
[1,1,2] have the following unique permutations:
[1,1,2], [1,2,1], and [2,1,1].
*/


import java.util.ArrayList;
import java.util.HashSet;


class leetcode_70 {
    public static void main(String[] args) {
        for (ArrayList<Integer> i : permuteUnique(new int [] {1, 1, 2})) System.out.println(i);
    }
    public static ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        HashSet<ArrayList<Integer>> all = new HashSet<ArrayList<Integer>>();
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        boolean[] used = new boolean[num.length];
        nextNum(num, used, tmp, all);
        return new ArrayList<ArrayList<Integer>>(all);
    }
    public static void nextNum(int[] num, boolean[] used, ArrayList<Integer> tmp, HashSet<ArrayList<Integer>> all) {
        if (tmp.size() == num.length) {
            ArrayList<Integer> res = new ArrayList<Integer>();
            for (int i : tmp) res.add(num[i]);
            all.add(res);
        } else {
            for (int i = 0; i < num.length; ++i) {
                if (!used[i]) {
                    tmp.add(i);
                    used[i] = true;
                    nextNum(num, used, tmp, all);
                    tmp.remove(tmp.size() - 1);
                    used[i] = false;
                }
            }
        }
    }
}

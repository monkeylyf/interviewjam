/*Knapsack

Classic dynamic programming example.

Given items weight [1, 2, 3, 4, ...n] (unit: kilogram), and given a knapsack which can hold only
k kilogram. How many ways are there to exactly fill your knapsack (weights of all items sumed up
to k)
*/

import java.util.ArrayList;
import java.util.Arrays;


class Knapsack{
    public static void main(String[] args) {
        //System.out.println(knapsack(new int[] {1,2,3,4,5}, 6));
        Knapsack(new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19}, 20);
    }
    public static int knapsack(int[] A, int k) {
        int[] track = new int[k + 1];
        track[0] = 1;
        int sum = 0;
        for (int i : A) {
            for (int j : track) System.out.print(j);
            System.out.println();
            int[] next = new int[k + 1];
            sum += i;
            for (int j = 0; j <= Math.min(k, sum); ++j) {
                next[j] = track[j] + ((j >= i) ? track[j - i] : 0);
            }
            track = next;
        }
        for (int j : track) System.out.print(j);
        System.out.println();
        return track[k];
    }
    public static ArrayList<ArrayList<Integer>> Knapsack(int[] A, int k) {
        ArrayList<ArrayList<Integer>> all = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        nextNum(A, k, all, tmp);
        for (ArrayList<Integer> i : all) System.out.println(i);
        return all;
    }
    public static void nextNum(int[] A, int k, ArrayList<ArrayList<Integer>> all, ArrayList<Integer> tmp) {
        if (k == 0) {
            ArrayList<Integer> answer = new ArrayList<Integer>();
            for (int i : tmp) {
                answer.add(i);
            }
            all.add(answer);
        } else if (k > 0 && A.length > 0){
            nextNum(Arrays.copyOfRange(A, 1, A.length), k, all, tmp);
            tmp.add(A[0]);
            nextNum(Arrays.copyOfRange(A, 1, A.length), k - A[0], all, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}

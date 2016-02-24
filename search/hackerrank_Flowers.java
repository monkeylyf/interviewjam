/*Flowers
hackerrank

You and your K-1 friends want to buy N flowers. Flower number i has cost ci.
Unfortunately the seller does not like a customer to buy a lot of flowers, so
he tries to change the price of flowers for customer who had bought flowers
before. More precisely if a customer has already bought x flowers, he should
pay (x+1)*ci dollars to buy flower number i.
You and your K-1 firends want to buy all N flowers in such a way that you spend
as less money as possible.

Input:

The first line of input contains two integers N and K (K <= N) next line contains
N positive integers c1,c2,…,cN respectively.

Output:

Print the minimum amount of money you (and your friends) have to pay in order
to buy all N flowers.

Sample input :

3 3
2 5 6

Sample output :

13

Constraint :

1 <= N, K  <= 100
Each ci is not more than 1000,000
*/

import java.util.*;


class Solution{
    public static void main( String args[] ){
    }
    public static void cost(int[] C, int N, int K) {
        // Using minHeap to split out batch with size K.
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(100, new minComparator());
        for (int i : C) {
            q.offer(i);
        }
        long sum = 0;
        int batch = 1;
        int count = 0;
        while (!q.isEmpty()) {
            int tmp = q.poll();
            //System.out.println(tmp + " " + batch);
            sum += batch * tmp;
            ++count;
            if (count == K) {
                ++batch;
                count = 0;
            }
        }
        System.out.println(sum);
    
    }
}


class minComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer a, Integer b) {
        if (a < b) return 1;
        if (a > b) return -1;
        return 0;
    }
}

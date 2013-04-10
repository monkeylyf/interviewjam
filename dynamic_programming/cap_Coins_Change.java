/*Coins_Change

Given an infinite number of quarters (25 cents), dimes (10 cents), nickels
(5 cents) and pennies (1 cent), write code to calculate the number of ways
of representing n cents.

dynamic programming:
C(n) = C(25 cents) + C(no 25 cents)
C(no 25 cents) = C(10 cents) + C(no 10 cents)
...
*/

class cap_Coins_Change {
    public static void main(String[] args) {
        System.out.println(my(100, new int[] {25, 10, 5, 1}));
    }
    public static int my(int val, int[] set) {
        // Dynamic programming based solution.
        // e.g. set[1, 2, 3], val = 4
        //     0   1    2    3    4
        // 1   1   1    1    1    1
        // 2   1   1   1+1  1+1  1+2 
        // 3   1   1    2   2+1  3+1
        // C(n, {1,2,3}) = C(n, {1,2}) + C(n - 3, {1, 2, 3})
        // Unbounded since number of coins are infinite.
        int[] table = new int[val + 1];
        table[0] = 1;
        for (int i : set) {
            for (int j = i; j <= val; ++j) {
                table[j] += table[j - i]; //C(j, {...i}) = C(j, {...}) + C{j - i, {...i}}
            }
        }
        return table[val];
    }
}

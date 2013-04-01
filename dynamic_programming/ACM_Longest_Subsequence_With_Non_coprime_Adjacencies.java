/*Longest_Subsequence_With_Non-coprime_Adjacencies
ACM
*/


class ACM_Longest_Subsequence_With_Non_coprime_Adjacencies {
    public static void main(String[] args) {
        int[] test = new int[] {2, 3, 4, 6, 9};
        System.out.println(longestNoncoprimeSubarray(test));
        int[] test1 = new int[] {1,2,3,4,5,6,7,8,9,10};
        System.out.println(longestNoncoprimeSubarray(test1));
    }
    public static int longestNoncoprimeSubarray(int[] A) {
        // The idea behind this is dp-based.
        // if element A[i] is in the subarray of A[0:i]. 
        // find the closest element A[j] which is non-prime with A[i].
        // else if element A[i] is not in the subarray of A[0:i].)
        // Breakint the problem into subproblem:
        // C[i] = Math.max(C[j] + 1, C[i - 1])
        if (A.length == 0) {
            return 0;
        }
        if (A.length == 1) {
            return 1;
        }
        int[] track = new int[A.length];
        track[0] = 1;
        for (int i = 1; i < A.length; ++i) {
            // Assume A[i] is in the subarray of A[0:i].
            for (int j = i - 1; j >= 0; --j) {
                if (!isCoprime(A[i], A[j])) {
                    // Found closest element A[j] which is non-coprime with A[i].
                    track[i] = track[j] + 1;
                    break;
                }
            }
            // Assume A[i] is not in the subarray of A[0:i]. track[i] = track[i - 1]
            // Take the larger one.
            track[i] = Math.max(track[i - 1], track[i]);
        }
        return track[A.length - 1];
    }
    public static boolean isCoprime(int a, int b) {
        for (int i = 2; i <= Math.min(a, b); ++i) {
            if (a % i == 0 && b % i == 0) {
                return false;
            }
        }
        return true;
    }

}

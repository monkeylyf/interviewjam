/*Max_Number_of_Cyclic_Automorphism

Given String A, we shift it by i times, where 0 <= i < A.length().
After shifting if the shifted string equals to original string, we
call it cylic automorphism.
For example, given string "abab"

0 shift: abab
1 shift: baba
2 shift: abab
3 shift: baba

Design an alogorithm to return the numbers of cyclic automorphism for given word
*/


class Max_Number_of_Cyclic_Automorphism {
    public static void main(String[] args) {
        System.out.println(kmp("byebye"));
        System.out.println(kmp("ababab"));
        System.out.println(kmp("aaaa"));
        System.out.println(cyclicAutomorphism("byebye"));
        System.out.println(cyclicAutomorphism("ababab"));
        System.out.println(cyclicAutomorphism("aaaa"));
    }
    public static int cyclicAutomorphism(String A) {
        // if such i exist beside i = 0.
        // 1. A.length() is even:
        // find the min i from 0 to A.length() that shifted is equal to original.
        // Because the original string and shitfted one is mismatched by i position.
        // then original string can be devided into i parts, and each part is equal.
        // 2. A.length() is odd.
        // Only if string is consists of one char. Otherwise there is no match
        // beside i = 0.
        int len = A.length();
        String temp = A + A;
        int i;
        for (i = 1; i < len; ++i) {
            if (len % i == 0 && temp.substring(i, i + len).equals(A)) {
                break;
            }
        }
        return len / i;
    }
    public static int kmp(String A) {
        // Since I just learnt KMP so trying to implement this with KMP
        // overlay function.
        int[] overlay = new int[A.length()];
        overlay[0] = -1;
        for (int i = 1; i < A.length(); ++i) {
            int index = overlay[i - 1];
            while (index >= 0 && A.charAt(index + 1) != A.charAt(i)) {
                index = overlay[index];
            }
            if (A.charAt(index + 1) == A.charAt(i)) {
                overlay[i] = index + 1;
            } else {
                overlay[i] = - 1;
            }
        }
        for (int i  = 0; i < A.length(); ++i) {
            System.out.println(A.substring(0, i + 1) + " " + overlay[i]);
        }
        int retval = overlay[overlay.length - 1];
        System.out.println("last index " + retval);
        while (A.length() % (A.length() - retval - 1) != 0) {
            retval = overlay[retval - 1];
        }
        return A.length() / (A.length() - retval - 1);
    }
}

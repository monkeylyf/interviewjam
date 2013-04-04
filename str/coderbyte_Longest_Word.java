/*Longest_Word
coderbyte

input: "i@(# love this shit"
output: "love"
*/


class coderbyte_Longest_Word {
    public static void main(String[] args) {
    }
    
    public static String LongestWord(String sen) { 
        char[] arr = sen.toCharArray();
        int head = 0, tail = 0, ascii;
        String ret = "";
        while (tail < arr.length) {
            ascii = (int)(arr[tail]);
            if ((ascii >= 65 && ascii <= 90) || (ascii >= 97 && ascii <= 122)) {
                // 'a'-'z' and'A'-'Z'.
                ++tail;
            } else {
                if (tail - head > ret.length()) {
                    // Update max.
                    ret = sen.substring(head, tail);
                }
                ++tail; 
                head = tail;
            }
        }
        // Check the last pair of head and tail.
        if (tail - head > ret.length()) {
            ret = sen.substring(head, tail);
        }
        return ret;
    }      
}

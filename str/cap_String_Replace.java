/*String_replace
careercup

Write a method to replace all spaces in a string with ‘%20’
*/

import java.util.*;

class cap_String_replace {
    public static void main(String[] args) {
        String str = "what the fuck ";
        String test1 = "whatthefuck";
        char[] cArray = str.toCharArray();
        ReplaceFun(cArray);
    }
    public static void ReplaceFun(char[] str) {
        int spaceCount = 0, length = str.length, newLength, i;
        for (char j : str) {
            if (j == ' ') {
                ++spaceCount;
            }
        }
        newLength = length + spaceCount * 2;
        char[] arr = new char[newLength + 1];
        arr[newLength] = '\0';
        for (i = length - 1; i >= 0; --i) {
            if (str[i] == ' ') {
                arr[newLength - 1] = '0';
                arr[newLength - 2] = '2';
                arr[newLength - 3] = '%';
                newLength = newLength - 3;
            } else {
                arr[newLength - 1] = str[i];
                newLength = newLength -1;
            }
        }
        System.out.println(new String(arr));
    }
}

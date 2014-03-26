/*Restore_IP_Addresses

Given a string containing only digits, restore it by returning all possible
valid IP address combinations.
For example:
Given "25525511135",
return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
*/


import java.util.ArrayList;


class leetcode_Restore_IP_Addresses {
    public static void main(String[] args) {
        restoreIpAddresses("0000");
        restoreIpAddresses("00");
    }
    public static ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> all = new ArrayList<String>();
        preDigit(s, "", 0, all);
        for (String i : all) System.out.println(i);
        return all;
    }
    public static void preDigit(String s, String partial, int count, ArrayList<String> all) {
        int len = s.length();
        if (count == 4 && len == 0) {
            all.add(partial.substring(1, partial.length())); // Use substring to remove the first dot.
        } else if (count == 4 && len > 0) {
            return; // Restored 4 numbers with unused numbers.
        } else {
            if (len >= 1) {
                // Take one digit.
                preDigit(s.substring(0, len - 1), '.' + s.substring(len - 1, len) + partial, count + 1, all);
            }
            if (len >= 2) {
                // Take two digits.
                if (s.charAt(len - 2) != '0') {
                    // First digit can be 0.
                    preDigit(s.substring(0, len - 2), '.' + s.substring(len - 2, len) + partial, count + 1, all);
                }
            }
            if (len >= 3) { 
                // Take two digits.
                if (s.charAt(len - 3) == '1' || s.charAt(len - 3) == '2' && Integer.parseInt(s.substring(len-3, len)) <= 255) {
                    // First digits must be either 1 or 2. And the val of three digits must be less than 256.
                    preDigit(s.substring(0, len - 3), '.' + s.substring(len - 3, len) + partial, count + 1, all);
                }
            }
        }
    }
}


/* Python Version
def restoreIpAddresses(self, s):
    def rec(idx, s, acc, container):
        if len(acc) == 4 and idx < len(s):
            return # Prune.
        elif idx == len(s) and len(acc) == 4:
            container.append('.'.join(acc))
        else:
            # Take one
            if idx <= len(s) - 1:
                num = int(s[idx])
                if num >= 0 and num <= 9:
                    acc.append(s[idx])
                    rec(idx + 1, s, acc, container)
                    acc.pop()
            
            # Take Two.
            if idx + 1 <= len(s) - 1:
                num = int(s[idx : idx + 2])
                if num >= 10 and num <= 99:
                    acc.append(s[idx : idx  + 2])
                    rec(idx + 2, s, acc, container)
                    acc.pop()
            # Take Three.
            if idx + 2 <= len(s) - 1:
                num = int(s[idx : idx + 3])
                if num >= 100 and num <= 255:
                    acc.append(s[idx : idx + 3])
                    rec(idx + 3, s, acc, container)
                    acc.pop()
        
    container = []
    rec(0, s, [], container)
    return container
*/

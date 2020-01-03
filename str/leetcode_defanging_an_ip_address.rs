/*Given a valid (IPv4) IP address, return a defanged version of that IP address.
A defanged IP address replaces every period "." with "[.]".

Example 1:

Input: address = "1.1.1.1"
Output: "1[.]1[.]1[.]1"
Example 2:

Input: address = "255.100.50.0"
Output: "255[.]100[.]50[.]0"


Constraints:

The given address is a valid IPv4 address.
*/

fn main() {
    let input = String::from("1.1.1.1");
    assert_eq!("1[.]1[.]1[.]1", Solution::defang_i_paddr(input));
}

struct Solution {
}

impl Solution {
    pub fn defang_i_paddr(address: String) -> String {
        return address.replace(".", "[.]")
    }
}
/*
class Solution:
    def defangIPaddr(self, address: str) -> str:
        import re
        # So real question is, which one is faster, re.sub or str.replace?
        # According to OJ, re.sub is faster a little bit but stackoverflow
        # says otherwise.
        return re.sub('\.', '[.]', address)
*/

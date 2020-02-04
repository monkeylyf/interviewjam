/**
 * Every email consists of a local name and a domain name, separated by the @
 * sign.
 *
 * For example, in alice@leetcode.com, alice is the local name, and leetcode.com
 * is the domain name.
 * Besides lowercase letters, these emails may contain '.'s or '+'s.
 * If you add periods ('.') between some characters in the local name part of an
 * email address, mail sent there will be forwarded to the same address without
 * dots in the local name.  For example, "alice.z@leetcode.com" and
 * "alicez@leetcode.com" forward to the same email address.  (Note that this
 * rule does not apply for domain names.)
 *
 * If you add a plus ('+') in the local name, everything after the first plus
 * sign will be ignored. This allows certain emails to be filtered, for example
 * m.y+name@email.com will be forwarded to my@email.com.  (Again, this rule does
 * not apply for domain names.)
 *
 * It is possible to use both of these rules at the same time.
 *
 * Given a list of emails, we send one email to each address in the list. How
 * many different addresses actually receive mails?
 *
 * Example 1:
 * Input: ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com",
 * "testemail+david@lee.tcode.com"]
 * Output: 2
 * Explanation: "testemail@leetcode.com" and "testemail@lee.tcode.com" actually
 * receive mails
 */

use std::collections::HashSet;

fn main() {
    let input1: Vec<String> = vec![
        "test.email+alex@leetcode.com".to_string(),
        "testemail+david@lee.tcode.com".to_string(),
        "test.e.mail+bob.cathy@leetcode.com".to_string()];
    assert_eq!(2, Solution::num_unique_emails(input1));
}

struct Solution {
}

impl Solution {
    pub fn num_unique_emails(emails: Vec<String>) -> i32 {
        let set: HashSet<String> = emails.iter()
            .map(|e| Solution::normailize(&e))
            .collect();
        return set.len() as i32;
    }

    fn normailize(email: &str) -> String {
        let mut chars: Vec<char> = vec![];
        let mut seen_at: bool = false;
        let mut seen_plus: bool = false;
        for c in email.chars() {
            if c == '@' {
                seen_at = true;
                chars.push(c);
            } else if seen_at {
                chars.push(c);
            } else if seen_plus {
                continue;
            } else if c == '.' {
                continue;
            } else if c == '+' {
                seen_plus = true;
            } else {
                chars.push(c);
            }
        }
        return chars.iter().collect();
    }
}

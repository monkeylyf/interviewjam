/**
 * A website domain like "discuss.leetcode.com" consists of various subdomains.
 * At the top level, we have "com", at the next level, we have "leetcode.com",
 * and at the lowest level, "discuss.leetcode.com". When we visit a domain like
 * "discuss.leetcode.com", we will also visit the parent domains "leetcode.com"
 * and "com" implicitly.
 *
 * Now, call a "count-paired domain" to be a count (representing the number of
 * visits this domain received), followed by a space, followed by the address.
 * An example of a count-paired domain might be "9001 discuss.leetcode.com".
 *
 * We are given a list cpdomains of count-paired domains. We would like a list
 * of count-paired domains, (in the same format as the input, and in any order),
 * that explicitly counts the number of visits to each subdomain.
 *
 * Example 1:
 * Input:
 * ["9001 discuss.leetcode.com"]
 * Output:
 * ["9001 discuss.leetcode.com", "9001 leetcode.com", "9001 com"]
 * Explanation:
 * We only have one website domain: "discuss.leetcode.com". As discussed above,
 * the subdomain "leetcode.com" and "com" will also be visited. So they will all
 * be visited 9001 times.
 *
 * Example 2:
 * Input:
 * ["900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"]
 * Output:
 * ["901 mail.com","50 yahoo.com","900 google.mail.com","5 wiki.org","5 org",
 * "1 intel.mail.com","951 com"]
 * Explanation:
 * We will visit "google.mail.com" 900 times, "yahoo.com" 50 times,
 * "intel.mail.com" once and "wiki.org" 5 times. For the subdomains, we will
 * visit "mail.com" 900 + 1 = 901 times, "com" 900 + 50 + 1 = 951 times, and
 * "org" 5 times.
 *
 * Notes:
 * The length of cpdomains will not exceed 100.
 * The length of each domain name will not exceed 100.
 * Each address will have either 1 or 2 "." characters.
 * The input count in any count-paired domain will not exceed 10000.
 * The answer output can be returned in any order.
 */

use std::collections::HashMap;

fn main() {
    let input: Vec<String> = vec![
        "900 google.mail.com".to_string(),
        "50 yahoo.com".to_string(),
        "1 intel.mail.com".to_string(),
        "5 wiki.org".to_string(),
    ];
    assert_eq!(
        vec!["901 mail.com".to_string(),
        "50 yahoo.com".to_string(),
        "900 google.mail.com".to_string(),
        "5 wiki.org".to_string(),
        "5 org".to_string(),
        "1 intel.mail.com".to_string(),
        "951 com".to_string()],
        Solution::subdomain_visits(input));
}

struct Solution {}

impl Solution {
    pub fn subdomain_visits(cpdomains: Vec<String>) -> Vec<String> {
        let mut counter: HashMap<String, i32> = HashMap::new();
        for cpdomain in &cpdomains {
            let parsed: (i32, Vec<String>) = Solution::parse(cpdomain);
            let visit: i32 = parsed.0;
            let domains: Vec<String> = parsed.1;
            for domain in domains {
                *counter.entry(domain).or_insert(0) += visit;
            }
        }
        let res: Vec<String> = counter.iter().map(|x| format!("{} {}", x.1, x.0)).collect();
        return res;
    }

    fn parse(s: &str) -> (i32, Vec<String>) {
        let tokens: Vec<&str> = s.split(' ').into_iter().collect();
        let visit: i32 = tokens[0].parse().unwrap();
        let cpdomain: &str = tokens[1];
        let mut domains: Vec<String> = vec![cpdomain.to_string()];
        for (i, c) in cpdomain.chars().enumerate() {
            if c == '.' {
                domains.push(cpdomain[i + 1..cpdomain.len()].to_string());
            }
        }
        return (visit, domains)
    }
}

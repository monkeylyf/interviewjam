/**
 * You are given an array A of strings.
 *
 * A move onto S consists of swapping any two even indexed characters of S, or
 * any two odd indexed characters of S.
 *
 * Two strings S and T are special-equivalent if after any number of moves onto
 * S, S == T.
 *
 * For example, S = "zzxy" and T = "xyzz" are special-equivalent because we may
 * make the moves "zzxy" -> "xzzy" -> "xyzz" that swap S[0] and S[2], then S[1]
 * and S[3].
 *
 * Now, a group of special-equivalent strings from A is a non-empty subset of A
 * such that:
 *
 * Every pair of strings in the group are special equivalent, and;
 * The group is the largest size possible (ie., there isn't a string S not in
 * the group such that S is special equivalent to every string in the group)
 * Return the number of groups of special-equivalent strings from A.
 *
 * Example 1:
 * Input: ["abcd","cdab","cbad","xyzz","zzxy","zzyx"]
 * Output: 3
 * Explanation:
 * One group is ["abcd", "cdab", "cbad"], since they are all pairwise special
 * equivalent, and none of the other strings are all pairwise special equivalent
 * to these.
 * The other two groups are ["xyzz", "zzxy"] and ["zzyx"]. Note that in
 * particular, "zzxy" is not special equivalent to "zzyx".
 *
 * Example 2:
 * Input: ["abc","acb","bac","bca","cab","cba"]
 * Output: 3
 *
 * Note:
 * 1 <= A.length <= 1000
 * 1 <= A[i].length <= 20
 * All A[i] have the same length.
 * All A[i] consist of only lowercase letters.
 */

use std::collections::HashMap;

fn main() {
    assert_eq!(3,
               Solution::num_special_equiv_groups(
                   vec!["abcd".to_string(),"cdab".to_string(),"cbad".to_string(),
                        "xyzz".to_string(),"zzxy".to_string(),"zzyx".to_string()]));
    assert_eq!(3,
               Solution::num_special_equiv_groups(
                   vec!["abc".to_string(),"acb".to_string(),"bac".to_string(),
                        "bca".to_string(),"cab".to_string(),"cba".to_string()]));
}

struct Solution {}

impl Solution {
    pub fn num_special_equiv_groups(a: Vec<String>) -> i32 {
        let mut counter: HashMap<(String, String), u16> = HashMap::new();
        for string in a {
            let sig: (String, String) = Solution::get_signature(&string);
            *counter.entry(sig).or_insert(0 as u16) += 1;
        }
        return counter.len() as i32;
    }

    pub fn get_signature(s: &str) -> (String, String)  {
        let mut even_map: [u16; 26] = [0; 26];
        let mut odd_map: [u16; 26] = [0; 26];
        for (i, value) in s.chars().enumerate() {
            let index: u32 = value as u32 - 97;
            if i % 2 == 0 {
                even_map[index as usize] += 1;
            } else {
                odd_map[index as usize] += 1;
            }
        }
        let mut even_sig: String = "".to_string();
        let mut odd_sig: String = "".to_string();
        for i in 0..26 {
            let even_frequency: u16 = even_map[i as usize];
            if even_frequency > 0 {
                even_sig.push_str(&(even_frequency * 100 + i).to_string());
            }
            let odd_frequency: u16 = odd_map[i as usize];
            if odd_frequency > 0 {
                odd_sig.push_str(&(odd_frequency * 100 + i).to_string());
            }
        }
        return (even_sig, odd_sig);
    }
}

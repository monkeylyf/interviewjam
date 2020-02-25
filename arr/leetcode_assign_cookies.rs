/**
 * Assume you are an awesome parent and want to give your children some cookies.
 * But, you should give each child at most one cookie. Each child i has a greed
 * factor gi, which is the minimum size of a cookie that the child will be
 * content with; and each cookie j has a size sj. If sj >= gi, we can assign the
 * cookie j to the child i, and the child i will be content. Your goal is to
 * maximize the number of your content children and output the maximum number.
 *
 * Note:
 * You may assume the greed factor is always positive.
 * You cannot assign more than one cookie to one child.
 *
 * Example 1:
 * Input: [1,2,3], [1,1]
 *
 * Output: 1
 *
 * Explanation: You have 3 children and 2 cookies. The greed factors of 3
 * children are 1, 2, 3.
 * And even though you have 2 cookies, since their size is both 1, you could
 * only make the child whose greed factor is 1 content.
 * You need to output 1.
 *
 * Example 2:
 * Input: [1,2], [1,2,3]
 * Output: 2
 *
 * Explanation: You have 2 children and 3 cookies. The greed factors of 2
 * children are 1, 2.
 * You have 3 cookies and their sizes are big enough to gratify all of the
 * children,
 * You need to output 2.
 */

fn main() {
    assert_eq!(2, Solution::find_content_children(vec![1, 2], vec![1, 2, 3]));
    assert_eq!(1, Solution::find_content_children(vec![1, 2, 3], vec![1, 1]));
}

struct Solution {}

impl Solution {
    pub fn find_content_children(g: Vec<i32>, s: Vec<i32>) -> i32 {
        let mut gg: Vec<i32> = g.iter().cloned().collect();
        gg.sort();
        let mut ss: Vec<i32> = s.iter().cloned().collect();
        ss.sort();
        // Two pointers.
        let mut i: usize = 0;
        let mut j: usize = 0;
        while j < gg.len() && i < ss.len() {
            if gg[j] <= ss[i] {
                j += 1;
            }
            i += 1;
        }
        return j as i32;
    }
}

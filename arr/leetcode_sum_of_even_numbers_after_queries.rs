/**
 * We have an array A of integers, and an array queries of queries.
 *
 * For the i-th query val = queries[i][0], index = queries[i][1], we add val to
 * A[index].  Then, the answer to the i-th query is the sum of the even values
 * of A.
 *
 * (Here, the given index = queries[i][1] is a 0-based index, and each query
 * permanently modifies the array A.)
 *
 * Return the answer to all queries.  Your answer array should have answer[i] as
 * the answer to the i-th query.
 *
 * Example 1:
 * Input: A = [1,2,3,4], queries = [[1,0],[-3,1],[-4,0],[2,3]]
 * Output: [8,6,2,4]
 * Explanation:
 * At the beginning, the array is [1,2,3,4].
 * After adding 1 to A[0], the array is [2,2,3,4], and the sum of even values is 2 + 2 + 4 = 8.
 * After adding -3 to A[1], the array is [2,-1,3,4], and the sum of even values is 2 + 4 = 6.
 * After adding -4 to A[0], the array is [-2,-1,3,4], and the sum of even values is -2 + 4 = 2.
 * After adding 2 to A[3], the array is [-2,-1,3,6], and the sum of even values is -2 + 6 = 4.
 *
 * Note:
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * 1 <= queries.length <= 10000
 * -10000 <= queries[i][0] <= 10000
 * 0 <= queries[i][1] < A.length
 */

fn main() {
    let a: Vec<i32> = vec![1, 2, 3, 4];
    let queries: Vec<Vec<i32>> = vec![
        vec![1, 0],
        vec![-3, 1],
        vec![-4, 0],
        vec![2, 3]];
    assert_eq!(vec![8, 6, 2, 4], Solution::sum_even_after_queries(a, queries));

    let b: Vec<i32> = vec![3, 2];
    let queries: Vec<Vec<i32>> = vec![
        vec![4, 0],
        vec![3, 0]];
    assert_eq!(vec![2, 12], Solution::sum_even_after_queries(b, queries));
}

struct Solution {
}

impl Solution {
    pub fn sum_even_after_queries(a: Vec<i32>, queries: Vec<Vec<i32>>) -> Vec<i32> {
        let mut even_sum: i32 = a.iter().filter(|x| *x % 2 == 0).sum();
        let mut aa: Vec<i32> = a.iter().cloned().collect();
        let mut query_result: Vec<i32> = Vec::with_capacity(a.len());
        for query in &queries {
            let delta: i32 = query[0];
            let index: usize = query[1] as usize;
            let value: i32 = aa[index];
            println!("{} {} {}", delta, index, value);
            if value % 2 == 0 {
                if delta % 2 == 0 {
                    even_sum += delta;
                } else {
                    even_sum -= value;
                }
            } else {
                if delta % 2 != 0 {
                    even_sum += value + delta;
                }
            }
            query_result.push(even_sum);
            aa[index] += delta;
        }
        return query_result;
    }
}

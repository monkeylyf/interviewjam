/**
 * You are given the array paths, where paths[i] = [cityAi, cityBi] means there
 * exists a direct path going from cityAi to cityBi. Return the destination
 * city, that is, the city without any path outgoing to another city.
 *
 * It is guaranteed that the graph of paths forms a line without any loop,
 * therefore, there will be exactly one destination city.
 *
 * Example 1:
 * Input: paths = [["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]]
 * Output: "Sao Paulo"
 * Explanation: Starting at "London" city you will reach "Sao Paulo" city which
 * is the destination city. Your trip consist of: "London" -> "New York" -> "Lima" -> "Sao Paulo".
 *
 * Example 2:
 * Input: paths = [["B","C"],["D","B"],["C","A"]]
 * Output: "A"
 * Explanation: All possible trips are:
 * "D" -> "B" -> "C" -> "A".
 * "B" -> "C" -> "A".
 * "C" -> "A".
 * "A".
 * Clearly the destination city is "A".
 *
 * Example 3:
 * Input: paths = [["A","Z"]]
 * Output: "Z"
 *
 * Constraints:
 * 1 <= paths.length <= 100
 * paths[i].length == 2
 * 1 <= cityAi.length, cityBi.length <= 10
 * cityAi != cityBi
 * All strings consist of lowercase and uppercase English letters and the space
 * character.
 */

use std::collections::HashMap;

fn main() {
    assert_eq!("A", Solution::dest_city(
            vec![
                vec!["B".to_string(), "C".to_string()],
                vec!["D".to_string(), "B".to_string()],
                vec!["C".to_string(), "A".to_string()]]));
}

struct Solution {}

impl Solution {
    pub fn dest_city(paths: Vec<Vec<String>>) -> String {
        if paths.is_empty() {
            return "".to_string();
        }

        let mut graph: HashMap<&str, &str> = HashMap::new();
        for i in &paths {
            graph.insert(&i[0], &i[1]);
        }
        let mut to: &str = &paths[0][1];
        while graph.contains_key(to) {
            to = graph.get(to).unwrap();
        }
        return to.to_string();
    }
}

/*4Sum

Given an array S of n integers, are there elements a, b, c, and d in S such
that a + b + c + d = target? Find all unique quadruplets in the array which
gives the sum of target.

Note:
Elements in a quadruplet (a,b,c,d) must be in non-descending order.
(ie, a ≤ b ≤ c ≤ d)
The solution set must not contain duplicate quadruplets.
For example, given array S = {1, 0, -1, 0, -2, 2}, and target = 0.

A solution set is:
(-1,  0, 0, 1)
(-2, -1, 1, 2)
(-2,  0, 0, 2)
*/

import java.util.*;


public class leetcode_4Sum {

    public static void main(String[] args) {
        //for (ArrayList<Integer> i : fourSum(new int[] {2, 1, 0, -1}, 2)) System.out.println(i);
		solve(new int[] {1,2,3,4,5}, 10);
    }

	// Hashing pairs: sum/index. arr with length n => n^2 pairs.
	// Sort pairs. Use two pointers find pair of pairs can sum up to target. sort: n^2(lg n^2) = n^2lgn and search: n
	// So total time complexity is O(n^2 logn)

	public static void solve(int[] arr, int target) {
		// Init vars.
		int n = arr.length, head, tail, sum, i, j, a, b;
		ArrayList<int[]> indexes;
		ArrayList<Integer> pairs = new ArrayList<Integer>();
		HashMap<Integer, ArrayList<int[]>> dict = new HashMap<Integer, ArrayList<int[]>>();
		HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
		// Hashing pairs: sum/index.
		for (i = 0; i < n - 1; ++i) {
			for (j = i + 1; j < n; ++j) {
				sum = arr[i] + arr[j];
				indexes = dict.get(sum);
				if (indexes == null) {
					indexes = new ArrayList<int[]>();
					pairs.add(sum);
				}
				indexes.add(new int[] { i, j });
				dict.put(sum, indexes);
			}
		}
		// Sort arraylist and start two pointers.
		Collections.sort(pairs);
		head = 0;
		tail = pairs.size() - 1;
		while (head < tail) {
			a = pairs.get(head);
			b = pairs.get(tail);
			if (a + b == target) {
				find_four(set, dict.get(a), dict.get(b), arr);
				head = head + 1;
				tail = tail - 1;
			} else if (a + b > target) {
				tail = tail - 1;
			} else {
				head = head + 1;
			}
		}
		// if x + x = target, check if dict contains key: x.
		if (target % 2 == 0 && dict.containsKey(target / 2)
				&& dict.get(target / 2).size() >= 2) {
			find_four(set, dict.get(target / 2), dict.get(target / 2), arr);
		}

		ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
		for (ArrayList<Integer> darn : set) {
			ret.add(darn);
		}
		System.out.println(ret);
	}

	public static void find_four(HashSet<ArrayList<Integer>> set, ArrayList<int[]> a,
			ArrayList<int[]> b, int[] arr) {
		int i, j;
		int[] foo, bar;
		ArrayList<Integer> index;
		for (i = 0; i < a.size(); ++i) {
			foo = a.get(i);
			for (j = 0; j < b.size(); ++j) {
				bar = b.get(j);
				if (foo[0] != bar[0] && foo[1] != bar[0] && foo[0] != bar[1]
						&& foo[1] != bar[1]) {
					// if indexes do not overlap, we find a valid 4 element.
					index = new ArrayList<Integer>();
					Collections.addAll(index, arr[foo[0]], arr[foo[1]],
							arr[bar[0]], arr[bar[1]]);
					Collections.sort(index);
					set.add(index);
				}
			}
		}
	}

    // Since we've know how to implement 3Sum.
    public static ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> all = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        for (int i = 0; i < num.length -3; ++i) {
            if (i > 0 && num[i - 1] == num[i]) {
                // Latter threeSum either has no or the same solution as previous.
                continue;
            }
            int[] arr = Arrays.copyOfRange(num, i + 1, num.length);
            ArrayList<ArrayList<Integer>> threeSum = threeSum(arr, target - num[i]);
            for (ArrayList<Integer> list : threeSum) {
                list.add(0, num[i]);
                all.add(list);
            }
        }
        return all;
    }
    public static ArrayList<ArrayList<Integer>> threeSum(int[] num, int target) {
        // Difference between original 3sum question: args num is already sorted.
        HashSet<ArrayList<Integer>> all = new HashSet<ArrayList<Integer>>();
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        for (int i = 0; i < num.length - 2; ++i) {
            int j = i + 1;
            int k = num.length - 1;
            while (j < k) {
                if (num[j] + num[k] > target - num[i]) {
                    --k;
                } else if (num[j] + num[k] < target - num[i]) {
                    ++j;
                } else {
                    Collections.addAll(tmp, num[i], num[j++], num[k--]);
                    all.add(tmp);
                    tmp = new ArrayList<Integer>();
                }
            }
        }
        return new ArrayList<ArrayList<Integer>>(all);
    }

    // O(N^3), way too slow.
    public static ArrayList<ArrayList<Integer>> fourSumTooSlow(int[] num, int target) {
        Arrays.sort(num);
        HashSet<ArrayList<Integer>> all = new HashSet<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < num.length - 3; ++i) {
            for (int j = i + 1; j < num.length - 2; ++j) {
                int h = j + 1;
                int k = num.length -1;
                int part = target - num[i] - num[j];
                while (h < k) {
                    int cur = num[h] + num[k];
                    if (part < cur) --k;
                    else if (part > cur) ++h;
                    else {
                        ArrayList<Integer> tmp = new ArrayList<Integer>();
                        Collections.addAll(tmp, num[i], num[j], num[h], num[k]);
                        if (all.add(tmp)) res.add(tmp);
                        tmp = new ArrayList<Integer>();
                    }
                }
            }
        }
        return res;
    } 
}

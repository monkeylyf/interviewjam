/*
 * leet code Two Sum
 */

#include <stdio.h>
#include <vector>
#include <map>

using std::vector;
using std::map;


void print_vector(const vector<int> *v) {
    for (int val : *v) {
        printf("%d ", val);
    }
    printf("\n");
}


class Solution {
    public:

    vector<int> twoSum(vector<int>& nums, int target) {
        map<int, int> mapping;

        int idx = 1;

        for (int val : nums) {
            auto iter = mapping.find(target - val);

            if (iter != mapping.end()) {
                // Find match.
                int known_idx = iter->second;

                vector<int> res {known_idx, idx};
                return res;
            }

            mapping[val] = idx;
            ++idx;
        }

        vector<int> res;
        return res;
    }
};


int main() {
    Solution sol = Solution();

    vector<int> nums {2, 3, 1, 6, 8};
    int target = 8;
    vector<int> res = sol.twoSum(nums, target);
    print_vector(&res);
    return 0;
}

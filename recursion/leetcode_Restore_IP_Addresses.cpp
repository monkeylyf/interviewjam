/**
 * Copyright 2016
 * author: madarfacar
 *
 * leetcode restore ip addr
 */

#include <stdio.h>
#include <string>
#include <vector>

using std::string;
using std::vector;


class Solution {
 public:
  vector<string> restoreIpAddresses(string s) {
    vector<string> ips;
    if (s.length() <= 4 * 3) {
      vector<int> ip;
      restoreIpAddressesRecur(&ips, &ip, 0, s);
    }
    return ips;
  }

 private:
  void restoreIpAddressesRecur(vector<string>* ips, vector<int>* ip,
    int start, string s) {
    // Finish scaning the string and check whether qualified to be an IP.
    if (start == s.length()) {
      if (ip->size() == 4) {
        ips->push_back(join(*ip, "."));
      }
      return;
    }

    // Check if prev token exists, if yes check if adding a new digit it's still
    // a valid IP segment, which falls in range [0, 255]
    if (!ip->empty() && ((ip->back() != 0 && ip->back() < 25) || (ip->back() == 25 && s[start] <= '5'))) {
      int last = ip->back();
      int last_idx = ip->size() - 1;
      (*ip)[last_idx] = last * 10 + (s[start] - '0');
      restoreIpAddressesRecur(ips, ip, start + 1, s);
      (*ip)[last_idx] = last;
    }
    // Treat current char as a new seg anyway.
    ip->push_back(s[start] - '0');
    restoreIpAddressesRecur(ips, ip, start + 1, s);
    ip->pop_back();
  }

  string join(const vector<int>& v, string delim) {
    string s = "";
    for (int i = 0; i < v.size(); ++i) {
      s += std::to_string(v[i]);
      if (i < v.size() - 1) {
        s += delim;
      }
    }
    return s;
  }
};


int main() {
  Solution sol;

  //vector<string> ips = sol.restoreIpAddresses("25525511135");
  vector<string> ips = sol.restoreIpAddresses("240102");

  for (string ip : ips) {
    printf("%s\n", ip.c_str());
  }
}

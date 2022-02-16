#include <bitset>

class Solution {
public:
    /**
    * (i & i - 1) drops the lowest set bit. For exmaple
    * 1110 & 1101 = 1100. We then can use this to find the
    * result of a previously found value, and increment it
    * to find the current value.
    **/
    vector<int> countBits(int n) {
        vector<int> bits(n + 1, 0);
        for (int i = 1; i <= n; ++i) {
            bits[i] = bits[i&(i-1)] + 1;
        }
        return bits;
    }
};
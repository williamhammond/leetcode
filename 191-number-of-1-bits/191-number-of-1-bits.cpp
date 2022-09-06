class Solution {
public:
    int hammingWeight(uint32_t n) {
        int weight = 0;
        while (n != 0) {
            if (n % 2 == 1) {
                weight += 1;
            }
            n = n >> 1;
        }
        return weight;
    }
};
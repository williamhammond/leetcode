#include <bitset>

class Solution {
public:
    vector<int> countBits(int n) {
        vector<int> bits;
        for (int i = 0; i < n + 1; i++) {
            std::string bitString = std::bitset<17>( i).to_string();
            int oneCount = 0;
            for (int j = 0; j < bitString.length(); j++) {
                if (bitString[j] == '1') oneCount++;
            }
            bits.push_back(oneCount);
        }
        return bits;
        
    }
};
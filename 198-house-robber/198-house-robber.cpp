class Solution {
public:
    int rob(vector<int>& nums) {
        int previous = 0;
        int current = 0;
        for (int i = 0; i < nums.size(); i++) {
            int temp = max(previous + nums[i], current);
            previous = current;
            current = temp;
        }
        return current;
    }
};
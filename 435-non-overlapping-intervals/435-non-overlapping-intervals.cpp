class Solution {
public:
    int eraseOverlapIntervals(vector<vector<int>>& intervals) {
        sort(intervals.begin(), intervals.end(), [](const auto& a, const auto& b)
        {
           return a[0] < b[0];
        }); 
        
        int result = 0;
        int previous = 0;
        for (int i = 1; i < intervals.size(); i++) {
            if (intervals[i][0] < intervals[previous][1]) {
                result++;
                if (intervals[i][1] < intervals[previous][1]) {
                  previous = i;  
                } 
            }
            else {
                previous = i;   
            }
        }
        
        return result;
    }
};
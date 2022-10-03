class Solution {
private:
public:
    vector<vector<int>> kClosest(vector<vector<int>>& points, int k) {
        auto comparator = [](vector<int> a, vector<int> b) { return abs(sqrtf(a[0] * a[0] + a[1] * a[1])) > abs(sqrtf(b[0] * b[0] + b[1] * b[1]));};
        priority_queue<vector<int>, vector<vector<int>>, decltype(comparator)> pq(comparator);
        for (auto point: points) {
            pq.push(point);
        }
        
        vector<vector<int>> result{};
        for (int i = 0; i < k; i++) {
            result.push_back(pq.top());
            pq.pop();
        }
        return result;
    }
};
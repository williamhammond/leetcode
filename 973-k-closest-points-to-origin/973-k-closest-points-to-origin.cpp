class Solution {
private:
public:
    vector<vector<int>> kClosest(vector<vector<int>>& points, int k) {
        auto comparator = [](vector<int> a, vector<int> b) { return a[0] * a[0] + a[1] * a[1] < b[0] * b[0] + b[1] * b[1];};
        partial_sort(points.begin(), points.begin() + k, points.end(), comparator);
        return vector<vector<int>>(points.begin(), points.begin() + k);

    }
};
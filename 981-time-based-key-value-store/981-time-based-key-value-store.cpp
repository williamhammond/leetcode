class TimeMap {
private:
    std::unordered_map<std::string, std::vector<std::pair<int, std::string>>> data;
    string search(std::vector<std::pair<int, std::string>> &values, const int &timestamp) {
        int left = 0;
        int right = values.size() - 1;
        while (left <= right) {
            int mid = (right + left) >> 1;
            auto value = values[mid];
            
            if (value.first > timestamp) {
                right = mid - 1;
            } else if(value.first < timestamp) {
                left = mid + 1;
            } else {
                return value.second;
            }
        }
        return right >= 0 ? values[right].second: "";
    }
    
    
public:
    TimeMap() {
        data = {}; 
    }
    
    void set(string key, string value, int timestamp) {
        if (data.count(key) == 0) {
            data[key] = {std::pair(timestamp, value)};
        } else {
            data[key].push_back(std::pair(timestamp,value));
        }
    }
    
    string get(string key, int timestamp) {
        if (data[key].size() == 0) {
            return "";
        }
        return search(data[key], timestamp);
    }
};

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap* obj = new TimeMap();
 * obj->set(key,value,timestamp);
 * string param_2 = obj->get(key,timestamp);
 */
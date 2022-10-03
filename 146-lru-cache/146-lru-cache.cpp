class LRUCache {
private:
    int capacity;
    list<pair<int, int>> order;
    unordered_map<int, list<pair<int, int>>::iterator> data; 
public:
    LRUCache(int in_capacity) {
        capacity = in_capacity;
        data.reserve(capacity);
    }
    
    int get(int key) {
        if (data.find(key) == data.end()) {
            return -1;
        }
        order.splice(order.begin(), order, data[key]);
        return data[key]->second;
        
    }
    
    void put(int key, int value) {
        if (get(key) != -1) {
            data[key]->second = value;
            return;
        }    
        if (data.size() == capacity) {
            int to_delete = order.back().first;
            order.pop_back();
            data.erase(to_delete);
        }
        
        order.emplace_front(key, value);
        data[key] = order.begin();
    }
};

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache* obj = new LRUCache(capacity);
 * int param_1 = obj->get(key);
 * obj->put(key,value);
 */
class Solution {
public:
    int search(vector<int>& nums, int target) {
        int left = 0;
        int right = nums.size() - 1;
        while (left < right) {
          // Prevents issues here
          // https://ai.googleblog.com/2006/06/extra-extra-read-all-about-it-nearly.html
          int mid = (left + right) >> 1;
          if(nums[mid] > nums[right]) {
           left = mid+1;   
          } else {
            right = mid; 
          }
        }
        
        int rotation = left;
        left = 0;
        right = nums.size() - 1;
        while(left <= right){
            int mid = (left + right) >> 1;
            int real_mid = (mid + rotation) % nums.size();
            
            if(nums[real_mid] == target) {
                return real_mid;
            }
            
            if(nums[real_mid] < target) {
             left = mid + 1;   
            } else {
                right = mid - 1;
            }
        }
        
        return -1;
    }
};
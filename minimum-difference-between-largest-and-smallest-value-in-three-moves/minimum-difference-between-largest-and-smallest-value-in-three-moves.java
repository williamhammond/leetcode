class Solution {
    public int minDifference(int[] nums) {
        if (nums.length < 5) return 0;
        int result = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < 4; i++) {
            result = Math.min(result, nums[nums.length - 4 + i] - nums[i]);
        }
        return result;
    }
}
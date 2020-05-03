class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int last = maxSum;
        for(int i = 1;i<nums.length;++i){
            last = (last + nums[i]) > nums[i] ?  (last + nums[i]) : nums[i];
            maxSum = Math.max(last,maxSum);
        }
        return maxSum;
    }
}
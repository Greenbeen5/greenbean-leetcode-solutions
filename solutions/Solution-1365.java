class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] cnt = new int[nums.length];
        int[] bucket = new int[101];
        for(int i = 0; i<nums.length; ++i){
            bucket[nums[i]]++;
        }
        for(int i = 0; i<nums.length; ++i){
            int sum = 0;
            for(int j = 0; j<nums[i]; ++j){
                sum += bucket[j];
            }
            cnt[i] = sum;
        }
        return cnt;
    }
}
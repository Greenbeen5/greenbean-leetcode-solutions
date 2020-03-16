class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length == 1){
            return true;
        }
        int longest = 1;
        for(int i = nums.length - 2; i >= 0 ;i--){
            if(nums[i] >= longest){
                longest = 1;
                continue;
            }else{
                longest++;
            }
        }
        if(nums[0] >= longest){
            return true;
        }else{
            return false;
        }
    }
}
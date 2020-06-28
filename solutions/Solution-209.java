class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int res = nums.length, curSum = 0;
        boolean flag = false;
        int left = 0, right = 1;
        if(nums.length == 0)return 0;
        curSum += nums[0];
        while(true){
            if(curSum < s){
                if(right < nums.length){
                    curSum += nums[right++];
                }else{
                    break;
                }
            }else{
                res = Math.min(right-left, res);
                flag = true;
                curSum-=nums[left];
                left++;
                if(left == right){
                    if(left < nums.length){
                        curSum += nums[left];
                        right++;
                    }else{
                        break;
                    }
                }
            }
        }
        if(!flag) return 0;
        return res;
    }
}
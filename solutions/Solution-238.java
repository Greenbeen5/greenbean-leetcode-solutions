class Solution {
    /* NOTE: the space complexity can be reduced to O(1) by using leftProd as the output,
            then calculate the rightProd dynamically.
            */
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] leftProd = new int[len]; // calculate the production of elements on the left side of i
        int[] rightProd = new int[len]; // calculate ... right ... i
        leftProd[0] = 1;
        rightProd[len-1] = 1;
        for(int i = 1 ;i<len;++i){
            leftProd[i] = leftProd[i-1] * nums[i-1];
        }
        for(int j = len-2;j>=0;--j){
            rightProd[j] = rightProd[j+1] * nums[j+1];
        }
        int[] ans = new int[len];
        for(int i = 0;i<len;++i){
            ans[i] = leftProd[i] * rightProd[i];
        }
        return ans;
    }
    

}
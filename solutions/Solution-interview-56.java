class Solution {
    public int[] singleNumbers(int[] nums) {
        int xor = 0;
        for(int num:nums){
            xor ^= num;
        }
        
        int mask = 1;
        while((mask & xor) == 0){
            mask <<= 1;
        }
        int a=0,b=0;
        for(int num : nums){
            if((num & mask) == 0){
                a ^= num;
            }else{
                b ^= num;
            }
        }
        int[] ans = new int[2];
        ans[0] = a;
        ans[1] = b;
        return ans;
    }
}
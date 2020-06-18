class Solution {
    public int removeDuplicates(int[] nums) {
        int numsSize = nums.length;
        if(numsSize <= 1)return numsSize;
        int no_dup_ptr = 0;
        int ptr = 0;
        int tmp;
        while(ptr < numsSize){
            tmp = ptr + 1;
            while(((tmp < numsSize)) && (nums[ptr] == nums[tmp]))tmp++;
            if(tmp < numsSize){
                nums[++no_dup_ptr]= nums[tmp];
            }
            ptr = tmp;
        }
        return no_dup_ptr + 1;
    }
}
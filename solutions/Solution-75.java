class Solution {
    public void sortColors(int[] nums) {
        int left = 0, right = nums.length-1;
        int red = 0;
        while(left <= right){
            if(nums[left] == 2){
                swap(nums,left,right);
                right--;
            } else if (nums[left] == 0){
                swap(nums,left,red);
                red++;
                if(nums[left] == 0)left++;
            } else if (nums[left] == 1){
                left++;
            }
        }
    }
    
    public void swap(int[] n, int l, int r){
        int tmp = n[l];
        n[l] = n[r];
        n[r] = tmp;
    }
}
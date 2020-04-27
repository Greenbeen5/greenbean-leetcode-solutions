class Solution {
    
    private int target = 0;
    private int ans = -1;
    
    public int search(int[] nums, int target) {
        this.target = target;
        if(nums.length == 0){
            return -1;
        }
        divide(nums,0,nums.length-1);
        return ans;
    }
    
    private void divide(int[] nums, int left, int right){
        if(right - left <= 1){
            if(nums[left] == target){
                ans = left;
            }
            if(nums[right] == target){
                ans = right;
            }
        }else{
            if(nums[left] < nums[right]){
                if(target >= nums[left] && target <= nums[right]){
                    int mid = (left+right) / 2;
                    divide(nums,left,mid);
                    divide(nums,mid+1,right);
                }
                return;
            }else{
                int mid = (left+right) / 2;
                divide(nums,left,mid);
                divide(nums,mid+1,right);
            }
        }        
    }
}
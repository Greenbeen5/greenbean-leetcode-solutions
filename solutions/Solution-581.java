class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);
        int left = 0, right = sorted.length - 1;
        boolean shuffled = false;
        for(int i = 0; i < nums.length; ++i){
            if(sorted[i] != nums[i]) {
                left = i;
                shuffled = true;
                break;
            }
        }
        for(int i = nums.length - 1; i>=left; --i){
            if(sorted[i] != nums[i]){
                right = i;
                shuffled = true;
                break;
            }
        }
        if(!shuffled) return 0;
        return right - left + 1;
    }
}
class Solution {
    public int thirdMax(int[] nums) {
        Integer one = null, two = null, three = null;
        if(nums.length == 1){
            return nums[0];
        }else if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }else{
            for(int i : nums){
                if(one == null){
                    one = i;
                }else if(two == null){
                    if(one > i){
                        two = i;
                    }else if(one < i){
                        two = one;
                        one = i;
                    }
                }else if(three == null){
                    if(two > i){
                        three = i;
                    }else if(one > i && i > two){
                        three = two;
                        two = i;
                    }else if(one < i){
                        three = two;
                        two = one;
                        one = i;
                    }
                }else{
                    if(three > i) continue;
                    else if(two > i){
                        three = i;
                    }else if(one > i && i > two){
                        three = two;
                        two = i;
                    }else if(one < i){
                        three = two;
                        two = one;
                        one = i;
                    }
                }
            }
        }
        if(three != null) return three;
        else return one;
    }
}
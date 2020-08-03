class Solution {
    List<List<Integer>> sum = new ArrayList<>();
    boolean overflow = false;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates); // sorting will deal with the duplication
        for(int i = 0; i<candidates.length; ++i){
            List<Integer> combination = new ArrayList<>();
            combination.add(candidates[i]);
            trySum(candidates, combination, target - candidates[i], i);
        }
        return sum;
    }
    
    public void trySum(int[] nums, List<Integer> com, int curTarget, int minIndex){
        if(curTarget == 0){
            List<Integer> copy = new ArrayList<>();
            copy.addAll(com);
            sum.add(copy);
        }else if(curTarget > 0){
            for(int j = minIndex; j<nums.length; ++j){
                com.add(nums[j]);
                trySum(nums, com, curTarget - nums[j], j);
                if(overflow){
                    overflow = false;
                    break;
                }
            }
        }else{
            overflow = true;
        }
        if(com.size() > 0) com.remove(com.size()-1);
    }
}
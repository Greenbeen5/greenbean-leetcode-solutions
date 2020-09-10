class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        int len = candidates.length;
        boolean[] used = new boolean[len];
        Set<List<Integer>> res = new HashSet<>();
        for(int i = 0; i<len; ++i){
            if(candidates[i] > target) break;
            List<Integer> comb = new ArrayList<>();
            int sum = candidates[i];
            used[i] = true;
            comb.add(0, candidates[i]);
            if(sum == target){
                res.add(new ArrayList<>(comb));
                used[i] = false;
                comb.remove(0);
                sum -= candidates[i];
            }else{
                backtrack(candidates, comb, used, sum, target, res, i);
                comb.remove(0);
                used[i] = false;
                sum -= candidates[i];
            }
        }
        return new ArrayList<>(res);
    }
    
    private void backtrack(int[] can, List<Integer> comb, boolean[] used, int sum, int target, Set<List<Integer>> res, int ind){
        for(int i = ind+1; i<can.length; ++i){
            if(!used[i]){
                if(sum + can[i] > target) break;
                used[i] = true;
                sum += can[i];
                comb.add(0, can[i]);
                if(sum == target){
                    res.add(new ArrayList<>(comb));
                    used[i] = false;
                    comb.remove(0);
                    sum -= can[i];
                }else{
                    backtrack(can, comb, used, sum, target, res, i);
                    comb.remove(0);
                    used[i] = false;
                    sum -= can[i];
                }
            }
            
        }
    }
}
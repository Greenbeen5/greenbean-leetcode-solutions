class Solution {
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> cur;
    private boolean[] visited;
    private int visitedCount = 0;
    public List<List<Integer>> permute(int[] nums) {
        visited = new boolean[nums.length];
        cur = new ArrayList<>(nums.length);
        for(int i = 0;i<nums.length;i++){
            test(nums,i);
        }
        return ans;
    }
    
    public void test(int[] nums, int ind){
        visited[ind] = true;
        visitedCount++;
        cur.add(nums[ind]);
        if(visitedCount == nums.length){
            ans.add(new ArrayList<Integer>(cur));
        }else{
            for(int i = 0; i<nums.length; ++i){
                if(!visited[i]){
                    test(nums, i);
                }
            }
        }
        visited[ind] = false;
        visitedCount--;
        cur.remove(cur.size() - 1);
    }
}
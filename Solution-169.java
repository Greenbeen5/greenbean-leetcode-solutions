class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i:nums){
            int cnt = map.getOrDefault(i,0);
            if(cnt == nums.length/2){
                return i;
            }
            map.put(i,cnt+1);
        }
        return -1;
    }
}
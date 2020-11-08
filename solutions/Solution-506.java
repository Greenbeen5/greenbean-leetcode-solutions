class Solution {
    public String[] findRelativeRanks(int[] nums) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);
        Map<Integer, Integer> ranks = new HashMap<>();
        for(int i = 0; i<copy.length; ++i){
            ranks.put(copy[i], copy.length - i);
        }
        String[] out = new String[nums.length];
        for(int i = 0; i<nums.length; ++i){
            int rank = ranks.get(nums[i]);
            if(rank > 3){
                out[i] = rank+"";
            }else{
                switch(rank){
                    case 1:
                        out[i] = "Gold Medal";
                        break;
                    case 2:
                        out[i] = "Silver Medal";
                        break;
                    case 3:
                        out[i] = "Bronze Medal";
                        break;
                    default:
                        break;
                    }
            }
        }
        return out;
    }
}
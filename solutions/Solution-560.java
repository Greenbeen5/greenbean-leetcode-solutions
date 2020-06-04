class Solution {
    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        int len = nums.length;
        int[] map = new int[len+1];
        //HashMap<Integer, Integer> sumMap = new HashMap<>();
        int cur = 0;
        map[0] = 0;
        //sumMap.put(0,cur);
        for(int i = 0;i<len;++i){
            cur += nums[i];
            map[i+1] = cur;
            //sumMap.put(i+1,cur);
        }
        for(int i = 0;i<len;++i){
            for(int j = i+1;j<=len;++j){
                if(/*sumMap.get(j) - sumMap.get(i) == k*/ map[j]-map[i] == k){
                    ans++;
                }
            }
        }
        
        return ans;
    }
    
    public int subarraySum_better(int[] nums, int k) {
        // 利用哈希表实现线性寻找
        HashMap <Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, 1);
        int i;
        int sum = 0;
        int count = 0;
        for (i = 0; i < nums.length; i++)
        {
            sum += nums[i];
            if (hashMap.containsKey(sum - k))   // 表示连续子数组减去连续子数组，必定为连续子数组
            {
                count += hashMap.get(sum - k);
            }
            hashMap.put(sum, hashMap.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
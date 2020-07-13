class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> table = new HashMap<>();
        List<Integer> out = new ArrayList<>();
        for(int i : nums2){
            if(table.containsKey((Integer)i)){
                int incr = table.get((Integer)i) + 1;
                table.put(i, incr);
            }else{
                table.put(i, 1);
            }
        }
        for(int i : nums1){
            if(table.containsKey((Integer)i)){
                int cnt = table.get((Integer)i);
                if(cnt == 0){
                    continue;
                }else{
                    table.put(i, cnt-1);
                    out.add(i);
                }
            }
        }
        int[] res = new int[out.size()];
        for(int i = 0; i<out.size(); ++i){
            res[i] = out.get(i);
        }
        return res;
    }
}
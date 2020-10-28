class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> count = new HashMap<>();
        for(int i : arr){
            if(count.containsKey(i)){
                count.put(i, count.get(i)+1);
            }else{
                count.put(i,1);
            }
        }
        Iterator<Integer> iter = count.values().iterator();
        Set<Integer> values = new HashSet<>();
        while(iter.hasNext()){
            int next = iter.next();
            if(values.contains(next)){
                return false;
            }else{
                values.add(next);
            }
        }
        return true;
    }
}
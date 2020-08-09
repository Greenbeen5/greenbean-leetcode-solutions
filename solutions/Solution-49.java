class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> mapper = new HashMap<>();
        for(String str : strs){
            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);
            String sorted = new String(charArr);
            if(mapper.containsKey(sorted)){
                mapper.get(sorted).add(str);
            }else{
                mapper.put(sorted, new ArrayList<String>());
                mapper.get(sorted).add(str);
            }  
        }

        return new ArrayList<List<String>>(mapper.values());
    }
}
class Solution {
    Map<Character, Set<Character>> findSet;
    public boolean equationsPossible(String[] equations) {
        findSet = new HashMap<>();
        char c1,c2,sgn;
        /* LOOP 1: Create the set of equivalent characters */
        for(String s : equations){
            char[] chs = s.toCharArray();
            sgn = chs[1];
            if(sgn == '!'){
                continue;
            }
            c1 = chs[0];
            c2 = chs[3];
            if(!findSet.containsKey(c1) && !findSet.containsKey(c2)){
                // create the set
                HashSet<Character> curSet = new HashSet<>();
                curSet.add(c1);
                curSet.add(c2);
                // put the set in the map
                findSet.put(c1, curSet);
                findSet.put(c2, curSet);
            }else{
                Set<Character> curSet1 = findSet.getOrDefault(c1, null);
                Set<Character> curSet2 = findSet.getOrDefault(c2, null);
                if(curSet1 != null){
                    if(curSet2 != null){
                        curSet1.addAll(curSet2);
                        for(Character ch : curSet2){
                            findSet.put(ch, curSet1);
                        }
                    }else{
                        curSet1.add(c2);
                        findSet.put(c2,curSet1);
                    }
                }else{
                    curSet2.add(c1);
                    findSet.put(c1, curSet2);
                }
            }
        }
        // if(findSet.size() == 0){ 
        //     // No != conditions, always true
        //     return true;
        // }
        /* LOOP 2: Test all != conditions */
        for(String s : equations){
            char[] chs = s.toCharArray();
            sgn = chs[1];
            if(sgn != '!'){
                continue;
            }
            c1 = chs[0];
            c2 = chs[3];
            if(c1 == c2){
                // x != x is always false
                return false;
            }
            if(!findSet.containsKey(c1) || !findSet.containsKey(c2)){
                // at least one of the characters is missing from the map, continue
                continue;
            }else{
                // judge if they are in the same set, if so, return false
                Set<Character> curSet = findSet.get(c1);
                if(curSet.contains(c2)){
                    return false;
                }
            }
        }
        
        return true;
    }
}
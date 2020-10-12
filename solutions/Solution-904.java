class Solution {
    public int totalFruit(int[] tree) {
        if(tree.length <= 2) return tree.length;
        //Set<Integer> fruits = new HashSet<>();
        int[] set = new int[2];
        set[0] = tree[0];
        set[1] = -1;
        int total = 0, cur = 0;
        for(int i = 0; i<tree.length; ++i){
            int pick = tree[i];
            if(set[1] == -1 && set[0] != pick){
                set[1] = pick;
                cur++;
                continue;
            }
            if(set[0] == pick || set[1] == pick){
                cur++;
            }else{
                total = Math.max(total, cur);
                cur = 1;
                int last = tree[i-1];
                int rm = -1;
                for(int j = i-1; j>=0; --j){
                    if(last == tree[j]){
                        cur++;
                    }else{
                        rm = tree[j];
                        break;
                    }
                }
                if(rm != -1){
                    if(set[0] == rm) set[0] = pick;
                    else if(set[1] == rm) set[1] = pick;
                }
            }
        }
        total = Math.max(total, cur);
        return total;
    }
}
class Solution {
    public int findCircleNum(int[][] M) {
        int N = M.length;
        if(N <= 1)return N;
        int[] roots = new int[N];
        for(int i = 0; i<N; ++i){
            roots[i] = i;
        }
        for(int i = 0; i<N; ++i){
            for(int j = 0; j<N; ++j){
                if(i != j && M[i][j]==1){
                    union(roots, i, j);
                }
            }
        }
        int res = 0;
        for(int i = 0; i<N; ++i){
            if(roots[i] == i){
                ++res;
            }
        }
        return res;
    }
    
    private void union(int[] roots, int i, int j){
        roots[find(roots, i)] = find(roots, j);
    }
    
    private int find(int[] roots, int i){
        if(roots[i] != i){
            roots[i] = find(roots, roots[i]);
        }
        return roots[i];
    }
}
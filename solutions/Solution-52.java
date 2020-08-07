class Solution {
    private int[] location;
    private boolean[] used;
    int ans = 0;

    public int totalNQueens(int n) {
        if(n == 0){
            return 0;
        }
        location = new int[n];
        used = new boolean[n];
        Arrays.fill(location, 0);
        Arrays.fill(used, false);
        solve(0,n);
        return ans;
    }
    
    private void solve(int k, int n){
        for(int i = 0; i<n;i++){
            if(!used[i]){
                location[k] = i;
                used[i] = true;
                if(check(k) && k != n-1){
                    solve(k+1, n);
                }else if(check(k) && k==n-1){
                    ans += 1;
                }
                used[i] = false; //还原现场
            }
        }
    }

    private boolean check(int k){
        for(int i = 0;i<k;i++){
            if(Math.abs(location[i] - location[k]) == Math.abs(i-k)){
                return false;
            }
        }
        return true;
    }

}
class Solution {
    public int numIslands(char[][] grid) {
        int islands = 0;
        if(grid.length == 0){
            return 0;
        }
        if(grid[0].length==0){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(grid[i][j] == '1'){
                    islands++;
                    bfsIsland(grid,i,j);
                }
            }
        }
        return islands;
    }
    
    private void bfsIsland(char[][] g,int x, int y){
        if(x<0 || y<0 || x>=g.length || y>=g[0].length){
            return;
        }
        if(g[x][y] == '1'){
            g[x][y] = '0';
            bfsIsland(g,x-1,y);
            bfsIsland(g,x+1,y);
            bfsIsland(g,x,y-1);
            bfsIsland(g,x,y+1);
        }else{
            return;
        }
    }
}
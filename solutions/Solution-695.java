class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0; 
        if(grid.length == 0 || grid[0].length == 0){
            return maxArea;
        }
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j] == 0){
                    continue;
                }else{
                    int curIsle = dfs(grid,i,j);
                    maxArea = Math.max(maxArea,curIsle);
                }
            }
        }
        return maxArea;
    }
    
    private int dfs(int[][] grid, int i ,int j){
        int area = 0;
        if(i < 0 || i>=grid.length || j < 0 || j>=grid[0].length || grid[i][j] == 0){
            return area;
        }
        if(grid[i][j] == 1){
            area++;
            grid[i][j] = 0;
        }
        area += dfs(grid,i-1,j);
        area += dfs(grid,i+1,j);
        area += dfs(grid,i,j+1);
        area += dfs(grid,i,j-1);
        
        return area;
    }
}
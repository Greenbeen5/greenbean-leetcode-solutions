class Solution {
    public int surfaceArea(int[][] grid) {
        int N = grid.length;
        int area = 0;
        for(int i = 0;i<N;i++){
            for(int j = 0;j<N;j++){
                if(grid[i][j]>0){
                    area += grid[i][j]*4 + 2;
                    if(j!=N-1){
                        area -= 2*(Math.min(grid[i][j+1],grid[i][j]));
                    }
                    if(i!=N-1){
                        area -= 2*(Math.min(grid[i+1][j],grid[i][j]));
                    }
                }
            }
        }
        return area;
    }
}
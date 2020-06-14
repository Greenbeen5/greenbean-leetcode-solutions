class Solution {
    boolean possible = false;
    int m,n;
    public boolean hasValidPath(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int initPath = grid[0][0];
        int initDir; // DIR: 1-left 2-right 3-up 4-down
        if(initPath == 1 || initPath == 6){
            initDir = 2;
            trav(grid, 0, 0, initDir);
        }else if(initPath == 2 || initPath == 3){
            initDir = 4;
            trav(grid, 0, 0, initDir);
        }else if(initPath == 5){
            return false;
        }else{
            trav(grid, 0, 0, 2);
            trav(grid, 0, 0, 4);
        }
        
        return possible;
    }
    
    public void trav(int[][] grid, int x, int y, int dir){
        int nx = x,ny = y;
        if(nx == n-1 && ny == m-1){
            possible = true;
            return;
        }
        switch(dir){
            case 1:
                nx--;
                break;
            case 2:
                nx++;
                break;
            case 3:
                ny--;
                break;
            case 4:
                ny++;
                break;
        }
        if(nx >= n || ny >= m || nx < 0 || ny < 0){
            return;
        }
        if(nx == 0 && ny == 0){
            return; // loop
        }
        int path = grid[ny][nx];
        if(path == 1){
            if(dir == 1){
                trav(grid, nx, ny, 1);
            }else if(dir == 2){
                trav(grid, nx, ny, 2);
            }else{
                return;
            }
        }
        if(path == 2){
            if(dir == 3){
                trav(grid, nx, ny, 3);
            }else if(dir == 4){
                trav(grid, nx, ny, 4);
            }else{
                return;
            }
        }
        if(path == 3){
            if(dir == 3){
                trav(grid, nx, ny, 1);
            }else if(dir == 2){
                trav(grid, nx, ny, 4);
            }else{
                return;
            }
        }
        if(path == 4){
            if(dir == 3){
                trav(grid, nx, ny, 2);
            }else if(dir == 1){
                trav(grid, nx, ny, 4);
            }else{
                return;
            }
        }
        if(path == 5){
            if(dir == 2){
                trav(grid, nx, ny, 3);
            }else if(dir == 4){
                trav(grid, nx, ny, 1);
            }else{
                return;
            }
        }
        if(path == 6){
            if(dir == 1){
                trav(grid, nx, ny, 3);
            }else if(dir == 4){
                trav(grid, nx, ny, 2);
            }else{
                return;
            }
        }
    }
}
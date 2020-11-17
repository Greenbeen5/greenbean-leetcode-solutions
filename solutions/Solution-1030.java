class Solution {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        List<Location> lList = new ArrayList<>();
        for(int i = 0; i<R; ++i){
            for(int j = 0; j<C; ++j){
                lList.add(new Location(i,j));
            }
        }
        lList.sort((l1,l2) -> 
            Math.abs(l1.R - r0) + Math.abs(l1.C - c0) - Math.abs(l2.R - r0) - Math.abs(l2.C - c0)
            );
        int[][] res = new int[lList.size()][2];
        for(int i = 0; i < lList.size(); ++i){
            res[i] = new int[]{lList.get(i).R, lList.get(i).C};
        }
        return res;
    }
    
    class Location{
        int R;
        int C;
        public Location(int R, int C){
            this.R = R;
            this.C = C;
        }
    }
}
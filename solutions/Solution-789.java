class Solution {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int dist, gDist=Integer.MAX_VALUE;
        dist = Math.abs(target[0]) + Math.abs(target[1]);
        for(int i = 0; i<ghosts.length; ++i){
            gDist = Math.min(gDist, Math.abs(target[0] - ghosts[i][0]) + Math.abs(target[1] - ghosts[i][1]));
        }
        return dist < gDist;
    }
}
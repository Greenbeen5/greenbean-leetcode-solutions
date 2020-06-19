class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[][] year = new int[366][2];
        for(int i = 0; i<days.length; ++i){
            year[days[i]][0] = 1;
        }
        int lastDay = days[days.length - 1];
        for(int i = 1; i<=lastDay; ++i){
            if(year[i][0] == 1){
                if(i < 7){
                    year[i][1] = Math.min(year[i-1][1] + costs[0], Math.min(costs[1], costs[2]));
                }else if(i < 30){
                    year[i][1] = Math.min(year[i-7][1] + costs[1], Math.min(year[i-1][1] + costs[0], costs[2]));
                }else{
                    year[i][1] = Math.min(year[i-30][1] + costs[2],Math.min(year[i-7][1] + costs[1], year[i-1][1] + costs[0]));
                }
            }else{
                year[i][1] = year[i-1][1];
            }
        }
        return year[lastDay][1];
    }
}
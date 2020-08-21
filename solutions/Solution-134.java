class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sumGas = 0;
        for(int i = 0; i<gas.length; ++i){
            sumGas += gas[i];
            sumGas -= cost[i];
        }
        if(sumGas < 0) return -1;
        int g = 0;
        int start = 0;
        for(int i = 0; i<gas.length; ++i){
            if((g + gas[i] - cost[i]) >= 0){
                g = g + gas[i] - cost[i];
            }else{
                g = 0;
                start = (i + 1) >= gas.length ? 0 : i+1;
            }
        }
        return start;
    }
}
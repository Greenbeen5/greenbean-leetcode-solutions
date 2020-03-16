class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int sumOfDist=0;
        int ans = 0;
        for(int n : distance){
            sumOfDist += n;
        }
        if(destination < start){
            int tmp = start;
            start = destination;
            destination = tmp;
        }
        for(int i = start;i<destination;i++){
            ans += distance[i];
        }
        return ans < (sumOfDist-ans) ? ans : sumOfDist - ans;
    }
}
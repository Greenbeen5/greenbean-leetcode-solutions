class Solution {
    public int numRabbits(int[] answers) {
        int minimum = answers.length;
        Arrays.sort(answers); // can also use Map
        for(int i = 0; i<answers.length; ++i){
            int cnt = answers[i];
            if(cnt == 0) continue;
            for(int j = 0; j <= cnt && i+j < answers.length; ++j){
                if(answers[i+j] > answers[i]){
                    minimum += cnt - j + 1; // the current number is already greater than cnt, need to add 1
                    i += j-1; // jump to the next color
                    break;
                }else if(i+j == answers.length-1){ // if reach the boundary
                    minimum += cnt - j; // the current number is equal to cnt, so no need to add 1
                    i = i+j; // end the outer loop
                }else if(j == cnt){
                    // i = i + j + 1;
                    i = i+j; // increment will add 1 to i, so do not add 1 here
                }
            }
        }
        return minimum;
    }
}
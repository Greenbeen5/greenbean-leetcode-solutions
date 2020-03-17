class Solution {
    public String getHint(String secret, String guess) {
        int bulls=0,cows=0;
        char[] sec = secret.toCharArray();
        char[] gue = guess.toCharArray();
        int S=0;
        int[] G = new int[sec.length];
        int[] table = new int[10];
        for(int i = 0;i<sec.length;i++){
            if(Character.isDigit(sec[i])){
                S = (int)sec[i] - (int)'0';
                table[S]++;
            }
            if(Character.isDigit(gue[i])){
                G[i] = (int)gue[i] - (int)'0';
            }
            
            if(S==G[i]){
                bulls++;
            }
        }
        for(int g : G){
            if(table[g]>0){
                cows++;
                table[g]--;
            }
        }
        cows -= bulls;
        return bulls+"A"+cows+"B";
    }
}
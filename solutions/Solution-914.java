class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        int gcd = 0;
        int[] table = new int[10001];
        if(deck.length <= 1){
            return false;
        }
        for(int i = 0;i < deck.length; ++i){
            table[deck[i]]++; 
        }
        for(int i=0; i < 10001;++i){
            if(table[i]!=0){
                if(gcd == 0){
                    gcd = table[i];
                }else{
                    gcd = getGcd(table[i],gcd);
                    if(gcd == 1){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    public int getGcd(int i, int j){
        if(i<j){
            int temp = i;
            i = j;
            j = temp;
        }
        int k=1;
        while(k != 0){
            k = i % j;
            i = j;
            j = k;
        }
        return i;
    }
}
int reverse(int x){
    int sig = x < 0 ? -1:1;
    if(x == INT_MIN){
        return 0;
    }
    if(x < 0) x = -x;
    int low;
    long rev=0L;
    while(x != 0){
        low = x % 10;
        if(low == 0 && rev == 0L){
            x /= 10;
        }else{
            rev *= 10L;
            rev += low;
            x /= 10;
        }
    }
    if(rev > INT_MAX){
        return 0;
    }
    return sig * (int)rev;
}
class Solution {
    public boolean isPerfectSquare(int num) {
        int tail = num % 10;
        if(tail == 2 || tail == 3 || tail == 7 || tail == 8){
            return false;
        }else{
            int i = 1, j = Math.min(num, 46340);
            int mid,sq;
            while(i < j){
                mid = (i + j) / 2;
                sq = mid * mid;
                if(sq < num){
                    i = mid+1;
                }else if(sq > num){
                    j = mid;
                }else{
                    return true;
                }
            }
            if(j * j == num)return true;
            return false;
        }
    }
}

/*
bool isPerfectSquare(int num){
    if (num == 0 ) return false;

    int i = 1;
    while ( num > 0){
        num -= i;
        i += 2;
    }
    return num == 0 ? true : false;

}
*/
class Solution {
    public int addDigits(int num) {
        int j = 0;
        if(num == 0){
            return num;
        }else if((j = num % 9) != 0){
            return j;
        }else{
            return 9;
        }
    }
}
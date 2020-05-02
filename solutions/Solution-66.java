class Solution {
    public int[] plusOne(int[] digits) {
        if(digits[0] == 0){
            return new int[]{1};
        }
        int len = digits.length;
        int[] upRes = new int[len + 1];
        upRes[0] = 1;
        //int[] normalRes = new int[len];
        if(digits[len-1] != 9){
            digits[len-1] += 1;
        }else{
            //digits[len-1] = 0;
            int i;
            for(i = len - 1; i >= 0;i--){
                if(digits[i] == 9){
                    digits[i] = 0;
                }else{
                    digits[i] += 1;
                    break;
                }
            }
            if(i == -1 && digits[0] == 0){
                return upRes;
            }
        }
        return digits;
    }
}
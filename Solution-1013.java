class Solution {
    public boolean canThreePartsEqualSum(int[] A) {
        if(A.length == 0){
            return false;
        }
        int sum = 0;
        int part = 0;
        for(int i = 0;i<A.length;i++){
            sum += A[i];
        }
        if(sum % 3 == 0){
            part = sum / 3;
            int sec1 = 0, sec2 = 0;
            for(int j = 0;j<A.length-2;j++){
                sec1 += A[j];
                if(part == sec1){
                    for(int k = j+1;k<A.length-1;k++){
                        sec2 += A[k];
                        if(part == sec2){
                            return true;
                        }
                    }
                }
            }
        }else{
            return false;
        }
        return false;
    }
}
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        int ml = 0, mr = m-1, row = 0;
        while(ml < mr){
            int mm = ml + (mr - ml) / 2;
            if(matrix[mm][0] == target) return true;
            else if(matrix[mm][0] > target){
                mr = mm;
            }else{
                ml = mm + 1;
            }
        }
        row = matrix[ml][0] > target ? ml-1 : ml;
        if(row < 0) return false;
        if(Arrays.binarySearch(matrix[row], target) < 0)return false;
        else{
            return true;
        }
    }
}
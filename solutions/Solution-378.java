class Solution {
     public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (check(matrix, mid, k, n)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean check(int[][] matrix, int mid, int k, int n) {
        int i = n - 1;
        int j = 0;
        int num = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= mid) {
                num += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return num >= k;
    }
    // public int kthSmallest(int[][] matrix, int k) {
    //     if(k==1) return matrix[0][0];
    //     int n = matrix.length;
    //     int[] colRow = new int[n*n];
    //     int ptr = 0;
    //     for(int i = 0; i<n; i++){
    //         for(int j = 0; j<n; j++){
    //             colRow[ptr++] = matrix[i][j];
    //         }
    //     }
    //     Arrays.sort(colRow);
    //     return colRow[k-1];
    // }
}
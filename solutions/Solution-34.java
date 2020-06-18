class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0)return new int[]{-1,-1};
        int left = binarySearchLeft(nums, 0, nums.length-1, target);
        int right = binarySearchRight(nums, 0, nums.length-1, target);
        return new int[]{left, right};
    }
    
    public int binarySearchLeft(int[] arr, int l, int r, int t){
        if(r - l == 1){
            if(arr[l] == t){
                return l;
            }
            if(arr[r] == t){
                return r;
            }
            return -1;
        }
        if(arr[l] > t || arr[r] < t ){
            return -1; // not found
        }
        if(arr[l] == t){
            return l;
        }
        if(arr[r] == t && arr[r-1] < t) return r;
        int m = (l + r) / 2;
        if(arr[m] < t){
            return binarySearchLeft(arr, m + 1, r, t);
        }else{
            return binarySearchLeft(arr, l, m , t);
        }
    }
    
    public int binarySearchRight(int[] arr, int l, int r, int t){
        if(r - l == 1){
            if(arr[r] == t){
                return r;
            }
            if(arr[l] == t){
                return l;
            }
            return -1;
        }
        if(arr[l] > t || arr[r] < t ){
            return -1; // not found
        }
        if(arr[r] == t){
            return r;
        }
        if(arr[l] == t && arr[l+1] > t) return l;
        int m = (l + r) / 2;
        if(arr[m] > t){
            return binarySearchRight(arr, l, m - 1, t);
        }else{
            return binarySearchRight(arr, m, r, t);
        }
    }
}
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int i:nums){
            heap.offer(i);
        }
        int l = nums.length - k + 1;
        int m=0;
        for(int i = 0;i<l;i++){
            m = heap.poll();
        }
        return m;
    }
}
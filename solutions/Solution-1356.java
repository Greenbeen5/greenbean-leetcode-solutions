class Solution {
    int[] twoPowers = {1, 1<<1, 1<<2, 1<<3, 1<<4, 1<<5, 1<<6, 1<<7, 1<<8, 1<<9, 1<<10, 1<<11, 1<<12, 1<<13};
    int[] cntBit = new int[10001];
    public int[] sortByBits(int[] arr) {
        Integer[] intArr = new Integer[arr.length];
        for(int i = 0; i<arr.length; ++i){
            intArr[i] = arr[i];
            cntBit[arr[i]] = countBit(arr[i]);
        }
        Arrays.sort(intArr, new Comparator<Integer>(){
            @Override
            public int compare(Integer i1, Integer i2){
                int comp = cntBit[i1] - cntBit[i2];
                if(comp == 0){
                    return i1 - i2;
                }else{
                    return comp;
                }
            }
        });
        for(int i = 0; i<arr.length; ++i){
            arr[i] = intArr[i];
        }
        return arr;
    }
    
    private int countBit(int i){
        int cnt = 0;
        for(int p : twoPowers){
            if((i & p) != 0) cnt++;
        }
        return cnt;
    }
}
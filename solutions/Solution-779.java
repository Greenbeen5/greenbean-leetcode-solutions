class Solution {
    public int kthGrammar(int N, int K) {
        int pow = 1 << (N-1); // 当前层的长度
        /*
          0 -> 0[1] -> 01[10] -> 0110[1001]
          每一次都是把上一层复制一份，然后copy部分全部取反，这样一来如果K在这一层的
          后半部分，就需要累加一次change，如果K在前半部分，就和上一层一样，那就没有
          取反，所以不用累加change，最后按change的奇偶性来输出即可。
        */
        int change = 0; 
        while(pow > 1){
            pow /= 2; // 上一层的元素数量
            if(K > pow){
                change++;
            }
            K = K % pow == 0 ? pow : K % pow; // 取余的时候要注意把余为0的改为pow
        }
        return change % 2 == 0 ? 0 : 1;
    }
}
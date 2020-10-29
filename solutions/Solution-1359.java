class Solution {
    public int countOrders(int n) {
        long opers;
        if(n == 1) return 1;
        else opers = countOrdersLong(n);
        return (int)(opers % 1000000007L);
    }
    
    public long countOrdersLong(int n) {
        if(n == 1) return 1;
        int last = (n - 1) * 2 + 1; // 上一次计算之后每个序列有多少个可以插入的位置
        int single = (last+1) * last / 2; // 对于一个序列有多少种插入方式
        long ret = countOrdersLong(n-1) * single;
        if(ret > (long)(1e9+7)){
            ret %= (long)(1e9+7);  // 余数运算法则
        }
        return ret;
    }
}
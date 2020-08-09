public class Solution {
    List<String> ans = new ArrayList<String>();//放结果的数组
    int n;//S的长度
    String result;//表示回溯中当前已经拼接起来的字符串
    int num_dot;//串result中，“.”的个数
    int idx;//表示，当前已经遍历到串s的哪个位置了

    public boolean check(String x){
        int num = Integer.parseInt(x);
        return num >=0 && num <= 255;
    }

    public List<String> restoreIpAddresses(String s) {
        n=s.length();
        idx=0;
        num_dot=0;
        result = "";
        backtrack(s);
        return ans;
    }

    public void backtrack(String s){
        if( num_dot==4 && idx==n ){
            ans.add(result.substring(0,result.length()-1));
        }
        else if( idx>=n && num_dot<4 ){
            return;
        }
        else if( idx<=n-1 && num_dot>=4 ){
            return;
        }

        List<String> st=new ArrayList<>();

        for(int i=0; i<3 && idx+i<n ;++i){
            String candidate=s.substring(idx,i+1+idx);
            if(i!=0 && candidate.charAt(0)=='0') continue;
            st.add(candidate);
        }

        for (String value : st) {
            if (check(value)) {
                int len = value.length();

                result += (value + ".");
                num_dot++;
                idx += len;
                backtrack(s);
                //重置result,num_dot,idx，准备迎接下一个strs[i]
                result = result.substring(0, result.length() - len - 1);

                num_dot--;
                idx -= len;
            }
        }
    }

}
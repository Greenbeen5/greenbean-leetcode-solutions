class Solution {
    public boolean isHappy(int n) {
        Set<Integer> happySet = new HashSet<>();
        //ArrayList<Integer> digits = new ArrayList<>();
        while(true){
            //digits.clear();
            int sum = 0;
            while(n > 0){
                int low = n % 10;
                sum += low * low;
                n /= 10;
            }
            // for(Integer i:digits){
            //     sum += i * i;
            // }
            if(sum == 1){
                return true;
            }
            if(happySet.contains(sum)){
                return false;
            }else{
                happySet.add(sum);
            }
            n = sum;
        }
    }
}
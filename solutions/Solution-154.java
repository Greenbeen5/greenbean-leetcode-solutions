class Solution {
    public int minArray(int[] numbers) {
        if(numbers.length == 1) return numbers[0];
        for(int i = 1; i<numbers.length; ++i){
            if(numbers[i] < numbers[i-1]) return numbers[i];
        }
        return numbers[0]; // all the same number
    }
}
class Solution {
    public String largestMultipleOfThree(int[] digits) {
        Arrays.sort(digits);
        if(digits[digits.length - 1] == 0){
            return "0";
        }
        int sum = 0;
        List<Integer> mod1 = new ArrayList<>(); // digits mod 3 == 1
        List<Integer> mod2 = new ArrayList<>(); // digits mod 3 == 2
        for(int i = 0; i < digits.length; ++i){
            sum += digits[i];
            if(digits[i] % 3 == 1){
                mod1.add(i);
            }else if(digits[i] % 3 == 2){
                mod2.add(i);
            }
        }
        if(sum % 3 == 0){
            return build(digits);
        }else if(sum % 3 == 1){
            if(mod1.size() == 0){
                if(mod2.size() < 2){
                    return "";
                }else{
                    for(int i = 0; i<2; ++i){
                        digits[mod2.get(i)] = -1; // two mod2 digits is equivalent to one mod 1 digit
                    }
                }
            }else{
                digits[mod1.get(0)] = -1; // mod1.get(0) is always the smallest
            }
        }else if(sum % 3 == 2){
            if(mod2.size() == 0){
                if(mod1.size() < 2){
                    return "";
                }else{
                    for(int i = 0; i<2; ++i){
                        digits[mod1.get(i)] = -1; // vice versa
                    }
                }
            }else{
                digits[mod2.get(0)] = -1;
            }
        }
        return build(digits);
    }
    
    private String build(int[] nums){
        StringBuilder sb = new StringBuilder();
        for(int i = nums.length - 1; i >= 0; --i){
            if(nums[i] != -1){
                sb.append(nums[i]);
            }
        }
        if(sb.length() == 0 || sb.charAt(0) == '0') return "";
        else return sb.toString();
    }
}
class Solution {
    public String defangIPaddr(String address) {
        char[] add = address.toCharArray();
        char[] out = new char[address.length() + 6];
        int n = 0;
        for(char c : add){
            if(c == '.'){
                out[n++] = '[';
                out[n++] = c;
                out[n++] = ']';
            }
            else{
                out[n++] = c;
            }
        }
        String s = new String(out);
        return s;
    }
}
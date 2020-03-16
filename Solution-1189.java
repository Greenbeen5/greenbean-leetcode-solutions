class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] wordCount = new int[5];
        for(int i = 0;i<text.length();++i){
            switch(text.charAt(i)){
                case 'b':
                    wordCount[0]+=2;
                    break;
                case 'a':
                    wordCount[1]+=2;
                    break;
                case 'n':
                    wordCount[2]+=2;
                    break;
                case 'l':
                    wordCount[3]++;
                    break;
                case 'o':
                    wordCount[4]++;
                    break;
                default:
                    break;
            }
        }
        int min = 5001;
        for(int m : wordCount){
            if(min > m){
                min = m;
            }
        }
        return min/2;
    }
}
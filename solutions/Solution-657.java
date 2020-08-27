class Solution {
    public boolean judgeCircle(String moves) {
        int horizontal = 0;
        int vertical = 0;
        for(char ch : moves.toCharArray()){
            switch(ch){
                case 'R':
                    horizontal++;
                    break;
                case 'L':
                    horizontal--;
                    break;
                case 'U':
                    vertical++;
                    break;
                case 'D':
                    vertical--;
                    break;
                default:
                    break;
            }
        }
        return (horizontal | vertical) == 0;
    }
}
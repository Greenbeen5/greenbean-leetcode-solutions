class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> remains = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i<asteroids.length; ++i){
            if(asteroids[i] < 0){
                while(stack.size() > 0){
                    int last = stack.pop();
                    if(last > -asteroids[i]){
                        stack.push(last);
                        break;
                    }else if(last == -asteroids[i]){
                        asteroids[i] = 0;
                        break;
                    }
                }
                if(stack.size() == 0 && asteroids[i] != 0){
                    remains.add(asteroids[i]);
                }
            }else{
                stack.push(asteroids[i]);
            }
        }
        while(stack.size() > 0){
            remains.add(stack.pollLast());
        }
        int[] res = new int[remains.size()];
        for(int i = 0; i<remains.size(); ++i){
            res[i] = remains.get(i);
        }
        return res;
    }
}
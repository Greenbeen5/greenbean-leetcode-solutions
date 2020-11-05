class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(wordList.size() == 0) return 0;
        if(!wordList.contains(endWord)) return 0;
        int dist = 1;
        Deque<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);
        while(queue.size() > 0){
            int curSize = queue.size();
            for(int i = 0; i<curSize; ++i){
                String cur = queue.poll();
                for(int k = 0; k<wordList.size(); ++k){
                    if(wordList.get(k) == "") continue;
                    String s = wordList.get(k);
                    if(s.equals(cur)){
                        wordList.set(wordList.indexOf(s), "");
                        continue;
                    }
                    boolean flag = false;
                    for(int j = 0; j<s.length(); ++j){
                        if(s.charAt(j) != cur.charAt(j)){
                            if(flag){
                                flag = false;
                                break;
                            } 
                            else{
                                flag = true;
                            }
                        }
                    }
                    if(flag){
                        if(s.equals(endWord)){
                            return dist+1;
                        }
                        wordList.set(wordList.indexOf(s), "");
                        queue.offer(s);
                    }
                }
            }
            dist++;
        }
        return 0;
    }
}
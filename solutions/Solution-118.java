class Solution {
    public List<List<Integer>> generate(int numRows) {
        if(numRows == 0)return new ArrayList<List<Integer>>();
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        List<Integer> init = new ArrayList<>();
        init.add(1);
        triangle.add(init);
        for(int i = 2; i<=numRows; ++i){
            List<Integer> cur = new ArrayList<>(i);
            List<Integer> last = triangle.get(i-2);
            cur.add(1);
            for(int j = 1; j < i-1; ++j){
                cur.add(last.get(j) + last.get(j-1));
            }
            cur.add(1);
            triangle.add(cur);
        }
        return triangle;
    }
}
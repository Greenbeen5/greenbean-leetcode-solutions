class Solution {
    public int[][] kClosest(int[][] points, int K) {
        int[][] ans = new int[K][2];
        PriorityQueue<Point> minHeap = new PriorityQueue<>(points.length, new Comparator<Point>(){
            @Override
            public int compare(Point p1, Point p2){
                return p1.distance - p2.distance;
            }
        });
        for(int i = 0; i<points.length; ++i){
            minHeap.offer(new Point(points[i][0], points[i][1]));
        }
        for(int i = 0; i<K; ++i){
            Point p = minHeap.poll();
            ans[i][0] = p.x;
            ans[i][1] = p.y;
        }
        return ans;
    }
    
    class Point{
        int x;
        int y;
        int distance;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
            distance = x*x + y*y;
        }
    }
}
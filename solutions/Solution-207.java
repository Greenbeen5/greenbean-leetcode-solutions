class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        /* This is a poor solution, a much better scheme is to use BFS and a 
           helper Queue. See that at the end of this document.
          */
        List<Set<Integer>> revAdj = new ArrayList<>(numCourses); // reverse adjacency matrix
        int[] indegrees = new int[numCourses];
        boolean[] removed = new boolean[numCourses]; // the courses removed
        for(int i = 0; i<numCourses; ++i){
            revAdj.add(new HashSet<Integer>());
        }
        for(int[] pre : prerequisites){
            revAdj.get(pre[0]).add(pre[1]);
            indegrees[pre[0]]++;
        }
        boolean allZeroFlg,operatedFlg;
        while(true){
            allZeroFlg = true;
            operatedFlg = false;
            for(int i = 0; i<numCourses; ++i){
                if(!removed[i] && indegrees[i] == 0){
                    for(int j = 0; j<numCourses; ++j){
                        if(!removed[j]){
                            Set<Integer> cur = revAdj.get(j);
                            if(cur.contains((Integer)i)){
                                indegrees[j]--;
                                cur.remove((Integer)i);
                                operatedFlg = true;
                            }
                        }
                    }
                    removed[i] = true;
                }else{
                    allZeroFlg = false;
                }
            }
            if(!operatedFlg || allZeroFlg){
                break;
            }
        }
        for(int i = 0; i<numCourses; ++i){
            if(!removed[i])
                return false;
        }
        return true;
    }
}

/*
public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        List<List<Integer>> adjacency = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++)
            adjacency.add(new ArrayList<>());
        // Get the indegree and adjacency of every course.
        for(int[] cp : prerequisites) {
            indegrees[cp[0]]++;
            adjacency.get(cp[1]).add(cp[0]);
        }
        // Get all the courses with the indegree of 0.
        for(int i = 0; i < numCourses; i++)
            if(indegrees[i] == 0) queue.add(i);
        // BFS TopSort.
        while(!queue.isEmpty()) {
            int pre = queue.poll();
            numCourses--;
            for(int cur : adjacency.get(pre))
                if(--indegrees[cur] == 0) queue.add(cur);
        }
        return numCourses == 0;
    }
    */
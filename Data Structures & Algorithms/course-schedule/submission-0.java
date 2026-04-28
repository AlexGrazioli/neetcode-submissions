class Solution {
    List<List<Integer>> graph = new ArrayList<>();
    boolean[] visited;
    boolean[] visiting;
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());
        for (int[]pre : prerequisites) graph.get(pre[0]).add(pre[1]);// course pre[0] requires pre[1]

        visited = new boolean[numCourses];
        visiting = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (dfs(i)) return false;
        }
        
        return true;
    }

    private boolean dfs(int course) {
        // check visiting → cycle
        if (visiting[course]) return true;
        
        // check visited → already safe
        if (visited[course]) return false;
        
        // mark visiting
        visiting[course] = true;
        
        // recurse into prerequisites
        for (Integer prerequisite : graph.get(course)) {
            if (dfs(prerequisite)) return true;
        }

        // unmark visiting, mark visited
        visiting[course] = false;
        visited[course] = true;
        
        return false;
    }
}

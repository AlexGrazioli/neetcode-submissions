class Solution {
        List<List<Integer>> graph = new ArrayList<>();
    boolean[] visited;

    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;

        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[]edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        visited = new boolean[n];
        dfs(0);

        for (boolean visitedNode : visited) {
         if (!visitedNode) return false;
        }

        return true;
    }

    private void dfs(int node) {
        if (visited[node]) return;
        visited[node] = true;

        for (Integer neighbour : graph.get(node)) 
            dfs(neighbour);
    }
}

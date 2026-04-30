class Solution {
    int[] parent;
    int components;

    public int countComponents(int n, int[][] edges) {
        components = n;
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        for (int[] edge : edges) {
            union(edge[0], edge[1]);
        }

        return components;
    }

    private int find(int node) {
        if (parent[node] == node) return node;
        return find(parent[node]);
    }

    private void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            parent[rootA] = rootB;
            components--;
        }
    }
}

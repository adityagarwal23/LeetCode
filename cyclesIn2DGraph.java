class Solution {
    public boolean containsCycle(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] parent = new int[m * n];

        //Initialize DSU: mapping (r, c) to i * n + j
        for (int i = 0; i < m * n; i++) parent[i] = i;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //check Right Neighbor
                if (j + 1 < n && grid[i][j] == grid[i][j + 1]) {
                    int u = i * n + j;
                    int v = i * n + (j + 1);

                    //inline Find for u
                    int rootU = u;
                    while (rootU != parent[rootU]) {
                        parent[rootU] = parent[parent[rootU]]; 
                        rootU = parent[rootU];
                    }
                    //inline Find for v
                    int rootV = v;
                    while (rootV != parent[rootV]) {
                        parent[rootV] = parent[parent[rootV]];
                        rootV = parent[rootV];
                    }

                    if (rootU == rootV) return true;
                    parent[rootU] = rootV;
                }

                //check Down Neighbor
                if (i + 1 < m && grid[i][j] == grid[i + 1][j]) {
                    int u = i * n + j;
                    int v = (i + 1) * n + j;

                    //inline Find for u
                    int rootU = u;
                    while (rootU != parent[rootU]) {
                        parent[rootU] = parent[parent[rootU]];
                        rootU = parent[rootU];
                    }
                    //inline Find for v
                    int rootV = v;
                    while (rootV != parent[rootV]) {
                        parent[rootV] = parent[parent[rootV]];
                        rootV = parent[rootV];
                    }

                    if (rootU == rootV) return true;
                    parent[rootU] = rootV;
                }
            }
        }
        return false;
    }
}
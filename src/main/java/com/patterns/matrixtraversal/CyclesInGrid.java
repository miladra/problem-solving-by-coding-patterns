package com.patterns.matrixtraversal;

class CyclesInGrid {
    public boolean containsCycle(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] parent = new int[m*n];
        int[] rank = new int[m*n];
        for (int i = 0; i < m*n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int index = i*n + j;
                if (i > 0 && grid[i][j] == grid[i-1][j]) {
                    int neighborIndex = (i-1)*n + j;
                    if (union(parent, rank, index, neighborIndex)) {
                        return true;
                    }
                }
                if (j > 0 && grid[i][j] == grid[i][j-1]) {
                    int neighborIndex = i*n + (j-1);
                    if (union(parent, rank, index, neighborIndex)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean union(int[] parent, int[] rank, int i, int j) {
        int root1 = find(parent, i);
        int root2 = find(parent, j);
        if (root1 == root2) {
            return true;
        }
        if (rank[root1] > rank[root2]) {
            parent[root2] = root1;
        } else if (rank[root1] < rank[root2]) {
            parent[root1] = root2;
        } else {
            parent[root2] = root1;
            rank[root1]++;
        }
        return false;
    }

    private int find(int[] parent, int i) {
        if (parent[i] != i) {
            parent[i] = find(parent, parent[i]);
        }
        return parent[i];
    }
}


class SolutionBruteForce {
    public boolean containsCycle(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    if (dfs(grid, visited, i, j, i, j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] grid, boolean[][] visited, int i, int j, int pi, int pj) {
        if (visited[i][j]) {
            return true;
        }
        visited[i][j] = true;
        int m = grid.length;
        int n = grid[0].length;
        boolean res = false;
        if (i > 0 && grid[i-1][j] == grid[i][j] && !(i-1 == pi && j == pj)) {
            res |= dfs(grid, visited, i-1, j, i, j);
        }
        if (j > 0 && grid[i][j-1] == grid[i][j] && !(i == pi && j-1 == pj)) {
            res |= dfs(grid, visited, i, j-1, i, j);
        }
        if (i < m-1 && grid[i+1][j] == grid[i][j] && !(i+1 == pi && j == pj)) {
            res |= dfs(grid, visited, i+1, j, i, j);
        }
        if (j < n-1 && grid[i][j+1] == grid[i][j] && !(i == pi && j+1 == pj)) {
            res |= dfs(grid, visited, i, j+1, i, j);
        }
        visited[i][j] = false;
        return res;
    }
}


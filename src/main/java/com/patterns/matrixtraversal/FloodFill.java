package com.patterns.matrixtraversal;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
    //DFS
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) return image;
        fill(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    private void fill(int[][] image, int sr, int sc, int color, int newColor) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != color) return;
        image[sr][sc] = newColor;
        fill(image, sr + 1, sc, color, newColor);
        fill(image, sr - 1, sc, color, newColor);
        fill(image, sr, sc + 1, color, newColor);
        fill(image, sr, sc - 1, color, newColor);
    }

    //BFS
    int[] DIRS = {0, 1, 0, -1, 0};

    public int[][] floodFill_BFS(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) return image; // same color -> no need to replace

        int m = image.length, n = image[0].length;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sr, sc});

        int oldColor = image[sr][sc];
        image[sr][sc] = newColor;
        while (!q.isEmpty()) {
            int[] top = q.poll();
            for (int i = 0; i < 4; i++) {
                int nr = top[0] + DIRS[i];
                int nc = top[1] + DIRS[i + 1];
                if (nr < 0 || nr == m || nc < 0 || nc == n || image[nr][nc] != oldColor) continue;
                image[nr][nc] = newColor; // also mean we marked it as visited!
                q.offer(new int[]{nr, nc});
            }
        }
        return image;
    }
}


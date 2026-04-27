import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public boolean hasValidPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] dr = { 0,  0, -1, 1};
        int[] dc = {-1,  1,  0, 0};
        int[] opp = {1, 0, 3, 2};

        boolean[][] opens = {
            {},
            {true,  true,  false, false},
            {false, false, true,  true},
            {true,  false, false, true},
            {false, true,  false, true},
            {true,  false, true,  false},
            {false, true,  true,  false}
        };

        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];

            if (r == m - 1 && c == n - 1) {
                return true;
            }

            for (int d = 0; d < 4; d++) {
                if (!opens[grid[r][c]][d]) {
                    continue;
                }

                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                    continue;
                }

                if (visited[nr][nc]) {
                    continue;
                }

                if (!opens[grid[nr][nc]][opp[d]]) {
                    continue;
                }

                visited[nr][nc] = true;
                queue.offer(new int[]{nr, nc});
            }
        }

        return false;
    }
}
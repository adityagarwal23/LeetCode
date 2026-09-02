import java.util.*;

class Solution {

    static class State {
        int r, c;
        int mask;
        int energy;
        int steps;

        State(int r, int c, int mask, int energy, int steps) {
            this.r = r;
            this.c = c;
            this.mask = mask;
            this.energy = energy;
            this.steps = steps;
        }
    }

    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();

        int startR = 0;
        int startC = 0;

        // Give every litter cell an ID: 0, 1, 2, ...
        int[][] litterId = new int[m][n];
        for (int[] row : litterId) {
            Arrays.fill(row, -1);
        }

        int litterCount = 0;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                char ch = classroom[r].charAt(c);

                if (ch == 'S') {
                    startR = r;
                    startC = c;
                } else if (ch == 'L') {
                    litterId[r][c] = litterCount++;
                }
            }
        }

        // All litter collected.
        int fullMask = (1 << litterCount) - 1;

        if (fullMask == 0) {
            return 0;
        }

        /*
         * bestEnergy[r][c][mask] =
         * maximum remaining energy with which we've reached
         * (r, c) after collecting exactly the litter in mask.
         *
         * -1 means this state has never been reached.
         * adopted from AI help
         */
        int[][][] bestEnergy = new int[m][n][1 << litterCount];

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                Arrays.fill(bestEnergy[r][c], -1);
            }
        }

        Queue<State> queue = new ArrayDeque<>();

        bestEnergy[startR][startC][0] = energy;
        queue.offer(new State(startR, startC, 0, energy, 0));

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            State cur = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                // Outside grid
                if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                    continue;
                }

                // Obstacle
                if (classroom[nr].charAt(nc) == 'X') {
                    continue;
                }

                //keep making moves
                if (cur.energy == 0) {
                    continue;
                }

                int newEnergy = cur.energy - 1;

                // Collect litter if this cell contains one.
                int newMask = cur.mask;

                if (classroom[nr].charAt(nc) == 'L') {
                    int id = litterId[nr][nc];
                    newMask |= (1 << id);
                }

                if (classroom[nr].charAt(nc) == 'R') {
                    newEnergy = energy;
                }

                int newSteps = cur.steps + 1;

                // We have collected everything.
                if (newMask == fullMask) {
                    return newSteps;
                }

                if (newEnergy == 0) {
                    continue;
                }

                //useless if we already reached.
                if (newEnergy <= bestEnergy[nr][nc][newMask]) {
                    continue;
                }

                bestEnergy[nr][nc][newMask] = newEnergy;

                queue.offer(
                    new State(
                        nr,
                        nc,
                        newMask,
                        newEnergy,
                        newSteps
                    )
                );
            }
        }

        return -1;
    }
}
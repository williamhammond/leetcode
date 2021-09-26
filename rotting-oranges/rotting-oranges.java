class Solution {
    private static class Pair<T, U> {
        private  final T first;
        private  final U second;
        public Pair(T first, U second) {
            this.first = first;
            this.second = second;
        }

        public T getFirst() {
            return first;
        }
        public U getSecond() {
            return second;
        }
    }
    private static final int[][] MOVES = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int orangesRotting(int[][] grid) {
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();

        int freshOranges = 0;
        int m = grid.length;
        int n = grid[0].length;

        for (int row = 0; row < m; ++row) {
            for (int col = 0; col < n; ++col) {
                if (grid[row][col] == 2) {
                    queue.add(new Pair<>(row, col));
                }
                if (grid[row][col] == 1) {
                    freshOranges++;
                }
            }
        }

        // Indicates the end of minute
        queue.add(null);
        int minutes = -1;
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> current = queue.remove();
            if (current == null) {
                minutes++;
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
                continue;
            }
            int row = current.getFirst();
            int col = current.getSecond();

            for (int[] move : MOVES) {
                int neighborRow = row + move[0];
                int neighborCol = col + move[1];
                if (neighborRow >= 0 && neighborRow < m && neighborCol >= 0 && neighborCol < n) {
                    if (grid[neighborRow][neighborCol] == 1) {
                        grid[neighborRow][neighborCol] = 2;
                        freshOranges--;
                        queue.offer(new Pair<>(neighborRow, neighborCol));
                    }
                }
            }
        }
        return freshOranges == 0 ? minutes : -1;
    }
}
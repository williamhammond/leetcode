import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

class Solution {
    int[][] dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    
    public int getFood(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<Pair> queue = new LinkedList<Pair>();
        queue.add(getStart(grid, m, n));
        
        int step = 0;
        while(!queue.isEmpty()) {
            step++;
            System.out.println("Current queue " + queue);
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair current = queue.remove();
                
                for (int[] dir: dirs) {
                    int adjX = current.getX() + dir[0];
                    int adjY = current.getY() + dir[1];
                    
                    if (adjX < 0 || adjY < 0 || adjX >= m || adjY >= n || grid[adjX][adjY] == 'X') {
                        continue;
                    }
                    
                    if (grid[adjX][adjY] == '#') {
                        return step;
                    }
                    
                    grid[adjX][adjY] = 'X';
                    queue.add(new Pair(adjX, adjY));
                }
            }
        }
        
        return -1;
    }
    
    public Pair getStart(char[][] grid, int m, int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '*') {
                    return new Pair(i, j);
                }
            }
        }
        throw new IllegalStateException("No start found.");
    }
    
    
    static class Pair {
        private final int x;
        private final int y;
        
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        public int getX () {
            return this.x;
        }
        
        public int getY () {
            return this.y;
        }
        
        @Override
        public String toString() {
            return "(" + getX() + ", " + getY() + ")";
        }
        
        @Override
        public boolean equals(Object o) {
            if (o == null) {
                return false;
            }
            if (o.getClass() != this.getClass()) {
                return false;
            }
            Pair other = (Pair) o;
            return other.x == this.x && other.y == this.y;
        }
    }
}
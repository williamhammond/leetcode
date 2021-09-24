import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        
        if (k >= m + n - 2) {
            return m + n - 2;
        }
        
        Deque<State> queue = new LinkedList<State>();
        HashSet<State> visited = new HashSet<>();
        
        
        State start = new State(0, 0, 0, k);
        queue.addLast(start);
        visited.add(start);
        while(!queue.isEmpty()) {
            State current = queue.pollFirst();
            if (m - 1 == current.getX() && n - 1 == current.getY()) {
                return current.steps;
            }
            
            int[] nextSteps = {current.getX(), current.getY() + 1, current.getX() + 1, current.getY(),
                               current.getX(), current.getY() - 1, current.getX() - 1, current.getY()};
            for (int i = 0; i < nextSteps.length; i += 2) {
                int adjX = nextSteps[i];
                int adjY = nextSteps[i + 1];
                
                if (adjX < 0 || adjY < 0 || adjX >= m || adjY >= n) {
                    continue;
                }
                int nextElimination = current.k - grid[adjX][adjY];
                State newState = new State(adjX, adjY, current.steps + 1, nextElimination);

                if (nextElimination >= 0 && !visited.contains(newState)) {
                    visited.add(newState);
                    queue.addLast(newState);
                }
            }
        }
        
        return -1;
    }
    
    static class State {
        private final int x;
        private final int y;
        private final int k;
        private final int steps;
        
        public State(int x, int y, int steps, int k) {
            this.x = x;
            this.y = y;
            this.k = k;
            this.steps = steps;
        }
        
        public int getSteps() {
            return this.steps;
        }
        
        public int getK() {
            return this.k;
        }
        
        public int getX() {
            return this.x;
        }
        
        public int getY() {
            return this.y;
        }
        
        @Override
        public int hashCode() {
            return (this.x + 1) * (this.y + 1) * this.k;
        }
        
        @Override
        public String toString() {
            return "score: " + getK() + ", step: " + getSteps() + "(" + getX() + ", " + getY() + ")";
        }
        
        @Override
        public boolean equals(Object o) {
            if (o == null) {
                return false;
            }
            if (o.getClass() != this.getClass()) {
                return false;
            }
            State other = (State) o;
            return other.x == this.x && other.y == this.y && other.k == this.k;
        }
    } 
}
    
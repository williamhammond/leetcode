import java.util.*;

class Solution {
    public boolean validTree(int n, int[][] edges) {
        
        if (edges.length != n - 1) return false;
        
        UnionFind unionFind = new UnionFind(n);
        for (int[] edge : edges) {
            int A = edge[0];
            int B = edge[1];
            if (!unionFind.union(edge[0], edge[1])) {
                return false;
            }
        }
        
        return true;
    }
    
    class UnionFind {
        private int[] root;
        private int[] rank;
        private int setCount;

        public UnionFind(int size) {
            setCount = size;
            root = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                root[i] = i;
                rank[i] = 1; 
            }
        }

        public int find(int x) {
            if (x == root[x]) {
                return x;
            }
            return root[x] = find(root[x]);
        }

        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    root[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    root[rootX] = rootY;
                } else {
                    root[rootY] = rootX;
                    rank[rootX] += 1;
                }
                setCount--;
                return true;
            }
            return false;
        }

        public boolean connected(int x, int y) {
            return find(x) == find(y);
        }
        
        public int getNumberOfDisjointSets() {
            return setCount;
        }
    }

}
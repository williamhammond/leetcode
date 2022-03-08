class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        self.M = len(grid)
        self.N = len(grid[0])
        
        result = 0
        for i in range(self.M):
            for j in range(self.N):
                if (grid[i][j] == "1"):
                    self.flood_fill(grid, i, j)
                    result += 1
        return result
    
    def flood_fill(self, grid: List[List[str]], m: int, n: int):
        queue = []
        queue.append((m, n))
        while len(queue) > 0:
            i, j = queue.pop()
            grid[i][j] = "0"
            
            if i - 1 >= 0 and grid[i - 1][j] == "1":
                queue.append((i - 1, j))
            if i + 1 < self.M and grid[i + 1][j] == "1":
                queue.append((i + 1, j))
            if j - 1 >= 0 and grid[i][j - 1] == "1":
                queue.append((i, j - 1))
            if j + 1 < self.N and grid[i][j + 1] == "1":
                queue.append((i, j + 1))
                
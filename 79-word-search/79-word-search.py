class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        self.m = len(board)
        self.n = len(board[0])
        
        for i in range(self.m):
            for j in range(self.n):
                if self.backtrack(board, word, i, j, 0):
                    return True
                
        return False
    
    def backtrack(self, board: List[List[str]], word: str, row: int, col: int, index: int) -> bool:
        if index == len(word):
            return True
        
        if row < 0 or col < 0 or row > self.m - 1 or col > self.n - 1:
            return False
        
        if board[row][col] != word[index]:
            return False

        
        board[row][col] = "*"
        exists = self.backtrack(board, word, row + 1, col, index + 1) or \
            self.backtrack(board, word, row - 1, col, index + 1)      or \
            self.backtrack(board, word, row , col + 1,  index + 1)    or \
            self.backtrack(board, word, row, col - 1,  index + 1)
        board[row][col] = word[index]
        
        return exists
        
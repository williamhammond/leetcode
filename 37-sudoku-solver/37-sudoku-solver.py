class Solution:
    def solveSudoku(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        self.m = 9
        self.valid_digits = [1, 2, 3, 4, 5, 6, 7, 8, 9]
        self.board = board
        self.solve()
        
    def solve(self) -> bool:
        for i in range(self.m):
            for j in range(self.m):
                if (self.board[i][j] == "."):
                    for digit in self.valid_digits:
                        digit = str(digit)
                        if (self.is_valid(i, j, digit)):
                            self.board[i][j] = digit
                            if (self.solve()):
                                return True
                            else:
                                self.board[i][j] = "."
                    return False
        return True
    
    def is_valid(self, row: int, col: int, digit: str) -> bool:
        row_region = 3 * int(row / 3)
        col_region = 3 * int(col / 3)
        for i in range(self.m):
            if self.board[i][col] == digit:
                return False
            if self.board[row][i] == digit:
                 return False
            if self.board[row_region + int(i / 3)][col_region + i % 3] == digit: 
                return False
        return True
        
        
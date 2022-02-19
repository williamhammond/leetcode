class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        return self.backtrack([], "", 0, 0, n)
    
    def backtrack(self, result: List[str], current: str, open_count: int, close_count: int, n: int) -> List[str]:
        if len(current) == n * 2:
            result.append(deepcopy(current))
        else:
            if open_count < n:
                self.backtrack(result, current + "(", open_count + 1, close_count, n);
            if close_count < open_count:
                self.backtrack(result, current + ")", open_count, close_count + 1, n);
        return result

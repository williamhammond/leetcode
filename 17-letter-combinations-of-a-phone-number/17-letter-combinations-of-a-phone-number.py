class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        self.digit_to_letter = {2: ["a", "b", "c"],
                                3: ["d", "e", "f"],
                                4: ["g", "h", "i"],
                                5: ["j", "k", "l"],
                                6: ["m", "n", "o"],
                                7: ["p", "q", "r", "s"],
                                8: ["t", "u", "v"],
                                9: ["w", "x", "y", "z"],
                               }
        return self.backtrack(digits, "", [], 0)
    
    def backtrack(self, digits:str, current: str, results: List[str], index: int) -> List[str]:
        if (digits == ""):
            return []
        if (len(current) == len(digits)):
            results.append(deepcopy(current))
        else:
            for letter in self.digit_to_letter[int(digits[index])]:
                current = current + letter
                self.backtrack(digits, current, results, index + 1)
                current = current[:-1]
            
            
        return results
        
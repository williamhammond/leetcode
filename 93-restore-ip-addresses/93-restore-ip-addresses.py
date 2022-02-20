import re

class Solution:
    def restoreIpAddresses(self, s: str) -> List[str]:
        result = []
        self.backtrack(s, 0, "", result)
        return result
    
    def backtrack(self, s: str, index: int, current: str, result: List[str]):
        if index == 4:
            if not s:
                result.append(current[:-1])
            return
        for i in range (1, 4):
            if not s:
                continue
            octet = s[0: i]
            if int(octet) > 255 or i != len(octet) or (len(octet) > 1 and octet[0] == "0"): 
                continue
            
            self.backtrack(s[i:], index + 1, current + octet + ".", result);
    
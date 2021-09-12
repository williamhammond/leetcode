import java.util.Set;
import java.util.HashSet;

import java.util.Map;
import java.util.HashMap;

class Solution {
    public int numSplits(String s) {
        Map<Character, Integer> leftCounts = new HashMap<Character, Integer>();
        Map<Character, Integer> rightCounts = new HashMap<Character, Integer>();
        
        leftCounts.put(s.charAt(0), 1);
        for (int i = 1; i < s.length(); i++) {
            int count = rightCounts.containsKey(s.charAt(i)) ? rightCounts.get(s.charAt(i)) : 0;
            rightCounts.put(s.charAt(i), count + 1);
        }
        
        int goodSplits = 0;
        for (int i = 1; i < s.length(); i++) {
            goodSplits += leftCounts.size() == rightCounts.size() ? 1 : 0;
            
            int count = leftCounts.containsKey(s.charAt(i)) ? leftCounts.get(s.charAt(i)) : 0;
            leftCounts.put(s.charAt(i), count + 1);
            
            if (rightCounts.get(s.charAt(i)) == 1) {
                rightCounts.remove(s.charAt(i));
            } else {
                rightCounts.put(s.charAt(i), rightCounts.get(s.charAt(i)) - 1);
            }
        }
        
        return goodSplits;
    }
}

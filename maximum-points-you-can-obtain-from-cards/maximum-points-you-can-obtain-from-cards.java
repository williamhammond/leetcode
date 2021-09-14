import java.util.Map;

class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int[] front = new int[k + 1];
        int[] back = new int[k + 1];
        
        int n = cardPoints.length; 
        for (int i = 0; i < k; i++) {
            front[i + 1] = cardPoints[i] + front[i];
            back[i + 1] = cardPoints[n - 1 - i] + back[i];  
        }
        
        int maxScore = 0;
        for (int i = 0; i <= k; i++) {
            int score = front[i] + back[k - i];
            maxScore = Math.max(maxScore, score);
        }
        return maxScore;
    }
}
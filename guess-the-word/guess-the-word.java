import java.util.Set;
import java.util.LinkedHashSet;
import java.util.Random;
/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
class Solution {
    public void findSecretWord(String[] wordlist, Master master) {
        for (int i = 0, score = 0; i < 10 && score < 6; i++) {
            String guess = wordlist[new Random().nextInt(wordlist.length)];
            score = master.guess(guess);
            List<String> filteredWords = new ArrayList<>();
            for (String word : wordlist) {
                if (match(guess, word) == score) {
                    filteredWords.add(word);
                }
                
            }
            wordlist = filteredWords.toArray(new String[filteredWords.size()]);
        }
    }
    
    public int match(String a, String b) {
        int matches = 0;
        for (int i = 0; i < a.length(); ++i)
            if (a.charAt(i) == b.charAt(i)) {
                matches++;
            }
        
        return matches;
    }
}

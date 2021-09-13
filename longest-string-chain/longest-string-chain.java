class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b)->Integer.compare(a.length(), b.length()));

        Map<String, Integer> cache = new HashMap<>();
        int result = 0;
        for (String word: words) {
            int best = 0;
            for (int i = 0; i < word.length(); i++) {
                String prev = word.substring(0, i) + word.substring(i + 1);
                best = Math.max(best, cache.getOrDefault(prev, 0) + 1);
            }
            cache.put(word, best);
            result = Math.max(result, best);
        }
        return result;
    }
}
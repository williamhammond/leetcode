class Solution {
    public List<String> fullJustify(String[] raw, int maxWidth) {
        List<String> result = new ArrayList<>();
        
        LinkedList<String> currentLine = new LinkedList<>(); 
        int currentSize = 0;
        for (int i = 0; i < raw.length; i++) {
            String word = raw[i];
            if ((word.length() + currentSize + (currentLine.size() - 1) >= maxWidth))  {
                result.add(justify(currentLine, currentSize, maxWidth, false)); 
                currentLine = new LinkedList<>(); 
                currentLine.add(word);
                currentSize = word.length();
                
            } else {
                currentLine.add(word);
                currentSize += word.length();
            }
            boolean isLast = i == raw.length - 1;
            // On the final iteration, we add whatever we have left.
            if (isLast) {
                result.add(justify(currentLine, currentSize, maxWidth, isLast)); 
            }
        }
        return result;
    }
    
    private String justify(LinkedList<String> line, int size, int maxWidth, boolean isLast) {
        int padding = maxWidth - size;
        if (isLast || line.size() == 1) {
            System.out.println(line);
            return String.join(" ", line) + " ".repeat(padding - (line.size() - 1));
        }
        
        int buckets = line.size() - 1; 
        Map<Integer, Integer> bucketSize = new HashMap<>();
        for (int i = 0; i < buckets; i++) {
            bucketSize.put(i, 0); 
        } 
        for (int i = 0; i < padding; i++) {
            int bucket = i % buckets; 
            bucketSize.put(bucket, bucketSize.get(bucket) + 1);
        }
        
        String result = "";
        for (int i = 0; i < line.size() - 1; i++) {
            String word = line.get(i);
            
            result += word; 
            result += " ".repeat(bucketSize.get(i));
        }
        result += line.getLast();
        return result;
    }
    
}
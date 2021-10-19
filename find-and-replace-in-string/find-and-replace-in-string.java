class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        String result = "";
        int previousIndex = 0;
        
        List<int[]> sorted = new ArrayList<>();
        for (int i = 0 ; i < indices.length; i++) {
          sorted.add(new int[]{indices[i], i});  
        } 
        Collections.sort(sorted, Comparator.comparing(i -> -i[0]));
        for (int[] index: sorted) {
            int i = index[0];
            int j = index[1];
            String source = sources[j];
            String target = targets[j];
            if (s.substring(i, i + source.length()).equals(source)) {
              s = s.substring(0, i) + target + s.substring(i + source.length());   
            }
        }
        return s;
    }
}
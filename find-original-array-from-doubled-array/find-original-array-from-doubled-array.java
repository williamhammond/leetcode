import java.util.SortedMap;
import java.util.TreeMap;
class Solution {
    public int[] findOriginalArray(int[] changed) {
        if (changed.length % 2 != 0) {
            return new int[]{};   
        }
        SortedMap<Integer, Integer> values = new TreeMap<>();
        for (int value: changed) {
            values.put(value, values.getOrDefault(value, 0) + 1);
        }
        int[] result = new int[changed.length / 2];
        int i = 0;
        
        for (int value: values.keySet()) {
            if (values.get(value) > values.getOrDefault(value * 2, 0)) {
                return new int[0];
            }
            for (int j = 0; j < values.get(value); j++) {
                result[i++] = value;
                values.put(value * 2, values.get(value * 2) - 1);
            }
            
        }
        return result;
    }
}
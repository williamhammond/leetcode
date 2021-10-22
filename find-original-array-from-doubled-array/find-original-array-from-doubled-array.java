import java.util.SortedMap;
import java.util.TreeMap;
class Solution {
    public int[] findOriginalArray(int[] changed) {
        if (changed.length % 2 != 0) {
            return new int[]{};   
        }
        SortedMap<Integer, Integer> values = new TreeMap<>();
        for (int i: changed) {
            if(values.containsKey(i)){
                values.put(i, values.get(i) + 1);
            } else {
                values.put(i, 1);
            }
        }
        
        int[] result = new int[changed.length / 2];
        int i = 0;
        for (int value: values.keySet()) {
            int count = values.get(value);
            while (count > 0) {
                if (value == 0)  {
                    if (values.get(value) % 2 != 0) {
                        return new int[]{};   
                    }
                    for (int j = 0; j < (values.get(value) / 2); j++) {
                        result[i] = 0;
                        i++;
                    }
                    count=0;
                    values.put(0, 0);
                } else {
                    if (!values.containsKey(value * 2) || values.get(value * 2) < 1) {
                        return new int[]{};   
                    }

                    result[i] = value;
                    i++;

                    values.put(value, values.get(value) - 1);
                    values.put(value * 2, values.get(value * 2) - 1);
                    count--;
                }
            }
        }
        return result;
    }
}
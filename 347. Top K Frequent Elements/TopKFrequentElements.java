import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.Map;
import java.util.List;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> numsMap = new HashMap<>();
        TreeMap<Integer, List<Integer>> freqMap = new TreeMap<>();
        int[] results = new int[k];

        for (int num: nums){
            numsMap.put(num, numsMap.getOrDefault(num, 0) + 1);
        }

        for (int num: numsMap.keySet()){
            int freq = numsMap.get(num);

            if (!freqMap.containsKey(freq)){
                freqMap.put(freq, new ArrayList<>());
            }
            freqMap.get(freq).add(num);
        }

        int i = 0;
        while (i < k ){
            // pollLastEntry() method is used to remove and 
            // returns a key-value mapping associated with the greatest key in this map,
            Map.Entry<Integer, List<Integer>> map = freqMap.pollLastEntry();

            // iterator object and also check if i <k
            Iterator<Integer> iter = map.getValue().iterator();
 
            while (i< k && iter.hasNext()){
                
                results[i] = iter.next();
                i++;
            }
        }
        return results;

    }
}

public class TopKFrequentElements {
    public static void main(String[] args){

        Solution solution = new Solution();

        int[] nums = {1};
        int k = 1;
        System.out.println(Arrays.toString(solution.topKFrequent(nums, k)));

    }
}

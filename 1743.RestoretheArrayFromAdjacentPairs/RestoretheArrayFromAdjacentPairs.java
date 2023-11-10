import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        // 2 data structures:
        // HashSet: to store singleValues in adjacentPairs-> will be at the corner of arrays
        // HashMap to map integer to its adjacents
        HashSet<Integer> singleValues = new HashSet<>();
        HashMap<Integer,ArrayList<Integer>> valueToAdjacents = new HashMap<>();
        
        for (int[] adjacentPair: adjacentPairs){
            
            // loop thru adjacent pair
            for (int i = 0; i < adjacentPair.length; i++){
                int current = adjacentPair[i];
                int another = (i == 1)? adjacentPair[0]:adjacentPair[1];

                // adding to hashmap
                ArrayList<Integer>adjs = valueToAdjacents.getOrDefault(current, new ArrayList<Integer>());
                adjs.add(another);
                valueToAdjacents.put(current,adjs);

                // adding to hashset
                if (singleValues.contains(current)) singleValues.remove(current);
                else singleValues.add(current);
            }
        }
        // Converting HashSet to Array 
        int[] singleValuesArray = singleValues.stream().mapToInt(Integer::intValue).toArray();
        int n = valueToAdjacents.size();
        int[] results = new int[n];
        
        // add singleValues to the corner of the array 
        // Rationale: corner of the array will only be one adjacent Pairs
        results[0] = singleValuesArray[0];
        results[n-1] = singleValuesArray[1];
        
        // initialize 2 pointers
        int left = 0;
        int right = n -1;
        
        while (left <= right){
            ArrayList<Integer> adjsLeft = valueToAdjacents.get(results[left]);
            ArrayList<Integer> adjsRight = valueToAdjacents.get(results[right]);

            // left
            // anyhow choose one to add since it is at the corner
            if (left == 0) results[left+1] = adjsLeft.get(0);
            
            else{
                for (int adj:adjsLeft){
                if (adj!=results[left-1]) results[left+1] = adj; 
            }
            }
            // right

            // anyhow choose one to add since it is at the corner
            if (right == n-1) results[right-1] = adjsRight.get(0);
            
            else{
                for (int adj:adjsRight){
                if (adj!=results[right + 1]) results[right-1] = adj; 
            }
            }

            left++;
            right--;
        }


        System.out.println(Arrays.toString(singleValuesArray));
        return results;
    }
}
public class RestoretheArrayFromAdjacentPairs {
    public static void main(String[] args){
        Solution solution = new Solution();
        int[][] adjacentPairs = {{2,1},{3,4},{3,2}};
        int[][] adjacentPairs2 = {{4,-2},{1,4},{-3,1}};
        int[][] adjacentPairs3 = {{100000,-100000}};
        System.out.println(Arrays.toString(solution.restoreArray(adjacentPairs)));
    }   
}

// Example 1:

// Input: adjacentPairs = [[2,1],[3,4],[3,2]]
// Output: [1,2,3,4]
// Explanation: This array has all its adjacent pairs in adjacentPairs.
// Notice that adjacentPairs[i] may not be in left-to-right order.
// Example 2:

// Input: adjacentPairs = [[4,-2],[1,4],[-3,1]]
// Output: [-2,4,1,-3]
// Explanation: There can be negative numbers.
// Another solution is [-3,1,4,-2], which would also be accepted.
// Example 3:

// Input: adjacentPairs = [[100000,-100000]]
// Output: [100000,-100000]

import java.util.HashSet;

class Solution {
    public int longestConsecutive(int[] nums) {
        int longest = 0;
        HashSet<Integer> uniques = new HashSet();
        
        //finding all unique nums
        for (int num:nums){
            uniques.add(num);
        }


        for (int num: nums){

            int leftNeighbor = num - 1;

            // if does not have a leftneighbor, it is the start of a set
            if (!uniques.contains(leftNeighbor)){

                // see if the longest consecutive
                int i = 0;
                while (uniques.contains(num+i)){
                    i++;
                }
                longest = Math.max(i,longest);
                }
            }
        

        return longest;
    }
}
public class LongestConsecutiveSequence {
    public static void main(String[] args){
        int[] nums = {0,3,7,2,5,8,4,6,0,1};
        
        Solution solution = new Solution(); 
        System.out.println(solution.longestConsecutive(nums));
    }
}
// Example 1:

// Input: nums = [100,4,200,1,3,2]
// Output: 4
// Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
// Example 2:

// Input: nums = [0,3,7,2,5,8,4,6,0,1]
// Output: 9

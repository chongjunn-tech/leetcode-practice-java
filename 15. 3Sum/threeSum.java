import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.HashSet;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        HashSet<List<Integer>> seen = new HashSet<>();
        //sort the array
        Arrays.sort(nums);

        System.out.println(Arrays.toString(nums));
        // fix one pointer so as easier to manipulate the 2 pointers approach
        for (int i = 0; i < nums.length - 2; i++){
            // initialize 2 pointers
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k){
                int sum = nums[i] + nums[j] + nums[k];

                if (sum == 0){
                    ArrayList<Integer> newList = new ArrayList<>(
                        List.of(nums[i], nums[j], nums[k])
                    );
                    Collections.sort(newList);

                    if (!seen.contains(newList)){
                        results.add(newList);
                        seen.add(newList);
                    }
                    // move both pointers as cannot have duplicate elements so for this set, found
                    // if just move one pointer the sum will not work out
                    // example if [-4, -1, -1, 0, 1, 2]
                    // and found i =1, j =2, k =5
                    // if u just move 1 pointer (k), the 3rd element u want to find is always the same as nums[i] + nums[j] = -2 and u are actually looking for 2 (same as before)
                    j++;
                    k--;
                }
                //reduce the sum so move right pointer to left
                else if (sum > 0){
                    k--;
                }
                //increase the sum so move the left pointer to right
                else if (sum < 0){
                    j++;
                }
            }
        }

        return results;
    }
}

public class threeSum {
    public static void main(String[] args){
        Solution solution = new Solution();
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(solution.threeSum(nums));
    }
}

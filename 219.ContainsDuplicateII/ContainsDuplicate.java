import java.util.HashMap;
import java.util.ArrayList;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        
        HashMap<Integer,ArrayList<Integer>> num2indices = new HashMap<>();

        for (int index = 0; index < nums.length; index++){

            int num = nums[index];

            if (!num2indices.containsKey(num)){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(index);
                num2indices.put(num, list);
            }
            else{
                ArrayList<Integer> indices = num2indices.get(num);
                Integer last = indices.get(indices.size()-1);
                if (index - last <= k){
                    return true;
                }
                indices.add(index);
            }
        }
        return false;
        
    }
}
public class ContainsDuplicate {
    public static void main(String[] args){

        int[] nums =  {1,2,3,1,2,3};
        int k = 2;

        Solution solution = new Solution();
        System.out.println(solution.containsNearbyDuplicate(nums, k));
    }
}

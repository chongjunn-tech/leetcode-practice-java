import java.util.Arrays;

class Solution {
    public int removeElement(int[] nums, int val) {
        
        int k = 0;

        for (int i = 0 ;i < nums.length; i++){
            if (nums[i] != val ){
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}

public class RemoveElement {
    public static void main(String[] args){
        Solution solution = new Solution();
        int [] nums = {1};

        System.out.println(solution.removeElement(nums, 1));
        System.out.println(Arrays.toString(nums));
    }
}

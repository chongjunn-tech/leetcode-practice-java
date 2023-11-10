import java.util.Arrays;

class Solution {
    public int[] productExceptSelf(int[] nums) {

        int[] productNums = new int[nums.length];

        int left = 1;
        int right = 1;
        
        //traverse right
        for (int i = 0; i< nums.length;i++ ){
            if (i == 0) productNums[i] = 1;
            else{
                left *= nums[i-1];
                productNums[i] = left;
            }
        }
        
        //traverse left
        for (int j = nums.length - 2; j >= 0; j-- ){
            right *= nums[j+1];
            productNums[j] *= right;
        }
        return productNums;
    }
}

public class ProductOfArrayExceptSelf {
    public static void main(String[] args){
        int[] nums = {1,2,3,4};
        Solution solution = new Solution();

        System.out.println(Arrays.toString(solution.productExceptSelf(nums)));
        // [24,12,8,6]

    }    
}

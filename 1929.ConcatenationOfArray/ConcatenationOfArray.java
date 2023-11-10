import java.util.Arrays;

class Solution {
    public int[] getConcatenation(int[] nums) {

        int[] concatnums = new int[nums.length * 2];
        
        for (int i = 0; i < nums.length ;i++){
            concatnums[i] = nums[i];
            concatnums[i + nums.length] = nums[i];
        }
        return concatnums;
    }
}

public class ConcatenationOfArray {
    public static void main(String[] args){
        Solution solution = new Solution();
        int[] nums = {1};

        System.out.println(Arrays.toString(solution.getConcatenation(nums)));
        
    }
}

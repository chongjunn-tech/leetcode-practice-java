class Solution {
    public int search(int[] nums, int target) {
        
        int left = 0;
        int right = nums.length - 1 ;

        // initialize right pointer to the last index of the array
        // account for if the nums have only 1 element, it will still enter the loop
        while (left <= right){

            int mid = (right + left)/ 2 ; 

            if (nums[mid] == target){
                return mid;
            }

            else if (nums[mid]> target){
                right = mid -1;
            }
            else if (nums[mid] < target){
                left = mid + 1;
            }
        }
        return -1;
    }
}
public class BinarySearch {

    public static void main(String[] args){
        
        Solution solution = new Solution();
        int[] nums = {5};
        int target = 5;

        System.out.println(solution.search(nums, target));
    }

    
}

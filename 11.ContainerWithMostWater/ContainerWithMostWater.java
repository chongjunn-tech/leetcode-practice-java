
class Solution {
    public int maxArea(int[] height) {
        
        // 2 <= n <= 105
        int left = 0;
        int right = height.length - 1;

        int maxArea = 0 ;
        while (left < right){
            int diff = right - left;

            maxArea = Math.max(maxArea, diff * Math.min(height[left],height[right]));

            // greedy approach shift pointer to find the
            if (height[left] > height[right]){
                right--;
            }
            else if (height[right] > height[left]){
                left++;
            }
            // move both pointers if they are of same height
            else{
                left++;
                right--;
            }
        }
        return maxArea;

    }
}
public class ContainerWithMostWater{
    public static void main(String[] args){
        
        Solution solution = new Solution();
        int[] height = {1, 1};
        System.out.println(solution.maxArea(height));
    }
}